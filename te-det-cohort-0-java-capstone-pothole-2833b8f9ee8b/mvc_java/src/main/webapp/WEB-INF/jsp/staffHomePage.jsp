<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Home Page</title>
</head>
<body>
	<c:url var="staffHomeUrl" value="/staffHomePage" />
	<form action="${staffHomeUrl}" method="POST">
		<div class="login-button">
			<button type="submit" class="btn btn-default"
				style="background-color: #004445; color: #9fd5b3; text-decoration: none;">
				<c:url var="reviewUrl" value="/review" />
				<a href="${reviewUrl}" class="">Review Potholes</a>
			</button>
		</div>
		<br> <br>
	</form>
</body>
</html>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>