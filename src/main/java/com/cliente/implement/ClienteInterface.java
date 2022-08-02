package com.cliente.implement;

import java.util.List;
import com.cliente.model.Cliente;

public interface ClienteInterface {
	
	public List<Cliente> listar();
	public Cliente consultarCliente(Integer idCliente);
	public Boolean borrarCliente(Integer idCliente);
	public Boolean guardarCliente(Cliente cliente);
	public Boolean actualizarCliente (Cliente cliente);
}
