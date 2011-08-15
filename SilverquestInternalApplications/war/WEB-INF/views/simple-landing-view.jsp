<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="/style.css" type="text/css"></link>
</head>

<body>
	<h1>Landing Page</h1>
	<img
		src="http://code.google.com/appengine/images/appengine-silver-120x30.gif"
		alt="Powered by Google App Engine" />
	<ul>
		<li><a href="/timesheets/intro.htm">Create a new TimeSheet</a></li>
		<li><a href="">See Corrections</a></li>
		<li><a href="/simple-admin/intro.htm">Admin</a></li>
		<li><a href="">Approve TimeSheets</a></li>
	</ul>
	
	<%@ include file="userdetails.jsp" %>
</body>
</html>