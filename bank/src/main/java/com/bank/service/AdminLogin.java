package com.bank.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.BankDao;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("adminUsername");
		String password = request.getParameter("adminPassword");
		
		PrintWriter out = response.getWriter();
		
		try {
			ResultSet rs = BankDao.LoginAdmin(username, password);
			if(rs != null) {
				HttpSession sess = request.getSession();
				sess.setAttribute("adminResultSet", rs);
//			    System.out.println("Admin session set  in AdminLogin.java : "+rs);
//				out.println("Successfully logged in...\nRedirecting to Home.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
				rd.forward(request, response);
				
			}
			else {
				HttpSession ses = request.getSession();
				ses.setAttribute("loginUnsuccessful", 1);
				response.sendRedirect("adminLogin.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
