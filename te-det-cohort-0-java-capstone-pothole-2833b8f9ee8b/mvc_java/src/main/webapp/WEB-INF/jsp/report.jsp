<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report A Pothole</title>
</head>
<body>
<h2>Enter GPS Coordinates</h2><br>
	<section class="report">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<c:url var="formAction" value="/report" />
		<form method="GET" action="${formAction}">
			<table>
				<tr>
					<td><b>Longitude: </b> <input type="text" name="longitude" placeholder="-83.0457538">
					<td></td>
				</tr>
				<tr>
					<td><b>Latitude: </b> <input type="text" name="latitude" placeholder="42.331427">
					<td><br>
				</tr>
			</table>
			<br>
			<div class="submit-button">
				<input type="submit" value="Submit" class="btn btn-default" 
				style="background-color: #004445; color: #9fd5b3"/>
			</div>
		</form>
	</section>
</body>
</html>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>