<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = 'stylesheet' href='homeStyle.css'>
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<style>
	body{
		background-color: #808080;
		z-index: 0;
	}
	
	.circle-1 {
  		width: 900px;
  		height: 900px;
  		position: absolute;
  		z-index: 2;
  		transform: translate(-300px, -400px);
  		background-color: #40E0D0;
  		border-radius: 50%;
  		box-shadow: inset -25px -25px 40px rgba(0,0,0,.5);
  		background-image: -webkit-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -moz-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);  
  		background-image: -o-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -ms-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
	}
	.circle-2 {
  		width: 500px;
  		height: 500px;
  		position: absolute;
  		z-index: 1;
  		transform: translate(200px, 300px);
  		background-color: #F28C28;
  		border-radius: 50%;
  		box-shadow: inset -25px -25px 40px rgba(0,0,0,.5);
  		background-image: -webkit-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -moz-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);  
  		background-image: -o-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -ms-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
	}
	.circle-3 {
  		width: 860px;
  		height: 860px;
  		position: absolute;
  		z-index: 3;
  		transform: translate(900px, 500px);
  		background-color: #EE82EE;
  		border-radius: 50%;
  		box-shadow: inset -25px -25px 40px rgba(0,0,0,.5);
  		background-image: -webkit-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -moz-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);  
  		background-image: -o-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
  		background-image: -ms-linear-gradient(-45deg, rgba(255,255,220,.2) 0%, transparent 100%);
	
	</style>
    <title>Admin Login</title>
    <script>
	function clearErrorsFunction() {
  	var x = document.getElementById("err-msg");
  		x.innerHTML = "";
		}
</script>
  </head>
<body>
	<div class="circle-1"></div>
  <div class="circle-2"></div>
  <div class="circle-3"></div>
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

<li><a href="login.jsp" class="nav-link">User</a></li>
</ul>
</nav>
</div>
<div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
</div>
</div>
</header></div>
	<div class="error-message"></div>
  	<div  style="position: absolute; height: 30%; width: 30%; z-index: 4; background-color: white;  border-radius: 15px; padding: 60px; align-items: center; margin-top: 10%; margin-bottom: 10%; margin-left: 36%;">
	<form class="row g-4"  action="AdminLogin" method="post">
	<center><h1>Admin Login</h1></center>
  <div class="col-md-12">
    <label for="adminUsername" class="form-label">Username</label>
    <input type="text" class="form-control" id="adminUsername" name="adminUsername" placeholder="Enter username" onchange="clearErrorsFunction()" required>
  </div>
  <div class="col-md-12">
    <label for="adminPassword" class="form-label">Password</label>
    <input type="password" class="form-control" id="adminPassword" name="adminPassword" placeholder="Enter password" onchange="clearErrorsFunction()" required>
  </div>
  <div class="col-md-12" name="err-msg" onload="document.getElementById('err-p').innerHTML=''">
  	<p style="color:red;" id="err-p"><% HttpSession sess = request.getSession();
    		String inside_p = "";
    	  if(sess.getAttribute("loginUnsuccessful") != null && (int)sess.getAttribute("loginUnsuccessful") == 1){ inside_p ="Authentication Failed! Wrong username or password entered.";}%><%= inside_p%></p><% inside_p = ""; sess.setAttribute("loginUnsuccessful",0); %>
  </div>
  
 
    <button type="submit" style="margin-top: 40px; padding: 10px; background-color: #32cd32; border: 0px; "class="btn btn-success d-grid col-11 mx-auto">Login</button>
  </form>
  </div>
</body>
</html>