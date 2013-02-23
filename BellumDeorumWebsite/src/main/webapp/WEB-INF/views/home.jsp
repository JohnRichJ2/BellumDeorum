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

<p>
	Hello, welcome to the site, please login!
</p>

<jsp:include page="login_module.jsp" />

</body>
</html>
