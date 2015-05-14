package Clases;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassCiudades {
	
	private int idCiudad;
	private String Descripcion;
	
	public ClassCiudades(int IdCiudad, String Descripcion){
	
		this.idCiudad = IdCiudad;
		this.Descripcion = Descripcion;
	}
	public ClassCiudades( String Descripcion){
		setDescripcion(Descripcion);
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public void insertarCiudad () throws ClassNotFoundException, SQLException{
		String sql = "INSERT INTO tblCiudades (descripcion) VALUES (?)";
		PreparedStatement instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getDescripcion());
		instrucion.execute();
	}

}
















