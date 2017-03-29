<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Accident Analysis</title>
<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>

<spring:url value="/resources/css/bootstrap.min.css" var="bootCss" />
<link href="${bootCss}" rel="stylesheet" />
<spring:url value="/resources/css/simple-sidebar.css" var="sidebar" />
<link href="${sidebar}" rel="stylesheet" />

<spring:url value="/resources/css/animations.css" var="animationCss" />
<link href="${animationCss}" rel="stylesheet" />
<spring:url value="/resources/css/maincss.css" var="mainminCss" />
<link href="${mainminCss}" rel="stylesheet" />


<spring:url value="/resources/scripts/angular.min.js" var="angular" />
<script src="${angular}"></script>
<spring:url value="/resources/scripts/angular-animate.js" var="angularanimate" />
<script src="${angularanimate}"></script>


<spring:url value="/resources/scripts/jquery.js" var="jquery" />
<script src="${jquery}"></script>

<spring:url value="/resources/scripts/bootstrap.min.js" var="bootstrap" />
<script src="${bootstrap}"></script>

<spring:url value="/resources/scripts/main.js" var="main" />
<script src="${main}"></script>

</head>
<body>
<!-- ${message} -->
		<nav class="navbar navbar-inverse navbar-fixed-top" style="border-radius: 0px; margin-bottom: 0px;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      
      <a class="navbar-brand" href="login.html">Accident Analysis</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      
      <ul class="nav navbar-nav navbar-right">
        
       
        <li><a href="login.html">Login </a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		<br>
    <div style="text-align:center;margin-top:20%; ">
		<h2>
		 You've been logged out successfully!
		</h2>
	</div>
	
</body>