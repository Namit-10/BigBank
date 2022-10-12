<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "javax.servlet.http.HttpSession, java.sql.ResultSet" %>

<%@ page import = "javax.servlet.http.HttpSession, com.bank.dao.*, java.sql.ResultSet" %>
<% HttpSession sess = request.getSession(); ResultSet rs = (ResultSet)sess.getAttribute("resultset");  String username = ""; if(rs != null){ username = rs.getString(1);String password = rs.getString(2);
double balance = BankDao.checkBalance(username,password);}
	else {response.sendRedirect("login.jsp");}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
<link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!--  <script defer="" referrerpolicy="origin" src="/cdn-cgi/zaraz/s.js?z=JTdCJTIyZXhlY3V0ZWQlMjIlM0ElNUIlNUQlMkMlMjJ0JTIyJTNBJTIyV2Vic2l0ZSUyME1lbnUlMjAlMjM0JTIyJTJDJTIyeCUyMiUzQTAuOTc1MjAxODAxOTI4NTk1NyUyQyUyMnclMjIlM0ExOTIwJTJDJTIyaCUyMiUzQTEwODAlMkMlMjJqJTIyJTNBOTQ4JTJDJTIyZSUyMiUzQTE4NDglMkMlMjJsJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZwcmV2aWV3LmNvbG9ybGliLmNvbSUyRnRoZW1lJTJGYm9vdHN0cmFwJTJGd2Vic2l0ZS1tZW51LTA0JTJGJTIyJTJDJTIyciUyMiUzQSUyMmh0dHBzJTNBJTJGJTJGY29sb3JsaWIuY29tJTJGJTIyJTJDJTIyayUyMiUzQTI0JTJDJTIybiUyMiUzQSUyMlVURi04JTIyJTJDJTIybyUyMiUzQS0zMzAlMkMlMjJxJTIyJTNBJTVCJTVEJTdE"></script>
<script nonce="cf078d64-675b-4313-8a11-5eb183dd4e62">(function(w,d){!function(a,e,t,r){a.zarazData=a.zarazData||{};a.zarazData.executed=[];a.zaraz={deferred:[],listeners:[]};a.zaraz.q=[];a.zaraz._f=function(e){return function(){var t=Array.prototype.slice.call(arguments);a.zaraz.q.push({m:e,a:t})}};for(const e of["track","set","debug"])a.zaraz[e]=a.zaraz._f(e);a.zaraz.init=()=>{var t=e.getElementsByTagName(r)[0],z=e.createElement(r),n=e.getElementsByTagName("title")[0];n&&(a.zarazData.t=e.getElementsByTagName("title")[0].text);a.zarazData.x=Math.random();a.zarazData.w=a.screen.width;a.zarazData.h=a.screen.height;a.zarazData.j=a.innerHeight;a.zarazData.e=a.innerWidth;a.zarazData.l=a.location.href;a.zarazData.r=e.referrer;a.zarazData.k=a.screen.colorDepth;a.zarazData.n=e.characterSet;a.zarazData.o=(new Date).getTimezoneOffset();a.zarazData.q=[];for(;a.zaraz.q.length;){const e=a.zaraz.q.shift();a.zarazData.q.push(e)}z.defer=!0;for(const e of[localStorage,sessionStorage])Object.keys(e||{}).filter((a=>a.startsWith("_zaraz_"))).forEach((t=>{try{a.zarazData["z_"+t.slice(7)]=JSON.parse(e.getItem(t))}catch{a.zarazData["z_"+t.slice(7)]=e.getItem(t)}}));z.referrerPolicy="origin";z.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(a.zarazData)));t.parentNode.insertBefore(z,t)};["complete","interactive"].includes(e.readyState)?zaraz.init():a.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,0,"script");})(window,document);</script>
-->
<style>
body {
	background-color: #800080;
}
</style>
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
<li><a href="DecideCard" class="nav-link">Debit Card</a></li>
<li><a href="Logout" class="nav-link">Logout</a></li>
</ul>
</nav>
</div>
<div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>
</div>
</div>
</header></div>


</body>
</html>