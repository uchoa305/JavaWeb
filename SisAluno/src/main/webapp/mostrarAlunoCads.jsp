<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="br.edu.unicid.bean.Alunos" %>


<%@page pageEncoding="ISO-8859-1" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Alunos</title>
</head>
<body>
	 
		<table width="100%" border="1" cellpadding="2" cellspacing="0">
			<tr>
				<th colspan="6"><h3>Lista de Alunos</h3></th>
			<tr>
			<tr>
				<th>Ca</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Nascimento</th>
				<th>Endereco</th>
				<th>Idade</th>
			<tr>
			<%
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				List<Alunos> lista = new ArrayList<Alunos>();
				lista = (ArrayList) request.getAttribute("alunosList");
				
				for(Alunos a: lista){%>
					<tr>
						<td><%out.println(a.getCaAluno());%></td>
						<td><%out.println(a.getNomeAluno());%></td>
						<td><%out.println(a.getEmailAluno());%></td>
						<td><%out.println(data.format(a.getDtaNasc()));%></td>
						<td><%out.println(a.getEndAluno());%></td>
						<td><%out.println(a.getIdadeAluno());%></td>
					</tr>
					<%
				}			
			%>
			<tr>
				<td colspan="6" align="center"><a href="index.jsp">Página Principal</a></td>
			<tr>
		</table>
	
</body>
</html>