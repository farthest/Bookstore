package com.servlet.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.BooksDao;
import com.Dao.bookstore.OtherDao;
import com.model.bookstore.Books;
import com.model.bookstore.Categories;

/**
 * Servlet implementation class CategoriesManServlet
 */
@WebServlet("/Man/CategoriesMan")
public class CategoriesManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesManServlet() {
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
		System.out.println(request.getParameter("flagType"));
		if (request.getParameter("flagType")!=null) {
			String flagType = request.getParameter("flagType");
			switch (flagType) {
			case "display":
				try {
					ArrayList<Categories> categories = OtherDao.getCategories();
					request.setAttribute("categories", categories);
					request.getRequestDispatcher("/admin/product_category.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "search":

				break;
			case "delete":
				int id = Integer.valueOf(request.getParameter("id"));
				try {
					boolean flag = OtherDao.deleteCategories(id);
					request.setAttribute("flag", flag);
					request.getRequestDispatcher("/admin/product_category.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					break;
			default:
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		 //���÷���������ı���ΪUTF-8
	    response.setCharacterEncoding("UTF-8");
	    //��������������������html,������utf-8�ı������鿴������ݡ�
	    response.setContentType("text/html; charset=utf-8");
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		try {
			boolean flag = OtherDao.addCategories(id, name);
			request.setAttribute("flag", flag);
			request.setAttribute("flagType", "display");
			request.getRequestDispatcher("/Man/CategoriesMan").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
