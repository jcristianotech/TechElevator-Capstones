<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div class="contain">
	<c:url var="userLoginUrl" value="/userLogin" />
	<form action="${userLoginUrl}" method="POST">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<div class="login-button">
			<button type="submit" class="btn btn-default" style="background-color: #004445; color: #9fd5b3" >
				User
				<%-- <c:url var="userLoginUrl" value="/userLogin" /> --%>
				<%-- <a href="${userLoginUrl}" class="btn-user">User</a> --%>
			</button>
		</div>
	</form>
	<br>
	<br>
	<c:url var="staffLoginUrl" value="/staffLogin" />
	<form action="${staffLoginUrl}" method="POST">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<div class="login-button">
			<button type="submit" class="btn btn-default" style="background-color: #004445; color: #9fd5b3" >
				Staff
				<%-- <a href="${staffLoginUrl}" class="btn-staff">Staff</a> --%>
			</button>
		</div>

	</form>
	</div>
</body>
</html>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>