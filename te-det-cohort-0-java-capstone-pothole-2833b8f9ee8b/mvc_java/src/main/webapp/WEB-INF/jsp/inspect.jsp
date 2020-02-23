<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Inspections Here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	padding: 5px;
	text-align: left;
	background-color: #F7C705;
}

tr:nth-child(odd) {
	background: #dbdbdb;
}

td {
	padding: 5px;
	text-align: center;
}

table {
	border-spacing: 25px;
}

div.word-break {
	word-wrap: break-word;
}
</style>
</head>
<body>
	<section class="inspect">
		<c:url var="formAction" value="/inspect" />
		<form method="POST" action="${formAction}">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<h1>Update Inspection</h1>
			<div class="inspect">
				<div class="listOfInspections">
					<c:choose>
						<c:when test="${not empty inspectedPotholes}">
							<table width=100%>
								<tr>
									<th style="padding: 10px"></th>
									<th style="padding: 10px">Pothole ID:</th>
									<th style="padding: 10px">Date Inspection:</th>
									<th style="padding: 10px">Rank:</th>
									<th style="padding: 10px">Description:</th>
								</tr>
								<c:forEach var="inspectedPotholes" items="${inspectedPotholes}">
									<tr>
										<td><input type="checkbox" name="selected"
											value="${inspectedPotholes.potholeId}"></td>
										<td><c:out value="${inspectedPotholes.potholeId}" /></td>
										<td><select name="dateInspection">
												<option value="blank"></option>
												<option value="08/30/2019">08/30/2019</option>
												<option value="08/31/2019">08/31/2019</option>
												<option value="09/01/2019">09/01/2019</option>
												<option value="09/02/2019">09/02/2019</option>
												<option value="09/03/2019">09/03/2019</option>
												<option value="09/04/2019">09/04/2019</option>
												<option value="09/05/2019">09/05/2019</option>
												<option value="09/06/2019">09/06/2019</option>
												<option value="09/07/2019">09/07/2019</option>
												<option value="09/08/2019">09/08/2019</option>
												<option value="09/09/2019">09/09/2019</option>
												<option value="09/10/2019">09/10/2019</option>
												<option value="09/11/2019">09/11/2019</option>
												<option value="09/12/2019">09/12/2019</option>
												<option value="09/13/2019">09/13/2019</option>
												<option value="09/14/2019">09/14/2019</option>
												<option value="09/15/2019">09/15/2019</option>
												<option value="09/16/2019">09/16/2019</option>
												<option value="09/17/2019">09/17/2019</option>
										</select></td>
										<td><select name="rank">
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
										</select></td>
										<td><input type="text" name="description"
											placeholder="Please enter detailed information about the pothole."
											style="width: 600px;"></td>
									</tr>
								</c:forEach>
							</table>
						</c:when>
					</c:choose>
				</div>
				<br>
				<div class="update-button">
					<input type="submit" value="Update" class="btn btn-default"
						style="background-color: #004445; color: #9fd5b3" />
				</div>
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