<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.http.HttpSession, java.sql.ResultSet" %>
<% HttpSession adminsess = request.getSession();
   if(adminsess.getAttribute("adminUsername") == null) {ResultSet adminRs = (ResultSet)adminsess.getAttribute("adminResultSet");
   if(adminRs == null){
	   response.sendRedirect("adminLogin.jsp");
   }
   
   }%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel = 'stylesheet' href='homeStyle.css'>
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<title>Login</title>
	<script type="text/javascript">
		function reallyLogout(){
			if(confirm("Do you really want to logout?")==true){
				location.replace("AdminLogout");
			}
			
		}
	</script>
	<style>
	body {
	background-color: #808080;
	}
</style>
  </head>
  
<body>
	<div id="sticky-wrapper" class="sticky-wrapper" style="height: 96px; position: absolute; z-index: 99;">
<header class="site-navbar js-sticky-header site-navbar-target" role="banner" style="width: 1980px;">
<div class="container" style="margin-top: 0px;">
<div class="row align-items-center position-relative">
<div class="site-logo">
<a href="login.jsp" class="text-black"><span class="text" style="color:#808080">BIG BANK</span></a>
</div>
<div class="col-12">
<nav class="site-navigation text-right ml-auto" role="navigation">
<ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
<li><a href="Home.jsp" class="nav-link"> </a></li>

<li><a href="adminHome.jsp" class="nav-link disabled">Admin Home</a></li>
<li><a href="showAllAccounts.jsp" class="nav-link">Accounts</a></li>
<li><a href="searchTransactionsByAccount.jsp" class="nav-link">Specific Transactions</a></li>
<li><a href="userInfo.jsp" class="nav-link">See User Info</a></li>
<li><a href="showAllTransactions.jsp" class="nav-link">All Transactions</a></li>
<li><a href="cardStatus.jsp" class="nav-link">Card status</a></li>
<li><a href="AdminLogout" onclick="reallyLogout()" class="nav-link">Logout</a></li>


</ul>
</nav>
</div>
<div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
</div>
</div>
</header></div>
</body>
</html>