package com.hadwinling.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hadwinling.entity.Admin;



/**
 * Servlet Filter implementation class LoginFilter
 * 登录验证：没有登录的情况下， 不允许进行Student的相关操作
 */
@WebFilter(filterName="loginFilter",urlPatterns="/student/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 登录验证，判断是否登录
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession sesison=req.getSession();
		Admin admin=(Admin)sesison.getAttribute("currAdmin");
		if(admin!=null) {
			//已登录，放行
			chain.doFilter(request, response);
		}else {
			//去登陆
			resp.sendRedirect(req.getContextPath()+"/login.jsp?info=2");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
