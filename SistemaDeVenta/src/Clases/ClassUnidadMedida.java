package Clases;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassUnidadMedida {
	
	private int idUnidadMedida;
	private String Descripcion;
	
	public ClassUnidadMedida(int IdUnidadMedida, String Descripcion){
	
		this.idUnidadMedida = IdUnidadMedida;
		this.Descripcion = Descripcion;
	}
	public ClassUnidadMedida( String Descripcion){
		setDescripcion(Descripcion);
	}
	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setIdUnidadMedida(int IdUnidadMedida) {
		this.idUnidadMedida = IdUnidadMedida;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	public void insertarUnidadMedida() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO tblUnidadMedida (Descripcion) VALUES (?)";
		PreparedStatement instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getDescripcion());
		instrucion.execute();
	}
}

















