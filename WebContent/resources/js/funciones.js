var tablaClientes;


function consultarCliente(idCliente){
	
	$.ajax({
		type: "GET",
		url: "Cliente",
		dataType: "json",
		data: {accion: "consultar", idCliente:idCliente}
	}).done(function(cliente){
		console.log(cliente);
		$('#idCliente').val(cliente.id);
        $('#nombre').val(cliente.nombre);
        
        
	}).fail();
}

function listarClientes(){
	console.log("Listando clientes...")
	$.ajax({
	        type: 'GET',
	        url: 'Cliente',
	        dataType: 'json',
	        data: {accion: "listar"}
	}).done(function(data){
		 	console.log('TODO BIEN');
	        console.log(data);

	        tablaClientes = $('#tablaClientes').DataTable({"ordering": false});
	        $.fn.dataTable.ext.errMode = 'none';
	       
	        $('#tablaClientes tr').each(function () {
	        	tablaClientes.row($(this)).remove().draw();
	        });
	        
	        $.each(data, function (i, item) { //Agregamos cada campo a la tabla y los botones
	        		tablaClientes.row.add([
	        		item.id,
	                item.nombre,
	                '<td><a class="btn btn-default  btn-sm btn-small"  data-toggle="modal" onclick="consultarCliente(' + item.id + ')" data-target="#modalClienteNuevo">\
	                <i class="fa fa-edit fa-lg"></i></a>\
	                <a class="btn btn-default btn-sm btn-small" onclick="borrarCliente(' + item.id + ')">\
	                  <i class="fa fa-trash"></i></a></td>'
	            ]).draw(false);   	
	        });
	}).fail(function (res, status, error) {
        console.log('ERROR: ' + res);
    });
}

function guardarCliente(){
	//Funcion utilizada tambien para actualizar cliente
	console.log("guardando cliente...")
	
	$.ajax({
		type: "POST",
		url: "Cliente",
		data: {accion: "guardar", cliente: $('#formCliente').serialize()}
	}).done(function(data){
		limpiar();
		listarClientes();
	}).fail();
	
	$('.close').click(); 
}

function borrarCliente(idCliente){
	console.log("Borrando cliente...")
	$.ajax({
		type: "GET",
		url: "Cliente",
		dataType: "json",
		data: {accion: "borrar", idCliente:idCliente}
	}).done(function(data){
		alert("cliente " + idCliente + " Eliminado!");
		listarClientes();
	}).fail();
}

function limpiar(){
	console.log("limpiando form")
	$('#nombre').val('');
}