package Clases;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassCategoriaProducto {
	
	private int idCategoriaPrudcto;
	private String Descripcion;
	
	public ClassCategoriaProducto(int IdCategoriaPrudcto, String Descripcion){
	
		this.idCategoriaPrudcto = IdCategoriaPrudcto;
		this.Descripcion = Descripcion;
	}
	public ClassCategoriaProducto( String Descripcion){
		setDescripcion(Descripcion);
	}
	public int getIdCategoriaPrudcto() {
		return idCategoriaPrudcto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setIdCategoriaPrudcto(int idCategoriaPrudcto) {
		this.idCategoriaPrudcto = idCategoriaPrudcto;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public void insertarCategoriaProducto() throws ClassNotFoundException, SQLException{
		String 	sql = " INSERT INTO tblCategoriaProducto (Descripcion) VALUES (?)  ";
		PreparedStatement instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1,getDescripcion());
		instrucion.execute();
	}

}





















