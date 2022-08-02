<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import='java.util.List' %>
<%   //<%@ page import='com.Clientees.model.Cliente' %>
<html>
		<script src="resources/js/jquery-3.6.0.js"></script>
		<script src="resources/js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/sweetalert2.all.min.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>
        <script src="resources/js/funciones.js" type="text/javascript"></script>
        
        
       	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/fontawesome.min.css" integrity="sha512-R+xPS2VPCAFvLRy+I4PgbwkWjw1z5B5gNDYgJN5LfzV4gGNeRQyVrY7Uk59rX+c8tzz63j8DeZPLqmXvBxj8pA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="resources/css/estilos.css" rel="stylesheet">
        
        
	
	
	<title>Control de Clientes</title>
	
	<body>
	
	<div class = "espacio"></div>
	<section>
		<input type="hidden" id="idCliente">   
		
		<form id="clientesForm">
		  <div class="form-row">
		    <div class="col" style="padding:10px">
			     <div class="row m-3 justify-content-center">
			  		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" onclick="limpiar()" data-target="#modalClienteNuevo">Nuevo</button>
			  	</div>
		  	</div>
		  </div>
		</form> 
    </section>
	
	<section>
		<div id="listado" class="col col-md-10">
			<table class="table table-striped table-hover" id="tablaClientes">
				<thead class="thead-dark">
					<tr>
						<th>Codigo</th>
						<th>Nombre</th>
						<th style="">Accion</th>
					</tr>
				</thead>
				
				<tbody>
					 <script>listarClientes()</script>
				</tbody>
			</table>
		</div>
	</section>
	
	
<div class="container">
	<!-- Modal -->
  <div class="modal fade" id="modalClienteNuevo" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
          	
          <form id="formCliente">
          	<input type="hidden" id="idClienteModal">
          	<div class="form-row">
		  		<div class="col col-md-12" style="padding:10px">
		     		<label for="nombre" style="padding-right: 10px">Nombre</label>
		      		<input type="text" class="form-control" name="nombre" id="nombre">
		    	</div>
		  	</div>
		  	
		  	
		  	
		   <div class="row">
		   		<!-- <div class="col col-md-4" style="padding:10px">
			     	<label for="esperanza" style="padding-right: 10px">Esperanza</label>
			      	<select class="form-control" name="esperanza" id="esperanza">
	        			<option value="O">Otras ovejas</option>
	        			<option value="U">Ungido</option>
			      	</select>
			    </div> -->
		   </div>
		   
		    <div class="row">
		    	<!-- <div class="col col-md-4" style="padding:10px">
			     	<label for="precursor" style="padding-right: 10px">¿Es precursor Regular?</label>
			      	<div>
	                    <input type="radio" name="precursor" value="true" id="pr1"><label for="pr1">SI</label>
	                    <input type="radio" name="precursor" value="false" id="pr2" checked><label for="pr2">NO</label>
	                </div>
			    </div> -->
		    </div>
		  	
          </form>	
          	
        </div>
        <div class="modal-footer">
         	<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
       	    <button type="button" class="btn btn-success"  id="guardar" onclick="guardarCliente()"><i aria-hidden="true"></i>Guardar</button>
        </div>
      </div>
      
    </div>
  </div>
</div>	
	
	
	</body>
	
</html>