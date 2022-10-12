package com.bank.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.BankDao;
import com.bank.model.User;
import com.bank.util.Util;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Signup() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			response.setContentType("text/html");
			
			
			
			String username = request.getParameter("username");
			Statement st = Util.getConnection().createStatement();
			String usernamesInDBQuery = "select username from user";
			int unique = 1;
			ResultSet rs5 = st.executeQuery(usernamesInDBQuery);
			while(rs5.next()) {
				if(rs5.getString(1) == username) {
					unique = 0;
					break;
				}
			}
			if(unique != 1) {
				out.println("<html><body><h1 style='background-color: red;'>Account creation failure!<br><br>Username already taken.</h1></body></html>");
			}
			
			else {
				String password = request.getParameter("password");
				
				String firstname = request.getParameter("firstName");
				
				String lastname = request.getParameter("lastName");
				
				String gender = request.getParameter("gender");
				
				String panNo = request.getParameter("panNo");
				
				String email = request.getParameter("email");
				
				String address = request.getParameter("address");
				
				String city = request.getParameter("city").toUpperCase();
				
				String state = request.getParameter("state");
				
				String country = request.getParameter("country");
				
				Date dob = Date.valueOf(request.getParameter("dob"));
				
				long aadharNo = Long.parseLong(request.getParameter("aadharNo"));
				
				long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
				
				int pincode = Integer.parseInt(request.getParameter("pincode"));
				
				User u = new User(username,password,firstname,lastname,gender,panNo,email,address,city,state,country,dob,aadharNo,phoneNo,pincode);
				
				Statement stmt = null;
				stmt = Util.getConnection().createStatement();
				
				BankDao.saveUser(u);
				
				out.println("<html><head>"
						+ ""
						+ "</head><body><h1 style='background-color: green; color: white;'>Account creation successful!</h1>"
						+ "<h3>"
						+ "ACCOUNT DETAILS ARE :"
						+ "ACCOUNT NUMBER : "
						+ ""+BankDao.getAccountNoByUsername(username)
						+ "FIRST NAME : "+firstname
						+ "LAST NAME : "+lastname
						+ ""
						+ "USERNAME : "+username
						+ "Click <a href='login.jsp'>here</a> to go to login."
						+ "</h3>"
						+ "</body></html>");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
//		out.println("SUCCESSFULLY REGISTERED ACCOUNT WITH THE DETAILS : ");
//		out.println(name+" "+email+" "+address+" "+phone_str+" "+dob_str+" "+username+" "+password+" "+repassword+" "+gender+" "+account_type);
		
	}

}
