<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="login">
	<form action="<c:url value="/login" />" method="POST">
		<input type="text" name="email">
		<input type="password" name="password">
		<input type="submit" value="Login">
	</form>
</div>