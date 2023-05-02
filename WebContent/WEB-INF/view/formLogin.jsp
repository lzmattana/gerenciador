<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORMULARIO CADASTRO</title>
</head>
<body>
	<form action="${linkEntradaServlet}" method="post">

		LOGIN: <input type="text" name="Login"/>
		SENHA: <input type="password" name="senha"/>
		<input type="hidden" name="acao" value="Login" /> 
		
		<input type="submit"/>

	</form>



</body>
</html>