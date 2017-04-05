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
<spring:url value="/resources/scripts/angular-animate.js"
	var="angularanimate" />
<script src="${angularanimate}"></script>


<spring:url value="/resources/scripts/jquery.js" var="jquery" />
<script src="${jquery}"></script>

<spring:url value="/resources/scripts/bootstrap.min.js" var="bootstrap" />
<script src="${bootstrap}"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="border-radius: 0px; margin-bottom: 0px;">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<a class="navbar-brand" href="login.html">Accident Analysis</a>

		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div id="registerform" ng-controller="HomeController" ng-app="myApp"
		style="margin-top: 63px">
		<form th:action="@{/register}" th:object="${user}" method="post">
			<div class="col-xs-3"></div>
			<div class="col-xs-6">
				<script type="text/javascript">
					function onchange_handler(obj, id) {
						var other_id = (id == 'transport') ? 'user'
								: 'transport';
						if (obj.checked) {
							document.getElementById(id + '_form_fields').style.display = 'block';
							document.getElementById(other_id + '_form_fields').style.display = 'none';
						} else {
							document.getElementById(id + '_form_fields').style.display = 'none';
							document.getElementById(other_id + '_form_fields').style.display = 'block';
						}
					}
				</script>
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">Register Here</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>First Name *</td>
							<td><input class="form-control" type="text" name="firstname"
								value="" th:field="*{firstname}" /></td>
						</tr>
						<tr>
							<td>Last Name *</td>
							<td><input class="form-control" type="text" name="lastname"
								value="" th:field="*{lastname}" /></td>
						</tr>
						<tr>
							<td>Choose User Name *</td>
							<td><input class="form-control" type="text" name="username"
								value="" th:field="*{username}" /></td>
						</tr>
						<tr>
							<td>Password *</td>
							<td><input class="form-control" type="password"
								name="password" value="" th:field="*{password}" /></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><select class="form-control" name="gender" value=""
								th:field="*{gender}">
									<option value="F">Female</option>
									<option value="M">Male</option>
							</select></td>
						</tr>
						<tr>
							 <td>Type</td>
							<!-- <td><select class="form-control" name="type" value=""
								th:field="*{type}">
									<option value="Transport official">TransportOfficial</option>
									<option value="Civilian">User</option>
							</select></td>-->
							<td>
							<input type="radio" name="type" value="Transport official"
								id="individual_form" style="margin: 0px !important"
								onchange="onchange_handler(this, 'transport');"
								onmouseup="onchange_handler(this, 'transport');">
							<strong>Transport Official</strong>

							<input type="radio" name="type" value="Civilian"
								id="corporation_form" style="margin: 0px !important"
								onchange="onchange_handler(this, 'user');"
								onmouseup="onchange_handler(this, 'user');">
							<strong>User</strong>
							</td>
						</tr>
					<!-- <div id="transport_form_fields" style="display: none;">-->
						<tr id="transport_form_fields" style="display: none;">
							<td>Role</td>
							<td><select class="form-control" name="role" value=""
								th:field="role">
									<option value="1">Accident Investigator</option>
									<option value="2">Accident Lead</option>
									<option value="3">Data Entry Official</option>
									<option value="4">Accident Scene Specialist</option>
									<option value="5">Road Official</option>
									<option value="6">Transport Manager</option>
									<option value="7">Chief of Staff</option>
									<option value="8">Construction Officer</option>
									<option value="9">Safety and Mobility Officer</option>
									<option value="10">External Relations Officer</option>
									<option value="11">Policy and Planning Officer</option>
									<option value="12">Regional Officer</option>
									<option value="13">Traffic Regulation Officer</option>
									<option value="14">Highway Planner</option>
									<option value="15">Supervisor</option>
									<option value="16">Government Co-ordinator</option>
									<option value="17">Commuter Relations Officer</option>
									<option value="18">Photographer</option>
									<option value="19">Highway Patrol Officer</option>
									<option value="20">Support Official</option>
							</select></td>
						</tr>
						
						<tr id="user_form_fields" style="display: none;">
							<td>Job Desc</td>
							<td><input class="form-control" type="text" name="job"
								value="" th:field="*{role}" /></td>
						</tr>
						
						<tr>
							<td>Street</td>
							<td><input class="form-control" type="text" name="street"
								value="" th:field="*{street}" /></td>
						</tr>
						<tr>
							<td>City</td>
							<td><input class="form-control" type="text" name="city"
								value="" th:field="*{city}" /></td>
						</tr>
						<tr>
							<td>State</td>
							<td><input class="form-control" type="text" name="state"
								value="" th:field="*{state}" /></td>
						</tr>
						<tr>
							<td>Zip Code</td>
							<td><input class="form-control" type="text" name="zip"
								value="" th:field="*{zip}" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" value="Register"
								style="margin-right: 10px" /><input type="reset" value="Reset" /></td>
						</tr>
						<tr>
							<td colspan="2">Returning user ? <a href="login.html">Login
									Here</a></td>
						</tr>
					</tbody>
				</table>
				<div
					style="margin-left: 82px; margin-top: -16px; color: red; width: -moz-max-content;">${message}</div>
			</div>
			<div class="col-xs-3"></div>

		</form>

	</div>

</body>
</html>