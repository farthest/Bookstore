package com.ui.bookstore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.bookstore.BooksDao;
import com.model.bookstore.Books;
import com.model.bookstore.CartItem;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id"));
		//���ﳵ����
	    //1:���ȿ����ҹ��������һ���鼮���������ʹ��idȷ��Ҳ����ʹ��session��ȡ����һ���鼮
	    Books book = new Books();
		try {
			book = BooksDao.getBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //2:������ΰ��鼮�ŵ����ﳵ��
	        //2.1:���ȿ����Ƿ��й��ﳵ�����û�У��򴴽��������ֱ��ʹ��
	        //2.2:����Ƚ����ﳵ��session���ó����������ھʹ�����
	    Map<Integer,CartItem> cart=(Map<Integer,CartItem>)request.getSession().getAttribute("cart");
	    //���û�й��ﳵ����ô������ֻ�е�һ�η��ʲŻ����
	    if(cart==null){
	        //newһ�����ﳵ
	        cart=new HashMap<>();
	    }
	    
	    //3:������ΰ��鼮�ŵ����ﳵ��
	        //3.1:��һ���ǹ��ﳵ���Ƿ��и��鼮�������ȴӹ��ﳵ�л�ȡ���鼮�����Ϊ�գ���ôû�и��鼮
	    CartItem item=(CartItem)cart.get(book.getId());
	    if(item==null){
	        //������ﳵ�в����ڸ��鼮����ô������������Ĭ��Ϊ1
	        item=new CartItem();
	        //���鼮�ŵ����ﳵ��
	        item.setBook(book);
	        //���鼮��Ĭ������Ϊ1
	        item.setNumber(1);
	    }else{
	        //������ﳵ���Լ��и��鼮����ô������1 
	        item.setNumber(item.getNumber()+1);
	    }
	    
	    //4:������ΰѹ��ﳵ��(����ѡ���鼮����һ�����鱾������)�ŵ����ﳵ��
	    cart.put(book.getId(),item);
	    //5:�����ﳵ�ŵ�session�У��������ȡ����
	    request.getSession().setAttribute("cart", cart);
	    
	    request.getRequestDispatcher("/BooksRandom").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
	}

}
