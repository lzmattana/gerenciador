<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FORMULARIO CADASTRO</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">

		Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		<input type="submit"/>

	</form>



</body>
</html>