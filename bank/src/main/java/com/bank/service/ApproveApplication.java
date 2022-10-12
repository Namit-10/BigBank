package com.bank.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.BankDao;

@WebServlet("/ApproveApplication")
public class ApproveApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNo = request.getParameter("accountNo");
		try {
			int status = BankDao.approveApplication(accountNo);
			if(status > 0) {
				int cardSt = BankDao.setCardInfo(accountNo);
				if(status > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("cardStatus.jsp");
					rd.include(request, response);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("cardStatusUpdateFailure2.jsp");
					rd.include(request, response);
				}
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("cardStatusUpdateFailure1.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
