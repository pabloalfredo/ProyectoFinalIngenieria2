package Clases;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public  class  Validacion {
	
	public static void validarUsuarios(JMenuItem itemConfiguracion, JMenuItem itemBackup, JMenuItem itemNuevoUsuario, JMenuItem itemCambiarDeUsuario, JMenuItem itemSalirSistema, JMenuItem itemNuevaVenta, JMenuItem itemConsultarVenta, JMenuItem itemRealizarCompra, JMenuItem itemConsultarCompra, JMenuItem itemRegistrarArt, JMenuItem itemConsuArti, JMenuItem itemReCliente, JMenuItem itemConCliente,JMenuItem itemRegProveedor, JMenuItem itemConProveedor, JMenu mnTablas, JMenu mnRVentas, JMenu mnRCompras, JMenu mnRArticulos, JMenu mnRClientes, JMenu mnRProveedores, JMenu mnRCaja, JMenuItem itemInformeVentaDia, JMenuItem itemBusquedaFactEm, JMenuItem itemListaArt, JMenuItem itemManual, JMenuItem itemAcercaApli)
	{
		if(Variable.configuracion == true){
			itemConfiguracion.setEnabled(true);
		}
		else{
			itemConfiguracion.setEnabled(false);
		}
		if(Variable.backup_Restauracion == true){
			itemBackup.setEnabled(true);
		}
		else{
			itemBackup.setEnabled(false);
		}
		if(Variable.nuevoUsuario== true){
			itemNuevoUsuario.setEnabled(true);
		}
		else{
			itemNuevoUsuario.setEnabled(false);
		}
		if(Variable.cambiarDeUsuario== true){
			itemCambiarDeUsuario.setEnabled(true);
		}
		else{
			itemCambiarDeUsuario.setEnabled(false);
		}
		if(Variable.salirDelSistema == true){
			itemSalirSistema.setEnabled(true);
		}
		else{
			itemSalirSistema.setEnabled(false);
		}
		if(Variable.realizarNuevaVenta == true){
			itemNuevaVenta.setEnabled(true);
		}
		else{
			itemNuevaVenta.setEnabled(false);
		}
		if(Variable.consultarVentas== true){
			itemConsultarVenta.setEnabled(true);
		}
		else{
			itemConsultarVenta.setEnabled(false);
		}
		if(Variable.realizarNuevaCompra== true){
			itemRealizarCompra.setEnabled(true);
		}
		else{
			itemRealizarCompra.setEnabled(false);
		}
		if(Variable.consultarCompra == true){
			itemConsultarCompra.setEnabled(true);
		}
		else{
			itemConsultarCompra.setEnabled(false);
		}
		if(Variable.registrarNuevoArticulo == true){
			itemRegistrarArt.setEnabled(true);
		}
		else{
			itemRegistrarArt.setEnabled(false);
		}
		if(Variable.consultarArticulos== true){
			itemConsuArti.setEnabled(true);
		}
		else{
			itemConsuArti.setEnabled(false);
		}
		if(Variable.registrarNuevoCliente== true){
			itemReCliente.setEnabled(true);
		}
		else{
			itemReCliente.setEnabled(false);
		}
		if(Variable.consultarClientes == true){
			itemConCliente.setEnabled(true);
		}
		else{
			itemConCliente.setEnabled(false);
		}
		if(Variable.registrarNuevoProveedor == true){
			itemRegProveedor.setEnabled(true);
		}
		else{
			itemRegProveedor.setEnabled(false);
		}
		if(Variable.consultarProveedores== true){
			itemConProveedor.setEnabled(true);
		}
		else{
			itemConProveedor.setEnabled(false);
		}
		if(Variable.tablasAuxiliares== true){
			mnTablas.setEnabled(true);
		}
		else{
			mnTablas.setEnabled(false);
		}
		if(Variable.reporteDeVentas == true){
			mnRVentas.setEnabled(true);
		}
		else{
			mnRVentas.setEnabled(false);
		}
		if(Variable.reporteDecompras == true){
			mnRCompras.setEnabled(true);
		}
		else{
			mnRCompras.setEnabled(false);
		}
		if(Variable.reporteDeArticulos== true){
			mnRArticulos.setEnabled(true);
		}
		else{
			mnRArticulos.setEnabled(false);
		}
		if(Variable.reporteDeClientes== true){
			mnRClientes.setEnabled(true);
		}
		else{
			mnRArticulos.setEnabled(false);
		}
		if(Variable.reportedeProveedores == true){
			mnRProveedores.setEnabled(true);
		}
		else{
			mnRProveedores.setEnabled(false);
		}
		if(Variable.cajaDiaria == true){
			mnRCaja.setEnabled(true);
		}
		else{
			mnRCaja.setEnabled(false);
		}
		if(Variable.informeDeVentaDiaria== true){
			itemInformeVentaDia.setEnabled(true);
		}
		else{
			itemInformeVentaDia.setEnabled(false);
		}
		if(Variable.busquedaFacturasdemitidas== true){
			itemBusquedaFactEm.setEnabled(true);
		}
		else{
			itemBusquedaFactEm.setEnabled(false);
		}
		if(Variable.listadoDeArticulos== true){
			itemListaArt.setEnabled(true);
		}
		else{
			itemListaArt.setEnabled(false);
		}
		if(Variable.manualDeUsuario == true){
			itemManual.setEnabled(true);
		}
		else{
			itemManual.setEnabled(false);
		}
		if(Variable.acercaDeLaAplicacion == true){
			itemAcercaApli.setEnabled(true);
		}
		else{
			itemAcercaApli.setEnabled(false);
		}
		
	}
}
