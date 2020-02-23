<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="User Login" />
<%@include file="common/header.jspf"%>

<h2>User Login</h2>
<body>
	<c:url var="userLoginFormUrl" value="/userLogin" />
	<form:form action="${userLoginFormUrl}" method="POST" modelAttribute="userLogin">
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

<!-- For some reason, JSP pages HATE it when I use form:form...eventually we
will need this for form validation and throwing errors, but for now
we have something -->
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>