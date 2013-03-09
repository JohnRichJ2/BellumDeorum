<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Bellum Deorum</title>
	<jsp:include page="common_head.jsp" />
</head>
<body>
	<jsp:include page="common_header.jsp" />

	<p>
		Register
	</p>
		
	<div class="login">
		<form action="<c:url value="/register/new" />" method="POST">
			<input class="defaultableTextInput" default="name" type="text" name="name">
			<input class="defaultableTextInput" default="email" type="text" name="email">
			<input class="defaultableTextInput" default="password" type="text" name="password">
			<input type="submit" value="Register">
		</form>
	</div>

	<jsp:include page="common_footer.jsp" />
</body>
</html>
