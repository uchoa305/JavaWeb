<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- imports -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <title>Ri Rap</title>
   
  </head>
  <body > <!-- onload="CarregaDados()" -->
 <div class="container">
	<div class="row">
		    <h2>Cadastro de Brinquedos</h2>
	</div>
	<hr/>
 	<form action="brinquedo" method="post" enctype="multipart/form-data">
 		<input type="hidden" name="cmd" value="incluir">
		  <div class="row">
		    <div class="col-sm-10">
		    <div class="mb-3">
    			<label for="exampleInputEmail1" class="form-label">Nome Brinquedo</label>
    			<input type="text" class="form-control" id="txtNomeBrinquedo" name="txtNomeBrinquedo" aria-describedby="emailHelp">
 			 </div>
			</div>
		    
		  </div>
		  <div class="row">
		    <div class="col-sm-4">
				<div class="mb-3">
    			<label for="exampleInputEmail1" class="form-label">Cod Brinquedo</label>
    			<input type="text" class="form-control" id="txtCodBrinquedo" name="txtCodBrinquedo">
 			 	</div>
			</div>
		    <div class="col-sm-6">
		    	<label for="exampleInputEmail1"  class="form-label">Categoria</label>
		    	<button type="button" class="btn btn-primary btn-sm">+</button>
		    	<select class="form-select" aria-label="Default select example" id="categoria" name="categoria">
				</select>
		    </div>
		    <div id="teste"> </div>
		    <div class="row">
		    	<div class="col-sm-4">
		    		<label for="exampleInputEmail1" class="form-label">Preço</label>
    				<input type="text" class="form-control" id="txtCodBrinquedo" name="txtPrecoBrinquedo">
		    	</div>
		    </div>
		  </div>
		  <br>
		  <div class="row">
		    	<div class="col-sm-10">
		    		<label for="exampleInputEmail1" class="form-label">Descrição</label>
    				<textarea class="form-control" id="exampleFormControlTextarea1" name="txtDescricao" rows="3"></textarea>
		    	</div>
		   </div>
		   <br>
		   <div class="row">
		    	<div class="col-sm-4">
		    		<label for="exampleInputEmail1" class="form-label">Foto:</label>
    					<div class="input-group">
  							<input type="file" class="form-control" name="file" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
  							<button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">+</button>
						</div>
		    	</div>
		    </div>
		    <br>
		    <div class="row">
		    	<div class="col-sm-4">
		    		<button type="submit" class="btn btn-outline-success">Cadastrar</button>
		    	</div>
		    </div>  
		   
	</form>
</div>



    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
  </body>
  <script>
  
 	/* 	function CarregaDados()
 		{
 			//document.location.href = "Categorias?cmd=listar";
 			xhtml = new XMLHttpRequest();
 			xhtml.onreadystatechange = function(){
 				if(xhtml.readyState == 4 && xhtml.status == 200)
 				{
 					document.getElementById("teste").InnerHTML = xhtml.responseText; 
 					console.log(xhtml.responseText);
 				}
 			}
 			xhtml.open("GET","categorias?cmd=listar",true);
 	 		xhtml.send(); 
 		} */
 	   $(document).ready(function () {
           $.ajax({
               url: "categorias?cmd=listar",
               method: "GET",
               data: {},
               success: function (data, textStatus, jqXHR) {
                   console.log(data);
                   let obj = $.parseJSON(data);
                   $.each(obj, function (key, value) {
                       $('#categoria').append('<option value="' + value.id + '">' + value.name + '</option>')
                   });
                   $('select').formSelect();
               },
               error: function (jqXHR, textStatus, errorThrown) {
                   $('#categoria').append('<option>Categoria indisponivel</option>');
               },
               cache: false
           });
 	   });
  </script>
</html>