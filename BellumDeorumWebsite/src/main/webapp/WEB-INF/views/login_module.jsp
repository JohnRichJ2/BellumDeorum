<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="login">
	<form action="<c:url value="/login" />" method="POST">
		<input class="defaultableTextInput" default="email" type="text" name="email">
		<input class="defaultableTextInput" default="password" type="text" name="password">
		<input type="submit" value="Login">
		<a href="<c:url value="/register" />"><input type="button" value="Register"></a>
	</form>
</div>