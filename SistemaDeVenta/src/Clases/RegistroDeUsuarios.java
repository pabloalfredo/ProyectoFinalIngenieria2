package Clases;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

public class RegistroDeUsuarios extends Variable {
	
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String telefono;
	private String email;
	private String nombreDeUsuario;
	private int idTipoUsuario;
	private String contrasena;
	private ClassTipoUsuario TipoUsuario;

	
	public RegistroDeUsuarios (String NombreDeUsuario, String Contrasena, ClassTipoUsuario TipoUsuario, String Nombres, String Apellidos, String FechaNacimiento, String Telefono, String Email, boolean Congiguracion
			,boolean Backup,boolean NuevoUsuario,boolean CambiarUsuario,boolean SalirSistema, boolean NuevaVenta, boolean ConsultarVenta, boolean NuevaCompra, boolean ConsultarCompra, boolean NuevoArticulo, boolean ConsultarArticulo, boolean NuevoCliente,
			boolean ConsultarCliente, boolean NuevoProveedor, boolean ConsultarProveedor, boolean TablaAuxiliares, boolean ReporteVentas, boolean ReporteCompras, boolean ReporteArticulos, boolean ReporteClientes
			,boolean ReporteProveedores, boolean CajaDiaria, boolean InformeVenta, boolean FacturasEmitidas, boolean ListaArticulos, boolean ManualUsuario, boolean AcercaAplicacion){
		
		setNombreDeUsuario(NombreDeUsuario);
		setContrasena(Contrasena);
		this.TipoUsuario = TipoUsuario;
		setNombres(Nombres);
		setApellidos(Apellidos);
		setFechaNacimiento(FechaNacimiento);
		setTelefono(Telefono);
		setEmail(Email);
		setConfiguracion(Congiguracion);
		setNuevoUsuario(NuevoUsuario);
		setCambiarDeUsuario(CambiarUsuario);
		setSalirDelSistema(SalirSistema);
		setBackup_Restauracion(Backup);
		setRealizarNuevaVenta(NuevaVenta);
		setConsultarVentas(ConsultarVenta);
		setRealizarNuevaCompra(NuevaCompra);
		setConsultarCompra(ConsultarCompra);
		setRegistrarNuevoArticulo(NuevoArticulo);
		setConsultarArticulos(ConsultarArticulo);
		setRegistrarNuevoCliente(NuevoCliente);
		setConsultarClientes(ConsultarCliente);
		setRegistrarNuevoProveedor(NuevoProveedor);
		setConsultarProveedores(ConsultarProveedor);
		setTablasAuxiliares(TablaAuxiliares);
		setReporteDeVentas(ReporteVentas); 
		setReporteDecompras(ReporteCompras);
		setReporteDeArticulos(ReporteArticulos);
		setReporteDeClientes(ReporteClientes);
		setReportedeProveedores(ReporteProveedores);
		setCajaDiaria(CajaDiaria);
		setInformeDeVentaDiaria(InformeVenta); 
		setBusquedaFacturasdemitidas(FacturasEmitidas);
		setListadoDeArticulos(ReporteArticulos);
		setManualDeUsuario(ManualUsuario);
		setAcercaDeLaAplicacion(AcercaAplicacion);	
	}
	
	public ClassTipoUsuario getTipoUsuario(){
		return TipoUsuario;
	}
	public void setTipoUsuario(ClassTipoUsuario TipoUsuario){
		this.TipoUsuario = TipoUsuario;
	}
	public String getNombreDeUsuario(){
		return nombreDeUsuario;
	}
	public String getContrasena(){
		return contrasena;
	}
	public int getIdTipoUsuario(){
		return idTipoUsuario;
	}
	public String getNombre(){
		return nombres;
	}
	public void setNombreDeUsuario(String NombreDeUsuario){
		this.nombreDeUsuario = NombreDeUsuario;
	}
	public void setContrasena(String Contrasena){
		this.contrasena = Contrasena;
	}
	public void setIdTipoUsuario(int IdTipoUsuario){
		this.idTipoUsuario = IdTipoUsuario;
	}
	
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setFechaNacimiento(String fechaNacimiento2) {
		this.fechaNacimiento = fechaNacimiento2;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// insertar un nuevo usuario con sus repectivos permisos 
	public void insertarNuevoUsuario () throws ClassNotFoundException, SQLException
	{
		String sql = "INSERT INTO tblusuario (nombreUsuario, contrasena, tipoUsuario, nombre, apellidos, fechaNacimiento, telefono, email, pConfiguracion, pBackup, pNUsuario, pCUsuario, pSalirSistema, pRVenta, pCVenta, pRCompra, pCCompra, pNArticulo, pCArticulo, pNCliente, pCCliente, pNProveedores, pCProveedores, pTablasAxu, pReporteVenta, pReporteCompras, pRArticulo, pRCliente, pRProveedores, pCajaDiaria, pInformeVentaD, pBusquedaFactura, pListaArti, pManualUsu, pAcercaApli)"
				+ "VALUES (?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement  instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getNombreDeUsuario());
		instrucion.setString(2, getContrasena());
		instrucion.setInt(3, getTipoUsuario().getIdTipoUsuario());
		instrucion.setString(4, getNombre());
		instrucion.setString(5, getApellidos());
		instrucion.setString(6, getFechaNacimiento());
		instrucion.setString(7, getTelefono());
		instrucion.setString(8, getEmail());
		instrucion.setBoolean(9, isConfiguracion());
		instrucion.setBoolean(10, isBackup_Restauracion());
		instrucion.setBoolean(11, isNuevoUsuario());
		instrucion.setBoolean(12, isCambiarDeUsuario());
		instrucion.setBoolean(13, isSalirDelSistema());
		instrucion.setBoolean(14 , isRealizarNuevaVenta());
		instrucion.setBoolean(15 , isConsultarVentas() );
		instrucion.setBoolean(16 , isRealizarNuevaCompra() );
		instrucion.setBoolean(17 , isConsultarCompra());
		instrucion.setBoolean(18 , isRegistrarNuevoArticulo());
		instrucion.setBoolean(19 , isConsultarArticulos() );
		instrucion.setBoolean(20 ,  isRegistrarNuevoCliente());
		instrucion.setBoolean(21 ,isConsultarClientes() );
		instrucion.setBoolean(22 , isRegistrarNuevoProveedor());
		instrucion.setBoolean(23 ,isConsultarProveedores() );
		instrucion.setBoolean(24 , isTablasAuxiliares());
		instrucion.setBoolean(25 , isReporteDeVentas());
		instrucion.setBoolean(26 ,isReporteDecompras() );
		instrucion.setBoolean(27 , isReporteDeArticulos());
		instrucion.setBoolean(28, isReporteDeClientes());
		instrucion.setBoolean(29,isReportedeProveedores() );
		instrucion.setBoolean(30, isCajaDiaria());
		instrucion.setBoolean(31, isInformeDeVentaDiaria());
		instrucion.setBoolean(32, isBusquedaFacturasdemitidas());
		instrucion.setBoolean(33, isListadoDeArticulos());
		instrucion.setBoolean(34, isManualDeUsuario());
		instrucion.setBoolean(35, isAcercaDeLaAplicacion());
		instrucion.execute();
	}

	
	// actualizar usuario con sus repectivos permisos 
	public void actualizarUsuario () throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE tblusuario SET contrasena=?, tipoUsuario=?, nombre=?, apellidos=?, fechaNacimiento=?, telefono=?, email=?, pConfiguracion=?, pBackup=?, pNUsuario=?, pCUsuario=?, pSalirSistema=?, pRVenta=?, pCVenta=?, pRCompra=?, pCCompra=?, pNArticulo=?, pCArticulo=?, pNCliente=?, pCCliente=?, pNProveedores=?, pCProveedores=?, pTablasAxu=?, pReporteVenta=?, pReporteCompras=?, pRArticulo=?, pRCliente=?, pRProveedores=?, pCajaDiaria=?, pInformeVentaD=?, pBusquedaFactura=?, pListaArti=?, pManualUsu=?, pAcercaApli=?  WHERE nombreUsuario =?";
		PreparedStatement  instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setString(1, getContrasena());
		instrucion.setInt(2, getTipoUsuario().getIdTipoUsuario());
		instrucion.setString(3, getNombre());
		instrucion.setString(4, getApellidos());
		instrucion.setString(5, getFechaNacimiento());
		instrucion.setString(6, getTelefono());
		instrucion.setString(7, getEmail());
		instrucion.setBoolean(8, isConfiguracion());
		instrucion.setBoolean(9, isBackup_Restauracion());
		instrucion.setBoolean(10, isNuevoUsuario());
		instrucion.setBoolean(11, isCambiarDeUsuario());
		instrucion.setBoolean(12, isSalirDelSistema());
		instrucion.setBoolean(13 , isRealizarNuevaVenta());
		instrucion.setBoolean(14 , isConsultarVentas() );
		instrucion.setBoolean(15 , isRealizarNuevaCompra() );
		instrucion.setBoolean(16 , isConsultarCompra());
		instrucion.setBoolean(17 , isRegistrarNuevoArticulo());
		instrucion.setBoolean(18 , isConsultarArticulos() );
		instrucion.setBoolean(19 ,  isRegistrarNuevoCliente());
		instrucion.setBoolean(20 ,isConsultarClientes() );
		instrucion.setBoolean(21 , isRegistrarNuevoProveedor());
		instrucion.setBoolean(22 ,isConsultarProveedores() );
		instrucion.setBoolean(23 , isTablasAuxiliares());
		instrucion.setBoolean(24 , isReporteDeVentas());
		instrucion.setBoolean(25 ,isReporteDecompras() );
		instrucion.setBoolean(26 , isReporteDeArticulos());
		instrucion.setBoolean(27, isReporteDeClientes());
		instrucion.setBoolean(28,isReportedeProveedores() );
		instrucion.setBoolean(29, isCajaDiaria());
		instrucion.setBoolean(30, isInformeDeVentaDiaria());
		instrucion.setBoolean(31, isBusquedaFacturasdemitidas());
		instrucion.setBoolean(32, isListadoDeArticulos());
		instrucion.setBoolean(33, isManualDeUsuario());
		instrucion.setBoolean(34, isAcercaDeLaAplicacion());
		instrucion.setString(35, getNombreDeUsuario());
		instrucion.execute();
	}
}






















