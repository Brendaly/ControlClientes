package com.cliente.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private static Connection cnx = null;
	
	
	   public static Connection obtener() throws SQLException, ClassNotFoundException {
	      if (cnx == null) {
	         try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            cnx = DriverManager.getConnection("jdbc:mysql://localhost/publicadores_db?serverTimezone=UTC", "root", "dbadmin");
	            System.out.println("Conexion exitosa");
	         } catch (SQLException ex) {
	            throw new SQLException(ex);
	         } catch (ClassNotFoundException ex) {
	            throw new ClassCastException(ex.getMessage());
	         }
	      }
	      return cnx;
	   }
  

}
