package com.bank.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.BankDao;
import com.bank.util.Util;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ResultSet rs = (ResultSet) sess.getAttribute("resultset");
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Withdraw</title>\n"
				+ "\n"
				+ "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400,700\" rel=\"stylesheet\">\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
				+ "	\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\" integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\" integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n"
				+ "<!--  <script defer=\"\" referrerpolicy=\"origin\" src=\"/cdn-cgi/zaraz/s.js?z=JTdCJTIyZXhlY3V0ZWQlMjIlM0ElNUIlNUQlMkMlMjJ0JTIyJTNBJTIyV2Vic2l0ZSUyME1lbnUlMjAlMjM0JTIyJTJDJTIyeCUyMiUzQTAuOTc1MjAxODAxOTI4NTk1NyUyQyUyMnclMjIlM0ExOTIwJTJDJTIyaCUyMiUzQTEwODAlMkMlMjJqJTIyJTNBOTQ4JTJDJTIyZSUyMiUzQTE4NDglMkMlMjJsJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZwcmV2aWV3LmNvbG9ybGliLmNvbSUyRnRoZW1lJTJGYm9vdHN0cmFwJTJGd2Vic2l0ZS1tZW51LTA0JTJGJTIyJTJDJTIyciUyMiUzQSUyMmh0dHBzJTNBJTJGJTJGY29sb3JsaWIuY29tJTJGJTIyJTJDJTIyayUyMiUzQTI0JTJDJTIybiUyMiUzQSUyMlVURi04JTIyJTJDJTIybyUyMiUzQS0zMzAlMkMlMjJxJTIyJTNBJTVCJTVEJTdE\"></script>\n"
				+ "<script nonce=\"cf078d64-675b-4313-8a11-5eb183dd4e62\">(function(w,d){!function(a,e,t,r){a.zarazData=a.zarazData||{};a.zarazData.executed=[];a.zaraz={deferred:[],listeners:[]};a.zaraz.q=[];a.zaraz._f=function(e){return function(){var t=Array.prototype.slice.call(arguments);a.zaraz.q.push({m:e,a:t})}};for(const e of[\"track\",\"set\",\"debug\"])a.zaraz[e]=a.zaraz._f(e);a.zaraz.init=()=>{var t=e.getElementsByTagName(r)[0],z=e.createElement(r),n=e.getElementsByTagName(\"title\")[0];n&&(a.zarazData.t=e.getElementsByTagName(\"title\")[0].text);a.zarazData.x=Math.random();a.zarazData.w=a.screen.width;a.zarazData.h=a.screen.height;a.zarazData.j=a.innerHeight;a.zarazData.e=a.innerWidth;a.zarazData.l=a.location.href;a.zarazData.r=e.referrer;a.zarazData.k=a.screen.colorDepth;a.zarazData.n=e.characterSet;a.zarazData.o=(new Date).getTimezoneOffset();a.zarazData.q=[];for(;a.zaraz.q.length;){const e=a.zaraz.q.shift();a.zarazData.q.push(e)}z.defer=!0;for(const e of[localStorage,sessionStorage])Object.keys(e||{}).filter((a=>a.startsWith(\"_zaraz_\"))).forEach((t=>{try{a.zarazData[\"z_\"+t.slice(7)]=JSON.parse(e.getItem(t))}catch{a.zarazData[\"z_\"+t.slice(7)]=e.getItem(t)}}));z.referrerPolicy=\"origin\";z.src=\"/cdn-cgi/zaraz/s.js?z=\"+btoa(encodeURIComponent(JSON.stringify(a.zarazData)));t.parentNode.insertBefore(z,t)};[\"complete\",\"interactive\"].includes(e.readyState)?zaraz.init():a.addEventListener(\"DOMContentLoaded\",zaraz.init)}(w,d,0,\"script\");})(window,document);</script>\n"
				+ "-->\n"
				+ "<style>\n"
				+ "body {\n"
				+ "	background-color: #800080;\n"
				+ "}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "\n"
				+ "<div id=\"sticky-wrapper\" class=\"sticky-wrapper\" style=\"height: 96px;\">\n"
				+ "<header class=\"site-navbar js-sticky-header site-navbar-target\" role=\"banner\" style=\"width: 1980px;\">\n"
				+ "<div class=\"container\">\n"
				+ "<div class=\"row align-items-center position-relative\">\n"
				+ "<div class=\"site-logo\">\n"
				+ "<a href=\"index.html\" class=\"text-black\"><span class=\"text\" style=\"color:#800080\">BIG BANK</span></a>\n"
				+ "</div>\n"
				+ "<div class=\"col-12\">\n"
				+ "<nav class=\"site-navigation text-right ml-auto\" role=\"navigation\">\n"
				+ "<ul class=\"site-menu main-menu js-clone-nav ml-auto d-none d-lg-block\">\n"
				+ "<li><a href=\"Home.jsp\" class=\"nav-link\">Home</a></li>\n"
				+ "\n"
				+ "<li><a href=\"deposit.jsp\" class=\"nav-link\">Deposit</a></li>\n"
				+ "<li><a href=\"withdraw.jsp\" class=\"nav-link\">Withdraw</a></li>\n"
				+ "<li><a href=\"transfer.jsp\" class=\"nav-link\">Fund Transfer</a></li>\n"
				+ "<li><a href=\"showTransactions.jsp\" class=\"nav-link\">Show Transactions</a></li>\n"
				+ "<li><a href=\"balanceCheck.jsp\" class=\"nav-link\">Check Balance</a></li>\n"
				+ "<li><a href=\"card.jsp\" class=\"nav-link\">Debit Card</a></li>\n"
				+ "<li><a href=\"Logout\" class=\"nav-link\">Logout</a></li>"

				+ "\n"
				+ "\n"
				+ "<li><a href=\"#contact-section\" class=\"nav-link\">Contact</a></li>\n"
				+ "</ul>\n"
				+ "</nav>\n"
				+ "</div>\n"
				+ "<div class=\"toggle-button d-inline-block d-lg-none\"><a href=\"#\" class=\"site-menu-toggle py-5 js-menu-toggle text-black\"><span class=\"icon-menu h3\"></span></a></div>\n"
				+ "</div>\n"
				+ "</div>\n"
				+ "</header></div>");
		try {
		String username = rs.getString(1);
		String password = rs.getString(2);
		
		String senderAccountNo = BankDao.getAccountNoByUsername(username);
		
		double senderBalance = BankDao.checkBalance(username, password);
		String enteredPassword = request.getParameter("password");
		String receiverAccountNo = request.getParameter("receiverAccountNo");
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		if(senderBalance > 0) {
			if(senderBalance - amount >= 1500) {
				int statusWithdraw = BankDao.withdraw(senderAccountNo, amount);
				if(statusWithdraw > 0) {
					int statusDeposit = BankDao.deposit(receiverAccountNo, amount);
					if(statusDeposit > 0) {
						out.println("<div style='background-color: green; color: white; margin-top: 30px; padding: 15px;'><h2>Transfer Success!</h2></div>");
					}
				}
			}
			else {
				//insufficient balance
				out.println("<div style='background-color: red; color: white;'><h2>Transfer Failure!</h2></div><br>Insufficient balance!");
			}
		}
		else {
			//authentication error
			out.println("<div style='background-color: red; color: white;'><h2>Transfer Failure!</h2></div><br>Authentication Failed!<br>Wrong password entered!");
		}
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
