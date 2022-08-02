package com.cliente.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cliente.model.Cliente;
import com.cliente.utils.Conexion;

public class ClienteImpl implements ClienteInterface{

	@Override
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT * FROM `publicadores_db`.`cliente`";
		System.out.println("SQL: " + sql);
		
		Connection conexion = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conexion = Conexion.obtener();
			stm = conexion.prepareStatement(sql);
			rs = stm.executeQuery();
			
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("ID_CLIENTE"));
				cliente.setNombre(rs.getString("NOMBRE"));
				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return clientes;
	}

	@Override
	public Cliente consultarCliente(Integer idCliente) {
		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM `publicadores_db`.`cliente` WHERE ID_CLIENTE = " + idCliente;
		
		Connection conexion = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conexion = Conexion.obtener();
			stm = conexion.prepareStatement(sql);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				cliente.setId(rs.getInt("ID_CLIENTE"));
				cliente.setNombre(rs.getString("NOMBRE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}

	@Override
	public Boolean borrarCliente(Integer idCliente) {
		String sql = "DELETE FROM `publicadores_db`.`cliente` WHERE ID_CLIENTE = " + idCliente;
		
		Boolean response = true;
		Connection conexion = null;
		PreparedStatement stm = null;
		
		System.out.println("SQL: " + sql);
		
		try {
			conexion = Conexion.obtener();
			stm = conexion.prepareStatement(sql);
			stm.executeUpdate();
			
		} catch (Exception e) {
			response = false;
		}
		
		return response;
	}

	@Override
	public Boolean guardarCliente(Cliente cliente) {
		String sql = "INSERT INTO `publicadores_db`.`cliente`(`NOMBRE`) VALUES (?)";
		
		Boolean response = true;
		Connection conexion = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conexion = Conexion.obtener();
			stm = conexion.prepareStatement(sql);
			stm.setString(1, cliente.getNombre());
			
			stm.executeUpdate();
			
			
			
		} catch (Exception e) {
			response = false;
		}
		
		return response;
	}

	@Override
	public Boolean actualizarCliente(Cliente cliente) {
		String sql = "UPDATE `publicadores_db`.`cliente` SET NOMBRE = ? WHERE ID_CLIENTE = " + cliente.getId();
		
		Boolean response = true;
		Connection conexion = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			conexion = Conexion.obtener();
			stm = conexion.prepareStatement(sql);
			stm.setString(2, cliente.getNombre());
			
			stm.executeUpdate();
			
			
			
		} catch (Exception e) {
			response = false;
		}
		
		return response;
	}

}
