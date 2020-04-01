package com.hadwinling.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.hadwinling.entity.Student;
import com.hadwinling.service.StudentService;
import com.hadwinling.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/student/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new StudentServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		HttpSession session = request.getSession();
//		System.out.println(pathInfo);
		Gson gson=new Gson();
		if ("/findAll".equals(pathInfo)) {
//			System.out.println("main");
			List<Student> students = studentService.findStudents();
			session.setAttribute("students", students);
			request.getRequestDispatcher("/WEB-INF/page/main.jsp").forward(request, response);
		}
		if ("/add".equals(pathInfo)) {
//			System.out.println("添加");
			request.getRequestDispatcher("/WEB-INF/page/add.jsp").forward(request, response);
		}
		if ("/doadd".equals(pathInfo)) {
			//处理添加内容
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			
			Student student = new Student(0, sno, sname, sex, address);
			boolean flag = studentService.addStudent(student);
			if (flag) {
				System.out.println("录入成功");
				response.sendRedirect("findAll");				
			}else {
				System.out.println("增加失败,学号重复");
				response.sendRedirect("/WEB-INF/page/add.jsp?info=1");
			}
		}
		if ("/del".equals(pathInfo)) {
			//删除
			int id = Integer.parseInt(request.getParameter("id"));
			boolean flag = studentService.deleteStudent(id);
			if (flag) {
				response.sendRedirect("findAll");
			}else {
				//删除失败
				response.sendRedirect("/WEB-INF/page/main.jsp?info=1");
			}
		}
		if ("/update".equals(pathInfo)) {
			int id = Integer.parseInt(request.getParameter("id"));
			Student student = studentService.findStudentById(id);
			session.setAttribute("student", student);
			session.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/page/updatestudent.jsp").forward(request, response);
		}
		if ("/doupdate".equals(pathInfo)) {
			int id = (int) session.getAttribute("id");
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			Student student = new Student(id, sno, sname, sex, address);
			System.out.println(student);
			studentService.updateStudent(student);
			response.sendRedirect("findAll");
		}
		if ("/search".equals(pathInfo)) {
			System.out.println("查询");
			request.getRequestDispatcher("/WEB-INF/page/search.jsp").forward(request, response);
			
		}
		if ("/dosearch".equals(pathInfo)) {
			String sname = request.getParameter("sname");
			System.out.println(sname);
			List<Student> students = studentService.findStudentByName(sname);
			String dataStr ="";
			if (students.size()==0) {
				dataStr = null;
				System.out.println("kong");
//				response.sendRedirect("/WEB-INF/page/search.jsp?info=1");
				request.getRequestDispatcher("/WEB-INF/page/search.jsp?info=1").forward(request, response);
				
			}else {
				dataStr=gson.toJson(students);
				//将json字符串写给客户端
				PrintWriter out=response.getWriter();
				out.write(dataStr);
				out.flush();
				out.close();
			}
		}
		if ("/quit".equals(pathInfo)) {
			//退出
			session.invalidate();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
