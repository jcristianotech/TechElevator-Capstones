<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="initial-scale=1.0">
<meta charset="utf-8">
<style>
/* Always set the map height explicitly to define the size of the div*/
/* element that contains the map. */
#map {
	margin: 0 auto 0 auto;
	height: 400px;
	width: 600px;
}

h3.warning {
	color: red;
	text-align: center;
}

.report-button {
	display: flex;
	justify-content: center;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script>
	
	var map;
	var directionsService;	
	var detroitCenterPos = {lat: 42.3650, lng: -83.0730} // TechTown
	var startMarker;
	var pos;

	$( document ).ready(function() {
	});      
	
	function initMap() {
		directionsService = new google.maps.DirectionsService();
		map = new google.maps.Map(document.getElementById('map'), {
		  center: detroitCenterPos,
		  zoom: 12
		});
		<c:forEach var="hole" items="${potholes}">
			var plat = ${hole.latitude}
			var plng =${hole.longitude}
			
			var pinColor = "mm_20_red.png"

			<c:if test="${hole.dateRepaired != null}">
				pinColor = "mm_20_green.png"
			</c:if>

			
			var urlString = "http://labs.google.com/ridefinder/images/" + pinColor
		
			var marker = new google.maps.Marker({
				position: {lat: plat, lng: plng},
				icon: {
					url: urlString
				},
				map: map
			});

		</c:forEach>
		map.addListener('click', function(e) {
		    placeMarker(e.latLng, map);
		});

		function placeMarker(position, map) {
		    var marker = new google.maps.Marker({
		        position: position,
		        icon: {
					url: urlString
				},
				map: map
		    });
		    map.panTo(position);
		    pos = position;
		    <!-- margaret will get back us on this-->
		}
    }
	
</script>

</head>
<body>
	<title>Home</title>

	<div class="important">
		<h3 class="warning" style="font-family: impact">
			&#9888; For the safety of yourself and others, please <u>DO NOT</u>
			report a pothole while driving. &#9888;
		</h3>
	</div>
	<h1 style="color: #004445; text-align: center;">POTHOLE TRACKER -
		DETROIT</h1>
	<h4 style="color: #004445; text-align: center;">
		<i>To report a pothole, please login.</i>
	</h4>
	<div class="report-button">
		<button type="submit" class="btn btn-default"
			style="text-align: center;">
			<c:url var="reportUrl" value="/report" />
			<a href="${reportUrl}" class="btn-user">Report</a>
		</button>
	</div>
	<br>
	<section class="home">
		<c:url var="formAction" value="/" />
		<form method="GET" action="${formAction}">
			<div id="wrapper">
				<div id="map"></div>
			</div>
			<script
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCaS38Te-INKef0SFOHYivHAEEbkSFa3_4&callback=initMap"
				async defer></script>
			<br>
			<h3 style="color: #004445; text-decoration: underline">Information</h3>
			<h4 style="color: #004445;">The map on this page shows potholes
				with green markers patched by the Department of Transportation in
				the last seven days. When crews respond to a pothole report, they
				fill all additional potholes on that block. The red markers indicate
				potholes that have been reported and are being scheduled for
				inspection and repair. Duplicate requests have been removed.</h4>
			<br>
		</form>
	</section>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="common/footer.jsp"%>