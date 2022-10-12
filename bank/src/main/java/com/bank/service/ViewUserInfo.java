package com.bank.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.BankDao;

@WebServlet("/ViewUserInfo")
public class ViewUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>\n"
				+ "<html lang=\"en\">\n"
				+ "  <head>\n"
				+ "    <!-- Required meta tags -->\n"
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "\n"
				+ "	<link rel = 'stylesheet' href='homeStyle.css'>\n"
				+ "    <!-- Bootstrap CSS -->\n"
				+ "	<link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
				+ "	\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\" integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\" integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\" crossorigin=\"anonymous\"></script>\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n"
				+ "	<title>Login</title>\n"
				+ "	<script type=\"text/javascript\">\n"
				+ "		function reallyLogout(){\n"
				+ "			if(confirm(\"Do you really want to logout?\")==true){\n"
				+ "				location.replace(\"AdminLogout\");\n"
				+ "			}\n"
				+ "			\n"
				+ "		}\n"
				+ "	</script>\n"
				+ "	<style>\n"
				+ "	body {\n"
				+ "	background-color: #808080;\n"
				+ "	}\n"
				+ "</style>\n"
				+ "  </head>\n"
				+ "  \n"
				+ "<body>\n"
				+ "	<div id=\"sticky-wrapper\" class=\"sticky-wrapper\" style=\"height: 96px; position: absolute; z-index: 99;\">\n"
				+ "<header class=\"site-navbar js-sticky-header site-navbar-target\" role=\"banner\" style=\"width: 1980px;\">\n"
				+ "<div class=\"container\" style=\"margin-top: 0px;\">\n"
				+ "<div class=\"row align-items-center position-relative\">\n"
				+ "<div class=\"site-logo\">\n"
				+ "<a href=\"login.jsp\" class=\"text-black\"><span class=\"text\" style=\"color:#808080\">BIG BANK</span></a>\n"
				+ "</div>\n"
				+ "<div class=\"col-12\">\n"
				+ "<nav class=\"site-navigation text-right ml-auto\" role=\"navigation\">\n"
				+ "<ul class=\"site-menu main-menu js-clone-nav ml-auto d-none d-lg-block\">\n"
				+ "<li><a href=\"Home.jsp\" class=\"nav-link\"> </a></li>\n"
				+ "\n"
				+ "<li><a href=\"adminHome.jsp\" class=\"nav-link\">Admin Home</a></li>\n"
				+ "<li><a href=\"showAllAccounts.jsp\" class=\"nav-link\">Accounts</a></li>\n"
				+ "<li><a href=\"searchTransactionsByAccount.jsp\" class=\"nav-link\">Specific Transactions</a></li>\n"
				+ "<li><a href=\"userInfo.jsp\" class=\"nav-link disabled\">See User Info</a></li>\n"
				+ "<li><a href=\"showAllTransactions.jsp\" class=\"nav-link\">All Transactions</a></li>\n"
				+ "<li><a href=\"cardStatus.jsp\" class=\"nav-link\">Card status</a></li>\n"
				+ "<li><a href=\"AdminLogout\" onclick=\"reallyLogout()\" class=\"nav-link\">Logout</a></li>\n"
				+ "\n"
				+ "\n"
				+ "</ul>\n"
				+ "</nav>\n"
				+ "</div>\n"
				+ "<div class=\"toggle-button d-inline-block d-lg-none\"><a href=\"#\" class=\"site-menu-toggle py-5 js-menu-toggle text-black\"><span class=\"icon-menu h3\"></span></a></div>\n"
				+ "</div>\n"
				+ "</div>\n"
				+ "</header></div>");
			ResultSet rs = BankDao.getUserInfoByUsername(username);
			
			if(rs != null) {
//				System.out.println("The rs value is not null");
				String password = (String)rs.getString(2);
				String firstName = (String)rs.getString(3);
				String lastName = (String)rs.getString(4);
				String gender = (String)rs.getString(5);
				Date dob = (Date)rs.getDate(6);
				String panNo = (String)rs.getString(7);
				long aadharNo = (long)rs.getLong(8);
				long phoneNo = (long)rs.getLong(9);
				String email = (String)rs.getString(10);
				String address = (String)rs.getString(11);
				String city = (String)rs.getString(12);
				String state = (String)rs.getString(13);
				String country = (String)rs.getString(14);
				int pincode = (int)rs.getInt(15);
				out.println("<center>");
				out.println("<h4>The user details are </h4><br><br>");
				out.println("<table style='margin-top:10%;'>"
								+ "<tr><td><label for='username'>Username</label></td><td><input name='username' id='username' type='text' value="+username+" readonly></td></tr>"
								+ "<tr><td><label for='password'>Password</label></td><td><input name='password' id='password'type='password' value="+password+" readonly></td></tr>"
								+ "<tr><td><label for='firstName'>First Name</label></td><td><input name='firstName' id='firstName' type='text' value="+firstName+" readonly></td></tr>"
								+ "<tr><td><label for='lastName'>Last Name</label></td><td><input name='lastName' id='lastName'  type='text' value="+lastName+" readonly></td></tr>"
								+ "<tr><td><label for='gender'>Gender</label></td><td><input name='gender'  id='gender' type='text' value="+gender+" readonly></td></tr>"
								+ "<tr><td><label for='dob'>Date of Birth</label></td><td><input name='dob' id='dob' type='date' value="+dob+" readonly></td></tr>"
								+ "<tr><td><label for='panNo'>PAN No</label></td><td><input name='panNo' id='panNo' type='text' value="+panNo+" readonly></td></tr>"
								+ "<tr><td><label for='aadharNo'>Aadhar No</label></td><td><input name='aadharNo' id='aadharNo' type='text' value="+aadharNo+" readonly></td></tr>"
								+ "<tr><td><label for='phoneNo'>Phone No</label></td><td><input name='phoneNo'  id='phoneNo' type='text' value="+phoneNo+" readonly></td></tr>"
								+ "<tr><td><label for='email'>Email</label></td><td><input name='email' id='email' type='email' value="+email+" readonly></td></tr>"
								+ "<tr><td><label for='address'>Address</label></td><td><input name='address' id='address' type='text' value="+address+" readonly></td></tr>"
								+ "<tr><td><label for='city'>City</label></td><td><input name='city' id='city' type='text' value="+city+" readonly></td></tr>"
								+ "<tr><td><label for='state'>State</label></td><td><input name='state' id='state' type='text' value="+state+" readonly></td></tr>"
								+ "<tr><td><label for='country'>Country</label></td><td><input name='country' id='country' type='text' value="+country+" readonly></td></tr>"
								+ "<tr><td><label for='pincode'>Pincode</label></td><td><input name='pincode' id='pincode' type='text' value="+pincode+" readonly></td></tr>"
								+ ""
						
						+ ""
						+ "</table>");
			}
			else {
//				System.out.println("The rs value is null");
				out.println("<div><h2 style='margin-top: 100px;padding:15px;position:absolute;background-color:red;color:black;width:100%;'>Error! No such user found.Try again <h6>here</a></h6></h2><br>");
//				System.out.println("Executing the line after");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
