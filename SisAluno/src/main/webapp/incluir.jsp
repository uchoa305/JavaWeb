<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Cadastro de Alunos</title>
</head>
<style> 
	.table{
	  margin-left: auto;
	  margin-right: auto;
	  width: 45%;
	  border-collapse: collapse;
	}
	.input{
	  margin-left: auto;
	  margin-right: auto;
	  width: 98%;
	}
	.th{
	    height: 70px;
	}
	th, td {
	  padding: 8px;
	}
	
	tr:nth-child(even) {background-color: #f2f2f2;}
	.btn_submit {
	  border: 5pxpx;
	  color: black;
	  padding: 15px 280px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
		.btn_submit:hover {
		  background-color: #4CAF50;
		  color: white;
		}
		.btn_back {
	  border: 5pxpx;
	  color: black;
	  padding: 15px 30px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 4px 2px;
	  cursor: pointer;
	}
		.btn_back:hover {
		  background-color: #FF6347;
		  color: white;
		}
</style>
<body> 

	<table  class="table" border="1">
		<tbody>
			<thead>
				<tr > <th class="th" colspan="2">Cadastro de Alunos </th> </tr>
			</thead>
			
			<form action="ServletAluno" method="get">
			<input type="hidden" name="cmd" value="incluir">
			<tr> 
				<td> CA </td> 
				<td> <input class ="input" type="text" name="txtCa" placeholder=" insira seu CA"> </td> 
			</tr>
			<tr> 
				<td> Nome </td> 
				<td> <input class ="input" type="text" name="txtNome" placeholder=" insira seu CA"> </td> 
			</tr>
			<tr> 
				<td> Email </td> 
				<td> <input class ="input" type="text"  name="txtEmail" placeholder=" insira seu email"> </td> 
			</tr>
			<tr> 
				<td> Data  de nascimento </td> 
				<td> <input class ="input" type="text" name="txtData" placeholder=" insira sua data de nascimento"></td> 
			</tr>
			<tr> 
				<td> Endereço </td> 
				<td> <input class ="input"  type="text" name="txtEndereco" placeholder=" insira seu endereço">  </td> 
			</tr>
			<tr> 
				<td>  Idade </td> 
				<td> <input class ="input" type="text" name="txtIdade" placeholder=" insira sua idade"></td> 
			</tr>
			<tr> <th colspan="2"> <button class="btn_submit" type="submit">Enviar</button>  </th> </tr>
		</form>
		</tbody>
	</table>
<a href="index.jsp"><button   class="btn_back" type="submit">Voltar</button> </a>
</body>
</html>