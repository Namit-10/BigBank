<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.http.HttpSession, com.bank.dao.*, java.sql.ResultSet" %>
<% HttpSession sess = request.getSession(); 
   ResultSet rs = (ResultSet)sess.getAttribute("resultset"); 
   String username = ""; 
   int balanceInt=0;
   double balance=0;
   String accountNo = "";
   String cardNo="";
   ResultSet rsCardDetails = null;
   String cvv="";
   String finalCardNo1= "", finalCardNo2= "", finalCardNo3= "", finalCardNo4 = "";
   if (rs != null) { 
	   username = rs.getString(1);
       String password = rs.getString(2);
       String fistname = rs.getString(3);
       String lastname = rs.getString(4);
       accountNo = BankDao.getAccountNoByUsername(username);
       
      
       if(BankDao.cardExists(accountNo) == 1 && BankDao.isCardApplicationPending(accountNo) != 1){
       cardNo = BankDao.getCardNoFromAccountNo(accountNo);
       /* System.out.println("Received card no is "+cardNo); */
       if(!cardNo.equals("") || cardNo != null && cardNo.length() > 0){
       finalCardNo1 = cardNo.substring(0,4);
       finalCardNo2 = cardNo.substring(4,8);
       finalCardNo3 = cardNo.substring(8,12);
       finalCardNo4 = cardNo.substring(12,16);
       rsCardDetails = BankDao.getCardInfo(accountNo);
       if(rsCardDetails.next()){
       cvv = rsCardDetails.getString(6);
       }
       
       }
       }
       
       }
	
	%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Debit card</title>
<style>
	.card {
		height: 300px;
		width: 477px;
		background-color: white;
		border-radius: 15px;
		margin-top: 200px;
	}
	body {
		background-color: #800080;
	}
	.flip-card {
  background-color: transparent;
  width: 477px;
  height: 300px;
  border-radius: 15px;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  
  border-radius: 15px;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
  background:linear-gradient(45deg, rgba(250, 250, 0), rgba(200, 0, 250));
  color: white;
}

/* Style the back side */
.flip-card-back {
  background:linear-gradient(45deg, rgba(180, 0, 30), rgba(0, 130, 80));
  color: white;
  transform: rotateY(180deg);
}

</style>
<script>
function Toggle() {
    var temp = document.getElementById("typepass");
    if (temp.innerHTML === "XXX") {
        temp.innerHTML = <%= cvv %>;
    }
    else {
        temp.innerHTML = "XXX";
    }
}
</script>
</head>
<body>
<div id="sticky-wrapper" class="sticky-wrapper" style="height: 96px;">
<header class="site-navbar js-sticky-header site-navbar-target" role="banner" style="width: 1980px;">
<div class="container">
<div class="row align-items-center position-relative">
<div class="site-logo">
<a href="index.html" class="text-black"><span class="text" style="color:#800080">BIG BANK</span></a>
</div>
<div class="col-12">
<nav class="site-navigation text-right ml-auto" role="navigation">
<ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
<li><a href="Home.jsp" class="nav-link">Home</a></li>
<li><a href="deposit.jsp" class="nav-link">Deposit</a></li>
<li><a href="withdraw.jsp" class="nav-link">Withdraw</a></li>
<li><a href="transfer.jsp" class="nav-link">Fund Transfer</a></li>
<li><a href="showTransactions.jsp" class="nav-link">Show Transactions</a></li>
<li><a href="balanceCheck.jsp" class="nav-link">Check Balance</a></li>
<li><a href="card.jsp" class="nav-link">Debit Card</a></li>
<li><a href="Logout" class="nav-link">Logout</a></li>
</ul>
</nav>
</div>
<div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
</div>
</div>
</header>
<% if(rsCardDetails != null) { %>
	<div class="position-box" style="margin-top: 20%; margin-left: 35%;">
	<div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
      <h1 style="margin-top:30px;"><%= finalCardNo1 %>&nbsp;&nbsp;<%= finalCardNo2 %>&nbsp;&nbsp;<%= finalCardNo3 %>&nbsp;&nbsp;<%= finalCardNo4 %>&nbsp;&nbsp;</h1>
      <small><label for="validFrom">Valid from</label></small><br>
      <p style="font-weight: bold; color: white;"><%= rsCardDetails.getDate(4)%></p>
      <small><label for="validThrough">Valid through</label></small><br>
      <p style="font-weight: bold; color: white;"><%= rsCardDetails.getDate(5)%></p>
      
      
      
    </div>
    <div class="flip-card-back">
    	<br><br><br><br>
    	<p style="font-weight: bold; color: white;">CVV</p>
    	<p ><small><span>Don't share it with anyone</span></small></p>
      <p id="typepass" style="font-weight: bold; color: white;">XXX</p>
      <input type="checkbox" onclick="Toggle()">
      <b>Show CVV</b>
    </div>
  </div>
</div>	
</div>
<% }

else {
	response.sendRedirect("applyForCard.jsp");
}%>
</body>
</html>