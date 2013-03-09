<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>User</title>
	<jsp:include page="common_head.jsp" />
</head>
<body>
	<jsp:include page="common_header.jsp" />

	<h2>
		Base <c:out value="${ user.name }" />
	</h2>
	
	<p>
		Welcome, yo!
	</p>
	
	<p>
		Base <c:out value="${ jsonUser }" />
	</p>


	<jsp:include page="common_footer.jsp" />

</body>
</html>
