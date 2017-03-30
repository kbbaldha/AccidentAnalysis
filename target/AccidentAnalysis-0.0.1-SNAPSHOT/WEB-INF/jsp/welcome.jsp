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

<spring:url value="/resources/scripts/jquery.canvasjs.min.js" var="chart" />
<script src="${chart}"></script>

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
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" style="border-radius: 0px; margin-bottom: 0px;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      
      <a class="navbar-brand" href="#">Accident Analysis</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      
      <ul class="nav navbar-nav navbar-right">
        
       
        <li><a href="logout.jsp">Logout </a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		
     <div id="wrapper" class="toggled" ng-controller="mainController" ng-app="myApp">
		<div id="loader" ng-show="loader.loading" style="position: absolute; height: 100%; background-color: rgba(0,0,0,0.5);  width: 100%;     z-index: 1000;">
			<img src="resources/images/loader.gif" height="100px" width="100px" style="position:absolute;top:30%;left:30%;">
		</div>
		<!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#"> 
                        Menu
                 	</a>
                </li>
                <li>
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a ng-click="show(1)">Safe Navigation</a>
                </li>
                <li>
                    <a ng-click="show(2)">Accident Prediction</a>
                </li>
                <li>
                    <a ng-click="show(3)">Correlation Speed limit</a>
                </li>
                <li>
                    <a ng-click="show(4)">Trend Analysis</a>
                </li>
               <li>
                    <a ng-show="'${usertype}' == 'Transport official'" ng-click="show(5)">Investigation Report</a>
                </li>
                <li>
                    <a ng-show="'${usertype}' == 'Transport official'" ng-click="show(6)">Accident Report</a>
                </li>
               </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper" style="margin-top: 50px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                     <div class="animate-if" ng-if="showDiv==1" ng-controller="safeNavigationController">
                     	
                     
                     </div>
  					<div class="animate-if" ng-if="showDiv==2" ng-controller="accidentPredictionController"><b>City List:</b>
  					<div ng-repeat="city in cities">
  						{{city.Name}}
  					</div>
  					</div>
  					<div class="animate-if" ng-if="showDiv==3" ng-controller="correlationSpeedController">{{name}}</div>
  					<div class="animate-if" ng-if="showDiv==4" ng-controller="trendAnalysisController">
  						<div id="chartContainer" style="height: 300px; width: 100%;">
  						
  						</div>
  					</div>
  					<div class="animate-if" ng-if="showDiv==5" ng-controller="investigationReportController">{{name}}</div>
  					<div ng-if="showDiv==6" ng-controller="accidentReportController">
  					<form  th:action="@{/report}" th:object="${incident}" method="post">
           <div class="col-xs-3"></div>
           <div class="col-xs-6">
            <table class="table">
                <thead>
                    <tr>
                        <th colspan="2">Report Here</th>
                    </tr>
                </thead>
                <tbody>
                	 <tr>
                        <td>Investigator's Id *</td>
                        <td><input class="form-control" type="text" name="reporterid" value="" th:field="*{reporterid}"/></td>
                    </tr>
                     <tr>
                        <td>Number of team mambers *</td>
                        <td><input class="form-control" type="text" name="numofteammembers" value="" th:field="*{numberofteammembers}"/></td>
                    </tr>
                    <tr>
                    <td>Incident Type</td>
                         <td>
                         <select class="form-control" name ="incidenttype" value = "" th:field="*{eventtype}" >
                             <option value="roadwork">roadwork</option>
   							 <option value="disasters">disasters</option>
   							 <option value="precipitation">precipitation</option>
   							 <option value="trafficConditions">trafficConditions</option>
   							 <option value="obstruction">obstruction</option>
   							 <option value="accidentsAndIncidents">accidentsAndIncidents</option>
 						</select>
 						</td>
                    </tr>
                      <tr>
                        <td>Incident Cause</td>
                       <td>
                         <select class="form-control" name ="incidentsubtype" value = "" th:field="*{eventsubtype}" >
  							 <option value="road construction">road construction</option>
   							 <option value="road maintenance operations">road maintenance operations</option>
   							 <option value="major flood">major flood</option>
   							 <option value="vehicle on fire">vehicle on fire</option>
   							 <option value="snow">snow</option>
   							 <option value="incident">incident</option>
   							 <option value="debris on roadway">debris on roadway</option>
   							 <option value="disabled vehicle">disabled vehicle</option>
   							 <option value="accident">accident</option>
   							 <option value="traffic congestion">traffic congestion</option>
 						</select>
 						</td>
                    </tr>
                      <tr>
                        <td>Latitude</td>
                        <td><input class="form-control" type="text" name="latitude" value="" th:field="*{latitude}" /></td>
                    </tr>
                      <tr>
                        <td>Longitude</td>
                        <td><input class="form-control" type="text" name="longitude" value="" th:field="*{logitude}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Report" style="margin-right:10px"/><input type="reset" value="Reset" /></td>
                    </tr>
                </tbody>
            </table>
             <div style="margin-left: 82px;margin-top: -16px;color: red;width: -moz-max-content;">${message}</div>
            </div>
            <div class="col-xs-3"></div>
         </form>
  		 </div>         
         </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
 
	
</body>