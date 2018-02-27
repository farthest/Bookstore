package com.servlet.bookstore;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.BooksDao;
import com.Dao.bookstore.OtherDao;
import com.model.bookstore.Categories;
import com.model.bookstore.Publishers;

/**
 * Servlet implementation class BooksAddServlet
 */
@WebServlet("/Man/BooksAdd")
public class BooksAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<Categories> categories = OtherDao.getCategories();
			ArrayList<Publishers> publishers = OtherDao.getPublishers();
			request.setAttribute("categories", categories);
			request.setAttribute("publishers", publishers);
			request.getRequestDispatcher("/admin/add_product.jsp").forward(request, response);
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
		request.setCharacterEncoding("utf-8");
		 //设置服务器输出的编码为UTF-8
	    response.setCharacterEncoding("UTF-8");
	    //告诉浏览器输出的内容是html,并且以utf-8的编码来查看这个内容。
	    response.setContentType("text/html; charset=utf-8");
	    String title = request.getParameter("Title");
	    String author = request.getParameter("Author");
	    int publisherId = Integer.valueOf(request.getParameter("PublisherId"));
	    Date publishDate = Date.valueOf(request.getParameter("PublishDate"));
	    String iSBN = request.getParameter("ISBN");
	    int wordsCount = Integer.valueOf(request.getParameter("WordsCount"));
	    float unitPrice = Float.valueOf(request.getParameter("UnitPrice"));
	    String contentDescription = request.getParameter("ContentDescription");
	    String aurhorDescription = request.getParameter("AurhorDescription");
	    String editorComment = request.getParameter("EditorComment");
	    String tOC = request.getParameter("TOC");
	    int categoryId = Integer.valueOf(request.getParameter("CategoryId"));
	    int clicks = 100;
	    int repertory = Integer.valueOf(request.getParameter("Repertory"));
	    try {
			boolean flag = BooksDao.addBook(title, author, publisherId, publishDate, iSBN, wordsCount, unitPrice, contentDescription, aurhorDescription, editorComment, tOC, categoryId, clicks, repertory);
					if (flag) {
				request.getRequestDispatcher("/admin/product_list.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/admin/add_product.jsp").forward(request, response);
			}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
