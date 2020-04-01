package com.hadwinling.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodeingFilter
 * 设置请求/响应字符集
 * 注解配置过滤器参数,字符集utf-8
 */
@WebFilter(filterName="encodeFilter",urlPatterns="/*",
initParams= {@WebInitParam(name="encode",value="utf-8")})
public class EncodeingFilter implements Filter {
	private String DEFAULT_ENCODE="utf-8";
    /**
     * Default constructor. 
     */
    public EncodeingFilter() {
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
		// place your code here
		//设置字符集
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		req.setCharacterEncoding(DEFAULT_ENCODE);
		resp.setContentType("text/html;charset="+DEFAULT_ENCODE);
		// 放行
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//初始化时读取配置信息，将值赋给属性
		DEFAULT_ENCODE=fConfig.getInitParameter("encode");
	}

}
