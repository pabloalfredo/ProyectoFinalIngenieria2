package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;


import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

import com.mysql.jdbc.ResultSet;

import Clases.CargarComboBox;
import Clases.ClassBaseDeDatos;
import Clases.ClassCategoriaProducto;
import Clases.ClassMarcaProducto;
import Clases.ClassRegistrarProducto;
import Clases.ClassUnidadMedida;
import Clases.ModeloTabla;
import Clases.ValidarTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FrmRegistroDeProductos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtBuscarPorCodigo;
	private static JFileChooser examinar = new JFileChooser();
	private JComboBox<Object>cmbProveedor,cmbUnidadMedida,cmbMarcaProducto,cmbCategoriaProducto;
	private JTextField txtEfectivo;
	private JTextField txtCostoProducto;
	private JTextField txtStockMaximo;
	private JTextField txtDescripcion;
	private JTextField txtCodigoProducto;
	private JTextField txtStockMinimo;
	private JTextField txtBuscarPorDescripcion;
	private long codigoProducto;
	private String descripcionProducto;
	private double costoProducto;
	private double efectivo;
	private int stockMaximo;
	private int stockMninimo;
	//private int exitencia;
	CargarComboBox combobox = new CargarComboBox();
	ClassCategoriaProducto objetoCategoriaProducto;
	ClassMarcaProducto objetoMarcaProducto;
	ClassUnidadMedida objetoUnidadMedida;
	ClassRegistrarProducto registrarArticulo,actualizarAticulos;
	ModeloTabla modeloTabla;
	private JTabbedPane tabbedPane;
	private JButton btnNuevoProducto,btnAgregarProducto,btnCancelar,btnSalir,btnEditar,btnGenerarCodigo,btnMarca,btnCategoria,btnUnidad,btnGuardar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroDeProductos frame = new FrmRegistroDeProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistroDeProductos()
	{
		initialize();
		desactivarControles();
	}
	public void initialize() {
		
		examinar.setMultiSelectionEnabled(false);
		examinar.setCurrentDirectory(new File("c://Documents and Settings"));
		setTitle("Administracion de Productos");
		setClosable(true);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 764, 476);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 139, 139));
		tabbedPane.setBounds(0, 111, 754, 277);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Productos", new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/articulos.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(34, 139, 34));
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		panel.setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(432, 92, 98, 103);
		imagen.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/imagen.png")));
		imagen.setHorizontalAlignment(SwingConstants.RIGHT);
		imagen.setForeground(new Color(0, 0, 128));
		imagen.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(imagen);
		
		final JButton buscarImagen = new JButton("....");
		buscarImagen.setBounds(542, 173, 30, 26);
		buscarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = e.getActionCommand();
				if(comando.equals("....")){
					examinar.showDialog(new FrmRegistroDeProductos(), "Seleccione una Imagen");
				}
			}
		});
		buscarImagen.setVerticalTextPosition(SwingConstants.TOP);
		buscarImagen.setVerticalAlignment(SwingConstants.BOTTOM);
		buscarImagen.setFont(new Font("SansSerif", Font.BOLD, 27));
		panel.add(buscarImagen);
		
		txtEfectivo = new JTextField();
		validarSoloNumeros(txtEfectivo); //VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtEfectivo.setBounds(580, 9, 57, 28);
		txtEfectivo.setForeground(new Color(0, 0, 128));
		txtEfectivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtEfectivo.setColumns(10);
		txtEfectivo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtEfectivo.setBackground(new Color(230, 230, 250));
		panel.add(txtEfectivo);
		
		JLabel lblPVenta = new JLabel("P. Venta");
		lblPVenta.setBounds(503, 14, 71, 16);
		lblPVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPVenta.setForeground(new Color(0, 0, 128));
		lblPVenta.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(lblPVenta);
		
		txtCostoProducto = new JTextField();
		validarSoloNumeros(txtCostoProducto);//VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtCostoProducto.setBounds(434, 9, 57, 28);
		txtCostoProducto.setForeground(new Color(0, 0, 128));
		txtCostoProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtCostoProducto.setColumns(10);
		txtCostoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCostoProducto.setBackground(new Color(230, 230, 250));
		panel.add(txtCostoProducto);
		
		JLabel label_2 = new JLabel("Costo");
		label_2.setBounds(340, 14, 90, 16);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Stock");
		label_3.setBounds(375, 47, 57, 16);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_3);
		
		txtStockMaximo = new JTextField();
		validarSoloNumeros(txtStockMaximo);//VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtStockMaximo.setBounds(436, 42, 57, 28);
		txtStockMaximo.setForeground(new Color(0, 0, 128));
		txtStockMaximo.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtStockMaximo.setBackground(new Color(230, 230, 250));
		panel.add(txtStockMaximo);
		
		JLabel label_4 = new JLabel("Stock Min");
		label_4.setBounds(499, 47, 75, 16);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_4);
		
		cmbProveedor = new JComboBox<Object>();
		//TODO: LLENAR COMBOBOX PROVEEDORES
		cmbProveedor.setFont(new Font("SansSerif", Font.BOLD, 13));
		cmbProveedor.setBounds(100, 167, 242, 28);
		cmbProveedor.setForeground(new Color(0, 0, 128));
		cmbProveedor.setBackground(new Color(0, 128, 128));
		panel.add(cmbProveedor);
		
		cmbUnidadMedida = new JComboBox<Object>();
		cmbUnidadMedida.setFont(new Font("SansSerif", Font.BOLD, 13));
		combobox.cargarComboBoxUnidadMedida(cmbUnidadMedida);  // CARGAR EL COMBOBOX ANTES DE PRESENTAR EL FORMULARIO,RESIVE UN OBJETO COMBOBOX
		cmbUnidadMedida.setBounds(102, 139, 216, 28);
		cmbUnidadMedida.setForeground(new Color(0, 0, 128));
		cmbUnidadMedida.setBackground(new Color(0, 128, 128));
		panel.add(cmbUnidadMedida);
		
		cmbMarcaProducto = new JComboBox<Object>();
		cmbMarcaProducto.setFont(new Font("SansSerif", Font.BOLD, 13));
		combobox.cargarComboBoxMarcaProducto(cmbMarcaProducto); // SE CARGA EL COMBBOX CON LA BASE DE DATOS,RESIVE UN OBJETO COMBOBOX
		cmbMarcaProducto.setBounds(102, 106, 216, 28);
		cmbMarcaProducto.setForeground(new Color(0, 0, 128));
		cmbMarcaProducto.setBackground(new Color(0, 128, 128));
		panel.add(cmbMarcaProducto);
		
		cmbCategoriaProducto = new JComboBox<Object>();
		cmbCategoriaProducto.setFont(new Font("SansSerif", Font.BOLD, 13));
		combobox.cargarComboBoxCategoriaProducto(cmbCategoriaProducto);// SE CARGA EL COMBBOX CON LA BASE DE DATOS, RESIVE UN OBJETO COMBOBOX
		cmbCategoriaProducto.setBounds(102, 74, 216, 28);
		cmbCategoriaProducto.setForeground(new Color(0, 0, 128));
		cmbCategoriaProducto.setBackground(new Color(0, 128, 128));
		panel.add(cmbCategoriaProducto);
		
		txtDescripcion = new JTextField();
		validarSoloLetras(txtDescripcion);// PERMITE SOLO LA ENTRADA DE LETRAS EN EL TEXTFIELD
		txtDescripcion.setBounds(102, 42, 240, 28);
		txtDescripcion.setForeground(new Color(0, 0, 128));
		txtDescripcion.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtDescripcion.setBackground(new Color(230, 230, 250));
		panel.add(txtDescripcion);
		
		txtCodigoProducto = new JTextField();
		validarSoloNumeros(txtCodigoProducto); //VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtCodigoProducto.setBounds(102, 9, 127, 28);
		txtCodigoProducto.setForeground(new Color(0, 0, 128));
		txtCodigoProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCodigoProducto.setBackground(new Color(230, 230, 250));
		panel.add(txtCodigoProducto);
		
		btnGenerarCodigo = new JButton("Generar");
		generarCodigoProductoAleatorio(btnGenerarCodigo);// LLAMADA AL METDO GENERR CODIGO ALEATORIOS 
		btnGenerarCodigo.setForeground(new Color(0, 0, 128));
		btnGenerarCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGenerarCodigo.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/902BCB3FC.png")));
		btnGenerarCodigo.setBounds(229, 6, 113, 34);
		panel.add(btnGenerarCodigo);
		
		btnCategoria = new JButton("");
		mtdoAgregarCategoria(btnCategoria); // LLAMADA AL METODO PARA AGREGAR UNA NUEVA CATEGORIA 
		btnCategoria.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/B7D02FDEF.png")));
		btnCategoria.setBounds(316, 74, 28, 28);
		panel.add(btnCategoria);
		
		btnMarca = new JButton("");
		mtdAgregarMarca(btnMarca);// LLAMADA AL METODO PARA AGREGAR UNA NUEVA MARCA 
		btnMarca.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/B7D02FDEF.png")));
		btnMarca.setBounds(316, 106, 28, 28);
		panel.add(btnMarca);
		
		btnUnidad = new JButton("");
		mtdAgregarUnidad(btnUnidad);// LLAMADA AL METODO PARA AGREGAR UNA NUEVA UNIDAD DE MEDIDA 
		btnUnidad.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/B7D02FDEF.png")));
		btnUnidad.setBounds(316, 139, 28, 28);
		panel.add(btnUnidad);
		
		JLabel label_5 = new JLabel("Proveedor");
		label_5.setBounds(6, 172, 90, 16);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Unidad");
		label_6.setBounds(8, 144, 90, 16);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Marca");
		label_7.setBounds(8, 111, 90, 16);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Categoria");
		label_8.setBounds(8, 79, 90, 16);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Descripcion");
		label_9.setBounds(8, 42, 90, 16);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(new Color(0, 0, 128));
		label_9.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Codigo");
		label_10.setBounds(8, 14, 90, 16);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(new Color(0, 0, 128));
		label_10.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel.add(label_10);
		
		txtStockMinimo = new JTextField();
		validarSoloNumeros(txtStockMinimo);//VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtStockMinimo.setForeground(new Color(0, 0, 128));
		txtStockMinimo.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtStockMinimo.setBackground(new Color(230, 230, 250));
		txtStockMinimo.setBounds(580, 42, 57, 28);
		panel.add(txtStockMinimo);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImagen.setForeground(new Color(0, 0, 128));
		lblImagen.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblImagen.setBounds(375, 173, 57, 16);
		panel.add(lblImagen);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Busqueda de Productos", new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/6B6F6D5EB.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 742, 175);
		panel_1.add(scrollPane);
		
		cargarDatosEnTabla();// LLAMADA AL METODO PARA CARGAR LOS DATOS EN LA TABLA
		table = new JTable(modeloTabla);
		table.setToolTipText("Doble Clic Para Editar Articulo");
		editarArticulo(table); // LLAMADA AL METEDO EDITAR ATICULOS CUANDO SE HAGA 2 CLICK EN LA FILA SELECCIONADA
		
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNombreDeUsuario = new JLabel("Codigo");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setForeground(new Color(0, 0, 128));
		lblNombreDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombreDeUsuario.setBounds(20, 6, 83, 19);
		panel_1.add(lblNombreDeUsuario);
		
		txtBuscarPorCodigo = new JTextField();
		metodoBuscarArticuloPorCodigo(); // LLAMADA AL  METDO PARA BUSCAR ARTICULOS POR CODIGO
		validarSoloNumeros(txtBuscarPorCodigo);//VALIDAR QUE SOLO SE ADMITAN NUMEROS EN EL TEXTFIELD
		txtBuscarPorCodigo.setForeground(new Color(0, 0, 128));
		txtBuscarPorCodigo.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorCodigo.setColumns(10);
		txtBuscarPorCodigo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorCodigo.setBackground(new Color(230, 230, 250));
		txtBuscarPorCodigo.setBounds(108, 3, 180, 26);
		panel_1.add(txtBuscarPorCodigo);
		
		JLabel lblTipoDeUsuario = new JLabel("Descripcion");
		lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeUsuario.setForeground(new Color(0, 0, 128));
		lblTipoDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTipoDeUsuario.setBounds(6, 36, 97, 19);
		panel_1.add(lblTipoDeUsuario);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscar.setForeground(new Color(0, 0, 128));
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(289, 28, 120, 33);
		panel_1.add(btnBuscar);
		
		txtBuscarPorDescripcion = new JTextField();
		metodoBuscarArticuloPorDescripcion();  // LLAMADA AL METODO PARA BUCAR ATICULOS POR DESCRIPCION
		validarSoloLetras(txtBuscarPorDescripcion);// VALIDAR QUE SOLO SE INTRODUSCAN LETRAS EN EL TEXTFIELD
		txtBuscarPorDescripcion.setForeground(new Color(0, 0, 128));
		txtBuscarPorDescripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorDescripcion.setColumns(10);
		txtBuscarPorDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorDescripcion.setBackground(new Color(230, 230, 250));
		txtBuscarPorDescripcion.setBounds(108, 33, 180, 26);
		panel_1.add(txtBuscarPorDescripcion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/333.jpg")));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_1.setBounds(6, 0, 100, 105);
		getContentPane().add(label_1);
		
		JLabel lblAdministracionDeUsuarios = new JLabel("Administracion de Productos");
		lblAdministracionDeUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdministracionDeUsuarios.setForeground(new Color(248, 248, 255));
		lblAdministracionDeUsuarios.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblAdministracionDeUsuarios.setBounds(106, 21, 527, 46);
		getContentPane().add(lblAdministracionDeUsuarios);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 128));
		panel_4.setBounds(0, 0, 760, 113);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 400, 760, 47);
		getContentPane().add(panel_3);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(null);
		
		btnNuevoProducto = new JButton("Nuevo [N]");
		nuevoLimpiarCampos(btnNuevoProducto); // LLAMADA AL METODO NUEVO ARTICULO QUE RESIVE UN BOTON 
		btnNuevoProducto.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/nuevo.png")));
		btnNuevoProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevoProducto.setForeground(new Color(0, 0, 128));
		btnNuevoProducto.setBounds(6, 6, 120, 36);
		panel_3.add(btnNuevoProducto);
		
		btnAgregarProducto = new JButton("Agregar");
		agregarNuevoArticulo(btnAgregarProducto); // LLAMADA AL METODO AGREGAR NUEVO ARTICULO QUE RESIVE UN BOTON
		btnAgregarProducto.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/157809D10.png")));
		btnAgregarProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAgregarProducto.setForeground(new Color(0, 0, 128));
		btnAgregarProducto.setBounds(138, 6, 120, 36);
		panel_3.add(btnAgregarProducto);
		
		btnCancelar = new JButton("Cancelar");
		cancelarEntradaArticulo(btnCancelar);// LLAMADA AL METODO CANCELAR LA ENTRADA DE ARTICULOS  QUE RESEIVE UN BOTON 
		btnCancelar.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/abort.png")));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setBounds(387, 6, 120, 36);
		panel_3.add(btnCancelar);
		
		btnSalir = new JButton("Salir [Esc]");
		cerrarFormArticulos(btnSalir); // LLAMADA AL METODO CERRAR FORMULARIO DE ARTICULOS QUE RESIVE UN BOTON 
		btnSalir.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/salir.png")));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBounds(634, 6, 120, 36);
		panel_3.add(btnSalir);
		
		btnEditar = new JButton("Editar");
		editarAticulos(btnEditar); //LLAMADA AL METODO EDITAR ARTICULOS QUE RESIVE UN BOTON 
		btnEditar.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/D1F0AC18D.png")));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setForeground(new Color(0, 0, 128));
		btnEditar.setBounds(512, 6, 120, 36);
		panel_3.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		guardarActualizarArticulo(btnGuardar); // LLAMADA AL METODO GUARDAR EDIICON DE ATICULOS
		btnGuardar.setIcon(new ImageIcon(FrmRegistroDeProductos.class.getResource("/Recursos/guardar.png")));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(260, 6, 120, 36);
		panel_3.add(btnGuardar);
		
		
	}// FIN DEL CONSTRUCTOR 

// METODO QUE LLAMA AL FORMULARIO AGREGAR UNA NUEVA MARCA PARA LUEGO SER MOSTRADA EN EL COMBOBOX CATEGORIA 
	private void mtdAgregarMarca(JButton btnMarca) {
		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMarcaProducto frm = new FrmMarcaProducto();
				getDesktopPane().add(frm);
				frm.setVisible(true);
			}
		});
	}
// METODO QUE LLAMA AL FORMULARIO AGREGAR UNA NUEVA UNIDAD MEDIDA PARA LUEGO SER MOSTRADA EN EL COMBOBOX CATEGORIA 
	private void mtdAgregarUnidad(JButton btnUnidad) {
		btnUnidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmMarcaProducto frm = new FrmMarcaProducto();
				getDesktopPane().add(frm);
				frm.setVisible(true);
			}
		});
	}

// METODO QUE LLAMA AL FORMULARIO AGREGAR UNA NUEVA CATEGORIA PARA LUEGO SER MOSTRADA EN EL COMBOBOX CATEGORIA 
	private void mtdoAgregarCategoria(JButton btnCategoria) {
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCategoriaProducto frm = new FrmCategoriaProducto();
				getDesktopPane().add(frm);
				frm.setVisible(true);
			}
		});
	}

// METODO ARA CARGAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS EN LA TABLA
	private void cargarDatosEnTabla() {
		try {
			modeloTabla = new ModeloTabla("codigoProducto as 'Codigo de Producto' , descripcion as 'Nombre del Producto' , idCategoriaProducto as 'Categoria' , idMarcaProducto as 'Marca',idUnidadMedida as Unidad, costo as Costo, efectivo as 'Precio de Venta', stockMaximo as 'Stock Maximo', stockMinimo as 'Stock Minimo'  ", "tblarticulos", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
// METODO PARA BUSCAR ARTICULOS POR DESCRIPCION 
	private void metodoBuscarArticuloPorDescripcion() {
		txtBuscarPorDescripcion.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				busquedaPorDescripcionaProducto();
			}
		});
	}
// METODO PARA BUSCAR ARTICULOS POR CODIGO 
	private void metodoBuscarArticuloPorCodigo() {
		txtBuscarPorCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCodigoProducto();
			}
		});
	}

// GERAR UN CODIGO ALEATORIO PARA LUEGO SER ASIGNADO AL TEXFIEL CODIGO 
	public void generarCodigoProductoAleatorio(JButton btnGenerarCodigo) {
		btnGenerarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarCodigo();
			}
		});
	}

// GUARDAR LA EDICION DEL ARTICULO CORRESPONDIENTE
	private void guardarActualizarArticulo(JButton btnGuardar) {
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarCamposVacios(); // LLAMADA A LA FUNCION PARA QUE NO SE DEJEN CAMMPOS VACIOS CUANDO SE GUARDE EL ARTICULO
				codigoProducto =  Long.parseLong(txtCodigoProducto.getText());
				descripcionProducto = txtDescripcion.getText();
				costoProducto = Double.parseDouble(txtCostoProducto.getText());
				efectivo = Double.parseDouble(txtEfectivo.getText());
				stockMaximo = Integer.parseInt(txtStockMinimo.getText());
				stockMninimo = Integer.parseInt(txtStockMaximo.getText());
				objetoCategoriaProducto = combobox.vectorCategoriaPrudcto.get(cmbCategoriaProducto.getSelectedIndex());
				objetoMarcaProducto = combobox.vectorMarcaProducto.get(cmbMarcaProducto.getSelectedIndex());
				objetoUnidadMedida = combobox.vectorUnidadMedida.get(cmbUnidadMedida.getSelectedIndex());
				actualizarAticulos = new ClassRegistrarProducto(codigoProducto, descripcionProducto, objetoCategoriaProducto, objetoMarcaProducto, objetoUnidadMedida, costoProducto, efectivo, stockMaximo, stockMninimo);
				try
				{
					actualizarAticulos.actualizarAticulos();
					JOptionPane.showMessageDialog(null, "Articulo Actualizado Correctamente");
					limpiarCampos();
					desactivarControles();
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
// CARGAR DE LA TABLA LOS DATOS PARA SER EDITADOS
	private void editarArticulo(final JTable table) {
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					desactivarControles();
					btnEditar.setEnabled(true);
					tabbedPane.setSelectedIndex(0);
					int filamodificar= table.getSelectedRow();  // VERIFICO QUE HAYA UNA FILA SELECCIONADA 
					if(filamodificar>=0)
					{
						 	txtCodigoProducto.setText(table.getValueAt(filamodificar, 0).toString());  // OBTENGO EL VALOR DE CADA FILA DE LA TABLA 
						 	txtDescripcion.setText(table.getValueAt(filamodificar, 1).toString());
						 	cmbCategoriaProducto.setSelectedItem(table.getValueAt(filamodificar, 2).toString());
						 	cmbMarcaProducto.setSelectedItem(table.getValueAt(filamodificar, 3).toString());
						 	cmbUnidadMedida.setSelectedItem(table.getValueAt(filamodificar, 4).toString());
						 	txtCostoProducto.setText(table.getValueAt(filamodificar, 5).toString());
						 	txtEfectivo.setText(table.getValueAt(filamodificar, 6).toString());
						 	txtStockMaximo.setText(table.getValueAt(filamodificar, 7).toString());
						 	txtStockMinimo.setText(table.getValueAt(filamodificar, 8).toString());
					}
				}
			}
		});
	}

// VALIDAR CAMPOS SOLO ADMITIR NUMEROS EN EL TEXTFIELD
	private void validarSoloNumeros(final JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validacion = new ValidarTextField();
				validacion.AdmitirSoloNumeros(campo);
			}
		});
	}
	
// VALIDAR CAMPOS SOLO ADMITIR LETRAS EN EL TEXTFIELD
	private void validarSoloLetras(final JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validacion = new ValidarTextField();
				validacion.AdmitirSoloLetras(campo);
			}
		});
	}
// METOD PARA CANCELAR LA ENTRADA DE ARTICULOS 
	private void cancelarEntradaArticulo(JButton btnCancelar) {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desactivarControles();
				limpiarCampos();
			}
		});
	}
// METODO EDITAR ARTICULOS 
	private void editarAticulos(JButton btnEditar) {
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activarArticulosEditar();
			}
		});
	}
// METODO CERRAR FORMULARIO DE REGISTRO DE ARTICULOS 
	private void cerrarFormArticulos(JButton btnSalir) {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
// METODO NUEVO - SE LIMPIAN Y ACTIVAN LOS CAMPOS 
	private void nuevoLimpiarCampos(JButton btnNuevoProducto) {
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				activarControlesNuevoArticulo();	
				limpiarCampos();
			}
		});
	}
// METEDO AGREGAR NUEVO ARTICULO  
	private void agregarNuevoArticulo(JButton btnAgregarProducto) {
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				validarCamposVacios(); // LLAMADA A LA FUNCION VALIDAR CAMPOS VACIOS PARA QUE NO SE DEJEN CAMPOS VACIOS CUANDO SE DE ENTER 
				long codigoObtenido = 0;
				ResultSet rs;
				String consulta = "SELECT codigoProducto FROM tblarticulos";   // VERIFICO QUE EL COIDOGO NO ESTE REPETIDO, LO BUSCO EN LA BASE DE DATOS Y LO COMPARO 
				try
				{
					rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
					while(rs.next())
					{
						codigoObtenido = rs.getInt(1);
					}
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
				
				codigoProducto =  Long.parseLong(txtCodigoProducto.getText());
				descripcionProducto = txtDescripcion.getText();
				costoProducto = Double.parseDouble(txtCostoProducto.getText());
				efectivo = Double.parseDouble(txtEfectivo.getText());
				stockMaximo = Integer.parseInt(txtStockMinimo.getText());
				stockMninimo = Integer.parseInt(txtStockMaximo.getText());
				objetoCategoriaProducto = combobox.vectorCategoriaPrudcto.get(cmbCategoriaProducto.getSelectedIndex());
				objetoMarcaProducto = combobox.vectorMarcaProducto.get(cmbMarcaProducto.getSelectedIndex());
				objetoUnidadMedida = combobox.vectorUnidadMedida.get(cmbUnidadMedida.getSelectedIndex());
				registrarArticulo = new ClassRegistrarProducto(codigoProducto, descripcionProducto, objetoCategoriaProducto, objetoMarcaProducto, objetoUnidadMedida, costoProducto, efectivo, stockMaximo, stockMninimo);
				
				if(codigoObtenido == codigoProducto)
				{
					JOptionPane.showMessageDialog(null, "Existe un Articulo con Este Codigo, Intente con Otro o Genere Uno");
					txtCodigoProducto.requestFocus();
					return;
				}
				else
				{
					
					try
					{
						registrarArticulo.registrarNuevoArticulo(); // REGISTRA EL ARTICULO
						JOptionPane.showMessageDialog(null, "Articulo Registrado Correctamente");
						limpiarCampos(); // LIMPIO EL FORMULARIO
						desactivarControles();  // DASACTIVO LOS CAMPOS
						
					}
					catch(ClassNotFoundException | SQLException e)
					{
						e.printStackTrace();
					}
				}

			}
		});
	}
	
//  PARA QUE CUANDO SE INICIE EL FORMULARIO LOS CONTROLES ESTEN DESACTIVADOS 
	public void desactivarControles(){
		txtCodigoProducto.setEnabled(false);
		btnGenerarCodigo.setEnabled(false);
		txtDescripcion.setEnabled(false);
		txtCostoProducto.setEnabled(false);
		txtEfectivo.setEnabled(false);
		txtStockMaximo.setEnabled(false);
		txtStockMinimo.setEnabled(false);
		cmbCategoriaProducto.setEnabled(false);
		cmbMarcaProducto.setEnabled(false);
		cmbUnidadMedida.setEnabled(false);
		cmbProveedor.setEnabled(false);
		btnNuevoProducto.setEnabled(true);
		btnSalir.setEnabled(true);
		btnAgregarProducto.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnCategoria.setEnabled(false);
		btnMarca.setEnabled(false);
		btnUnidad.setEnabled(false);
		btnGenerarCodigo.setEnabled(false);
		tabbedPane.setSelectedIndex(0);
	}
// ACTIVA LOS CONTROLES DEL FORMULARIOS PARA UN NUEVO ARTICULO
	public void activarControlesNuevoArticulo(){
		txtCodigoProducto.requestFocus();
		txtCodigoProducto.setEnabled(true);
		btnGenerarCodigo.setEnabled(true);
		txtDescripcion.setEnabled(true);
		txtCostoProducto.setEnabled(true);
		txtEfectivo.setEnabled(true);
		txtStockMaximo.setEnabled(true);
		txtStockMinimo.setEnabled(true);
		cmbCategoriaProducto.setEnabled(true);
		cmbMarcaProducto.setEnabled(true);
		cmbUnidadMedida.setEnabled(true);
		cmbProveedor.setEnabled(true);
		btnNuevoProducto.setEnabled(false);
		btnSalir.setEnabled(true);
		btnAgregarProducto.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnCategoria.setEnabled(true);
		btnMarca.setEnabled(true);
		btnUnidad.setEnabled(true);
		tabbedPane.setSelectedIndex(0);
	}
// ACTIVA LOS CONTROLES DEL FORMULARIO PARA SER EDITADOS
	public void activarArticulosEditar(){
		txtCodigoProducto.setEnabled(false);
		btnGenerarCodigo.setEnabled(false);
		txtDescripcion.setEnabled(true);
		txtCostoProducto.setEnabled(true);
		txtEfectivo.setEnabled(true);
		txtStockMaximo.setEnabled(true);
		txtStockMinimo.setEnabled(true);
		cmbCategoriaProducto.setEnabled(true);
		cmbMarcaProducto.setEnabled(true);
		cmbUnidadMedida.setEnabled(true);
		cmbProveedor.setEnabled(true);
		btnNuevoProducto.setEnabled(false);
		btnSalir.setEnabled(true);
		btnAgregarProducto.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnCategoria.setEnabled(true);
		btnMarca.setEnabled(true);
		btnUnidad.setEnabled(true);
		tabbedPane.setSelectedIndex(0);
	}
// LIMPIA LOS CAMPOS DEL FORMULARIO
	public void limpiarCampos(){
		txtCodigoProducto.setText("");
		txtDescripcion.setText("");
		cmbCategoriaProducto.setSelectedIndex(0);
		cmbMarcaProducto.setSelectedIndex(0);
		cmbUnidadMedida.setSelectedIndex(0);
		txtCostoProducto.setText("");
		txtEfectivo.setText("");
		txtStockMaximo.setText("");
		txtStockMinimo.setText("");
		tabbedPane.setSelectedIndex(0);
	}
	
// VALIDAR QUE LOS CONTROLES NO ESTEN VACIOS 
	public void validarCamposVacios(){
		
		try
		{
			if(txtCodigoProducto.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "El Codigo del Articulo no Puede Estar en Blanco");
				txtCodigoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
				txtCodigoProducto.requestFocus();
				return;
			}
			else
			{
				txtCodigoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
			if(txtDescripcion.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "El Nombre del Articulo no Puede Estar en Blanco");
				txtDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
				txtDescripcion.requestFocus();
				return;
			}
			else
			{
				txtDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
			if(txtCostoProducto.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "El Nombre del Articulo no Puede Estar en Blanco");
				txtCostoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
				txtCostoProducto.requestFocus();
				return;
			}
			else
			{
				txtCostoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
			if(txtEfectivo.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "El Precio de Venta del Articulo no Puede Estar en Blanco");
				txtEfectivo.requestFocus();
				return;
			}
			else
			{
				txtEfectivo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
			
			if(txtStockMaximo.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "Establesca un Stock Maximo para el Articulo");
				txtStockMaximo.requestFocus();
				return;
			}
			else
			{
				txtStockMaximo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
			
			if(txtStockMinimo.getText().trim().length() <=0 )
			{
				JOptionPane.showMessageDialog(null, "Establesca un Stock Minino para el Articulo");
				txtStockMinimo.requestFocus();
				return;
			}
			else
			{
				txtStockMinimo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			}
		}
		catch(IllegalFormatException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

// BUSCAR ARTICULO POR CODIGO 
	private void busquedaPorCodigoProducto() {
		try{
			String condicion = "1";
			condicion = "codigoProducto like '%" + txtBuscarPorCodigo.getText() + "%'";
			modeloTabla.establecerCondicion( condicion );
			modeloTabla.realizarBusqueda();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
// BUSCAR ARTICULO POR DESCRIPCION DEL ARTICULO
	private void busquedaPorDescripcionaProducto() {
		try{
			String condicion = "1";
			condicion = "descripcion like '%" + txtBuscarPorDescripcion.getText() + "%'";
			modeloTabla.establecerCondicion( condicion );
			modeloTabla.realizarBusqueda();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}

///// ESTA FUNCION GENERA EL CODIGO ALEATORIO PARA SER ASIGANDO AL PRODUDCTO EN CASO DE QUE NO TENGA CODIGO
	public long generarCodigo (){

		Random num = new Random();
		long codigo = 0;
		long codigoObtenido = 0;
		codigo = num.nextInt(1999999999 -1000000000 +1) +1000000000;  // PARA GENERAR EL CODIGO ALEATORIO ENTRE EL RANGO DE 2 VALORES
		ResultSet rs = null;
		String consulta = "SELECT codigoProducto FROM tblarticulos";   // VERIFICO QUE EL COIDOGO NO ESTE REPETIDO, LO BUSCO EN LA BASE DE DATOS Y LO COMPARO 
		try
		{
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
			while(rs.next())
			{
				codigoObtenido = rs.getInt(1);
			}
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		if(codigo == codigoObtenido )  // SI EL CODIGO GENERADO Y EL OBTENIDO DE LA BASE DE DATOS SON IGUALES LO GENERO OTRA VEZ
		{					
			codigo = num.nextInt(1999999999 -1000000000 +1) +1000000000;
		}
		else
		{
			txtCodigoProducto.setText(Long.toString(codigo));  // SE LO ASIGNO AL TEXFIEL CODIGO DEL PRODUCTO 
		}
	
		return codigo;
		
	}
	
	
}
