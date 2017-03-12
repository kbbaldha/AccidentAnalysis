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
<spring:url value="/resources/css/animations.css" var="animationCss" />
<link href="${animationCss}" rel="stylesheet" />
<spring:url value="/resources/scripts/angular.min.js" var="angular" />
<script src="${angular}"></script>
<spring:url value="/resources/scripts/angular-animate.js" var="angularanimate" />
<script src="${angularanimate}"></script>


<spring:url value="/resources/scripts/main.js" var="main" />
<script src="${main}"></script>

<spring:url value="/resources/scripts/controllers/mainController.js" var="mainController" />
<script src="${mainController}"></script>
<spring:url value="/resources/scripts/controllers/safeNavigationController.js" var="safeNavigationController" />
<script src="${safeNavigationController}"></script>
<spring:url value="/resources/scripts/controllers/accidentPredictionController.js" var="accidentPredictionController" />
<script src="${accidentPredictionController}"></script>
<spring:url value="/resources/scripts/controllers/correlationSpeedController.js" var="correlationSpeedController" />
<script src="${correlationSpeedController}"></script>
<spring:url value="/resources/scripts/controllers/trendAnalysisController.js" var="trendAnalysisController" />
<script src="${trendAnalysisController}"></script>
<spring:url value="/resources/scripts/controllers/investigationReportController.js" var="investigationReportController" />
<script src="${investigationReportController}"></script>
<spring:url value="/resources/scripts/controllers/accidentReportController.js" var="accidentReportController" />
<script src="${accidentReportController}"></script>

<spring:url value="/resources/scripts/services/allservices.js" var="services" />
<script src="${services}"></script>

</head>
<body>${message}
 
	<div ng-controller="mainController" ng-app="myApp">
  		
  		<div ng-click="show(1)">Safe Navigation</div>
  		<div ng-click="show(2)">Accident Prediction</div>
  		<div ng-click="show(3)">Correlation Speed limit</div>
  		<div ng-click="show(4)">Trend Analysis</div>
  		<div ng-click="show(5)">Investigation Report</div>
  		<div ng-click="show(6)">Accident Report</div>
  		
  		<div class="animate-if" ng-if="showDiv==1" ng-controller="safeNavigationController" >{{name}}</div>
  		<div class="animate-if" ng-if="showDiv==2" ng-controller="accidentPredictionController">{{name}}</div>
  		<div class="animate-if" ng-if="showDiv==3" ng-controller="correlationSpeedController">{{name}}</div>
  		<div class="animate-if" ng-if="showDiv==4" ng-controller="trendAnalysisController">{{name}}</div>
  		<div class="animate-if" ng-if="showDiv==5" ng-controller="investigationReportController">{{name}}</div>
  		<div class="animate-if" ng-if="showDiv==6" ng-controller="accidentReportController">{{name}}</div>

	</div>
</body>