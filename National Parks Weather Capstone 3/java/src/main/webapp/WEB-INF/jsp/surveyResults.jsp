<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Survey" />
</c:import>

<div class="survey-results-wrapper">
	<h1>Survey Results</h1>
	<table>
		<tr>
			<th class=""></th>
			<th class="">Park</th>
			<th class="">Votes</th>
		</tr>
		<c:forEach items="${results}" var="result">
			<c:url var="parkDetailUrl" value="/parkDetail">
				<c:param name="parkCode" value="${result.parkCode}" />
			</c:url>
			<tr>
				<td class=""><a href="${parkDetailUrl}"> <img
						class="tableParkImg"
						src="<c:url value="img/parks/${fn:toLowerCase(result.parkCode)}.jpg" />" />
				</a></td>
				<td class=""><c:out value="${result.parkName}" /></td>
				<td class=""><c:out value="${result.votes}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />