
<%
	//scriplet
	String nomeEmpresa = (String) request.getAttribute("empresa"); // transforma obj em string castando
	System.out.println(nomeEmpresa);
%>


<html>
<body>
	Empresa
	<%= nomeEmpresa %>
	cadastrada com sucesso!
</body>
</html>
