package Formulario;


import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import java.awt.EventQueue;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import javax.swing.text.html.parser.Parser;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import Clases.CargarComboBox;
import Clases.ClassBaseDeDatos;
import Clases.ClassTipoUsuario;
import Clases.ModeloTabla;
import Clases.RegistroDeUsuarios;
import Clases.ValidarTextField;
import Clases.Variable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollBar;

import com.mysql.jdbc.ResultSet;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAdminUsuarios extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cmTipoUsuario;
	private JTable table;
	private JTextField txtNombres;
	private JTextField txtApellido;
	private JTextField txtFechaNacimiento;
	private JTextField txtNumeroTelefono;
	private JTextField txtCorreo;
	private JTextField txtNombreDeUsuario;
	private JPasswordField txtContrasena;
	private JTextField txtNombreABuscar;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String telefono;
	private String email;
	private String nombreUsuario;
	private String contrasena;
	private JComboBox<Object> cmbTipoUsuario, cmbBuscarTipoUsuario;
	private ModeloTabla modeloTabla;
	private JCheckBox chckbxConfiguracion;
	private JCheckBox chckbxBackuprestore;
	private JCheckBox chckbxRegistrarNuevoUsuario;
	private JCheckBox chckbxCambiarDeUsuario;
	private JCheckBox chckbxSalirDelSistema;
	private JCheckBox chckbxRealizarUnaVenta;
	private JCheckBox chckbxConsultarComprasRealizadas;
	private JCheckBox chckbxRealizarCompras;
	private JCheckBox chckbxConsultarVentasRealizadas;
	private JCheckBox chckbxConsultarArticulos;
	private JCheckBox chckbxCrearNuevoArticulos;
	private JCheckBox chckbxCrearNuevoCliente;
	private JCheckBox chckbxConsultarClientes;
	private JCheckBox chckbxCrearNuevoProveedor;
	private JCheckBox chckbxConsultarProveedores;
	private JCheckBox chckbxTablasAuxiliares;
	private JCheckBox chckbxReportesVenta;
	private JCheckBox chckbxReportesDeCompras;
	private JCheckBox chckbxReportesDeArticulos;
	private JCheckBox chckbxReportesDeCliente;
	private JCheckBox chckbxReportesDeProveedores;
	private JCheckBox chckbxCajaDiaria;
	private JCheckBox chckbxInformeDeVentas;
	private JCheckBox chckbxBusquedaFacturasEmitidas;
	private JCheckBox chckbxListadoDeArticulos;
	private JCheckBox chckbxManualDeUsuario;
	private JCheckBox chckbxAcercaDeLa;
	private JTabbedPane tabbedPane;
	CargarComboBox comboBox = new CargarComboBox();
	private static JFileChooser examinar = new JFileChooser();
	private JButton btnGuardar,btnNuevoUsuario, btnAgregarUsuario,btnCancelar,btnEditar,btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminUsuarios frame = new FrmAdminUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	FrmAdminUsuarios()
	{
		inizialize();
		mtdDesactivarControles();
		
	}
	public void inizialize()  {
		examinar.setMultiSelectionEnabled(false);
		examinar.setCurrentDirectory(new File("c://Documents and Settings"));
		setTitle("Administracion de Usuarios");
		setClosable(true);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 757, 495);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 139, 139));
		tabbedPane.setBounds(0, 111, 753, 302);
		getContentPane().add(tabbedPane);
		
		final JPanel panel = new JPanel();
		panel.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Usuario", new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/cliente.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(34, 139, 34));
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		panel.setLayout(null);
		
		JLabel label = new JLabel("Nombres");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setBounds(6, 11, 89, 16);
		panel.add(label);
		
		txtNombres = new JTextField();
		validarSoloLetras(txtNombres);
		txtNombres.setForeground(new Color(0, 0, 128));
		txtNombres.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNombres.setColumns(10);
		txtNombres.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombres.setBackground(new Color(230, 230, 250));
		txtNombres.setBounds(98, 6, 238, 28);
		panel.add(txtNombres);
		
		JLabel label_2 = new JLabel("Apellidos");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_2.setBounds(6, 44, 89, 16);
		panel.add(label_2);
		
		txtApellido = new JTextField();
		validarSoloLetras(txtApellido);
		txtApellido.setForeground(new Color(0, 0, 128));
		txtApellido.setFont(new Font("Verdana", Font.BOLD, 12));
		txtApellido.setColumns(10);
		txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtApellido.setBackground(new Color(230, 230, 250));
		txtApellido.setBounds(98, 39, 238, 28);
		panel.add(txtApellido);
		
		JLabel label_3 = new JLabel("  Fecha Nac");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_3.setBounds(6, 79, 89, 16);
		panel.add(label_3);
		
//VALIDANDO NUMERO TELEFONICO USANDO MASCARA DE TEXTO
///////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO			
		MaskFormatter mascara = null;   // mascara de texto para fecha de nacimiento
		try {
			mascara = new MaskFormatter("##/##/####"); //asignando la mascara de fecha
			mascara.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtFechaNacimiento = new JFormattedTextField(mascara);
		txtFechaNacimiento.setForeground(new Color(0,0,128));
		txtFechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 12));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtFechaNacimiento.setBackground(new Color(230, 230, 250));
		txtFechaNacimiento.setBounds(98, 74, 238, 28);
		panel.add(txtFechaNacimiento);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////FNN		
		JLabel label_6 = new JLabel("E-Mail");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_6.setBounds(14, 146, 83, 16);
		panel.add(label_6);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(new Color(0, 0, 128));
		txtCorreo.setFont(new Font("Verdana", Font.BOLD, 12));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCorreo.setBackground(new Color(230, 230, 250));
		txtCorreo.setBounds(100, 141, 238, 28);
		panel.add(txtCorreo);
		
		JLabel label_7 = new JLabel("Telefono");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_7.setBounds(21, 111, 74, 16);
		panel.add(label_7);

//VALIDANDO NUMERO TELEFONICO SUANDO MASCARA DE TEXTO
///////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO		
		MaskFormatter numeroCelular = null ;
		try{
			numeroCelular = new MaskFormatter("(###)-###-####");   // VALIDANDO NUMERO DE CELULAR USANDO MASCARA DE TEXTO
			numeroCelular.setPlaceholderCharacter('_');
		}catch(ParseException e){
			e.printStackTrace();
		}
		txtNumeroTelefono = new JFormattedTextField(numeroCelular);
		txtNumeroTelefono.setForeground(new Color(0, 0, 128));
		txtNumeroTelefono.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNumeroTelefono.setColumns(10);
		txtNumeroTelefono.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNumeroTelefono.setBackground(new Color(230, 230, 250));
		txtNumeroTelefono.setBounds(98, 106, 238, 28);
		panel.add(txtNumeroTelefono);
		
		JLabel lblTipousuario = new JLabel("Tipo_Usuario");
		lblTipousuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipousuario.setForeground(new Color(0, 0, 128));
		lblTipousuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTipousuario.setBounds(348, 71, 116, 16);
		panel.add(lblTipousuario);
		
		txtNombreDeUsuario = new JTextField();
		txtNombreDeUsuario.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
			}
		});
		txtNombreDeUsuario.setForeground(new Color(0, 0, 128));
		txtNombreDeUsuario.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNombreDeUsuario.setColumns(10);
		txtNombreDeUsuario.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombreDeUsuario.setBackground(new Color(230, 230, 250));
		txtNombreDeUsuario.setBounds(467, 6, 170, 28);
		panel.add(txtNombreDeUsuario);
		
		JLabel lblNombreusuario = new JLabel("Nombre-Usuario");
		lblNombreusuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreusuario.setForeground(new Color(0, 0, 128));
		lblNombreusuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombreusuario.setBounds(342, 15, 122, 16);
		panel.add(lblNombreusuario);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasena.setForeground(new Color(0, 0, 128));
		lblContrasena.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblContrasena.setBounds(348, 44, 116, 16);
		panel.add(lblContrasena);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtContrasena.setForeground(new Color(0, 0, 128));
		txtContrasena.setBackground(new Color(230, 230, 250));
		txtContrasena.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtContrasena.setBounds(467, 38, 170, 28);
		panel.add(txtContrasena);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/imagen.png")));
		imagen.setHorizontalAlignment(SwingConstants.RIGHT);
		imagen.setForeground(new Color(0, 0, 128));
		imagen.setFont(new Font("SansSerif", Font.BOLD, 14));
		imagen.setBounds(467, 111, 98, 103);
		panel.add(imagen);
		
		final JButton buscarImagen = new JButton("....");
		buscarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = e.getActionCommand();
				if(comando.equals("....")){
					examinar.showDialog(new FrmAdminUsuarios(), "Seleccione una Imagen");
				}
			}
		});
		buscarImagen.setVerticalTextPosition(SwingConstants.TOP);
		buscarImagen.setVerticalAlignment(SwingConstants.BOTTOM);
		buscarImagen.setFont(new Font("SansSerif", Font.BOLD, 27));
		buscarImagen.setBounds(570, 188, 30, 26);
		panel.add(buscarImagen);
		
		cmbTipoUsuario = new JComboBox<Object>();
		cmbTipoUsuario.setForeground(new Color(0, 0, 128));
		cmbTipoUsuario.setFont(new Font("SansSerif", Font.BOLD, 13));
		comboBox.cargarComboBoxTipoUsuario(cmbTipoUsuario); // cargamos el combo box  
		cmbTipoUsuario.setBackground(new Color(0, 128, 128));
		cmbTipoUsuario.setBounds(467, 72, 170, 26);
		panel.add(cmbTipoUsuario);
		
		try {
			modeloTabla = new ModeloTabla("nombreUsuario as 'Nombre De Usuario' , contrasena as Contrasena , tbltipousuario.descripcion as 'Tipo Usuario', nombre as Nombres, apellidos as Apellidos  ", "tblusuario, tbltipousuario", "tblusuario.tipoUsuario = tbltipousuario.idTipoUsuario");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Asignar Permisos", new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/51F0B6FBE.png")), panel_2, null);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 128));
		panel_2.setLayout(null);
		
		chckbxConfiguracion = new JCheckBox("Configuracion");
		chckbxConfiguracion.setForeground(new Color(0, 0, 128));
		chckbxConfiguracion.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxConfiguracion.setBounds(6, 6, 195, 18);
		panel_2.add(chckbxConfiguracion);
		
		chckbxBackuprestore = new JCheckBox("Backup/Restore");
		chckbxBackuprestore.setForeground(new Color(0, 0, 128));
		chckbxBackuprestore.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxBackuprestore.setBounds(6, 36, 195, 18);
		panel_2.add(chckbxBackuprestore);
		
		chckbxRealizarUnaVenta = new JCheckBox("Realizar una Venta");
		chckbxRealizarUnaVenta.setForeground(new Color(0, 0, 128));
		chckbxRealizarUnaVenta.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxRealizarUnaVenta.setBounds(6, 66, 195, 18);
		panel_2.add(chckbxRealizarUnaVenta);
		
		chckbxConsultarComprasRealizadas = new JCheckBox("Consultar  Compras");
		chckbxConsultarComprasRealizadas.setForeground(new Color(0, 0, 128));
		chckbxConsultarComprasRealizadas.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxConsultarComprasRealizadas.setBounds(6, 156, 195, 18);
		panel_2.add(chckbxConsultarComprasRealizadas);
		
		chckbxRealizarCompras = new JCheckBox("Realizar Compras");
		chckbxRealizarCompras.setForeground(new Color(0, 0, 128));
		chckbxRealizarCompras.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxRealizarCompras.setBounds(6, 126, 195, 18);
		panel_2.add(chckbxRealizarCompras);
		
		chckbxConsultarVentasRealizadas = new JCheckBox("Consultar Ventas Realizadas");
		chckbxConsultarVentasRealizadas.setForeground(new Color(0, 0, 128));
		chckbxConsultarVentasRealizadas.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxConsultarVentasRealizadas.setBounds(6, 96, 195, 18);
		panel_2.add(chckbxConsultarVentasRealizadas);
		
		chckbxConsultarArticulos = new JCheckBox("Consultar Articulos");
		chckbxConsultarArticulos.setForeground(new Color(0, 0, 128));
		chckbxConsultarArticulos.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxConsultarArticulos.setBounds(6, 211, 195, 18);
		panel_2.add(chckbxConsultarArticulos);
		
		chckbxCrearNuevoArticulos = new JCheckBox("Crear Nuevo Articulos");
		chckbxCrearNuevoArticulos.setForeground(new Color(0, 0, 128));
		chckbxCrearNuevoArticulos.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxCrearNuevoArticulos.setBounds(6, 181, 195, 18);
		panel_2.add(chckbxCrearNuevoArticulos);
		
		chckbxCrearNuevoCliente = new JCheckBox("Crear Nuevo Cliente");
		chckbxCrearNuevoCliente.setForeground(new Color(0, 0, 128));
		chckbxCrearNuevoCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxCrearNuevoCliente.setBounds(213, 6, 195, 18);
		panel_2.add(chckbxCrearNuevoCliente);
		
		chckbxConsultarClientes = new JCheckBox("Consultar Clientes");
		chckbxConsultarClientes.setForeground(new Color(0, 0, 128));
		chckbxConsultarClientes.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxConsultarClientes.setBounds(213, 36, 195, 18);
		panel_2.add(chckbxConsultarClientes);
		
		chckbxCrearNuevoProveedor = new JCheckBox("Crear Nuevo Proveedor");
		chckbxCrearNuevoProveedor.setForeground(new Color(0, 0, 128));
		chckbxCrearNuevoProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxCrearNuevoProveedor.setBounds(213, 66, 195, 18);
		panel_2.add(chckbxCrearNuevoProveedor);
		
		chckbxConsultarProveedores = new JCheckBox("Consultar Proveedores");
		chckbxConsultarProveedores.setForeground(new Color(0, 0, 128));
		chckbxConsultarProveedores.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxConsultarProveedores.setBounds(213, 96, 195, 18);
		panel_2.add(chckbxConsultarProveedores);
		
		chckbxTablasAuxiliares = new JCheckBox("Tablas Auxiliares");
		chckbxTablasAuxiliares.setForeground(new Color(0, 0, 128));
		chckbxTablasAuxiliares.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxTablasAuxiliares.setBounds(213, 126, 195, 18);
		panel_2.add(chckbxTablasAuxiliares);
		
		chckbxReportesVenta = new JCheckBox("Reportes Venta");
		chckbxReportesVenta.setForeground(new Color(0, 0, 128));
		chckbxReportesVenta.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxReportesVenta.setBounds(213, 156, 195, 18);
		panel_2.add(chckbxReportesVenta);
		
		chckbxReportesDeCompras = new JCheckBox("Reportes de Compras");
		chckbxReportesDeCompras.setForeground(new Color(0, 0, 128));
		chckbxReportesDeCompras.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxReportesDeCompras.setBounds(213, 181, 195, 18);
		panel_2.add(chckbxReportesDeCompras);
		
		chckbxReportesDeArticulos = new JCheckBox("Reportes de Articulos");
		chckbxReportesDeArticulos.setForeground(new Color(0, 0, 128));
		chckbxReportesDeArticulos.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxReportesDeArticulos.setBounds(213, 211, 195, 18);
		panel_2.add(chckbxReportesDeArticulos);
		
		chckbxReportesDeCliente = new JCheckBox("Reportes de Cliente");
		chckbxReportesDeCliente.setForeground(new Color(0, 0, 128));
		chckbxReportesDeCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxReportesDeCliente.setBounds(406, 6, 195, 18);
		panel_2.add(chckbxReportesDeCliente);
		
		chckbxReportesDeProveedores = new JCheckBox("Reportes de Proveedores");
		chckbxReportesDeProveedores.setForeground(new Color(0, 0, 128));
		chckbxReportesDeProveedores.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxReportesDeProveedores.setBounds(406, 36, 195, 18);
		panel_2.add(chckbxReportesDeProveedores);
		
		chckbxCajaDiaria = new JCheckBox("Caja Diaria");
		chckbxCajaDiaria.setForeground(new Color(0, 0, 128));
		chckbxCajaDiaria.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxCajaDiaria.setBounds(406, 66, 195, 18);
		panel_2.add(chckbxCajaDiaria);
		
		chckbxInformeDeVentas = new JCheckBox("Informe de Ventas Diarias ");
		chckbxInformeDeVentas.setForeground(new Color(0, 0, 128));
		chckbxInformeDeVentas.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxInformeDeVentas.setBounds(406, 96, 195, 18);
		panel_2.add(chckbxInformeDeVentas);
		
		chckbxBusquedaFacturasEmitidas = new JCheckBox("Busqueda Facturas Emitidas");
		chckbxBusquedaFacturasEmitidas.setForeground(new Color(0, 0, 128));
		chckbxBusquedaFacturasEmitidas.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxBusquedaFacturasEmitidas.setBounds(406, 126, 195, 18);
		panel_2.add(chckbxBusquedaFacturasEmitidas);
		
		chckbxListadoDeArticulos = new JCheckBox("Listado de Articulos");
		chckbxListadoDeArticulos.setForeground(new Color(0, 0, 128));
		chckbxListadoDeArticulos.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxListadoDeArticulos.setBounds(406, 156, 195, 18);
		panel_2.add(chckbxListadoDeArticulos);
		
		chckbxManualDeUsuario = new JCheckBox("Manual de Usuario");
		chckbxManualDeUsuario.setForeground(new Color(0, 0, 128));
		chckbxManualDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxManualDeUsuario.setBounds(406, 181, 195, 18);
		panel_2.add(chckbxManualDeUsuario);
		
		chckbxAcercaDeLa = new JCheckBox("Acerca de la Aplicacion");
		chckbxAcercaDeLa.setForeground(new Color(0, 0, 128));
		chckbxAcercaDeLa.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxAcercaDeLa.setBounds(406, 211, 195, 18);
		panel_2.add(chckbxAcercaDeLa);
		
		chckbxSalirDelSistema = new JCheckBox("Salir del Sistema");
		chckbxSalirDelSistema.setForeground(new Color(0, 0, 128));
		chckbxSalirDelSistema.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxSalirDelSistema.setBounds(405, 238, 195, 18);
		panel_2.add(chckbxSalirDelSistema);
		
		chckbxCambiarDeUsuario = new JCheckBox("Cambiar de Usuario");
		chckbxCambiarDeUsuario.setForeground(new Color(0, 0, 128));
		chckbxCambiarDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		chckbxCambiarDeUsuario.setBounds(213, 238, 195, 18);
		panel_2.add(chckbxCambiarDeUsuario);
		
		chckbxRegistrarNuevoUsuario = new JCheckBox("Registrar Nuevo Usuario");
		chckbxRegistrarNuevoUsuario.setForeground(new Color(0, 0, 128));
		chckbxRegistrarNuevoUsuario.setFont(new Font("SansSerif", Font.BOLD, 10));
		chckbxRegistrarNuevoUsuario.setBounds(6, 238, 195, 18);
		panel_2.add(chckbxRegistrarNuevoUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Busqueda de Usuarios", new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/6B6F6D5EB.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 64, 741, 192);
		panel_1.add(scrollPane);
		
		table = new JTable(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		editarUsuarios(table); // LLAMADA AL METOD PARA EDITAR USUARIO CUANDO SE HAGA 2 CLICK EN LA FILA 
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setForeground(new Color(0, 0, 128));
		lblNombreDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombreDeUsuario.setBounds(6, 9, 152, 19);
		panel_1.add(lblNombreDeUsuario);
		
		txtNombreABuscar = new JTextField();
		txtNombreABuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorTipoUsuario();
			}
		});
		txtNombreABuscar.setForeground(new Color(0, 0, 128));
		txtNombreABuscar.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNombreABuscar.setColumns(10);
		txtNombreABuscar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombreABuscar.setBackground(new Color(230, 230, 250));
		txtNombreABuscar.setBounds(160, 6, 180, 26);
		panel_1.add(txtNombreABuscar);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario");
		lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeUsuario.setForeground(new Color(0, 0, 128));
		lblTipoDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTipoDeUsuario.setBounds(26, 41, 129, 19);
		panel_1.add(lblTipoDeUsuario);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				busquedaPorTipoUsuario();
			}
		});
		btnBuscar.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscar.setForeground(new Color(0, 0, 128));
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(340, 28, 117, 35);
		panel_1.add(btnBuscar);
		
		cmbBuscarTipoUsuario = new JComboBox<Object>();
		cmbBuscarTipoUsuario.setBackground(new Color(0, 128, 128));
		comboBox.cargarComboBoxTipoUsuario(cmbBuscarTipoUsuario);
		cmbBuscarTipoUsuario.setBounds(160, 33, 180, 26);
		panel_1.add(cmbBuscarTipoUsuario);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/nuevousuario1.png")));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_1.setBounds(6, 0, 100, 105);
		getContentPane().add(label_1);
		
		JLabel lblAdministracionDeUsuarios = new JLabel("Administracion de Usuarios");
		lblAdministracionDeUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdministracionDeUsuarios.setForeground(new Color(248, 248, 255));
		lblAdministracionDeUsuarios.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblAdministracionDeUsuarios.setBounds(106, 21, 495, 46);
		getContentPane().add(lblAdministracionDeUsuarios);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(0, 420, 753, 47);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		btnNuevoUsuario = new JButton("Nuevo [N]");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				mtdActivarControlesNuevoUsuario();
			}
		});
		btnNuevoUsuario.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/nuevo.png")));
		btnNuevoUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevoUsuario.setForeground(new Color(0, 0, 128));
		btnNuevoUsuario.setBounds(6, 6, 120, 36);
		panel_3.add(btnNuevoUsuario);
		
		btnAgregarUsuario = new JButton("Agregar");
		agregarNuevoUsuario(btnAgregarUsuario);
		btnAgregarUsuario.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/157809D10.png")));
		btnAgregarUsuario.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAgregarUsuario.setForeground(new Color(0, 0, 128));
		btnAgregarUsuario.setBounds(135, 6, 120, 36);
		panel_3.add(btnAgregarUsuario);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				mtdDesactivarControles();
			}
		});
		btnCancelar.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/abort.png")));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setBounds(380, 6, 120, 36);
		panel_3.add(btnCancelar);
		
		btnSalir = new JButton("Salir [Esc]");
		salirDelInternalFrame(btnSalir);
		btnSalir.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/salir.png")));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBounds(627, 6, 120, 36);
		panel_3.add(btnSalir);
		
		btnEditar = new JButton("Editar");
		mtdEditarUsuario(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/D1F0AC18D.png")));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setForeground(new Color(0, 0, 128));
		btnEditar.setBounds(505, 6, 120, 36);
		panel_3.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		mtdGuardarUsuarioEditado(btnGuardar);
		btnGuardar.setIcon(new ImageIcon(FrmAdminUsuarios.class.getResource("/Recursos/guardar.png")));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setBounds(259, 6, 120, 36);
		panel_3.add(btnGuardar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 128));
		panel_4.setBounds(0, 0, 753, 113);
		getContentPane().add(panel_4);
			
	}// fin del constructor

	/**
	 * METODO PARA GUARDAR USUARIO DESPUES DE SER EDITADO
	 */
	private void mtdGuardarUsuarioEditado(final JButton btnGuardar) {
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtdValidarCamposVacios();
	
				nombres = txtNombres.getText();
				apellidos = txtApellido.getText();
				fechaNacimiento = txtFechaNacimiento.getText();
				telefono = txtNumeroTelefono.getText();
				email = txtCorreo.getText();
				nombreUsuario = txtNombreDeUsuario.getText();
				contrasena = new String(txtContrasena.getPassword()); // combirtiendo la contrasena a string 
				ClassTipoUsuario ObjetoTipoUsuario = FrmAdminUsuarios.this.comboBox.vectorTipoUsuario.get(cmbTipoUsuario.getSelectedIndex()); 
				Variable.configuracion = chckbxConfiguracion.isSelected();
				Variable.backup_Restauracion = chckbxBackuprestore.isSelected();
				Variable.nuevoUsuario = chckbxRegistrarNuevoUsuario.isSelected();
				Variable.cambiarDeUsuario = chckbxCambiarDeUsuario.isSelected();
				Variable.salirDelSistema = chckbxSalirDelSistema.isSelected();
				Variable.realizarNuevaVenta = chckbxRealizarUnaVenta.isSelected();
				Variable.consultarVentas = chckbxConsultarVentasRealizadas.isSelected();
				Variable.realizarNuevaCompra = chckbxRealizarCompras.isSelected();
				Variable.consultarCompra = chckbxConsultarComprasRealizadas.isSelected();
				Variable.registrarNuevoArticulo = chckbxCrearNuevoArticulos.isSelected();
				Variable.consultarArticulos = chckbxCrearNuevoArticulos.isSelected();
				Variable.registrarNuevoCliente = chckbxCrearNuevoCliente.isSelected();
				Variable.consultarClientes = chckbxConsultarClientes.isSelected();
				Variable.registrarNuevoProveedor = chckbxCrearNuevoProveedor.isSelected();
				Variable.consultarProveedores = chckbxConsultarProveedores.isSelected();
				Variable.tablasAuxiliares = chckbxTablasAuxiliares.isSelected();
				Variable.reporteDeVentas = chckbxReportesVenta.isSelected();
				Variable.reporteDecompras = chckbxReportesDeCompras.isSelected();
				Variable.reporteDeArticulos = chckbxReportesDeArticulos.isSelected();
				Variable.reporteDeClientes = chckbxReportesDeCliente.isSelected();
				Variable.reportedeProveedores = chckbxReportesDeProveedores.isSelected();
				Variable.cajaDiaria = chckbxCajaDiaria.isSelected();
				Variable.informeDeVentaDiaria = chckbxInformeDeVentas.isSelected();
				Variable.busquedaFacturasdemitidas = chckbxBusquedaFacturasEmitidas.isSelected();
				Variable.listadoDeArticulos = chckbxListadoDeArticulos.isSelected();
				Variable.manualDeUsuario = chckbxManualDeUsuario.isSelected();
				Variable.acercaDeLaAplicacion = chckbxAcercaDeLa.isSelected();
				RegistroDeUsuarios actualizarRegistro = new RegistroDeUsuarios(nombreUsuario, contrasena, ObjetoTipoUsuario, nombres, apellidos, fechaNacimiento, telefono, email,Variable.configuracion,
						Variable.backup_Restauracion,Variable.nuevoUsuario,Variable.cambiarDeUsuario,Variable.salirDelSistema,Variable.realizarNuevaVenta,Variable.consultarVentas,Variable.realizarNuevaCompra,Variable.consultarCompra, Variable.registrarNuevoArticulo,
						Variable.consultarArticulos,Variable.registrarNuevoCliente,Variable.consultarClientes,Variable.registrarNuevoProveedor,Variable.consultarProveedores, Variable.tablasAuxiliares,
						Variable.reporteDeVentas,Variable.reporteDecompras,Variable.reporteDeArticulos,Variable.reporteDeClientes,Variable.reportedeProveedores,Variable.cajaDiaria,Variable.informeDeVentaDiaria,
						Variable.busquedaFacturasdemitidas,Variable.listadoDeArticulos,Variable.manualDeUsuario,Variable.acercaDeLaAplicacion );
				try 
				{
					actualizarRegistro.actualizarUsuario();
					JOptionPane.showMessageDialog(null, "Usuario Actualizado Correctamente");
					limpiarCampos();
					mtdDesactivarControles();

				} 
				catch (ClassNotFoundException | SQLException e)
				{
					JOptionPane.showMessageDialog(null, e.toString());
				} 
			}
		});
	}

// SE CARGAN LOS DATOS EN LOS CAMPOS CUANDO SE HACE DOBLE CLIC EN LA COLUNA SELECCIONADA
		private void editarUsuarios(final JTable table) {
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2)
					{
						
						int filaModificar = table.getSelectedRow();
						mtdDesactivarControles();
						btnEditar.setEnabled(true);
						String nombreDeUsuario = (String) table.getValueAt(filaModificar, 0);
					    buscarUsuarioEditar(nombreDeUsuario); // SE LLAMA LA FUNCION QUE CARGA LOS DATOS EN LOS CAMPOS
					}
				}
			});
		}
		
//METODO PARA BUSCAR EL USUARIO A EDITAR Y CARGA LOS DATOS DE LA BUSQUEDA EN LOS CAMPOS CORRESPONDIENTES
		private void buscarUsuarioEditar(String nombreDeUsuario) {
			try{
		         
	            String consulta = "SELECT * FROM tblusuario WHERE nombreUsuario = '"+nombreDeUsuario+"'";
	            ResultSet rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
	            while(rs.next())
	            {
	            	nombreUsuario = rs.getString(1);
	            	contrasena = rs.getString(2);
	            	cmTipoUsuario = rs.getInt(3);
	            	nombres = rs.getString(4);
	            	apellidos = rs.getString(5);
	            	Variable.configuracion = rs.getBoolean(6);
					Variable.backup_Restauracion = rs.getBoolean(7);
					Variable.nuevoUsuario = rs.getBoolean(8);
					Variable.cambiarDeUsuario = rs.getBoolean(9);
					Variable.salirDelSistema = rs.getBoolean(10);
					Variable.realizarNuevaVenta = rs.getBoolean(11);
					Variable.consultarVentas = rs.getBoolean(12);
					Variable.realizarNuevaCompra = rs.getBoolean(13);
					Variable.consultarCompra = rs.getBoolean(14);
					Variable.registrarNuevoArticulo = rs.getBoolean(15);;
					Variable.consultarArticulos = rs.getBoolean(16);
					Variable.registrarNuevoCliente = rs.getBoolean(17);
					Variable.consultarClientes = rs.getBoolean(18);
					Variable.registrarNuevoProveedor = rs.getBoolean(19);
					Variable.consultarProveedores = rs.getBoolean(20);
					Variable.tablasAuxiliares = rs.getBoolean(21);
					Variable.reporteDeVentas = rs.getBoolean(22);
					Variable.reporteDecompras = rs.getBoolean(23);
					Variable.reporteDeArticulos = rs.getBoolean(24);
					Variable.reporteDeClientes = rs.getBoolean(25);
					Variable.reportedeProveedores = rs.getBoolean(26);
					Variable.cajaDiaria = rs.getBoolean(27);
					Variable.informeDeVentaDiaria = rs.getBoolean(28);
					Variable.busquedaFacturasdemitidas = rs.getBoolean(29);
					Variable.listadoDeArticulos = rs.getBoolean(30);
					Variable.manualDeUsuario =rs.getBoolean(31);
					Variable.acercaDeLaAplicacion = rs.getBoolean(32);
	  
	            }
	            // AQUE SE BUSCA TIPO DE USUARIO  PARA CALGARLA EN EL COMBOBOX 
	            String tipousuario="";
	            String consulta1 ="SELECT * FROM tblTipoUsuario WHERE idTipoUsuario='"+cmTipoUsuario+"'";
	            ResultSet rs1 = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta1);
	            while(rs1.next())
	            {
	                tipousuario = rs1.getString(2); 
	            }
	           
	            txtNombreDeUsuario.setText(nombreUsuario);
	            txtContrasena.setText(contrasena);
	            cmbTipoUsuario.setSelectedItem(tipousuario);
	            txtNombres.setText(nombres);
	            txtApellido.setText(apellidos);
	            chckbxConfiguracion.setSelected(Variable.configuracion);
            	chckbxBackuprestore.setSelected(Variable.backup_Restauracion);
            	chckbxRegistrarNuevoUsuario.setSelected(Variable.nuevoUsuario);
            	chckbxCambiarDeUsuario.setSelected(Variable.cambiarDeUsuario);
            	chckbxSalirDelSistema.setSelected(Variable.salirDelSistema);
            	chckbxRealizarUnaVenta.setSelected(Variable.realizarNuevaVenta);
            	chckbxConsultarComprasRealizadas.setSelected(Variable.consultarVentas);
            	chckbxRealizarCompras.setSelected(Variable.realizarNuevaCompra);
            	chckbxConsultarVentasRealizadas.setSelected(Variable.consultarCompra);
            	chckbxConsultarArticulos.setSelected(Variable.consultarArticulos);
            	chckbxCrearNuevoArticulos.setSelected(Variable.registrarNuevoArticulo);
            	chckbxCrearNuevoCliente.setSelected(Variable.registrarNuevoCliente);
            	chckbxConsultarClientes.setSelected(Variable.consultarClientes);
            	chckbxCrearNuevoProveedor.setSelected(Variable.registrarNuevoProveedor);
            	chckbxConsultarProveedores.setSelected(Variable.consultarProveedores);
            	chckbxTablasAuxiliares.setSelected(Variable.tablasAuxiliares);
            	chckbxReportesVenta.setSelected(Variable.reporteDeVentas);
            	chckbxReportesDeCompras.setSelected(Variable.reporteDecompras);
            	chckbxReportesDeArticulos.setSelected(Variable.reporteDeArticulos);
            	chckbxReportesDeCliente.setSelected(Variable.reporteDeClientes);
            	chckbxReportesDeProveedores.setSelected(Variable.reportedeProveedores);
            	chckbxCajaDiaria.setSelected(Variable.cajaDiaria);
            	chckbxInformeDeVentas.setSelected(Variable.informeDeVentaDiaria);
            	chckbxBusquedaFacturasEmitidas.setSelected(Variable.busquedaFacturasdemitidas);
            	chckbxListadoDeArticulos.setSelected(Variable.listadoDeArticulos);
            	chckbxManualDeUsuario.setSelected(Variable.manualDeUsuario);
            	chckbxAcercaDeLa.setSelected(Variable.acercaDeLaAplicacion);
	    
	            }catch(Exception e)
	            {
	            	e.printStackTrace();
	            }
			
		}

	/**
	 * ESTE METO HABILITA LOS CAMPOS PARA SER EDITADOS 
	 */
	private void mtdEditarUsuario(final JButton btnEditar) {
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtdActivarControlesNuevoUsuario();
				btnNuevoUsuario.setEnabled(false);
				btnGuardar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnAgregarUsuario.setEnabled(false);
			}
		});
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////validar solo letras 
	private void validarSoloLetras(final JTextField textfield) {
		textfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {                                            
				ValidarTextField validar = new ValidarTextField(); 							// VALIDA QUE SOLO SE AMITAN LETRAS
				validar.AdmitirSoloLetras(textfield);								// PASANDOLE COMO PARAMETRO AL OBJETO DE LA CLASE EL TEXTFIELD
			}
		});
	}

	private void salirDelInternalFrame(JButton btnSaliresc) {
		btnSaliresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////// Agregar Nuevo Usuario 
	private void agregarNuevoUsuario(JButton btnAgregar) {
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				mtdValidarCamposVacios();
				String nombreUsuarioObtendio = "";
				ResultSet rs;
				String consulta = "SELECT nombreUsuario FROM tblusuario";   // VERIFICO QUE EL COIDOGO NO ESTE REPETIDO, LO BUSCO EN LA BASE DE DATOS Y LO COMPARO 
				try
				{
					rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
					while(rs.next())
					{
						nombreUsuarioObtendio = rs.getString(1);
					}
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
				nombres = txtNombres.getText();
				apellidos = txtApellido.getText();
				fechaNacimiento = txtFechaNacimiento.getText();
				telefono = txtNumeroTelefono.getText();
				email = txtCorreo.getText();
				nombreUsuario = txtNombreDeUsuario.getText();
				contrasena = new String(txtContrasena.getPassword()); // combirtiendo la contrasena a string 
				ClassTipoUsuario ObjetoTipoUsuario = FrmAdminUsuarios.this.comboBox.vectorTipoUsuario.get(cmbTipoUsuario.getSelectedIndex()); 
				Variable.configuracion = chckbxConfiguracion.isSelected();
				Variable.backup_Restauracion = chckbxBackuprestore.isSelected();
				Variable.nuevoUsuario = chckbxRegistrarNuevoUsuario.isSelected();
				Variable.cambiarDeUsuario = chckbxCambiarDeUsuario.isSelected();
				Variable.salirDelSistema = chckbxSalirDelSistema.isSelected();
				Variable.realizarNuevaVenta = chckbxRealizarUnaVenta.isSelected();
				Variable.consultarVentas = chckbxConsultarVentasRealizadas.isSelected();
				Variable.realizarNuevaCompra = chckbxRealizarCompras.isSelected();
				Variable.consultarCompra = chckbxConsultarComprasRealizadas.isSelected();
				Variable.registrarNuevoArticulo = chckbxCrearNuevoArticulos.isSelected();
				Variable.consultarArticulos = chckbxCrearNuevoArticulos.isSelected();
				Variable.registrarNuevoCliente = chckbxCrearNuevoCliente.isSelected();
				Variable.consultarClientes = chckbxConsultarClientes.isSelected();
				Variable.registrarNuevoProveedor = chckbxCrearNuevoProveedor.isSelected();
				Variable.consultarProveedores = chckbxConsultarProveedores.isSelected();
				Variable.tablasAuxiliares = chckbxTablasAuxiliares.isSelected();
				Variable.reporteDeVentas = chckbxReportesVenta.isSelected();
				Variable.reporteDecompras = chckbxReportesDeCompras.isSelected();
				Variable.reporteDeArticulos = chckbxReportesDeArticulos.isSelected();
				Variable.reporteDeClientes = chckbxReportesDeCliente.isSelected();
				Variable.reportedeProveedores = chckbxReportesDeProveedores.isSelected();
				Variable.cajaDiaria = chckbxCajaDiaria.isSelected();
				Variable.informeDeVentaDiaria = chckbxInformeDeVentas.isSelected();
				Variable.busquedaFacturasdemitidas = chckbxBusquedaFacturasEmitidas.isSelected();
				Variable.listadoDeArticulos = chckbxListadoDeArticulos.isSelected();
				Variable.manualDeUsuario = chckbxManualDeUsuario.isSelected();
				Variable.acercaDeLaAplicacion = chckbxAcercaDeLa.isSelected();
				RegistroDeUsuarios insertarRegistro = new RegistroDeUsuarios(nombreUsuario, contrasena, ObjetoTipoUsuario, nombres, apellidos, fechaNacimiento, telefono, email,Variable.configuracion,
						Variable.backup_Restauracion,Variable.nuevoUsuario,Variable.cambiarDeUsuario,Variable.salirDelSistema,Variable.realizarNuevaVenta,Variable.consultarVentas,Variable.realizarNuevaCompra,Variable.consultarCompra, Variable.registrarNuevoArticulo,
						Variable.consultarArticulos,Variable.registrarNuevoCliente,Variable.consultarClientes,Variable.registrarNuevoProveedor,Variable.consultarProveedores, Variable.tablasAuxiliares,
						Variable.reporteDeVentas,Variable.reporteDecompras,Variable.reporteDeArticulos,Variable.reporteDeClientes,Variable.reportedeProveedores,Variable.cajaDiaria,Variable.informeDeVentaDiaria,
						Variable.busquedaFacturasdemitidas,Variable.listadoDeArticulos,Variable.manualDeUsuario,Variable.acercaDeLaAplicacion );
				if(nombreUsuarioObtendio == txtNombreDeUsuario.getText())
				{
					JOptionPane.showMessageDialog(null, "Existe un Usuario con Este Nombre de Usuario, Intento Con Otro");
					txtNombreDeUsuario.requestFocus();
					return;
				}
				else
				{
					try 
					{
						insertarRegistro.insertarNuevoUsuario();
						JOptionPane.showMessageDialog(null, "Usuario Agregado Correctamente");
						limpiarCampos();
						mtdDesactivarControles();

					} 
					catch (ClassNotFoundException | SQLException e)
					{
						JOptionPane.showMessageDialog(null, e.toString());
					}
				}
				 
				
			}
		});
	}
// METODO PARA VALIDAR LOS CAMPOS VACIOS	
	public void mtdValidarCamposVacios()
	{
		if(txtNombres.getText().trim().length()<=0)
		{
			JOptionPane.showMessageDialog(null, "No Puede Dejar el Nombre en Blanco");
			txtNombres.requestFocus();
			return;
		}
		if(txtApellido.getText().trim().length()<=0)
		{
			JOptionPane.showMessageDialog(null, "No Puede Dejar el Nombre en Blanco");
			txtApellido.requestFocus();
			return;
		}
		if( txtNumeroTelefono.getText().trim().length()<=0)
		{
			JOptionPane.showMessageDialog(null, "No Puede Dejar el Telefono en Blanco");
			txtNumeroTelefono.requestFocus();
			return;
		}
		if(txtNombreDeUsuario.getText().trim().length()<=0)
		{
			JOptionPane.showMessageDialog(null, "No Puede Dejar el Nombre de Usuario en Blanco");
			txtNombreDeUsuario.requestFocus();
			return;
		}
		if(txtContrasena.getText().trim().length()<=0)
		{
			JOptionPane.showMessageDialog(null, "No Puede Dejar la Contrena en Blanco");
			txtContrasena.requestFocus();
			return;
		}
		
		
	}
//Buscar por nombre de usuario
/////////////////////////////////////////////////////////////////////////////////////////////////////////////// buscar por nombre de usuario
	private void busquedaPorTipoUsuario() {
		try{
			String condicion = "1";
			condicion = "nombreUsuario like '%" + txtNombreABuscar.getText() + "%'";
			modeloTabla.establecerCondicion( condicion );
			modeloTabla.realizarBusqueda();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
// LIMPIAR CAMPOS 	
	private void limpiarCampos(){
		txtNombres.setText("");
		txtApellido.setText("");
		txtFechaNacimiento.setText("");
		txtNumeroTelefono.setText("");
		txtCorreo.setText("");
		txtNombreDeUsuario.setText("");
		txtContrasena.setText("");
		chckbxConfiguracion.setSelected(false);
		chckbxBackuprestore.setSelected(false);
		chckbxRegistrarNuevoUsuario.setSelected(false);
		chckbxCambiarDeUsuario.setSelected(false);
		chckbxSalirDelSistema.setSelected(false);
		chckbxRealizarUnaVenta.setSelected(false);
		chckbxConsultarComprasRealizadas.setSelected(false);
		chckbxRealizarCompras.setSelected(false);
		chckbxConsultarVentasRealizadas.setSelected(false);
		chckbxConsultarArticulos.setSelected(false);
		chckbxCrearNuevoArticulos.setSelected(false);
		chckbxCrearNuevoCliente.setSelected(false);
		chckbxConsultarClientes.setSelected(false);
		chckbxCrearNuevoProveedor.setSelected(false);
		chckbxConsultarProveedores.setSelected(false);
		chckbxTablasAuxiliares.setSelected(false);
	    chckbxReportesVenta.setSelected(false);
		chckbxReportesDeCompras.setSelected(false);
		chckbxReportesDeArticulos.setSelected(false);
		chckbxReportesDeCliente.setSelected(false);
		chckbxReportesDeProveedores.setSelected(false);
		chckbxCajaDiaria.setSelected(false);
		chckbxInformeDeVentas.setSelected(false);
		chckbxBusquedaFacturasEmitidas.setSelected(false);
		chckbxListadoDeArticulos.setSelected(false);
		chckbxManualDeUsuario.setSelected(false);
		chckbxAcercaDeLa.setSelected(false);
		cmbTipoUsuario.setSelectedIndex(0);
		tabbedPane.setSelectedIndex(0);	 // manda al curso al panel de registro de usuario
	}
// DESACTIVAR CONTROLES  AL INICIAR EL FORMULARIO	
	public void mtdDesactivarControles()
	{
		tabbedPane.setSelectedIndex(0);	 // manda al curso al panel de registro de usuario
		txtNombres.setEnabled(false);
		txtApellido.setEnabled(false);
		txtFechaNacimiento.setEnabled(false);
		txtNumeroTelefono.setEnabled(false);
		txtCorreo.setEnabled(false);
		txtNombreDeUsuario.setEnabled(false);
		txtContrasena.setEnabled(false);
		cmbTipoUsuario.setEnabled(false);
		chckbxConfiguracion.setEnabled(false);
		chckbxBackuprestore.setEnabled(false);
		chckbxRegistrarNuevoUsuario.setEnabled(false);
		chckbxCambiarDeUsuario.setEnabled(false);
		chckbxSalirDelSistema.setEnabled(false);
		chckbxRealizarUnaVenta.setEnabled(false);
		chckbxConsultarComprasRealizadas.setEnabled(false);
		chckbxRealizarCompras.setEnabled(false);
		chckbxConsultarVentasRealizadas.setEnabled(false);
		chckbxConsultarArticulos.setEnabled(false);
		chckbxCrearNuevoArticulos.setEnabled(false);
		chckbxCrearNuevoCliente.setEnabled(false);
		chckbxConsultarClientes.setEnabled(false);
		chckbxCrearNuevoProveedor.setEnabled(false);
		chckbxConsultarProveedores.setEnabled(false);
		chckbxTablasAuxiliares.setEnabled(false);
	    chckbxReportesVenta.setEnabled(false);
		chckbxReportesDeCompras.setEnabled(false);
		chckbxReportesDeArticulos.setEnabled(false);
		chckbxReportesDeCliente.setEnabled(false);
		chckbxReportesDeProveedores.setEnabled(false);
		chckbxCajaDiaria.setEnabled(false);
		chckbxInformeDeVentas.setEnabled(false);
		chckbxBusquedaFacturasEmitidas.setEnabled(false);
		chckbxListadoDeArticulos.setEnabled(false);
		chckbxManualDeUsuario.setEnabled(false);
		chckbxAcercaDeLa.setEnabled(false);
		btnNuevoUsuario.setEnabled(true);
		btnAgregarUsuario.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);
	}
// ACTIVAR CONTROLES  PARA REGISTRAR UN NUEVO USUARIO
	public void mtdActivarControlesNuevoUsuario()
	{
		tabbedPane.setSelectedIndex(0);	 // manda al curso al panel de registro de usuario
		txtNombres.setEnabled(true);
		txtApellido.setEnabled(true);
		txtFechaNacimiento.setEnabled(true);
		txtNumeroTelefono.setEnabled(true);
		txtCorreo.setEnabled(true);
		txtNombreDeUsuario.setEnabled(true);
		txtContrasena.setEnabled(true);
		cmbTipoUsuario.setEnabled(true);
		chckbxConfiguracion.setEnabled(true);
		chckbxBackuprestore.setEnabled(true);
		chckbxRegistrarNuevoUsuario.setEnabled(true);
		chckbxCambiarDeUsuario.setEnabled(true);
		chckbxSalirDelSistema.setEnabled(true);
		chckbxRealizarUnaVenta.setEnabled(true);
		chckbxConsultarComprasRealizadas.setEnabled(true);
		chckbxRealizarCompras.setEnabled(true);
		chckbxConsultarVentasRealizadas.setEnabled(true);
		chckbxConsultarArticulos.setEnabled(true);
		chckbxCrearNuevoArticulos.setEnabled(true);
		chckbxCrearNuevoCliente.setEnabled(true);
		chckbxConsultarClientes.setEnabled(true);
		chckbxCrearNuevoProveedor.setEnabled(true);
		chckbxConsultarProveedores.setEnabled(true);
		chckbxTablasAuxiliares.setEnabled(true);
	    chckbxReportesVenta.setEnabled(true);
		chckbxReportesDeCompras.setEnabled(true);
		chckbxReportesDeArticulos.setEnabled(true);
		chckbxReportesDeCliente.setEnabled(true);
		chckbxReportesDeProveedores.setEnabled(true);
		chckbxCajaDiaria.setEnabled(true);
		chckbxInformeDeVentas.setEnabled(true);
		chckbxBusquedaFacturasEmitidas.setEnabled(true);
		chckbxListadoDeArticulos.setEnabled(true);
		chckbxManualDeUsuario.setEnabled(true);
		chckbxAcercaDeLa.setEnabled(true);
		btnNuevoUsuario.setEnabled(false);
		btnAgregarUsuario.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);	
	}
}
