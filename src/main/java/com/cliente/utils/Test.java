package com.cliente.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

	public static void main(String args[]) {
		System.out.println("Hola consola");
		
		Connection conn = null;
		Conexion conexion = new Conexion();
		try {
			conn = conexion.obtener();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
