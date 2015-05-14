package Clases;


import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassRegistrarCliente {
	
	private int codigoCliente;
	private String direccion,apellidos,nombres,email,ocupacion,fechaNacimiento,celular,estadoCivil,sexo,cedula;
	private ClassCiudades Ciudad;
	private String ciudad;
		
	public ClassRegistrarCliente(int codigoCliente, String nombres,
			String apellidos, String fechaNacimiento, String sexo,
			String estadoCivil, String cedula, ClassCiudades objetoTipoCiudad,
			String direccion, String email, String celular, String ocupacion) {
		
		setCodigoCliente(codigoCliente);
		setNombres(nombres);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
		setSexo(sexo);
		setEstadoCivil(estadoCivil);
		setCedula(cedula);
		this.Ciudad = objetoTipoCiudad;
		setDireccion(direccion);
		setEmail(email);
		setCelular(celular);
		setOcupacion(ocupacion);
	}

	public ClassRegistrarCliente (int codigoCliente, String nombres, String ciudad)
	{
		setCodigoCliente(codigoCliente);
		setNombres(nombres);
		setCiudad(ciudad);
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getApellidos() {
		return apellidos;
	}


	public String getNombres() {
		return nombres;
	}


	public String getEmail() {
		return email;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getCelular() {
		return celular;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public String getSexo() {
		return sexo;
	}


	public String getCedula() {
		return cedula;
	}


	public ClassCiudades getCiudad() {
		return Ciudad;
	}


	public void setCodigoCliente(int codigocliente) {
		this.codigoCliente = codigocliente;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public void setCiudad(ClassCiudades ciudad) {
		Ciudad = ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/// ESTE METEDO REALIZA LA INSERCION DE PRODUCTOS EN LA BASE DE DATOSS
	public void registrarNuevoProveedor() throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO tblproveedor(codigoProveedor,nombres,apellidos,fechaNacimiento,sexo,estadoCivil,cedula,idCiudad,direccion,email,celular,ocupacion)"
				   + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setInt(1, getCodigoCliente());
		instrucion.setString(2, getNombres());
		instrucion.setString(3, getApellidos());
		instrucion.setString(4, getFechaNacimiento());
		instrucion.setString(5, getSexo());
		instrucion.setString(6, getEstadoCivil());
		instrucion.setString(7, getCedula());
		instrucion.setInt(8, getCiudad().getIdCiudad());
		instrucion.setString(9, getDireccion());
		instrucion.setString(10, getEmail());
		instrucion.setString(11, getCelular());
		instrucion.setString(12, getOcupacion());
		instrucion.execute();
	}
	
	// ESTE METODO REALIZA LA ACTUALIZACION DE PROVEEDORES
	public void actualizarProveedor() throws ClassNotFoundException, SQLException{
		String sql = "UPDATE tblproveedor SET nombres=?,apellidos=?,fechaNacimiento=?,sexo=?,estadoCivil=?,cedula=?,idCiudad=?,direccion=?,email=?,celular=?,ocupacion=? WHERE codigoProveedor=? ";
		PreparedStatement instrucion =(PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getNombres());
		instrucion.setString(2, getApellidos());
		instrucion.setString(3, getFechaNacimiento());
		instrucion.setString(4, getSexo());
		instrucion.setString(5, getEstadoCivil());
		instrucion.setString(6, getCedula());
		instrucion.setInt(7, getCiudad().getIdCiudad());
		instrucion.setString(8, getDireccion());
		instrucion.setString(9, getEmail());
		instrucion.setString(10, getCelular());
		instrucion.setString(11, getOcupacion());
		instrucion.setInt(12, getCodigoCliente());
		instrucion.execute();
		
		
	}
}
