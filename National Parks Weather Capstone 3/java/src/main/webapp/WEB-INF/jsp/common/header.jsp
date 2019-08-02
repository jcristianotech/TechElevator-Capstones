<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <link href="<c:url value="/css/modern-normalize.css"/>" rel="stylesheet" type="text/css"/>
  <link href="<c:url value="/css/site.css"/>" rel="stylesheet" type="text/css"/>
  <title>National Park Geek | <c:out value="${param.pageTitle}"/></title>
</head>
<body>

<header>
  <div class="header-logo">
    <c:url var="LogoURL" value="/img/logo.png"/>
    <img src="${LogoURL}" alt="National Park Geek Logo"/>
  </div>
  <div class="header-nav">
    <nav>
	    <c:url var="HomeURL" value="/"/>
	    <a href="${HomeURL}">Home</a>
	    <c:url var="SurveyURL" value="/survey" />
	    <a href="${SurveyURL}">Survey</a>
    </nav>
  </div>
</header>
<section class="main-container">