package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion {
	private static String db = "Vinateria";
	private static String user = "root";
	private static String pass = "mysqlluiss";
	private static String host = "localhost";
	private static String server = "jdbc:mysql://"+host+"/"+db;
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(server, user, pass);
		} catch (Exception e) {
			System.out.println(String.valueOf(e));
		}
		return con;
	}
	
	public static ResultSet getTabla(String comando) {
		Connection con = getConnection();
		java.sql.Statement st;
		ResultSet datos=null;
		try {
			st = con.createStatement();
			datos = st.executeQuery(comando);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datos;
	} 
}