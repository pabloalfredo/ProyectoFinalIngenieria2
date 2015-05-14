package Formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuItem;

import Clases.AplicarTemaVentana;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

import Clases.*;

import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class FrmPrincipal {

	private JFrame frmSistemaDeVenta;
	private String nombreDelUsuario;
	private JLabel tipousuario;
	private JLabel usuario;
	private JMenuItem mntmResumenDelDia;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal window = new FrmPrincipal();
					window.frmSistemaDeVenta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param <vproducto>
	 */
	private void initialize() {
		AplicarTemaVentana tema = new AplicarTemaVentana();
		tema.temaNibus();
		frmSistemaDeVenta = new JFrame();
		frmSistemaDeVenta.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSistemaDeVenta.setType(Type.POPUP);
		frmSistemaDeVenta.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/Recursos/0863E5DD6.png")));
		frmSistemaDeVenta.setTitle("Sistema de Venta Pantalla Principal");
		frmSistemaDeVenta.setBounds(100, 100, 920, 543);
		
		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setAutoscrolls(true);
		desktopPane.setBackground(new Color(128, 128, 128));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(135, 206, 235));
		frmSistemaDeVenta.setJMenuBar(menuBar);
		
		JMenu sistema = new JMenu("Sistema");
		sistema.setMnemonic('S');
		sistema.setForeground(new Color(0, 0, 128));
		sistema.setFont(new Font("Segoe UI", Font.BOLD, 16));
		sistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/0863E5DD6.png")));
		menuBar.add(sistema);
		
		JMenuItem itemConfiguracion = new JMenuItem("Configuracion");
		itemConfiguracion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConfiguracionesGenerales frm = new FrmConfiguracionesGenerales();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
				
			}
		});
		itemConfiguracion.setMnemonic('C');
		itemConfiguracion.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemConfiguracion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		itemConfiguracion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/0486DF474.png")));
		sistema.add(itemConfiguracion);
		
		JMenuItem itemBackup = new JMenuItem("Backup/Restore");
		itemBackup.setMnemonic('B');
		itemBackup.setFont(new Font("SansSerif", Font.BOLD, 12));
		sistema.add(itemBackup);
		
		JSeparator separator_1 = new JSeparator();
		sistema.add(separator_1);
		
		JMenu mnUsuario = new JMenu("Usuario");
		mnUsuario.setMnemonic('U');
		mnUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/51F0B6FBE.png")));
		sistema.add(mnUsuario);
		
		JMenuItem itemNuevoUsuario = new JMenuItem("Agregar Nuevo");
		agregarNuevoUsuario(desktopPane, itemNuevoUsuario);       // Nuevo Usuario: Metodo despues del constructor
		itemNuevoUsuario.setMnemonic('N');
		itemNuevoUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemNuevoUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		mnUsuario.add(itemNuevoUsuario);
		
		JMenuItem itemCambiarDeUsuario = new JMenuItem("Cambiar de Usuario");
		cambiarDeUsuario(itemCambiarDeUsuario);
		itemCambiarDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemCambiarDeUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.ALT_MASK));
		itemCambiarDeUsuario.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/902BCB3FC.png")));
		sistema.add(itemCambiarDeUsuario);
		
		JSeparator separator = new JSeparator();
		sistema.add(separator);
		
		final JMenuItem itemSalirSistema = new JMenuItem("Salir");
		itemSalirSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = JOptionPane.showConfirmDialog(itemSalirSistema, FrmPrincipal.class.getName().concat("Formulario Principal"), "Salir de la Aplicacion", 2);
	
				if(opcion == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		itemSalirSistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		
		itemSalirSistema.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemSalirSistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		itemSalirSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/20DC4B327.png")));
		sistema.add(itemSalirSistema);
		
		JMenu mantenimiento = new JMenu("Mantenimiento");
		mantenimiento.setMnemonic('M');
		mantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/63BB74773.png")));
		mantenimiento.setForeground(new Color(0, 0, 128));
		mantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mantenimiento);
		
		JMenu ventas = new JMenu("Administrar Ventas");
		ventas.setMnemonic('V');
		ventas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/fffdd2r - copia.png")));
		ventas.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(ventas);
		
		JMenuItem itemNuevaVenta = new JMenuItem("Nueva Venta");
		nuevaVenta(desktopPane, itemNuevaVenta);
		itemNuevaVenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		itemNuevaVenta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		itemNuevaVenta.setFont(new Font("SansSerif", Font.BOLD, 12));
		ventas.add(itemNuevaVenta);

		JMenuItem itemConsultarVenta = new JMenuItem("Consultar Ventas");
		itemConsultarVenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		consultarVentas(desktopPane, itemConsultarVenta);
		itemConsultarVenta.setFont(new Font("SansSerif", Font.BOLD, 12));
		ventas.add(itemConsultarVenta);
		
		JMenu mnAdministrarCompras = new JMenu("Administrar Compras");
		mnAdministrarCompras.setMnemonic('C');
		mnAdministrarCompras.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/D63E3C19B.png")));
		mnAdministrarCompras.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(mnAdministrarCompras);
		
		JMenuItem itemRealizarCompra = new JMenuItem("Nueva Comra");
		itemRealizarCompra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		itemRealizarCompra.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		nuevaCompra(desktopPane, itemRealizarCompra);
		itemRealizarCompra.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnAdministrarCompras.add(itemRealizarCompra);
		
		JMenuItem itemConsultarCompra = new JMenuItem("Consultar Compras");
		itemConsultarCompra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		consultaDeCompras(desktopPane, itemConsultarCompra);
		itemConsultarCompra.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnAdministrarCompras.add(itemConsultarCompra);
		
		JSeparator separator_7 = new JSeparator();
		mantenimiento.add(separator_7);
		
		JMenu mnAdministrarProductos = new JMenu("Administrar Articulos");
		mnAdministrarProductos.setMnemonic('A');
		mnAdministrarProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/articulos.png")));
		mnAdministrarProductos.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(mnAdministrarProductos);

		JMenuItem itemRegistrarArt = new JMenuItem("Articulos");
		itemRegistrarArt.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		itemRegistrarArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeProductos frm = new FrmRegistroDeProductos();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemRegistrarArt.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemRegistrarArt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnAdministrarProductos.add(itemRegistrarArt);
		
		JMenuItem itemConsuArti = new JMenuItem("Consultar Articulos");
		itemConsuArti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaDeArticulos frm = new FrmConsultaDeArticulos();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemConsuArti.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemConsuArti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnAdministrarProductos.add(itemConsuArti);
		
		JSeparator separator_2 = new JSeparator();
		mantenimiento.add(separator_2);
		
		JMenu mnNewMenu_1 = new JMenu("Administracion de Clientes");
		mnNewMenu_1.setMnemonic('D');
		mnNewMenu_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/cliente.png")));
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(mnNewMenu_1);
		
		JMenuItem itemReCliente = new JMenuItem("Clientes");
		itemReCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		itemReCliente.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		itemReCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeClientes frm = new FrmRegistroDeClientes();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemReCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnNewMenu_1.add(itemReCliente);
		
		JMenuItem itemConCliente = new JMenuItem("Consulta de Clientes");
		itemConCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		itemConCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaClientes frm = new FrmConsultaClientes();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemConCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnNewMenu_1.add(itemConCliente);
		
		JMenu mnAdministracionDeProveedores = new JMenu("Administracion de Proveedores");
		mnAdministracionDeProveedores.setMnemonic('P');
		mnAdministracionDeProveedores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/probeedores.png")));
		mnAdministracionDeProveedores.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(mnAdministracionDeProveedores);
		
		JMenuItem itemRegProveedor = new JMenuItem("Proveedores");
		itemRegProveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		itemRegProveedor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/B7D02FDEF.png")));
		itemRegProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeProveedores frm = new FrmRegistroDeProveedores();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemRegProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnAdministracionDeProveedores.add(itemRegProveedor);
		
		JMenuItem itemConProveedor = new JMenuItem("Consulta de Proveedores");
		itemConProveedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		itemConProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaProveedores frm = new FrmConsultaProveedores();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		itemConProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnAdministracionDeProveedores.add(itemConProveedor);
		
		JSeparator separator_3 = new JSeparator();
		mantenimiento.add(separator_3);
		
		JMenu mnTablas = new JMenu("Tablas Auxiliares");
		mnTablas.setMnemonic('T');
		mnTablas.setFont(new Font("Dialog", Font.BOLD, 12));
		mantenimiento.add(mnTablas);
		
		JMenuItem mItemMarcas = new JMenuItem("Marcas");
		mnTablas.setMnemonic('M');
		mItemMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMarcaProducto frm = new FrmMarcaProducto();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		mItemMarcas.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnTablas.add(mItemMarcas);
		
		JMenuItem mItemCategoria = new JMenuItem("Categoria");
		mItemCategoria.setMnemonic('C');
		mItemCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCategoriaProducto frm = new FrmCategoriaProducto();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		mItemCategoria.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnTablas.add(mItemCategoria);
		
		JMenuItem mItemUnidadDeMedina = new JMenuItem("Unidad de Medina");
		mItemUnidadDeMedina.setMnemonic('U');
		mItemUnidadDeMedina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmUnidadDeMedida frm = new FrmUnidadDeMedida();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
				
			}
		});
		mItemUnidadDeMedina.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnTablas.add(mItemUnidadDeMedina);
		
		JMenuItem mItemCiudad = new JMenuItem("Ciudad");
		mItemCiudad.setMnemonic('D');
		mItemCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCiudad frm =  new FrmCiudad();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		mItemCiudad.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnTablas.add(mItemCiudad);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/44B9E873E.png")));
		mnReportes.setForeground(new Color(0, 0, 128));
		mnReportes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnReportes);
		
		JMenu mnRVentas = new JMenu("Ventas");
		mnRVentas.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/fffdd2r - copia.png")));
		mnReportes.add(mnRVentas);
		
		mntmResumenDelDia = new JMenuItem("Resumen del Dia");
		mntmResumenDelDia.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRVentas.add(mntmResumenDelDia);
		
		JMenuItem mItemResEntreFecha = new JMenuItem("Resumen entre Fecha");
		mItemResEntreFecha.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRVentas.add(mItemResEntreFecha);
		
		JMenu mnRCompras = new JMenu("Compras");
		mnRCompras.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRCompras.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/D63E3C19B.png")));
		mnReportes.add(mnRCompras);
		
		JMenuItem mItemResumenDia = new JMenuItem("Resumen del Dia");
		mItemResumenDia.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRCompras.add(mItemResumenDia);
		
		JMenuItem mItemCResumenFecha = new JMenuItem("Resumen entre Fecha");
		mItemCResumenFecha.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRCompras.add(mItemCResumenFecha);
		
		JSeparator separator_4 = new JSeparator();
		mnReportes.add(separator_4);
		
		JMenu mnRArticulos = new JMenu("Articulos");
		mnRArticulos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/articulos.png")));
		mnRArticulos.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnReportes.add(mnRArticulos);
		
		JMenuItem mItemListadoDeArticulo = new JMenuItem("Listado de Articulo");
		mItemListadoDeArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReporteArticulos frm = new ReporteArticulos("Reporte-Articulos.jasper");
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		mItemListadoDeArticulo.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRArticulos.add(mItemListadoDeArticulo);
		
		JMenuItem mItemListadoDeArticuloCat = new JMenuItem("Listado de Articulo Por Categoria");
		mItemListadoDeArticuloCat.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRArticulos.add(mItemListadoDeArticuloCat);
		
		JSeparator separator_5 = new JSeparator();
		mnReportes.add(separator_5);
		
		JMenu mnRClientes = new JMenu("Clientes");
		mnRClientes.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/cliente.png")));
		mnReportes.add(mnRClientes);
		
		JMenuItem mntmListadoPorNombre = new JMenuItem("Listado Por Nombre");
		mntmListadoPorNombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRClientes.add(mntmListadoPorNombre);
		
		JMenuItem mntmListadoDeVentaCliente = new JMenuItem("Listado de Venta Por Cliente");
		mntmListadoDeVentaCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRClientes.add(mntmListadoDeVentaCliente);
		
		JMenu mnRProveedores = new JMenu("Proveedores");
		mnRProveedores.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRProveedores.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/probeedores.png")));
		mnReportes.add(mnRProveedores);
		
		JMenuItem mntmListadoDeProveedores = new JMenuItem("Listado de Proveedores");
		mntmListadoDeProveedores.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRProveedores.add(mntmListadoDeProveedores);
		
		JMenuItem mntmArticulosComprados = new JMenuItem("Articulos Comprados");
		mntmArticulosComprados.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRProveedores.add(mntmArticulosComprados);
		
		JSeparator separator_6 = new JSeparator();
		mnReportes.add(separator_6);
		
		JMenu mnRCaja = new JMenu("Caja");
		mnRCaja.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/caja.png")));
		mnRCaja.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnReportes.add(mnRCaja);
		
		JMenuItem mntmCajaDiaria = new JMenuItem("Caja Diaria");
		mntmCajaDiaria.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnRCaja.add(mntmCajaDiaria);
		
		JMenu mnInformes = new JMenu("Informes");
		mnInformes.setMnemonic('I');
		mnInformes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/B991B78C0.png")));
		mnInformes.setForeground(new Color(0, 0, 128));
		mnInformes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnInformes);
		
		JMenuItem itemInformeVentaDia = new JMenuItem("Ventas Diarias");
		itemInformeVentaDia.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnInformes.add(itemInformeVentaDia);
		
		JMenuItem mntmCompras = new JMenuItem("Compras Diarias");
		mntmCompras.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnInformes.add(mntmCompras);
		
		JMenuItem mntmProductosMasVendidos = new JMenuItem("Productos Mas Vendidos");
		mntmProductosMasVendidos.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnInformes.add(mntmProductosMasVendidos);
		
		JMenu mnBusqueda = new JMenu("Busqueda");
		mnBusqueda.setMnemonic('B');
		mnBusqueda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/E937E1E0B (2).png")));
		mnBusqueda.setForeground(new Color(0, 0, 128));
		mnBusqueda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnBusqueda);
		
		JMenuItem itemBusquedaFactEm = new JMenuItem("Facturas Emitidas");
		itemBusquedaFactEm.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(itemBusquedaFactEm);
		
		JMenuItem itemListaArt = new JMenuItem("Listado de Articulos");
		itemListaArt.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(itemListaArt);
		
		JMenuItem mntmListadoDeClientes = new JMenuItem("Listado de Clientes");
		mntmListadoDeClientes.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(mntmListadoDeClientes);
		
		JMenuItem mItemRListaProveedores = new JMenuItem("Listado de Proveedores");
		mItemRListaProveedores.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(mItemRListaProveedores);
		
		JMenuItem mntmEntradaDeArticulos = new JMenuItem("Entrada de Articulos");
		mntmEntradaDeArticulos.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(mntmEntradaDeArticulos);
		
		JMenuItem menuItem_8 = new JMenuItem("Proveedores");
		menuItem_8.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("Proveedores");
		menuItem_9.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnBusqueda.add(menuItem_9);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/imagenMenu/D1EEE4A5B.png")));
		mnAyuda.setForeground(new Color(0, 0, 128));
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnAyuda);
		
		JMenuItem itemManual = new JMenuItem("Manual de Usuario");
		itemManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LansarAyuda ayda = new LansarAyuda();
				ayda.LansarLaAyuda();
			}
		});
		
		itemManual.setFont(new Font("SansSerif", Font.BOLD, 12));
		itemManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnAyuda.add(itemManual);
		
		JMenuItem itemAcercaApli = new JMenuItem("Acerca de la Aplicacion");
		itemAcercaApli.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		itemAcercaApli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Acerca de la Aplicacion");
			}
		});
		itemAcercaApli.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnAyuda.add(itemAcercaApli);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		frmSistemaDeVenta.getContentPane().add(toolBar, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Iniciar una nueva Venta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmFacturaVenta frm = new FrmFacturaVenta();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/fffdd2r.png")));
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Iniciar una nueva Compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmFacturaCompras frm = new FrmFacturaCompras();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/compra.png")));
		toolBar.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setToolTipText("Registrar un nuevo Cliente");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeClientes frm = new FrmRegistroDeClientes();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		button.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/mencliente.png")));
		toolBar.add(button);
		
		JButton btnp = new JButton("");
		btnp.setToolTipText("Registrar un nuevo Proveedor");
		btnp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeProveedores frm = new FrmRegistroDeProveedores();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		btnp.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/menuproe.png")));
		toolBar.add(btnp);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmRegistroDeProductos frm = new FrmRegistroDeProductos();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
		button_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Recursos/menuart.png")));
		button_2.setToolTipText("Registrar un nuevo  Articulo");
		toolBar.add(button_2);
		
		JToolBar toolBar_1 = new JToolBar();
		frmSistemaDeVenta.getContentPane().add(toolBar_1, BorderLayout.SOUTH);
		
		JLabel label = new JLabel("Usuario Conectado:");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 16));
		toolBar_1.add(label);
		
		nombreDelUsuario = null;
	    usuario = new JLabel(nombreDelUsuario);
		usuario.setForeground(new Color(0, 100, 0));
		usuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		toolBar_1.add(usuario);
		
	    tipousuario = new JLabel("(Administrador)");
		tipousuario.setFont(new Font("Segoe Print", Font.BOLD, 13));
		toolBar_1.add(tipousuario);
		
		frmSistemaDeVenta.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		// LES PASO A LA CLASE VALIDACION LOS MENU Y MENU ITEM PARA SER ACTIVADO O DESACTIVADO CADA MENU
		Validacion.validarUsuarios(itemConfiguracion, itemBackup, itemNuevoUsuario, itemCambiarDeUsuario, itemSalirSistema, itemNuevaVenta, itemConsultarVenta, itemRealizarCompra, itemConsultarCompra, itemRegistrarArt, itemConsuArti, itemReCliente, itemConCliente, itemRegProveedor, itemConProveedor, mnTablas, mnRVentas, mnRCompras, mnRArticulos, mnRClientes, mnRProveedores, mnRCaja, itemInformeVentaDia, itemBusquedaFactEm, itemListaArt, itemManual, itemManual);
		
	} // fin del constructor

	private void consultaDeCompras(final JDesktopPane desktopPane,
			JMenuItem mntmConsultarCompras) {
		mntmConsultarCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaDeCompras frm = new FrmConsultaDeCompras();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);;
			}
		});
	}

	private void nuevaCompra(final JDesktopPane desktopPane,
			JMenuItem mntmNuevaComra) {
		mntmNuevaComra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmFacturaCompras frm = new FrmFacturaCompras();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
	}

	private void consultarVentas(final JDesktopPane desktopPane,
			JMenuItem mntmConsultarVentas) {
		mntmConsultarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmConsultaDeVenta frm = new FrmConsultaDeVenta();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
	}

	private void nuevaVenta(final JDesktopPane desktopPane, JMenuItem menuventas) {
		menuventas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmFacturaVenta frm = new FrmFacturaVenta();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
	}

	private void cambiarDeUsuario(JMenuItem mntmNewMenuItem) {
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ocultarFrame();
				FrmLogin frm = new FrmLogin();
				frm.setVisible(true);
				
			}
		});
	}

	private void agregarNuevoUsuario(final JDesktopPane desktopPane,
			JMenuItem mntmAgregarNuevo) {
		mntmAgregarNuevo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				FrmAdminUsuarios frm = new FrmAdminUsuarios();
				PosicionarInternalFrameCentroPantalla.centrarFormularioEnPantalla(desktopPane, frm);
			}
		});
	}
	protected void ocultarFrame() {
		frmSistemaDeVenta.setVisible(false);
	}

	public void mostrarFormulario() {
		frmSistemaDeVenta.setVisible(true);
	}

	public void nombreDelUsuario(String nombreObtenido) {
		nombreDelUsuario = nombreObtenido;
		usuario.setText(nombreDelUsuario);
			
	}
	
}
