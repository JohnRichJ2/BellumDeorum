<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>Login</title>
	<jsp:include page="common_head.jsp" />
</head>
<body>
	<jsp:include page="common_header.jsp" />

	<h1>
		You failed to login successfully, :(
	</h1>
	
	<jsp:include page="login_module.jsp" />


	<jsp:include page="common_footer.jsp" />
</body>
</html>
