package com.cliente.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cliente.implement.ClienteImpl;
import com.cliente.model.Cliente;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@WebServlet("/Cliente")
public class ControlCliente extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlCliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Listar, consultar, borrar
		 ClienteImpl clienteImpl = new ClienteImpl();
			
		try {
			String accion = request.getParameter("accion");
			System.out.println("accion: " + accion);
			
			if(accion.equals("listar")) {
				System.out.println("Listando clientes controlador");
				List<Cliente> clientes = new ArrayList<Cliente>();
				JsonArray listValores = new JsonArray();
		       
		        clientes = clienteImpl.listar();
		        
				System.out.println("Total de clientes: " + clientes.size());
				
				for(Cliente c : clientes){
					JsonObject obj = (JsonObject) toObject(c);
		            listValores.add(obj);
				}
				String json = listValores.toString();
				
				response.getWriter().write(json);
				
			}else if(accion.equals("borrar")) {
				String idClienteSt = request.getParameter("idCliente");
				
				System.out.println("Borando cliente: " + idClienteSt);
				Integer idCliente = Integer.parseInt(idClienteSt);
				Boolean rsp = clienteImpl.borrarCliente(idCliente);
				
				response.getWriter().write(String.valueOf(rsp));
			}else if(accion.equals("consultar")) {
				String idClienteSt = request.getParameter("idCliente");
				System.out.println("Consultando cliente: " + idClienteSt);
				
				Integer idCliente = Integer.parseInt(idClienteSt);
				Cliente cliente = new Cliente();
				
				cliente = clienteImpl.consultarCliente(idCliente);
				JsonObject clienteJson = (JsonObject) toObject(cliente);
				String json = clienteJson.toString();
				System.out.println(cliente.getNombre());
				response.getWriter().write(json);
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//Guardar, actualizar
		
		String accion = request.getParameter("accion");
		String clienteString = request.getParameter("cliente");
		Cliente cliente = new Cliente();
		ClienteImpl clienteImpl = new ClienteImpl();
		
		cliente = toCliente(URLDecoder.decode(clienteString, "UTF-8"));
		
		
		if(accion.equals("guardar")) {
			clienteImpl.guardarCliente(cliente);
		}else if(accion.equals("actualizar")) {
			clienteImpl.actualizarCliente(cliente);
		}
	}
	
	private Object toObject(Cliente cliente) {
		 JsonObject obj = new JsonObject();
		 try {
			 obj.addProperty("id", cliente.getId());
			 obj.addProperty("nombre", cliente.getNombre());
						 
		} catch (Exception e) {
			 System.out.println("Error toObject : " + e);
			 e.printStackTrace();
		}
		 
		 return obj;
	 }
	
	private Cliente toCliente(String clienteString) {
		Cliente cliente = new Cliente();
		
		Map<String, String> clienteMap = new HashMap<String, String>();
		String[] datos = clienteString.split("&");
		
		for(String dato:datos) {
			String[] subDato = dato.split("=");
			System.out.println("Propiedad: " + subDato[0] + "| valor: " + subDato[1]);
			clienteMap.put(subDato[0], subDato[1]);
		}
		
		cliente.setNombre(clienteMap.get("nombre"));
		
		System.out.println("Cliente String: " + cliente.toString());
		
		return cliente;
	}
}
