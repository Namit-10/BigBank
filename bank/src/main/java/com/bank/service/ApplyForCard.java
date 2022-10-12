package com.bank.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.BankDao;

@WebServlet("/ApplyForCard")
public class ApplyForCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enteredPassword = request.getParameter("password");
		HttpSession sess = request.getSession();
		ResultSet rs = (ResultSet)sess.getAttribute("resultset");

		String username;
		try {
			username = rs.getString(1);
			String accountNo = BankDao.getAccountNoByUsername(username);
			ResultSet sessionDetailsRs = (ResultSet)sess.getAttribute("resultset");
//			System.out.println("In ApplyForCard.java");
			
			if(sessionDetailsRs != null) {
				String password = sessionDetailsRs.getString(2);
				if(password.equals(enteredPassword)) {
					int status = BankDao.applyForCard(accountNo);
//					System.out.println("The status of card application is : "+status);
					if(status > 0) {
						response.sendRedirect("successfulCardApplication.jsp");
					}
				}
				else {
					response.sendRedirect("authFailureCardApplication.jsp");
				}
			}
			else {
				System.out.println("Resultset null");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
