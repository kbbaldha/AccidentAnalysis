<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="border-radius: 0px; margin-bottom: 0px;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      
      <a class="navbar-brand" href="login.html">Accident Analysis</a> 
      
    </div>
  </div><!-- /.container-fluid -->
</nav>
<div id="registerform" ng-controller="HomeController" ng-app="myApp" style="margin-top: 63px" >
<form  th:action="@{/register}" th:object="${user}" method="post">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Register Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="username" value="" th:field="*{username}"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" th:field="*{password}"/></td>
                    </tr>
                    <tr>
                    <td>Gender</td>
                         <td>
                         <select name ="gender" value = "" th:field="*{gender}" >
   							 <option value="F">Female</option>
   							 <option value="M">Male</option>
 						</select>
 						</td>
                    </tr>
                      <tr>
                        <td>Type</td>
                       <td>
                         <select name ="type" value = "" th:field="*{type}" >
   							 <option value="Transport Official">TransportOfficial</option>
   							 <option value="Civilian">User</option>
 						</select>
 						</td>
                    </tr>
                      <tr>
                        <td>Street</td>
                        <td><input type="text" name="username" value="" th:field="*{street}" /></td>
                    </tr>
                      <tr>
                        <td>City</td>
                        <td><input type="text" name="username" value="" th:field="*{city}" /></td>
                    </tr>
                      <tr>
                        <td>State</td>
                        <td><input type="text" name="username" value="" th:field="*{state}" /></td>
                    </tr>
                      <tr>
                        <td>Zip Code</td>
                        <td><input type="text" name="username" value="" th:field="*{zip}" /></td>
                    </tr>
					                    
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                     <tr>
                        <td colspan="2"> Returning user ? <a href="login.html">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
</div>
<div>${message}</div>
</body>
</html>