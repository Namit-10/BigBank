package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.bank.model.User;
import com.bank.util.*;

public class BankDao {
	public static int saveUser(User user) {
		Statement stmt = null;
		String sql = null;
		Statement stmt2 = null;
		String sql2 = null;
		
		try {
			sql = "insert into user values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getGender()+"','"+user.getDob()+"','"+user.getPanNo()+"',"+user.getAadharNo()+","+user.getPhoneNo()+",'"+user.getEmail()+"','"+user.getAddress()+"','"+user.getCity()+"','"+user.getState()+"','"+user.getCountry()+"',"+user.getPincode()+") ";
			stmt = Util.getConnection().createStatement();
			int a = stmt.executeUpdate(sql);
			
			stmt2 = Util.getConnection().createStatement();
			String cityUpper = user.getCity().toUpperCase();
			sql2 = "select branchId from branch where branchCity = '"+cityUpper+"' ";
			ResultSet rs2 = stmt2.executeQuery(sql2);
			String first4Chars = "";
			
			if(rs2.next()) {
				System.out.println("found branch "+rs2.getString(1));
				String full_branchId = rs2.getString(1);
				first4Chars = full_branchId.substring(full_branchId.length() - 4);
				
				long leftLimit = 100000000000L;
			    long rightLimit = 999999999999L;
			    
			    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
			    String accountNo = first4Chars+Long.toString(generatedLong);
			    
				String sql3 = "insert into account values('"+accountNo+"','"+user.getUsername()+"','"+full_branchId+"', 0, CURDATE(), 'SAVINGS', 1)";
				Statement stmt3 = Util.getConnection().createStatement();
				int b = stmt3.executeUpdate(sql3);
				
				BankDao.deposit(accountNo,1500.00d);
				return a+b;
			}
			else {
				return a;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	
	public static int deposit(String accountNo, Double amount) {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "update account set balance = balance +"+amount+" where accountNo = "+accountNo+" ";
			stmt = Util.getConnection().createStatement();
			int status = stmt.executeUpdate(sql);
			
			String bal_q = "select balance from account where accountNo ="+accountNo+" ";
			Statement stmt2 = Util.getConnection().createStatement();
			ResultSet rs = stmt2.executeQuery(bal_q);
			
			double bal;
			
			if(rs.next()) {
				bal = (Double)rs.getDouble(1);
			
			
			Statement stmt3 = Util.getConnection().createStatement();
			
			String trans_update_query = "insert into transactions(accountNo,dateAndTime,transactionType,amount,balanceAfterTransaction) values('"+accountNo+"',CURRENT_TIMESTAMP(), 'Cr', "+amount+","+bal+") ";
			int status2 = stmt3.executeUpdate(trans_update_query);
			return status2;
			}
			else {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int withdraw(String accountNo, Double amount) {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "update account set balance = balance -"+amount+" where accountNo = "+accountNo+" ";
			stmt = Util.getConnection().createStatement();
			int status = stmt.executeUpdate(sql);
			
			String bal_q = "select balance from account where accountNo ="+accountNo+" ";
			Statement stmt2 = Util.getConnection().createStatement();
			ResultSet rs = stmt2.executeQuery(bal_q);
			
			double bal;
			
			if(rs.next()) {
				bal = (Double)rs.getDouble(1);
			
			
			Statement stmt3 = Util.getConnection().createStatement();
			
			String trans_update_query = "insert into transactions(accountNo,dateAndTime,transactionType,amount,balanceAfterTransaction) values('"+accountNo+"',CURRENT_TIMESTAMP(), 'Dr', "+amount+","+bal+") ";
			int status2 = stmt3.executeUpdate(trans_update_query);
			return status2;
			}
			else {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public static double getBalanceIfAccountExists(String accountNo) throws SQLException {
		Statement st = Util.getConnection().createStatement();
		String sql = "select balance from account where accountNo = "+accountNo+" ";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			return rs.getDouble(1);
		}
		else {
			return -400;
		}
	}
	public static String getAccountNoByUsername(String username) throws SQLException {
		String accountNo;
		Statement st = Util.getConnection().createStatement();
		String sql = "select a.accountNo from account as a, user as u where u.username=a.username and u.username = '"+username+"' ";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			return rs.getString(1);
		}
		else {
			return null;
		}
	}
	
	public static ResultSet getUserInfoByUsername(String username) throws SQLException {
		ResultSet userInfo = null;
		Statement st = Util.getConnection().createStatement();
		String sql = "select * from user where username = '"+username+"' ";
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			return rs;
		}
		else {
			return null;
		}
	}
	
	public static ResultSet LoginUser(String username, String password) throws SQLException {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "select * from user where username='"+username+"' and password = '"+password+"' ";
			stmt = Util.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static ResultSet LoginAdmin(String adminUsername, String adminPassword) throws SQLException {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "select * from admin where username='"+adminUsername+"' and password = '"+adminPassword+"' ";
			stmt = Util.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static double checkBalance(String username, String password) {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "select a.balance from account as a, user as u where u.username='"+username+"' and u.password='"+password+"' and a.username=u.username ";
			stmt = Util.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getDouble(1);
			}
			else {
				return -200;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return -800;
		}
	}
	
	public static ResultSet showTransactions(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from transactions where accountNo ="+accountNo+" order by dateAndTime desc";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static ResultSet getAllUsernames() throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select username from user ";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static ResultSet showAllTransactions() throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from transactions order by dateAndTime desc";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static ResultSet showAllAccounts() throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from account";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static int approveApplication(String accountNo) throws SQLException {
	    Statement stmt = Util.getConnection().createStatement();
		String sql = "update cardApplication set applicationStatus='APPROVED',approvedDate=curdate() where accountNo='"+accountNo+"' ";
		int status = stmt.executeUpdate(sql);
		return status;
	}
	
	public static int rejectApplication(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "update cardApplication set applicationStatus='REJECTED' where accountNo='"+accountNo+"' ";
		int status = stmt.executeUpdate(sql);
		return status;
	}
	
	public static ResultSet showAllApplications() throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from cardApplication";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static ResultSet showUserInfoOfAccount(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from user where accountNo = "+accountNo+" ";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
		
	public static ResultSet cardApplicationStatus(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from cardApplication where accountNo = "+accountNo+" ";
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}
	
	public static int setCardInfo(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		long leftLimit = 1000000000000000L;
	    long rightLimit = 9999999999999999L;
	    
	    long generatedCardNo = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	    
	    int leftcvv = 100;
	    int rightcvv = 999;
	    int cvv = leftcvv + (int)(Math.random() * (rightcvv - leftcvv));
	    
		String sql = "insert into card values('"+generatedCardNo+"', '"+accountNo+"' , CURDATE(), CURDATE(), DATE_ADD(CURDATE(), INTERVAL 5 YEAR),"+cvv+")";
		
		int status = stmt.executeUpdate(sql);
		return status;
		
	}
	
	public static String getCardNoFromAccountNo(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select cardNo from card where accountNo ="+accountNo+" ";
		String cardNo = "";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			cardNo = rs.getString(1);
		}
		return cardNo;
	}
	
	public static int cardExists(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from card where accountNo = "+accountNo+" ";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static int isCardApplicationPending(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from cardApplication where accountNo = '"+accountNo+"' and applicationStatus = 'PENDING' ";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static ResultSet getCardInfo(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "select * from card where accountNo ="+accountNo+" ";
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public static int applyForCard(String accountNo) throws SQLException {
		Statement stmt = Util.getConnection().createStatement();
		String sql = "insert into cardApplication(accountNo, appliedDate,applicationStatus) values("+accountNo+",CURDATE(), 'PENDING')";
		int rs = stmt.executeUpdate(sql);
		return rs;
	}
	
	public static double checkBalance(String accountNo) {
		Statement stmt = null;
		String sql = null;
		
		try {
			sql = "select a.balance from account a where a.accountNo = '"+accountNo+"' ";
			stmt = Util.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getDouble(1);
			}
			else {
				return -400;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return -800;
		}
	}
	
	
	
}
