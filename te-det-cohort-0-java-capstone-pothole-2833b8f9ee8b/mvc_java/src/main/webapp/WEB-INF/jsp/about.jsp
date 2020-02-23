<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
<style>

body {
	background-color: yellow;
}

.pothole {
	display: inline-block;
}

.notPothole {
	
}
</style>
</head>
<body>
	<h1
		style="text-decoration: underline; color: #004445; font-family: helvetica;">Pothole
		in the Street</h1>
	<p>This service request allows for Detroit residents to report
		street surface potholes. Potholes are typically irregularly shaped
		pavement holes. If the problem appears to be a utility cut (usually a
		square cut for water or sewer repairs) or a sinkhole (usually a dip in
		the pavement or a void, often near a manhole or catch basin), please
		call 311 directly.</p>

	<h3 style="text-decoration: underline; color: #004445;">What is a
		pothole?</h3>
	<p>A pothole is formed when street surfaces freeze and thaw and
		crack, allowing water to seep under the pavement. As that water
		freezes and thaws, it causes an expansion in the surface crack,
		creating what we see as potholes. Potholes usually occur in a traffic
		lane of roadways and are normally irregular in shape and size. They
		also tend to be relatively shallow holes unless ignored, and the base
		of the street is still observable.</p>

	<h3 style="text-decoration: underline; color: #004445;">What is a
		cave-in?</h3>
	<p>Cave-ins can occur when utility services housed underneath the
		roadway are damaged and are usually found near a manhole or catch
		basin. Cave-ins, sometimes called sinkholes, can range from a slight
		dip in the roadway to a deep hole in the pavement that requires
		immediate attention.</p>

	<h3 style="text-decoration: underline; color: #004445;">Who fixes
		potholes and cave-ins?</h3>
	<p>DDOT has inspectors in neighborhoods across the city and
		construction crews assigned to repair potholes throughout the year.
		Because most potholes occur during the winter and spring, DDOT
		schedules crews to work every day, including weekends during 'pothole
		season'. When a cave-in or sinkhole is reported, DDOT inspectors will
		assess the degree of damage to the roadway and determine what caused
		the problem. It will then forward its assessment to the agency or
		utility company that needs to make the repairs. Depending on what
		caused the cave-in, work under the roadway might need to be completed
		before the road repairs are made. Residents are asked to report
		potholes and cave-ins they encounter to 311.</p>

	<h3
		style="text-decoration: underline; color: #004445; display: inline-block;">Pothole
		 vs Not a Pothole</h3>
	<div class="pothole" style="">
		<c:url var="potholeUrl" value="img/pothole.jpg" />
		<img src="${potholeUrl}" height="100%" width="40%" border="10" />
		<c:url var="notPotholeUrl" value="img/NotPothole.jpg" />
		<img src="${notPotholeUrl}" height="5%" width="40%" border="10" />
	</div>
	<div class="info">
		<h3 style="text-decoration: underline; color: #004445;">Why is
			the pothole still there?</h3>
		<p>There are several reasons why we may not have made the repair
			you requested:</p>
		<p>
		<h4 style="text-decoration: underline; color: #004445;">Weather
			Delay:</h4>
		Potholes cannot be filled if it is raining, if the pothole itself is
		filled with water or when the temperature is below 45 degrees.
		Flooding or extended periods of rain or freezing temperatures can
		create a backlog of repairs. When work is delayed, the requested
		repairs go into queue until weather conditions improve. The crews then
		work overtime to resolve the backlog of repairs.
		</p>
		<p>
		<h4 style="text-decoration: underline; color: #004445;">Can't
			find the pothole:</h4>
		Sometimes customers give incomplete or insufficient information and we
		cannot locate the potholes they are reporting. This is why leaving
		your name and email address is so important. The more contact
		information we have, the easier and faster it is to contact you for a
		better description of the location.
		</p>
		<p>
		<h4 style="text-decoration: underline; color: #004445;">Other
			Jurisdictions:</h4>
		Some locations in the City of Detroit are actually owned and/or
		maintained by other entities such as the City of Hamtramck, the City
		of Highland Park, or private owners. When citizens report potholes on
		roads that are outside of the City of Detroit's responsibility, we
		forward the information to the right entity.
		</p>
	</div>
</body>
</html>
<br>
<br>
<br>
<br>
<%@ include file="common/footer.jsp"%>