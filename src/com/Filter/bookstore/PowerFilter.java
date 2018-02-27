package com.Filter.bookstore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.bookstore.Users;


/**
 * Servlet Filter implementation class PowerFilter
 */
@WebFilter(filterName="/PowerFilter",urlPatterns= {"/Man/*","/admin/*"})
public class PowerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PowerFilter() {
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

		// pass the request along the filter chain
		HttpServletRequest httpreq=(HttpServletRequest)request;
		HttpServletResponse httres=(HttpServletResponse)response;
		System.out.println("Filter:"+httpreq.getRequestURI());

		//�Ƿ��¼
		if(httpreq.getSession().getAttribute("User")==null){
			RequestDispatcher rd=httpreq.getRequestDispatcher("/error.jsp");
			httpreq.setAttribute("ErrorMessage", "�Ƿ�����");
			rd.forward(httpreq, httres);
			return;
		}
		//�Ƿ���Ȩ��
		Users user=(Users) httpreq.getSession().getAttribute("User");
		if(user.getPermissionId()!=10){
			RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
			request.setAttribute("ErrorMessage", "�Բ�����û��Ȩ�ޣ�����ϵ��������ԭ��Ȩ��");
			rd.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
