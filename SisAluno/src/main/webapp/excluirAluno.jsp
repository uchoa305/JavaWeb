<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SisAluno</title>
</head>
<body>
<center>
	<table border="1">
	<form action="ServletAluno?cmd=excluir" method="post">
	<tbody>  		
		<tr>
			<th colspan="2"><h1>Excluir Alunos</h1></th>
		</tr>	
		<tr>
			<td>CA do Aluno:</td> 
			<td><input type = "text" name = "txtCa"  size="60" maxlength = "60"></td>
			</tr>
		<tr>
		     <td colspan="2" align="center"><input type = "submit" value="Enviar"></td>
		</tr>	
	</tbody>  	
	</form>
	</table>
	</center>
</body>
</html>