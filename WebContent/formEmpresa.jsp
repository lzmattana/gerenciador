<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:url value="/novaEmpresaCriada" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORMULARIO CADASTRO</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome"/>
		<input type="submit"/>

	</form>



</body>
</html>