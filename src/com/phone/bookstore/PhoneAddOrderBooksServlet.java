package com.phone.bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PhoneAddOrderBooksServlet
 */
@WebServlet("/PhoneAddOrderBooks")
public class PhoneAddOrderBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneAddOrderBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //����json����
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        String acceptjson = "";
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while((temp = br.readLine()) != null){
            sb.append(temp);
        }
        br.close();
        //���ϵĹ��̶���request�ж�ȡjson������jsonת����string������������ʾ����������String���͵�json����acceptjson����
        acceptjson = sb.toString();
        System.out.println("=======json is==========="+acceptjson);
	}

}
