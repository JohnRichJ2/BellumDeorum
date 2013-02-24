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
		Hello, welcome to the site, please login!
	</p>

	<jsp:include page="login_module.jsp" />

	<jsp:include page="common_footer.jsp" />
</body>
</html>
