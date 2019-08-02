<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Home" />
</c:import>

<%-- <div class="park-detail-wrapper"> --%>

	<div class="park-">
    <div class="park-detail-image">
      <c:url var="parkImageUrl" value="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" />
      <img src="${parkImageUrl}" />
    </div>
		<div class="quote">
			"<c:out value="${park.inspirationalQuote}" />"
			<div class="quote-source">
				<c:out value="${park.inspirationalQuoteSource}" />
			</div>
		</div>
	</div>

	<div class="grid-container">

		<%-- <div class=""> --%>

			<div class="park-description">
				<c:out value="${park.parkDescription}" />
			</div>

			<div class="park-name">
				<div class="name">
					<c:out value="${park.parkName}" />
				</div>
				<div class="state-founded">
					<div class="state">
						<c:out value="${park.state}" />
					</div>
					<div class="founded">
						Founded
						<c:out value="${park.yearFounded}" />
					</div>
				</div>
			</div>
			
			<div class="visitor-info">
				<div class="campsite-title">Campsites:</div>
				<div class="visitor-title">Annual Visitors:</div>
				<div class="entry-fee-title">Entry Fee:</div>
				<div class="campsites-count">
					<c:out value="${park.numberOfCampsites}" />
				</div>
				<div class="visitor-count">
					<c:out value="${park.annualVisitorCount}" />
				</div>
				<div class="entry-fee">
					<c:out value="${park.entryFee}" />
				</div>
			</div>
			
			<div class="park-detail">
				<div class="climate-title">Climate:</div>
				<div class="climate">
					<c:out value="${park.climate}" />
				</div>
				<div class="acerage-title">Acerage:</div>
				<div class="acerage">
					<c:out value="${park.acreage}" />
				</div>
				<div class="miles-of-trails-title">Miles of Trails:</div>
				<div class="miles-of-trails">
					<c:out value="${park.milesOfTrail}" />
				</div>
				<div class="elevation-title">Elevation:</div>
				<div class="elevation">
					<c:out value="${park.elevationInFeet}" />
					ft
				</div>
				<div class="animal-species-title">Animal Species:</div>
				<div class="animal-species">
					<c:out value="${park.numberOfAnimalSpecies}" />
				</div>
			</div>

		<%-- </div> --%>

		<div class="temp-switch">
			<c:set var="otherUnit" value="Celsius" />
			<c:if test="${temperatureUnit.celsius == true}">
				<c:set var="otherUnit" value="Farenheit" />
			</c:if>

			<c:url var="switchUnitUrl" value="/switchTempUnit">
				<c:param name="parkCode" value="${park.parkCode}" />
				<c:param name="isCelsius" value="${!temperatureUnit.celsius}" />
			</c:url>
			<a href="${switchUnitUrl}"><span><c:out value="Show in ${otherUnit}" /></span></a>
		</div>

		<div class="park-weather-main">

			<c:forEach var="day" items="${weather.dailyWeather}"
				varStatus="iteration">

				<c:set var="weatherClass" value="weatherDay" />
				<c:if test="${iteration.index == 0 }">
					<c:set var="weatherClass" value="weatherToday" />
				</c:if>
				<div class="${weatherClass} weatherDisplay">
					<h3>
						<c:out value="${day.dayName}" />
					</h3>
					<img
						src="<c:url value="img/weather/${fn:replace(day.forecast,' ', '')}.png" />" />
					<h4>
						<c:out value="${day.forecast}" />
					</h4>
					<div class="">
						<div class="">
							<div class="">High</div>
							<div>
								<c:out value="${day.highWithUnit}" />
							</div>
						</div>
						<div class="">
							<div class="">Low</div>
							<div>
								<c:out value="${day.lowWithUnit}" />
							</div>
						</div>
					</div>

					<div class="">
						<ul>
							<c:forEach var="warning" items="${day.warnings}">
								<li><c:out value="${warning}" /></li>
							</c:forEach>
						</ul>
					</div>
				</div>

			</c:forEach>

		</div>

	</div>

<%-- </div> --%>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />