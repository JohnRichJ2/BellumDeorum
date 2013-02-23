<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
	<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/common.js" />"></script>
</head>
<body>

<h1>
	Bellum Deorum  
</h1>

<h2>
	Base <c:out value="${ player.name }" />
</h2>

<p>
	Welcome, yo!
</p>



</body>
</html>
