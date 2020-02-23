<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="pageTitle" value="Staff Login" />
<%@ include file="common/header.jspf"%>
<h2>Staff Login</h2>
<body>
	<c:url var="staffLoginFormUrl" value="/staffLogin" />
	<form:form action="${staffLoginFormUrl}" method="POST" modelAttribute="staffLogin">
		<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input class="form-control" path="email" placeholder="Email" />
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input type="password" class="form-control" path="password"
				placeholder="Password" />
		</div>
		<button type="submit" class="btn btn-default" style="background-color: #004445; color: #9fd5b3">Login</button>
	</form:form>
</body>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>