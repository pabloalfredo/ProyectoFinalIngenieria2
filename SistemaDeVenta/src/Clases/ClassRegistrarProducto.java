package Clases;


import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ClassRegistrarProducto {
	
	private long codigoProducto;
	private String descripcion;
	private double costoProducto;
	private int ganancia;                     // VARIABLES 
	private double efectivo;
	private int stockMaximo;
	private int stockMninimo;
	private int cantidad;
	private ClassCategoriaProducto CategoriaProducto;   // VARIABLE TIPO CLASS CATEGORIA PRODUCTO
	private ClassMarcaProducto MarcaProducto;
	private ClassUnidadMedida UnidadMedida;
	
	//CONSTRUCTOR QUE RESIVE 9 PARAMETROS
	public ClassRegistrarProducto (long CodigoProducto, String Descripcion, ClassCategoriaProducto CategoriaProducto, ClassMarcaProducto MarcaProducto, ClassUnidadMedida UnidadMedida, double CostoProudcto, double Efectivo, int StockMasimo, int StockMinino){
		setCodigoProducto(CodigoProducto);
		setDescripcion(Descripcion);
		this.CategoriaProducto = CategoriaProducto;
		this.MarcaProducto = MarcaProducto;
		this.UnidadMedida = UnidadMedida;
		setCostoProducto(CostoProudcto);
		setEfectivo(Efectivo);
		setStockMaximo(StockMasimo);
		setStockMninimo(StockMinino);
		
	}
	public ClassRegistrarProducto (long CodigoProducto, String Descripcion, double Efectivo){
		setCodigoProducto(CodigoProducto);
		setDescripcion(Descripcion);
		setEfectivo(Efectivo);
	}
	
	public long getCodigoProducto() {
		return codigoProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getCostoProducto() {
		return costoProducto;
	}
	public ClassCategoriaProducto getCategoriaProducto(){
		return CategoriaProducto;
	}
	public ClassMarcaProducto getMarcaProducto(){
		return MarcaProducto;
	}
	public ClassUnidadMedida getUnidadMedida(){
		return UnidadMedida;
	}
	public int getGanancia(){
		return ganancia;
	}
	public double getEfectivo() {
		return efectivo;
	}
	public int getStockMaximo() {
		return stockMaximo;
	}
	public int getStockMninimo() {
		return stockMninimo;
	}
	public int getCantidad(){
		return cantidad;
	}
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	public void setCodigoProducto(long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCategoriaProducto(ClassCategoriaProducto categoriaProducto){
		this.CategoriaProducto = categoriaProducto;
	}
	public void setMarcaProducto(ClassMarcaProducto marcaProducto){
		this.MarcaProducto = marcaProducto;
	}
	public void setUnidadMedida(ClassUnidadMedida unidadMedida){
		this.UnidadMedida = unidadMedida;
	}
	public void setCostoProducto(double costoProducto) {
		this.costoProducto = costoProducto;
	}
	public void setGanancia(int ganancia){
		this.ganancia = ganancia;
	}
	public void setEfectivo(double efectivo) {
		this.efectivo = efectivo;
	}
	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}
	public void setStockMninimo(int stockMninimo) {
		this.stockMninimo = stockMninimo;
	}
	
	/// ESTE METEDO REALIZA LA INSERCION DE PRODUCTOS EN LA BASE DE DATOSS
	public void registrarNuevoArticulo() throws ClassNotFoundException, SQLException {
		
		String sql = "INSERT INTO tblarticulos(codigoProducto, descripcion,idCategoriaProducto,idMarcaProducto,idUnidadMedida, costo, efectivo, stockMaximo,stockMinimo)"
				   + "VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement instrucion = (PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		instrucion.setLong(1, getCodigoProducto());
		instrucion.setString(2, getDescripcion());
		instrucion.setInt(3, getCategoriaProducto().getIdCategoriaPrudcto());
		instrucion.setInt(4, getMarcaProducto().getIdMarcaProducto());
		instrucion.setInt(5, getUnidadMedida().getIdUnidadMedida());
		instrucion.setDouble(6, getCostoProducto());
		instrucion.setDouble(7, getEfectivo());
		instrucion.setInt(8, getStockMaximo());
		instrucion.setInt(9, getStockMninimo());
		instrucion.execute();
	}
	
	// ESTE METODO REALIZA LA ACTUALIZACION DE PRODUCTOS
	public void actualizarAticulos() throws ClassNotFoundException, SQLException{
		String sql = "UPDATE tblarticulos SET descripcion =?, idCategoriaProducto=?,idMarcaProducto=?, idUnidadMedida=?, costo=?, efectivo=?, stockMaximo=?,stockMinimo=? WHERE codigoProducto=? ";
		PreparedStatement instrucion =(PreparedStatement) ClassBaseDeDatos.getConnection().prepareStatement(sql);
		
		
		instrucion.setString(1, getDescripcion());
		instrucion.setInt(2, getCategoriaProducto().getIdCategoriaPrudcto());
		instrucion.setInt(3, getMarcaProducto().getIdMarcaProducto());
		instrucion.setInt(4, getUnidadMedida().getIdUnidadMedida());
		instrucion.setDouble(5, getCostoProducto());
		instrucion.setDouble(6, getEfectivo());
		instrucion.setInt(7, getStockMaximo());
		instrucion.setInt(8, getStockMninimo());
		instrucion.setLong(9, getCodigoProducto());
		instrucion.execute();
		
	}
}
