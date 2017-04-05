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
<spring:url value="/resources/scripts/angular-animate.js"
	var="angularanimate" />
<script src="${angularanimate}"></script>


<spring:url value="/resources/scripts/jquery.js" var="jquery" />
<script src="${jquery}"></script>

<spring:url value="/resources/scripts/bootstrap.min.js" var="bootstrap" />
<script src="${bootstrap}"></script>

<spring:url value="/resources/scripts/jquery.canvasjs.min.js"
	var="chart" />
<script src="${chart}"></script>

<spring:url value="/resources/scripts/main.js" var="main" />
<script src="${main}"></script>

<spring:url value="/resources/scripts/controllers/mainController.js"
	var="mainController" />
<script src="${mainController}"></script>
<spring:url
	value="/resources/scripts/controllers/safeNavigationController.js"
	var="safeNavigationController" />
<script src="${safeNavigationController}"></script>
<spring:url
	value="/resources/scripts/controllers/accidentPredictionController.js"
	var="accidentPredictionController" />
<script src="${accidentPredictionController}"></script>
<spring:url
	value="/resources/scripts/controllers/correlationSpeedController.js"
	var="correlationSpeedController" />
<script src="${correlationSpeedController}"></script>
<spring:url
	value="/resources/scripts/controllers/trendAnalysisController.js"
	var="trendAnalysisController" />
<script src="${trendAnalysisController}"></script>
<spring:url
	value="/resources/scripts/controllers/investigationReportController.js"
	var="investigationReportController" />
<script src="${investigationReportController}"></script>
<spring:url
	value="/resources/scripts/controllers/accidentReportController.js"
	var="accidentReportController" />
<script src="${accidentReportController}"></script>

<spring:url value="/resources/scripts/services/allservices.js"
	var="services" />
<script src="${services}"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="border-radius: 0px; margin-bottom: 0px;">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<a class="navbar-brand" href="#">Accident Analysis</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<ul class="nav navbar-nav navbar-right">


				<li><a href="logout.jsp">Logout </a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div id="wrapper" class="toggled" ng-controller="mainController"
		ng-app="myApp">
		<div id="loader" ng-show="loader.loading"
			style="position: absolute; height: 100%; background-color: rgba(0, 0, 0, 0.5); width: 100%; z-index: 1000;">
			<img src="resources/images/loader.gif" height="100px" width="100px"
				style="position: absolute; top: 30%; left: 30%;">
		</div>
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Menu </a></li>
				<li><a href="#">Dashboard</a></li>
				<li><a ng-click="show(1)">Safe Navigation</a></li>
				<li><a ng-click="show(2)">Accident Prediction</a></li>
				<li><a ng-click="show(3)">Correlation Speed limit</a></li>
				<li><a ng-click="show(4)">Trend Analysis</a></li>
				<li><a ng-show="'${usertype}' == 'Transport official'"
					ng-click="show(5)">Investigation Report</a></li>
				<li><a ng-show="'${usertype}' == 'Transport official'"
					ng-click="show(6)">Accident Report</a></li>
                <li>
                    <a ng-click="show(7)">Table Meta Data</a>
                </li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper" style="margin-top: 50px;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="animate-if" ng-if="showDiv==1"
							ng-controller="safeNavigationController"></div>
                     		<div id="map"></div>
						<div class="animate-if" ng-if="showDiv==2"
	ng-controller="accidentPredictionController">
							<b>City List:</b>
							<div ng-repeat="city in cities">{{city.Name}}</div>
						</div>
						<div class="animate-if" ng-if="showDiv==3"
							ng-controller="correlationSpeedController">
							<div id="scatterChartContainer" style="height: 300px; width: 100%;">
							</div>
							</div>
						<div class="animate-if" ng-if="showDiv==4"
							ng-controller="trendAnalysisController">
							<div id="chartContainer" style="height: 300px; width: 100%;">

							</div>
						</div>
  					<div class="animate-if" ng-if="showDiv==5" ng-controller="investigationReportController">
  						Enter Username: <input class="form-control" type="text" ng-model="userName"></input>
  						<button class"btn" ng-click="getDays()">Get Average Days</button>
  						<p ng-show="avgDays > 0" >The avg number of days to solve incident is {{avgDays}}<p>
  					</div>
						<div ng-if="showDiv==6" ng-controller="accidentReportController">
							<form name="incident" novalidate>
								<center>
									<div class="col-xs-3"></div>
									<div class="col-xs-5">
										<table  class="table">
											<thead>
												<tr>
													<th colspan="2">Report Incident here</th>
												</tr>
											</thead>
											<tbody>
											<tr>
												<td>No of team members *</td>
												<td><input name="numofteammembers" type="text"
													ng-model="numofteammembers" required></td>
											</tr>

											<tr>
												<td>Incident Type *</td>
												<td><select name="incidenttype" value=""
													ng-model="incidenttype" required>
														<option value="roadwork">roadwork</option>
														<option value="disasters">disasters</option>
														<option value="precipitation">precipitation</option>
														<option value="trafficConditions">trafficConditions</option>
														<option value="obstruction">obstruction</option>
														<option value="accidentsAndIncidents">accidentsAndIncidents</option>
												</select></td>
											</tr>

											<tr>
												<td>Incident Cause *</td>
												<td><select name="incidentsubtype" value=""
													ng-model="incidentsubtype" required>
														<option value="road construction">road
															construction</option>
														<option value="road maintenance operations">road
															maintenance operations</option>
														<option value="major flood">major flood</option>
														<option value="vehicle on fire">vehicle on fire</option>
														<option value="snow">snow</option>
														<option value="incident">incident</option>
														<option value="debris on roadway">debris on
															roadway</option>
														<option value="disabled vehicle">disabled vehicle</option>
														<option value="accident">accident</option>
														<option value="traffic congestion">traffic
															congestion</option>
												</select></td>
											</tr>

											<tr>
												<td>Latitude</td>
												<td><input type="text" name="latitude" value=""
													ng-model="latitude" /></td>
											</tr>
											<tr>
												<td>Longitude</td>
												<td><input type="text" name="longitude" value=""
													ng-model="logitude" /></td>
											</tr>

											<tr>
												<td>
													<button ng-click="reset()">Reset</button>
												</td>
												<td>
													<button ng-click="submit()">Submit</button>
												</td>
											</tr>
											</tbody>
										</table>
										<div style="margin-left: -27px; margin-top: 20px; color: red;">{{message}}</div>
									</div>
							</form>
							
         			<div class="animate-if" ng-if="showDiv==7" ng-controller="tableDataController">
  						
  						<p>The total number of rows are <b>{{total.RowCount}}</b></p>
  						<br/>
  						<table class="table table-condensed">
    					<thead>
      					<tr>
       					 	<th>Table Name</th>
        					<th>Row Count</th>
     						 </tr>
    					</thead>
    					<tbody>
      					<tr ng-repeat="table in tables">
        					<td>{{table.TableName}}</td>
        					<td>{{table.RowCount}}</td>
      					</tr>
      					</tbody>
      					</table>
  					</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /#page-content-wrapper -->

		</div>
		<!-- /#wrapper -->
	
<script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAyhMnyMaiJeOXb7flbK2NDs__m7zygWhw&callback=initMap">
</script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
</body>