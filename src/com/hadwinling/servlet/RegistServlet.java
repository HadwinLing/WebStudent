package com.hadwinling.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hadwinling.service.AdminService;
import com.hadwinling.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/regist/*")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("跳转去注册");
//		if ("/regist".equals(pathInfo)) {
			
//		}
//		response.sendRedirect("/WEB-INF/page/regist.jsp");
		
//		request.getRequestDispatcher("regist.jsp").forward(request, response);
		String pathInfo = request.getPathInfo();
		System.out.println(pathInfo);
		if ("/doregist".equals(pathInfo)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password1 = request.getParameter("password1");
			boolean flag = false;
			if (password.equals(password1)) {
				 flag = adminService.adminRegist(username, password);
			}else {
				System.out.println("密码不一致");
				request.getRequestDispatcher("regist.jsp?info=2").forward(request, response);
			}
			System.out.println(flag);
			if (flag) {
				//注册成功
				System.out.println("注册成功");
				response.sendRedirect("/WebStudent/login.jsp");
//				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				//注册失败
				System.out.println("注册失败");
				request.getRequestDispatcher("/WebStudent/login.jsp?info=3").forward(request, response);
			}
			
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
