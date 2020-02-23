<%@ include file="common/header.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Register" />
<h1>Registration</h1>

<body>
	<c:url var="registerUrl" value="/register" />
	
<%-- <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" /> --%>

	<form:form  modelAttribute="user" action="${registerUrl}" method="post">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
		<div class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" class="form-control" placeholder="First Name" />
			<form:errors path="firstName" cssClass="bg-danger" />
		</div>
		<div class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input class="form-control" path="lastName" placeholder="Last Name" />
			<form:errors path="lastName" cssClass="bg-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:input class="form-control" path="email" placeholder="Email" />
			<form:errors path="email" cssClass="bg-danger" />
		</div>
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:password class="form-control" path="password" />
			<form:errors path="password" cssClass="bg-danger" />
		</div>
<%-- 		<div class="form-group">
			<form:label path="confirmPassword">Confirm Password</form:label>
			<form:password class="form-control" path="confirmPassword" />
		</div> --%>

		<button type="submit" class="btn btn-default" style="background-color: #004445; color: #9fd5b3" >Save User</button>
	</form:form>
</body>

<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>