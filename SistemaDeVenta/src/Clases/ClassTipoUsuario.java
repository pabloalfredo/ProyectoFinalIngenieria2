package Clases;

public class ClassTipoUsuario {
	
	private int idTipoUsuario;
	private String Descripcion;
	
	public ClassTipoUsuario(int idTipoProudcto, String Descripcion){
	
		this.idTipoUsuario = idTipoProudcto;
		this.Descripcion = Descripcion;
	}
	public ClassTipoUsuario( String Descripcion){
		setDescripcion(Descripcion);
	}
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoUsuario = idTipoProducto;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
