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
import javax.swing.JEditorPane;
import javax.swing.JTextPane;


public class FrmConfiguracionesGenerales extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JFileChooser examinar = new JFileChooser();
	private int codigoProveedor, cmSexo,cmEstadoCivil,cmCiudad;
	private String direccion,apellidos,nombres,email,ocupacion,fechaNacimiento,celular,estadoCivil,sexo,cedula;
	private MaskFormatter maskcedula,maskfechaNacimiento,maskcelular;
	private JButton btnNuevoProveedor,btnAgregarProveedor,btnGuardar,btnCancelar,btnEditar,btnSalir;
	ClassRegistrarProveedor registrarProveedores,actualizarProveedor;
	ClassCiudades objetoTipoCiudad ;
	CargarComboBox comboBox = new CargarComboBox();
	private ModeloTabla modeloTabla;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConfiguracionesGenerales frame = new FrmConfiguracionesGenerales();
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
	FrmConfiguracionesGenerales()
	{
		INITIALIZE();
		//mtdDesactivarControlesFormulario();
	}
	public void INITIALIZE() {
		examinar.setMultiSelectionEnabled(false);
		examinar.setCurrentDirectory(new File("c://Documents and Settings"));
		setTitle("Configuraciones del Negocio");
		setClosable(true);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 791, 476);
		getContentPane().setLayout(null);
		
//VALIDACION DE LA CEDULA CON MASCARA
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO
		maskcedula = null;
		try {
		maskcedula = new MaskFormatter("###-#######-#");           //validando la cedula usando maskormatter 
		maskcedula.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();                                                
		}
		
// VALIDANDO FECHA DE NACIMIENTO CON MASCARA
////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO
		maskfechaNacimiento = null;
		try {
		maskfechaNacimiento = new MaskFormatter("##/##/####");  // VALIDANDO LA FECHA DE NACIMEINTO USANDO MASCARA
		maskfechaNacimiento.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		try {
			modeloTabla = new ModeloTabla("codigoProveedor as 'Codigo del Proveedor' , nombres as Nombres , apellidos as Apellidos , fechaNacimiento as 'Fecha de Nacimiento',sexo as Sexo, estadoCivil as 'Estado Civil', cedula as Cedula, idCiudad as Ciudad, direccion as Direccion, email as 'Correo Electronico', celular as Celular, ocupacion as Ocupacion  ", "tblproveedor", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		//mtdParaBuscarPorCodigo();
		//mtdBuscarPorNombre();
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 128));
		panel_4.setBounds(0, 0, 787, 113);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/config.png")));
		label.setBounds(6, 6, 130, 101);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		panel_4.add(label);
		
		JLabel lblAdministracionDeUsuarios = new JLabel("Configuraciones Generales del Negocio");
		lblAdministracionDeUsuarios.setBounds(126, 27, 643, 46);
		panel_4.add(lblAdministracionDeUsuarios);
		lblAdministracionDeUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdministracionDeUsuarios.setForeground(new Color(248, 248, 255));
		lblAdministracionDeUsuarios.setFont(new Font("SansSerif", Font.BOLD, 33));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 400, 787, 47);
		getContentPane().add(panel_3);
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setLayout(null);
		
		btnNuevoProveedor = new JButton("Nuevo [N]");
		//mtdNuevoProveedor();  // LLAMADA AL METODO NUEVO PROVEEDOR  EL CUAL HABILITA LOS CAMPOS PARA PARA EL REGISTRO DE UN NUEVO PROVEEDOR
		btnNuevoProveedor.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/nuevo.png")));
		btnNuevoProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNuevoProveedor.setForeground(new Color(0, 0, 128));
		btnNuevoProveedor.setBounds(6, 6, 120, 36);
		panel_3.add(btnNuevoProveedor);
		
		btnAgregarProveedor = new JButton("Agregar");
		//mtdAgregarProveedor(btnAgregarProveedor); //LLAMADA AL METODO CUANDO SE PRESIONA EL BOTON AGREGAR  PARA INSERTAR EN LA BASE DE DATOS UN NUEVO PROVEEDOR 
		btnAgregarProveedor.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/157809D10.png")));
		btnAgregarProveedor.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAgregarProveedor.setForeground(new Color(0, 0, 128));
		btnAgregarProveedor.setBounds(138, 6, 120, 36);
		panel_3.add(btnAgregarProveedor);
		
		btnCancelar = new JButton("Cancelar");
		//mtdCancelarEntradaProveedor(); // CANCELAR LA ENTRADA DE PROVEEDOR
		btnCancelar.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/abort.png")));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setForeground(new Color(0, 0, 128));
		btnCancelar.setBounds(397, 6, 120, 36);
		panel_3.add(btnCancelar);
		
		btnSalir = new JButton("Salir [Esc]");
		//mtdSalirFormularioProveedor();// SALIR DEL LA VENTADA DE PROVEEDORES
		btnSalir.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/salir.png")));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBounds(661, 6, 120, 36);
		panel_3.add(btnSalir);
		
		btnEditar = new JButton("Editar");
		//mtdEditarProveedores(btnEditar);// LLAMADA AL METODO EDITAR PROVEEDOR
		btnEditar.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/D1F0AC18D.png")));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setForeground(new Color(0, 0, 128));
		btnEditar.setBounds(529, 6, 120, 36);
		panel_3.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		//mtdActualizarProveedor(btnGuardar);
		btnGuardar.setIcon(new ImageIcon(FrmConfiguracionesGenerales.class.getResource("/Recursos/guardar.png")));
		btnGuardar.setForeground(new Color(0, 0, 128));
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setBounds(270, 6, 120, 36);
		panel_3.add(btnGuardar);
		
		JLabel lblNombreDelNegocio = new JLabel("Nombre del Negocio");
		lblNombreDelNegocio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreDelNegocio.setForeground(new Color(0, 0, 128));
		lblNombreDelNegocio.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNombreDelNegocio.setBounds(0, 130, 168, 16);
		getContentPane().add(lblNombreDelNegocio);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 128));
		textField.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(175, 125, 516, 28);
		getContentPane().add(textField);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvincia.setForeground(new Color(0, 0, 128));
		lblProvincia.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProvincia.setBounds(0, 163, 168, 16);
		getContentPane().add(lblProvincia);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0, 0, 128));
		textField_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setBounds(175, 158, 516, 28);
		getContentPane().add(textField_1);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setForeground(new Color(0, 0, 128));
		lblDireccion.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDireccion.setBounds(0, 196, 168, 16);
		getContentPane().add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(0, 0, 128));
		textField_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setBounds(175, 191, 516, 28);
		getContentPane().add(textField_2);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setForeground(new Color(0, 0, 128));
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTelefono.setBounds(0, 229, 168, 16);
		getContentPane().add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(0, 0, 128));
		textField_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_3.setBackground(new Color(230, 230, 250));
		textField_3.setBounds(175, 224, 148, 28);
		getContentPane().add(textField_3);
		
		JLabel lblRnc = new JLabel("RNC");
		lblRnc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRnc.setForeground(new Color(0, 0, 128));
		lblRnc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRnc.setBounds(0, 261, 168, 16);
		getContentPane().add(lblRnc);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(0, 0, 128));
		textField_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setBounds(175, 256, 148, 28);
		getContentPane().add(textField_4);
		
		
		
		JLabel lblPoliticasDeDevoluciones = new JLabel("Politicas Devoluciones");
		lblPoliticasDeDevoluciones.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoliticasDeDevoluciones.setForeground(new Color(0, 0, 128));
		lblPoliticasDeDevoluciones.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPoliticasDeDevoluciones.setBounds(0, 289, 168, 16);
		getContentPane().add(lblPoliticasDeDevoluciones);
		
		JLabel lblEslogan = new JLabel("Eslogan");
		lblEslogan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEslogan.setForeground(new Color(0, 0, 128));
		lblEslogan.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblEslogan.setBounds(327, 231, 75, 16);
		getContentPane().add(lblEslogan);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(0, 0, 128));
		textField_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setBounds(407, 224, 284, 28);
		getContentPane().add(textField_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textPane.setFont(new Font("SansSerif", Font.BOLD, 13));
		textPane.setForeground(new Color(0, 0, 128));
		textPane.setBounds(175, 289, 239, 91);
		getContentPane().add(textPane);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogo.setForeground(new Color(0, 0, 128));
		lblLogo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLogo.setBounds(461, 264, 75, 16);
		getContentPane().add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		panel.setBounds(546, 267, 145, 113);
		getContentPane().add(panel);
		
		JButton button = new JButton(".....");
		button.setVerticalTextPosition(SwingConstants.TOP);
		button.setVerticalAlignment(SwingConstants.BOTTOM);
		button.setFont(new Font("SansSerif", Font.BOLD, 27));
		button.setBounds(692, 355, 60, 26);
		getContentPane().add(button);

	}// FIN DEL CONSRUCTOR 
}

