package com.productos.negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.productos.datos.Conexion;

public class Producto{
	private Integer id;
	private String nombre;
	private int cantidad;
	private double precio;
	private Byte foto;

	public String consultarTodo() {
	    String sql = "SELECT id_producto, nombre, cantidad, precio, descripcion FROM productos";
	    Conexion con = new Conexion();
	    StringBuilder tabla = new StringBuilder("<table class=\"table table-striped\">"
	            + "<thead class='table-primary'>"
	            + "<tr>"
	            + "<th scope=\"col\">ID</th>"
	            + "<th scope=\"col\">Producto</th>"
	            + "<th scope=\"col\">Cantidad</th>"
	            + "<th scope=\"col\">Precio</th>"
	            + "</tr>"
	            + "</thead>"
	            + "<tbody>");
	    ResultSet rs = null;
	    rs = con.Consulta(sql);
	    try {
	        while (rs.next()) {
	            int id = rs.getInt(1);
	            tabla.append("<tr>")
	                .append("<td>").append(id).append("</td>")
	                .append("<td>").append(rs.getString(2)).append("</td>")
	                .append("<td>").append(rs.getInt(3)).append("</td>")
	                .append("<td>").append(rs.getDouble(4)).append("</td>")
	                .append("<td>")
	                .append("</td>")
	                .append("</tr>");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.print(e.getMessage());
	    }
	    tabla.append("</tbody>")
	    .append("</table>");
	    return tabla.toString();
	}

	public String buscarProductoCategoria(int cat)
	{
		String sql="SELECT id_producto, nombre, cantidad, precio, descripcion FROM productos WHERE id_categoria="+cat;
		Conexion con = new Conexion();
		StringBuilder tabla = new StringBuilder("<table class=\"table table-primary\">"
				+ "<thead>"
				+ "<tr>"
				+ "<th scope=\"col\">ID</th>"
				+ "<th scope=\"col\">Producto</th>"
				+ "<th scope=\"col\">Cantidad</th>"
				+ "<th scope=\"col\">Precio</th>"
				+ "</tr>"
				+ "</thead>"
				+ "<tbody>");
		ResultSet rs = null;
		rs = con.Consulta(sql);
		try {
			while (rs.next()) {
				tabla.append("<tr>")
				.append("<td>").append(rs.getInt(1)).append("</td>")
				.append("<td>").append(rs.getString(2)).append("</td>")
				.append("<td>").append(rs.getInt(3)).append("</td>")
				.append("<td>").append(rs.getDouble(4)).append("</td>")
				.append("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla.append("</tbody>")
		.append("</table>");
		return tabla.toString();
	}

	public String ingresarProducto(int id, int cat, String nombre, int cantidad, double precio, String directorio, String descripcion) {
		String result = "Se intenta insertar";
		Connection con = null;
		PreparedStatement pr = null;
		FileInputStream streamEntrada = null;

		try {
			Conexion conexion = new Conexion(); 
			con = conexion.getConexion(); 
			String sql = "INSERT INTO productos (id_producto, id_categoria, nombre, precio, descripcion, foto, cantidad) VALUES (?, ?, ?, ?, ?, ?, ?)";
			pr = con.prepareStatement(sql);
			pr.setInt(1, id);
			pr.setInt(2, cat);
			pr.setString(3, nombre);
			pr.setDouble(4, precio);
			pr.setString(5, descripcion);

			File fichero = new File(directorio);
			streamEntrada = new FileInputStream(fichero);
			pr.setBinaryStream(6, streamEntrada, (int) fichero.length());

			pr.setInt(7, cantidad);

			if (pr.executeUpdate() == 1) {
				result = "Inserción correcta";
			} else {
				result = "Error en inserción";
			}
		} catch (Exception ex) {
			result = "Error: " + ex.getMessage(); 
		} finally {
			if (streamEntrada != null) {
				try {
					streamEntrada.close();
				} catch (IOException ex) {
					result = "Error al cerrar el stream: " + ex.getMessage();
				} } if (pr != null) { try { pr.close(); } catch (SQLException ex) { result = "Error al cerrar el PreparedStatement: " + ex.getMessage(); }
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					result = "Error al cerrar la conexión: " + ex.getMessage();
				}
			}
		}
		return result;
	}
	
	public String eliminarProducto(int id) {
	    String result = "Se intenta eliminar";
	    Connection con = null;
	    PreparedStatement pr = null;

	    try {
	        Conexion conexion = new Conexion(); 
	        con = conexion.getConexion(); 
	        String sql = "DELETE FROM productos WHERE id_producto = ?";
	        pr = con.prepareStatement(sql);
	        pr.setInt(1, id);

	        if (pr.executeUpdate() == 1) {
	            result = "Eliminación correcta";
	        } else {
	            result = "No se encontró el producto con el ID especificado";
	        }
	    } catch (Exception ex) {
	        result = "Error: " + ex.getMessage(); 
	    } finally {
	        if (pr != null) { 
	            try { 
	                pr.close(); 
	            } catch (SQLException ex) { 
	                result = "Error al cerrar el PreparedStatement: " + ex.getMessage(); 
	            } 
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                result = "Error al cerrar la conexión: " + ex.getMessage();
	            }
	        }
	    }
	    return result;
	}
	
	public String actualizarProducto(int id, int cat, String nombre, int cantidad, double precio, String directorio, String descripcion) {
	    String result = "Se intenta actualizar";
	    Connection con = null;
	    PreparedStatement pr = null;
	    FileInputStream streamEntrada = null;

	    try {
	        Conexion conexion = new Conexion();
	        con = conexion.getConexion();
	        String sql = "UPDATE productos SET id_categoria = ?, nombre = ?, precio = ?, descripcion = ?, foto = ?, cantidad = ? WHERE id_producto = ?";
	        pr = con.prepareStatement(sql);
	        pr.setInt(1, cat);
	        pr.setString(2, nombre);
	        pr.setDouble(3, precio);
	        pr.setString(4, descripcion);

	        File fichero = new File(directorio);
	        streamEntrada = new FileInputStream(fichero);
	        pr.setBinaryStream(5, streamEntrada, (int) fichero.length());

	        pr.setInt(6, cantidad);
	        pr.setInt(7, id);

	        if (pr.executeUpdate() == 1) {
	            result = "Actualización correcta";
	        } else {
	            result = "No se encontró el producto con el ID especificado";
	        }
	    } catch (Exception ex) {
	        result = "Error: " + ex.getMessage();
	    } finally {
	        if (streamEntrada != null) {
	            try {
	                streamEntrada.close();
	            } catch (IOException ex) {
	                result = "Error al cerrar el stream: " + ex.getMessage();
	            }
	        }
	        if (pr != null) {
	            try {
	                pr.close();
	            } catch (SQLException ex) {
	                result = "Error al cerrar el PreparedStatement: " + ex.getMessage();
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                result = "Error al cerrar la conexión: " + ex.getMessage();
	            }
	        }
	    }
	    return result;
	}


	public static void main() {
		Producto p1 =new Producto();
		System.out.println(p1.ingresarProducto(3, 1,"intelcorei9", 10, 500, null, "pc de escritorio"));
		
	}
}