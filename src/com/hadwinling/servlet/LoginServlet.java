package com.hadwinling.servlet;

import java.io.IOException;
import java.sql.Struct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hadwinling.entity.Admin;
import com.hadwinling.service.AdminService;
import com.hadwinling.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService adminService = new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =  request.getParameter("username");
		String password = request.getParameter("password");
		Admin admin =  adminService.adminLogin(username, password);
		System.out.println(admin);
		HttpSession session = request.getSession();
		if (admin!=null) {
			session.setAttribute("currAdmin", admin);
			response.sendRedirect("student/findAll");
			System.out.println("成功");
		}else {
			System.out.println("失败");
			response.sendRedirect("login.jsp?info=1");
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
