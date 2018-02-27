package com.phone.bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.OrderDao;

/**
 * Servlet implementation class PhoneAddOrderServlet
 */
@WebServlet("/PhoneAddOrder")
public class PhoneAddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneAddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 //���÷���������ı���ΪUTF-8
	    response.setCharacterEncoding("UTF-8");
	    //��������������������html,������utf-8�ı������鿴������ݡ�
	    response.setContentType("text/html; charset=utf-8");
	    System.out.println(request.getParameter("userId"));
		int userId = Integer.valueOf(request.getParameter("userId"));
		float totalPrice = Float.valueOf(request.getParameter("totalPrice"));
		int orderStatus = Integer.valueOf(request.getParameter("orderStatus"));
		try {
			int orderid = OrderDao.addOrder(userId, totalPrice, orderStatus);
			PrintWriter out = response.getWriter();
			out.print(orderid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
