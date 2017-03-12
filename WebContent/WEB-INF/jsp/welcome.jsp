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
<spring:url value="/resources/scripts/angular.min.js" var="angular" />
<script src="${angular}"></script>
<spring:url value="/resources/scripts/main.js" var="main" />
<script src="${main}"></script>

</head>
<body>${message}
 
	<br>
	<br>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
 
		Welcome to Accident analysis
		Click <a
			href="http://crunchify.com/category/java-web-development-tutorial/"
			target="_blank">here</a> for all Java and <a
			href='http://crunchify.com/category/spring-mvc/' target='_blank'>here</a>
		for all Spring MVC, Web Development examples.<br>
	</div>
</body>