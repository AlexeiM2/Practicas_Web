package com.productos.datos;
import java.sql.*;
public class Conexion
{
	private Statement St; 
	private String driver;
	private String user;
	private String pwd;
	private String cadena;
	private Connection con;

	String getDriver()
	{
		return this.driver;
	}
	String getUser()
	{
		return this.user;
	}
	String getPwd()
	{
		return this.pwd;
	}
	String getCadena()
	{
		return this.cadena;
	}
	public Connection getConexion()
	{ 
		return this.con; 
	}

	public Conexion() {

		this.driver ="org.postgresql.Driver";
		this.user="postgres";
		this.pwd="1234";
		this.cadena="jdbc:postgresql://localhost:5432/postgres";
		this.con=this.crearConexion();

	}

	Connection crearConexion()
	{
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e) {

		}

		try
		{
			Class.forName(getDriver());
			Connection con=DriverManager.getConnection(getCadena(),getUser(),getPwd());
			System.out.println("Se conecto a la base datos postgres");
			return con;
		}
		catch(Exception ee)
		{
			System.out.println("Error: " + ee.getMessage());
			return null;
		}
	}


	public String Ejecutar(String sql)
	{
		String error="";
		try
		{
			St=getConexion().createStatement();
			St.execute(sql);
			error="Datos insertados";
		}
		catch(Exception ex)
		{
			error = ex.getMessage();
		}
		return(error);
	}



	public ResultSet Consulta(String sql)
	{
		String error="";
		ResultSet reg=null;

		try
		{
			St=getConexion().createStatement();
			reg=St.executeQuery(sql);


		}
		catch(Exception ee)
		{
			error = ee.getMessage();
		}
		return(reg);
	}
//	 public static void main(String[] args) {
//	        Conexion conexion = new Conexion();
//
//	        // Prueba de conexión ejecutando una consulta simple
//	        String sql = "SELECT * FROM categorias";
//	        try {
//	            ResultSet resultSet = conexion.Consulta(sql);
//	            while (resultSet.next()) {
//	                // Aquí puedes procesar los resultados si la consulta fue exitosa
//	                // Por ejemplo, imprimir los resultados en la consola
//	                System.out.println("Columna 1: " + resultSet.getString(1));
//	                System.out.println("Columna 2: " + resultSet.getString(2));
//	                // ... Continúa con las demás columnas según sea necesario
//	            }
//	            // Cerrar el ResultSet después de usarlo
//	           resultSet.close();
//	        } catch (Exception e) {
//	            // Manejo de errores si la conexión o la consulta fallan
//	            e.printStackTrace();
//	        }
//	    }
}