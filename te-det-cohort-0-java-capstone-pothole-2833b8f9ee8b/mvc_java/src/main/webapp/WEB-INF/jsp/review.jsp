
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review Potholes</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th {
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
	<section class="review">
		<c:url var="formAction" value="/review" />
		<form method="POST" action="${formAction}">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<h1>Review Potholes</h1>
			<div class="review">
				<table style="width: 100%;">
					<tr>
						<th style="padding:10px"></th>
						<th style="padding:10px">Pothole ID:</th>
						<th style="padding:10px">Date Reported:</th>
						<th style="padding:10px">User ID:</th>
						<th style="padding:10px">Latitude:</th>
						<th style="padding:10px">Longitude:</th>
						<th style="padding:10px">Date Inspected:</th>
						<th style="padding:10px">Rank:</th>
						<th style="padding:10px">Date Repaired:</th>
						<th style="padding:10px">Description:</th>
					</tr>
					<div class="listOfReviews">
						<c:forEach var="potholes" items="${potholes}">
							<tr>
								<td><input type="checkbox" name="selected" value="${potholes.potholeId}"/></td>
								<td><c:out value="${potholes.potholeId}" /></td>
								<td><c:out value="${potholes.dateReported}" /></td>
								<td><c:out value="${potholes.userId}" /></td>
								<td><c:out value="${potholes.latitude}" /></td>
								<td><c:out value="${potholes.longitude}" /></td>
								<td><c:out value="${potholes.dateInspected}" /></td>
								<td><c:out value="${potholes.rank}" /></td>
								<td><c:out value="${potholes.dateRepaired}" /></td>
								<td><c:out value="${potholes.description}" /></td>
							</tr>
						</c:forEach>
				</table>
			</div>
			<br> <input type="submit" name="btn" value="Delete"
				class="btn btn-default"
				style="background-color: #d6281c; color: #dbdbdb" /> <br> <br>
			<br> <input type="submit" name="btn" class="btn btn-default"
				value="Inspect" style="background-color: #004445; color: #dbdbdb" />

			<br> <input type="submit" name="btn" value="Repair"
				class="btn btn-default"
				style="background-color: #004445; color: #dbdbdb" />
		</form>
	</section>
</body>
</html>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>