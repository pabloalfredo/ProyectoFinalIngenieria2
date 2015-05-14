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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;

import Clases.CargarComboBox;
import Clases.ClassBaseDeDatos;
import Clases.ClassCiudades;
import Clases.ClassRegistrarProveedor;
import Clases.ModeloTabla;
import Clases.ValidarTextField;

import com.mysql.jdbc.ResultSet;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FrmRegistroDeClientes extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtBuscarPorCodigo;
	private static JFileChooser examinar = new JFileChooser();
	private JTextField txtBuscarPorNombre;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtCodigoProveedor;
	private JTextField txtEmail;
	private JTextField txtOcupacion;
	private int codigoProveedor, cmSexo,cmEstadoCivil,cmCiudad;
	private String direccion,apellidos,nombres,email,ocupacion,fechaNacimiento,celular,estadoCivil,sexo,cedula;
	private JComboBox<Object> cmbEstadoCivil, cmbSexo,cmbCiudad;
	private MaskFormatter maskcedula,maskfechaNacimiento,maskcelular;
	private JFormattedTextField txtCedula,txtFechaNacimiento,txtTelefono;
	private JButton btnNuevoProveedor,btnAgregarProveedor,btnGuardar,btnCancelar,btnEditar,btnSalir,btnAgregarCiudad,btnGenerarCodigoProveedor;
	ClassRegistrarProveedor registrarProveedores,actualizarProveedor;
	ClassCiudades objetoTipoCiudad ;
	CargarComboBox comboBox = new CargarComboBox();
	private ModeloTabla modeloTabla;
	private JTabbedPane tabbedPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroDeClientes frame = new FrmRegistroDeClientes();
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
	FrmRegistroDeClientes()
	{
		INITIALIZE();
		mtdDesactivarControlesFormulario();
	}
	public void INITIALIZE() {
		examinar.setMultiSelectionEnabled(false);
		examinar.setCurrentDirectory(new File("c://Documents and Settings"));
		setTitle("Administracion de  Clientes");
		setClosable(true);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 791, 476);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 139, 139));
		tabbedPane.setBounds(0, 111, 787, 286);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("SansSerif", Font.BOLD, 12));
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Clientes", new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/cliente.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(34, 139, 34));
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		panel.setLayout(null);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(new Color(0, 0, 128));
		txtDireccion.setFont(new Font("Verdana", Font.BOLD, 12));
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtDireccion.setBackground(new Color(230, 230, 250));
		txtDireccion.setBounds(96, 209, 302, 28);
		panel.add(txtDireccion);
		
		JLabel label_5 = new JLabel("Direccion: ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_5.setBounds(20, 214, 77, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Ciudad");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_6.setBounds(14, 181, 77, 16);
		panel.add(label_6);
		
		cmbCiudad = new JComboBox<Object>();
		comboBox.cargarComboBoxCiudades(cmbCiudad);
		cmbCiudad.setForeground(new Color(0, 0, 128));
		cmbCiudad.setFont(new Font("Verdana", Font.BOLD, 12));
		cmbCiudad.setBorder(null);
		cmbCiudad.setBackground(new Color(0, 128, 128));
		cmbCiudad.setBounds(96, 177, 275, 26);
		panel.add(cmbCiudad);
		
		btnAgregarCiudad = new JButton("");
		btnAgregarCiudad.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/B7D02FDEF.png")));
		btnAgregarCiudad.setBounds(372, 177, 28, 28);
		panel.add(btnAgregarCiudad);
		
//VALIDACION DE LA CEDULA CON MASCARA
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO
		maskcedula = null;
		try {
		maskcedula = new MaskFormatter("###-#######-#");           //validando la cedula usando maskormatter 
		maskcedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();                                                
		}
		txtCedula = new JFormattedTextField(maskcedula);
		txtCedula.setForeground(new Color(0, 0, 128));
		txtCedula.setFont(new Font("Verdana", Font.BOLD, 12));
		txtCedula.setColumns(10);
		txtCedula.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCedula.setBackground(new Color(230, 230, 250));
		txtCedula.setBounds(278, 144, 122, 28);
		panel.add(txtCedula);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FIN
		
		JLabel label_7 = new JLabel("Cedula");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_7.setBounds(217, 149, 56, 16);
		panel.add(label_7);
		
		cmbEstadoCivil = new JComboBox<Object>();
		cmbEstadoCivil.setModel(new DefaultComboBoxModel<Object>(new String[] {"Soltero", "Casado", "Divorciado", "Viudo"}));
		cmbEstadoCivil.setForeground(new Color(0, 0, 128));
		cmbEstadoCivil.setFont(new Font("Verdana", Font.BOLD, 12));
		cmbEstadoCivil.setBorder(null);
		cmbEstadoCivil.setBackground(new Color(0, 128, 128));
		cmbEstadoCivil.setBounds(96, 145, 122, 26);
		panel.add(cmbEstadoCivil);
		
		JLabel label_8 = new JLabel("Estado Civil");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_8.setBounds(4, 149, 89, 16);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("  Fecha Nac");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(new Color(0, 0, 128));
		label_9.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_9.setBounds(4, 114, 89, 16);
		panel.add(label_9);
		
// VALIDANDO FECHA DE NACIMIENTO CON MASCARA
////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO
		maskfechaNacimiento = null;
		try {
		maskfechaNacimiento = new MaskFormatter("##/##/####");  // VALIDANDO LA FECHA DE NACIMEINTO USANDO MASCARA
		maskfechaNacimiento.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtFechaNacimiento = new JFormattedTextField(maskfechaNacimiento);
		txtFechaNacimiento.setForeground(new Color(0, 0, 128));
		txtFechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 12));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtFechaNacimiento.setBackground(new Color(230, 230, 250));
		txtFechaNacimiento.setBounds(96, 109, 122, 28);
		panel.add(txtFechaNacimiento);
///////////////////////////////////////////////////////////////////////////////////////////////////////////// FIN
		
		JLabel label_10 = new JLabel("Sexo");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(new Color(0, 0, 128));
		label_10.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_10.setBounds(217, 114, 42, 16);
		panel.add(label_10);
		
		cmbSexo = new JComboBox<Object>();
		cmbSexo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Masculino", "Femenino"}));
		cmbSexo.setForeground(new Color(0, 0, 128));
		cmbSexo.setFont(new Font("Verdana", Font.BOLD, 12));
		cmbSexo.setBorder(null);
		cmbSexo.setBackground(new Color(0, 128, 128));
		cmbSexo.setBounds(268, 111, 130, 26);
		panel.add(cmbSexo);
		
		txtApellido = new JTextField();
		mtdValidarSoloLetras(txtApellido); //METDO VALIDAR SOLO LETRAS EN EL TEXFIELD
		txtApellido.setForeground(new Color(0, 0, 128));
		txtApellido.setFont(new Font("Verdana", Font.BOLD, 12));
		txtApellido.setColumns(10);
		txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtApellido.setBackground(new Color(230, 230, 250));
		txtApellido.setBounds(96, 74, 302, 28);
		panel.add(txtApellido);
		
		JLabel label_11 = new JLabel("Apellidos");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setForeground(new Color(0, 0, 128));
		label_11.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_11.setBounds(4, 79, 89, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Nombres");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setForeground(new Color(0, 0, 128));
		label_12.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_12.setBounds(4, 46, 89, 16);
		panel.add(label_12);
		
		txtNombre = new JTextField();
		mtdValidarSoloLetras(txtNombre);// METODO VALIDAR SOLO LETRAS EN EL TEXFIELD
		txtNombre.setForeground(new Color(0, 0, 128));
		txtNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombre.setBackground(new Color(230, 230, 250));
		txtNombre.setBounds(96, 41, 302, 28);
		panel.add(txtNombre);
		
		txtCodigoProveedor = new JTextField();
		mtdValidarSoloNumeros(txtCodigoProveedor);// ADMITIR SOLO NUMEROS EN EL TEXFIELD
		txtCodigoProveedor.setForeground(new Color(0, 0, 128));
		txtCodigoProveedor.setFont(new Font("Verdana", Font.BOLD, 12));
		txtCodigoProveedor.setColumns(10);
		txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCodigoProveedor.setBackground(new Color(230, 230, 250));
		txtCodigoProveedor.setBounds(96, 9, 122, 28);
		panel.add(txtCodigoProveedor);
		
		JLabel label_13 = new JLabel("Codigo");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(new Color(0, 0, 128));
		label_13.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_13.setBounds(4, 18, 89, 16);
		panel.add(label_13);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 128));
		txtEmail.setFont(new Font("Verdana", Font.BOLD, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtEmail.setBackground(new Color(230, 230, 250));
		txtEmail.setBounds(484, 9, 228, 28);
		panel.add(txtEmail);
		
		JLabel label = new JLabel("E-Mail");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setBounds(395, 14, 88, 16);
		panel.add(label);
		
		JLabel label_2 = new JLabel("Celular");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_2.setBounds(395, 46, 88, 16);
		panel.add(label_2);
		
// VALIDANDO NUMERO TELEFONICO USANDO MASCARA DE TEXTO
/////////////////////////////////////////////////////////////////////////////////////////////////// INICO
		maskcelular = null;
		try{
		maskcelular = new MaskFormatter("(###)-###-####");  // validando el numero telefonico usando mascara de texto
		maskcelular.setPlaceholderCharacter('_');
		}
		catch(ParseException e){
		e.printStackTrace();
		}
		txtTelefono = new JFormattedTextField(maskcelular);
		txtTelefono.setForeground(new Color(0, 0, 128));
		txtTelefono.setFont(new Font("Verdana", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtTelefono.setBackground(new Color(230, 230, 250));
		txtTelefono.setBounds(484, 41, 228, 28);
		panel.add(txtTelefono);
//////////////////////////////////////////////////////////////////////////////////////////////////////////FIN	
		
		txtOcupacion = new JTextField();
		mtdValidarSoloLetras(txtOcupacion);//METDO VALIDAR SOLO LETRAS  EN EL TEXFIELD
		txtOcupacion.setForeground(new Color(0, 0, 128));
		txtOcupacion.setFont(new Font("Verdana", Font.BOLD, 12));
		txtOcupacion.setColumns(10);
		txtOcupacion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtOcupacion.setBackground(new Color(230, 230, 250));
		txtOcupacion.setBounds(484, 74, 228, 28);
		panel.add(txtOcupacion);
		
		JLabel label_4 = new JLabel("Ocupacion");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_4.setBounds(394, 81, 89, 16);
		panel.add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/imagen.png")));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_3.setBounds(485, 114, 98, 103);
		panel.add(label_3);
		
		JLabel label_14 = new JLabel("Imagen");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(new Color(0, 0, 128));
		label_14.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_14.setBounds(428, 195, 57, 16);
		panel.add(label_14);
		
		JButton button_1 = new JButton("....");
		button_1.setVerticalTextPosition(SwingConstants.TOP);
		button_1.setVerticalAlignment(SwingConstants.BOTTOM);
		button_1.setFont(new Font("SansSerif", Font.BOLD, 27));
		button_1.setBounds(585, 191, 30, 26);
		panel.add(button_1);
		
		btnGenerarCodigoProveedor = new JButton("Generar");
		mtdGenerarCodigoProveedor(btnGenerarCodigoProveedor); // METODO GENERAR CODIGO ALEATORIO PARA PROVEEDOR
		btnGenerarCodigoProveedor.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/902BCB3FC.png")));
		btnGenerarCodigoProveedor.setForeground(new Color(0, 0, 128));
		btnGenerarCodigoProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGenerarCodigoProveedor.setEnabled(false);
		btnGenerarCodigoProveedor.setBounds(219, 6, 113, 34);
		panel.add(btnGenerarCodigoProveedor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Busqueda de Clientes", new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/6B6F6D5EB.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 775, 175);
		panel_1.add(scrollPane);
		
		try {
			modeloTabla = new ModeloTabla("codigoProveedor as 'Codigo del Proveedor' , nombres as Nombres , apellidos as Apellidos , fechaNacimiento as 'Fecha de Nacimiento',sexo as Sexo, estadoCivil as 'Estado Civil', cedula as Cedula, idCiudad as Ciudad, direccion as Direccion, email as 'Correo Electronico', celular as Celular, ocupacion as Ocupacion  ", "tblproveedor", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		table = new JTable(modeloTabla);
		editarProveedores(table);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNombreDeUsuario = new JLabel("Codigo");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDeUsuario.setForeground(new Color(0, 0, 128));
		lblNombreDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombreDeUsuario.setBounds(0, 6, 152, 19);
		panel_1.add(lblNombreDeUsuario);
		
		txtBuscarPorCodigo = new JTextField();
		mtdParaBuscarPorCodigo();
		mtdValidarSoloNumeros(txtBuscarPorCodigo); // LLAMADA AL METODO VALIDAR SOLO NUMERO EN EL TEXFIELD
		txtBuscarPorCodigo.setForeground(new Color(0, 0, 128));
		txtBuscarPorCodigo.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorCodigo.setColumns(10);
		txtBuscarPorCodigo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorCodigo.setBackground(new Color(230, 230, 250));
		txtBuscarPorCodigo.setBounds(157, 3, 132, 26);
		panel_1.add(txtBuscarPorCodigo);
		
		JLabel lblTipoDeUsuario = new JLabel("Nombre");
		lblTipoDeUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeUsuario.setForeground(new Color(0, 0, 128));
		lblTipoDeUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTipoDeUsuario.setBounds(29, 37, 123, 19);
		panel_1.add(lblTipoDeUsuario);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscar.setForeground(new Color(0, 0, 128));
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(338, 31, 120, 33);
		panel_1.add(btnBuscar);
		
		txtBuscarPorNombre = new JTextField();
		mtdBuscarPorNombre();// LLAMADA AL METODO PARA BUSCAR PROVEEDOR POR NOMBRE 
		mtdValidarSoloLetras(txtBuscarPorNombre);// METEDO VALIDAR SOLO LETRAS EN EL TEFIELD
		txtBuscarPorNombre.setForeground(new Color(0, 0, 128));
		txtBuscarPorNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorNombre.setColumns(10);
		txtBuscarPorNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorNombre.setBackground(new Color(230, 230, 250));
		txtBuscarPorNombre.setBounds(157, 33, 180, 26);
		panel_1.add(txtBuscarPorNombre);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/22.png")));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		label_1.setBounds(6, 0, 100, 105);
		getContentPane().add(label_1);
		
		JLabel lblAdministracionDeUsuarios = new JLabel("Administracion de Clientes");
		lblAdministracionDeUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdministracionDeUsuarios.setForeground(new Color(248, 248, 255));
		lblAdministracionDeUsuarios.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblAdministracionDeUsuarios.setBounds(106, 21, 585, 46);
		getContentPane().add(lblAdministracionDeUsuarios);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 128));
		panel_4.setBounds(0, 0, 787, 113);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 400, 787, 47);
		getContentPane().add(panel_3);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(null);
		
		btnNuevoProveedor = new JButton("Nuevo [N]");
		mtdNuevoProveedor();  // LLAMADA AL METODO NUEVO PROVEEDOR  EL CUAL HABILITA LOS CAMPOS PARA PARA EL REGISTRO DE UN NUEVO PROVEEDOR
		btnNuevoProveedor.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/nuevo.png")));
		btnNuevoProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevoProveedor.setForeground(new Color(0, 0, 128));
		btnNuevoProveedor.setBounds(6, 6, 120, 36);
		panel_3.add(btnNuevoProveedor);
		
		btnAgregarProveedor = new JButton("Agregar");
		mtdAgregarProveedor(btnAgregarProveedor); //LLAMADA AL METODO CUANDO SE PRESIONA EL BOTON AGREGAR  PARA INSERTAR EN LA BASE DE DATOS UN NUEVO PROVEEDOR 
		btnAgregarProveedor.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/157809D10.png")));
		btnAgregarProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAgregarProveedor.setForeground(new Color(0, 0, 128));
		btnAgregarProveedor.setBounds(138, 6, 120, 36);
		panel_3.add(btnAgregarProveedor);
		
		btnCancelar = new JButton("Cancelar");
		mtdCancelarEntradaProveedor(); // CANCELAR LA ENTRADA DE PROVEEDOR
		btnCancelar.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/abort.png")));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setBounds(397, 6, 120, 36);
		panel_3.add(btnCancelar);
		
		btnSalir = new JButton("Salir [Esc]");
		mtdSalirFormularioProveedor();// SALIR DEL LA VENTADA DE PROVEEDORES
		btnSalir.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/salir.png")));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBounds(661, 6, 120, 36);
		panel_3.add(btnSalir);
		
		btnEditar = new JButton("Editar");
		mtdEditarProveedores(btnEditar);// LLAMADA AL METODO EDITAR PROVEEDOR
		btnEditar.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/D1F0AC18D.png")));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setForeground(new Color(0, 0, 128));
		btnEditar.setBounds(529, 6, 120, 36);
		panel_3.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		mtdActualizarProveedor(btnGuardar);
		btnGuardar.setIcon(new ImageIcon(FrmRegistroDeClientes.class.getResource("/Recursos/guardar.png")));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setBounds(270, 6, 120, 36);
		panel_3.add(btnGuardar);

	}// FIN DEL CONSRUCTOR 

	/**
	 * ESTE METOD ACTUALIZA LOS DATOS DEL PROVEEDOR CUANDO SE EDITA EL PROVEEDO
	 * Y SE HACE CLIC EN GUARDAR 
	 */
	private void mtdActualizarProveedor(final JButton btnGuardar) {
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarCamposVacios(); // LLAMADA A LA FUNCION PARA QUE NO SE DEJEN CAMMPOS VACIOS CUANDO SE GUARDE EL ARTICULO
				codigoProveedor =  Integer.parseInt(txtCodigoProveedor.getText());
				nombres = txtNombre.getText();
				apellidos = txtApellido.getText();
				fechaNacimiento = txtFechaNacimiento.getText();
				sexo = (String) cmbSexo.getSelectedItem();
				estadoCivil = (String) cmbEstadoCivil.getSelectedItem();
				cedula = txtCedula.getText();
				//ciudad = (String) cmbCiudad.getSelectedItem();
				direccion = txtDireccion.getText();
				email = txtEmail.getText();
				celular = txtTelefono.getText();
				ocupacion = txtOcupacion.getText();
				objetoTipoCiudad = comboBox.vectorCiudades.get(cmbCiudad.getSelectedIndex());
				actualizarProveedor = new ClassRegistrarProveedor(codigoProveedor,nombres,apellidos,fechaNacimiento,sexo,estadoCivil,cedula,objetoTipoCiudad,direccion,email,celular,ocupacion);
				try
				{
					actualizarProveedor.actualizarProveedor();
					JOptionPane.showMessageDialog(null, " Actualizado Correctamente");
					limpiarCampos();
					mtdDesactivarControlesFormulario();
					
				}
				catch(ClassNotFoundException | SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
// METODO PARA BUSCAR PROVEEDOR POR NOMBRE
	private void mtdBuscarPorNombre() {
		txtBuscarPorNombre.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				busquedaPorNombreProveedor();
			}
		});
	}
// METODO PARA BUSCAR PROVEEDOR POR CODIGO
	private void mtdParaBuscarPorCodigo() {
		txtBuscarPorCodigo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCodigoProducto();
			}
		});
	}
	
//ESTE METODO ACTIVA LOS CONTROLES NECESARIOS PARA LA EDICION DE UN PROVEEDOR
	private void mtdEditarProveedores(final JButton btnEditar) {
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtdActivarControlesParaEdicion();
			}
		});
	}
// VALIDAR CAMPOS SOLO ADMITIR NUMEROS EN EL TEXTFIELD
	private void mtdValidarSoloNumeros(final JTextField campo) {
		campo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validacion = new ValidarTextField();
				validacion.AdmitirSoloNumeros(campo);
			}
		});
	}

// VALIDAR CAMPOS SOLO ADMITIR LETRAS EN EL TEXTFIELD
		private void mtdValidarSoloLetras(final JTextField campo) {
			campo.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent arg0) {
					ValidarTextField validacion = new ValidarTextField();
					validacion.AdmitirSoloLetras(campo);
				}
			});
		}
// ESTE METDO GENERA UN CODIGO ALEATORIO Y SE LO ASIGANA AL TEXFIEL CODIGO PROVEEDOR		
	private void mtdGenerarCodigoProveedor(JButton btnGenerarCodigoProveedor) {
		btnGenerarCodigoProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random num = new Random();
				int codigo = 0;
				int codigoObtenido = 0;
				codigo = num.nextInt(199999999 -100000000 +1) +10000000;  // PARA GENERAR EL CODIGO ALEATORIO ENTRE EL RANGO DE 2 VALORES
				ResultSet rs = null;
				String consulta = "SELECT codigoProveedor FROM tblproveedor";   // VERIFICO QUE EL COIDOGO NO ESTE REPETIDO, LO BUSCO EN LA BASE DE DATOS Y LO COMPARO 
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
					txtCodigoProveedor.setText(Integer.toString(codigo));  // SE LO ASIGNO AL TEXFIEL CODIGO DEL PRODUCTO 
				}
			}
		});
	}
// SE CARGAN LOS DATOS EN LOS CAMPOS CUANDO SE HACE DOBLE CLIC EN LA COLUNA SELECCIONADA
	private void editarProveedores(final JTable table) {
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2)
				{
					
					int filaModificar = table.getSelectedRow();
					mtdEditar();
					int codigo = (int) table.getValueAt(filaModificar, 0);
				    BuscarProductoEditar(codigo); // SE LLAMA LA FUNCION QUE CARGA LOS DATOS EN LOS CAMPOS
				}
			}
		});
	}
	
//METODO PARA BUSCAR EL PRODUCTO A EDITAR Y CARGA LOS DATOS DE LA BUSQUEDA EN LOS CAMPOS CORRESPONDIENTES
	private void BuscarProductoEditar(int codigoproveedor) {
		try{
	         
            String consulta = "SELECT * FROM tblproveedor WHERE codigoProveedor = '"+codigoproveedor+"'";
            ResultSet rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
            while(rs.next())
            {
            	codigoProveedor = rs.getInt(1);
            	nombres = rs.getString(2);
            	apellidos = rs.getString(3);
            	fechaNacimiento = rs.getString(4);
            	sexo = rs.getString(5);
            	estadoCivil = rs.getString(6);
            	cedula = rs.getString(7);
            	cmCiudad = rs.getInt(8);
            	direccion = rs.getString(9);
            	email = rs.getString(10);
            	celular = rs.getString(11);
            	ocupacion = rs.getString(12);
            	
            }
            // AQUE SE BUSCA LA CIUDAD  PARA CALGARLA EN EL COMBOBOX 
            String ciudad="";
            String consulta1 ="SELECT * FROM tblCiudades WHERE idCiudad='"+cmCiudad+"'";
            ResultSet rs1 = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta1);
            while(rs1.next())
            {
                ciudad = rs1.getString(2); 
            }
           
            
            txtCodigoProveedor.setText(Integer.toString(codigoProveedor));
    		txtDireccion.setText(direccion);
    		txtApellido.setText(apellidos);
    		txtNombre.setText(nombres);
    		txtEmail.setText(email);
    		txtOcupacion.setText(ocupacion);
    		cmbEstadoCivil.setSelectedIndex(cmEstadoCivil);
    		cmbSexo.setSelectedIndex(cmSexo);
    		cmbCiudad.setSelectedItem(ciudad);
    		txtCedula.setText(cedula);
    		txtFechaNacimiento.setText(fechaNacimiento);
    		txtTelefono.setText(celular);
    
            }catch(Exception e)
            {
            	e.printStackTrace();
            }
		
	}

	// METODO AGREGAR NUEVO PROVEEDOR 
	private void mtdAgregarProveedor(JButton btnAgregarProveedor) {
		btnAgregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//validarCamposVacios(); // LLAMADA A LA FUNCION VALIDAR CAMPOS VACIOS PARA QUE NO SE DEJEN CAMPOS VACIOS CUANDO SE DE ENTER 
				// VALIDA QUE LOS CAMPOS NO ESTEN VACIOS 
				if(txtCodigoProveedor.getText().trim().length() <=0 )
				{
					JOptionPane.showMessageDialog(null, "El Codigo del Proveedor no Puede Estar en Blanco");
					txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
					txtCodigoProveedor.requestFocus();
					return;
				}
				else
				{
					txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
				}

				if(txtNombre.getText().trim().length() <=0 )
				{
					JOptionPane.showMessageDialog(null, "El Nombre del Proveedor no Puede Estar en Blanco");
					txtNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
					txtNombre.requestFocus();
					return;
				}
				else
				{
					txtNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
				}

				if(txtApellido.getText().trim().length() <=0 )
				{
					JOptionPane.showMessageDialog(null, "El Apellido del Proveedor no Puede Estar en Blanco");
					txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
					txtApellido.requestFocus();
					return;
				}
				else
				{
					txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
				}
				
				int codigoObtenido = 0;
				ResultSet rs;
				String consulta = "SELECT codigoProveedor FROM tblproveedor";   // VERIFICO QUE EL COIDOGO NO ESTE REPETIDO, LO BUSCO EN LA BASE DE DATOS Y LO COMPARO 
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
				
				codigoProveedor =  Integer.parseInt(txtCodigoProveedor.getText());
				nombres = txtNombre.getText();
				apellidos = txtApellido.getText();
				fechaNacimiento = txtFechaNacimiento.getText();
				sexo = (String) cmbSexo.getSelectedItem();
				estadoCivil = (String) cmbEstadoCivil.getSelectedItem();
				cedula = txtCedula.getText();
				//ciudad = (String) cmbCiudad.getSelectedItem();
				direccion = txtDireccion.getText();
				email = txtEmail.getText();
				celular = txtTelefono.getText();
				ocupacion = txtOcupacion.getText();
				objetoTipoCiudad = comboBox.vectorCiudades.get(cmbCiudad.getSelectedIndex());
				registrarProveedores = new ClassRegistrarProveedor(codigoProveedor,nombres,apellidos,fechaNacimiento,sexo,estadoCivil,cedula,objetoTipoCiudad,direccion,email,celular,ocupacion);

				if(codigoObtenido == codigoProveedor)
				{
					JOptionPane.showMessageDialog(null, "Existe un Proveedor con Este Codigo, Intente con Otro o Genere Uno");
					txtCodigoProveedor.requestFocus();
					return;
				}
				else
				{
					try
					{
						registrarProveedores.registrarNuevoProveedor(); 
						JOptionPane.showMessageDialog(null, "Proveedor Registrado Correctamente");
						limpiarCampos();
						mtdDesactivarControlesFormulario(); // HAY PRESIONAR EL BOTON REGISTRAR SE LIMPIAN LOS CAMPOS Y SE DESACTIVAN
					}
					catch(ClassNotFoundException | SQLException e)
					{
						e.printStackTrace();
					}
				}
				
			}
		});
	}
// SALIR DEL FORMULARIO
	private void mtdSalirFormularioProveedor() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
// CACELAR LA ENTRADA DE PROVEDOR
	private void mtdCancelarEntradaProveedor() {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				mtCancelarNuevoProveedor();
			}
		});
	}
// ACTIVAR CONTROLES CUANDO SE PRESIONA EL BOTON NUEVO, LISTO PARA INGRESAR UN NUEVO PROVEEDOR
	private void mtdNuevoProveedor() {
		btnNuevoProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				mtdActivarControlesNuevoProveedor();
				
			}
		});
	}
// LIMPIAR CAMPOS DEL FORMULARIO	
	private void limpiarCampos() {
		txtCodigoProveedor.setText("");
		txtDireccion.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtEmail.setText("");
		txtOcupacion.setText("");
		cmbEstadoCivil.setSelectedIndex(1);
		cmbSexo.setSelectedIndex(1);
		cmbCiudad.setSelectedIndex(1);
		txtCedula.setText("");
		txtFechaNacimiento.setText("");
		txtTelefono.setText("");
		tabbedPane.setSelectedIndex(0);
		
	}
// DESACTIVAR LOS CONTROLES DEL FORMULARIO CUANDO SE INICIA
	public void mtdDesactivarControlesFormulario()
	{
		txtCodigoProveedor.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtApellido.setEnabled(false);
		txtNombre.setEnabled(false);
		txtEmail.setEnabled(false);
		txtOcupacion.setEnabled(false);
		cmbEstadoCivil.setEnabled(false);
		cmbSexo.setEnabled(false);
		cmbCiudad.setEnabled(false);
		txtCedula.setEnabled(false);
		txtFechaNacimiento.setEnabled(false);
		txtTelefono.setEnabled(false);
		btnNuevoProveedor.setEnabled(true);
		btnAgregarProveedor.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);
		btnGenerarCodigoProveedor.setEnabled(false);
		
	}
// ACTIVA LOS CONTROLES PARA EDICION DE  PROVEEDOR
	public void mtdActivarControlesParaEdicion()
	{
		txtCodigoProveedor.setEnabled(false);
		txtDireccion.setEnabled(true);
		txtApellido.setEnabled(true);
		txtNombre.setEnabled(true);
		txtEmail.setEnabled(true);
		txtOcupacion.setEnabled(true);
		cmbEstadoCivil.setEnabled(true);
		cmbSexo.setEnabled(true);
		cmbCiudad.setEnabled(true);
		txtCedula.setEnabled(true);
		txtFechaNacimiento.setEnabled(true);
		txtTelefono.setEnabled(true);
		btnNuevoProveedor.setEnabled(false);
		btnAgregarProveedor.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);
		btnGenerarCodigoProveedor.setEnabled(false);
		tabbedPane.setSelectedIndex(0);
		
	}
// MEDOTO PAR A EDITAR CIANDO DE SEPRECIONE UN UNU PORVEEDOR 	
	public void mtdEditar()
	{
		txtCodigoProveedor.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtApellido.setEnabled(false);
		txtNombre.setEnabled(false);
		txtEmail.setEnabled(false);
		txtOcupacion.setEnabled(false);
		cmbEstadoCivil.setEnabled(false);
		cmbSexo.setEnabled(false);
		cmbCiudad.setEnabled(false);
		txtCedula.setEnabled(false);
		txtFechaNacimiento.setEnabled(false);
		txtTelefono.setEnabled(false);
		btnNuevoProveedor.setEnabled(true);
		btnAgregarProveedor.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEditar.setEnabled(true);
		btnSalir.setEnabled(true);
		tabbedPane.setSelectedIndex(0);
		btnGenerarCodigoProveedor.setEnabled(false);
	}
	public void mtdActivarControlesNuevoProveedor()
	{
		txtCodigoProveedor.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtApellido.setEnabled(true);
		txtNombre.setEnabled(true);
		txtEmail.setEnabled(true);
		txtOcupacion.setEnabled(true);
		cmbEstadoCivil.setEnabled(true);
		cmbSexo.setEnabled(true);
		cmbCiudad.setEnabled(true);
		txtCedula.setEnabled(true);
		txtFechaNacimiento.setEnabled(true);
		txtTelefono.setEnabled(true);
		btnNuevoProveedor.setEnabled(false);
		btnAgregarProveedor.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);
		btnGenerarCodigoProveedor.setEnabled(true);
		txtCodigoProveedor.requestFocus();
		
	}
	
	public void mtCancelarNuevoProveedor()
	{
		txtCodigoProveedor.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtApellido.setEnabled(false);
		txtNombre.setEnabled(false);
		txtEmail.setEnabled(false);
		txtOcupacion.setEnabled(false);
		cmbEstadoCivil.setEnabled(false);
		cmbSexo.setEnabled(false);
		cmbCiudad.setEnabled(false);
		txtCedula.setEnabled(false);
		txtFechaNacimiento.setEnabled(false);
		txtTelefono.setEnabled(false);
		btnNuevoProveedor.setEnabled(true);
		btnAgregarProveedor.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);
		btnEditar.setEnabled(false);
		btnSalir.setEnabled(true);
		btnGenerarCodigoProveedor.setEnabled(false);
		
		
	}
	
	
	// VALIDAR QUE LOS CONTROLES NO ESTEN VACIOS 
	public void validarCamposVacios(){	
		if(txtCodigoProveedor.getText().trim().length() <=0 )
		{
			JOptionPane.showMessageDialog(null, "El Codigo del Proveedor no Puede Estar en Blanco");
			txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
			txtCodigoProveedor.requestFocus();
			return;
		}
		else
		{
			txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		}

		if(txtNombre.getText().trim().length() <=0 )
		{
			JOptionPane.showMessageDialog(null, "El Nombre del Proveedor no Puede Estar en Blanco");
			txtNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
			txtNombre.requestFocus();
			return;
		}
		else
		{
			txtNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		}

		if(txtApellido.getText().trim().length() <=0 )
		{
			JOptionPane.showMessageDialog(null, "El Apellido del Proveedor no Puede Estar en Blanco");
			txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(178, 34, 34)));
			txtApellido.requestFocus();
			return;
		}
		else
		{
			txtApellido.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		}
	}
	
	// BUSCAR ARTICULO POR CODIGO 
		private void busquedaPorCodigoProducto() {
			try{
				String condicion = "1";
				condicion = "codigoProveedor like '%" + txtBuscarPorCodigo.getText() + "%'";
				modeloTabla.establecerCondicion( condicion );
				modeloTabla.realizarBusqueda();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
	// BUSCAR ARTICULO POR DESCRIPCION DEL ARTICULO
		private void busquedaPorNombreProveedor() {
			try{
				String condicion = "1";
				condicion = "nombres like '%" + txtBuscarPorNombre.getText() + "%'";
				modeloTabla.establecerCondicion( condicion );
				modeloTabla.realizarBusqueda();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
}

