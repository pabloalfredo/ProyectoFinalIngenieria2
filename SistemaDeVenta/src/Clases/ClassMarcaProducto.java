package Clases;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassMarcaProducto {
	
	private int idMarcaProducto;
	private String Descripcion;
	
	public ClassMarcaProducto(int IdMarcaProducto, String Descripcion){
	
		this.idMarcaProducto = IdMarcaProducto;
		this.Descripcion = Descripcion;
	}
	public ClassMarcaProducto( String Descripcion){
		setDescripcion(Descripcion);
	}
	public int getIdMarcaProducto() {
		return idMarcaProducto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setIdMarcaProducto(int idMarcaProducto) {
		this.idMarcaProducto = idMarcaProducto;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public void insertarMarca() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO tblMarcaProducto (descripcion) VALUES (?)";
		PreparedStatement instrucion =  (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getDescripcion());
		instrucion.execute();
		
	}
}


















