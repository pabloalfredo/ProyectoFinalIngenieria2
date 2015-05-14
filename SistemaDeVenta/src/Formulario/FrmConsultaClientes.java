package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import Clases.ModeloTabla;
import Clases.ValidarTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmConsultaClientes extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarPorCodigo;
	private JTextField txtBuscarPorNombre;
	private JTable table;
	private ModeloTabla modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaClientes frame = new FrmConsultaClientes();
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
	public FrmConsultaClientes() {
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		getContentPane().setForeground(new Color(0, 0, 128));
		getContentPane().setFont(new Font("Verdana", Font.BOLD, 12));
		setClosable(true);
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(10, 192, 701, 160);
		getContentPane().add(scrollPane);
		
		try {
			modeloTabla = new ModeloTabla("codigoProveedor as 'Codigo del Proveedor' , nombres as Nombres , apellidos as Apellidos , fechaNacimiento as 'Fecha de Nacimiento',sexo as Sexo, estadoCivil as 'Estado Civil', cedula as Cedula, idCiudad as Ciudad, direccion as Direccion, email as 'Correo Electronico', celular as Celular, ocupacion as Ocupacion  ", "tblproveedor", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		
		table = new JTable(modeloTabla);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		txtBuscarPorCodigo = new JTextField();
		mtdBuscarClientePorCodigo(txtBuscarPorCodigo);
		txtBuscarPorCodigo.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorCodigo.setForeground(new Color(0, 0, 128));
		txtBuscarPorCodigo.setBackground(new Color(230, 230, 250));
		txtBuscarPorCodigo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorCodigo.setBounds(71, 125, 114, 28);
		getContentPane().add(txtBuscarPorCodigo);
		txtBuscarPorCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 130, 59, 16);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setForeground(new Color(0, 0, 128));
		lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblCodigo);
		
		txtBuscarPorNombre = new JTextField();
		mtdBuscarPorNombre(txtBuscarPorNombre);
		txtBuscarPorNombre.setForeground(new Color(0, 0, 128));
		txtBuscarPorNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorNombre.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorNombre.setBackground(new Color(230, 230, 250));
		txtBuscarPorNombre.setBounds(71, 158, 315, 28);
		txtBuscarPorNombre.setColumns(10);
		getContentPane().add(txtBuscarPorNombre);
		
		JLabel lblDescripcion = new JLabel("Nombre");
		lblDescripcion.setBounds(0, 165, 67, 16);
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setForeground(new Color(0, 0, 128));
		lblDescripcion.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblDescripcion);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(186, 130, 59, 16);
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setForeground(new Color(0, 0, 128));
		lblCedula.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblCedula);
		
		JButton button_1 = new JButton("Imprimir");
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/Recursos/273065992.png")));
		button_1.setBorder(null);
		button_1.setBounds(112, 371, 90, 58);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setVerticalTextPosition(SwingConstants.TOP);
		button_1.setVerifyInputWhenFocusTarget(false);
		button_1.setIconTextGap(2);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		getContentPane().add(button_1);
		
		
// VALIDANDO LA CEDULA USANDO MASCARA DE TEXTO
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////INICIO		
		MaskFormatter cedula = null;
		try {
		cedula = new MaskFormatter("###-#######-#");           //validando la cedula usando maskormatter 
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();                                                
		}
		JFormattedTextField txtBuscarPorCedula = new JFormattedTextField(cedula);
		txtBuscarPorCedula.setForeground(new Color(0, 0, 128));
		txtBuscarPorCedula.setFont(new Font("Verdana", Font.BOLD, 12));
		txtBuscarPorCedula.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorCedula.setBackground(new Color(230, 230, 250));
		txtBuscarPorCedula.setColumns(10);
		txtBuscarPorCedula.setBounds(252, 125, 134, 28);
		getContentPane().add(txtBuscarPorCedula);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////FIN		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 718, 113);
		getContentPane().add(panel);
		
		JLabel label_1 = new JLabel("Listado de Clientes");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(248, 248, 255));
		label_1.setFont(new Font("SansSerif", Font.BOLD, 37));
		label_1.setBounds(133, 22, 585, 46);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(16, 6, 114, 91);
		panel.add(label_2);
		label_2.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/Recursos/22.png")));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton button_2 = new JButton("Buscar");
		button_2.setForeground(new Color(0, 0, 128));
		button_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_2.setBounds(398, 156, 120, 33);
		getContentPane().add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(0, 365, 718, 64);
		getContentPane().add(panel_1);
		
		JButton button = new JButton("Nuevo");
		button.setBounds(6, 6, 90, 58);
		panel_1.add(button);
		button.setForeground(new Color(0, 0, 128));
		button.setBorder(null);
		button.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/Recursos/B7D02FDEF.png")));
		button.setVerticalTextPosition(SwingConstants.TOP);
		button.setVerifyInputWhenFocusTarget(false);
		button.setIconTextGap(2);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(622, 6, 90, 58);
		panel_1.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBorder(null);
		btnSalir.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/Recursos/29C5898C8.png")));
		btnSalir.setVerticalTextPosition(SwingConstants.TOP);
		btnSalir.setVerifyInputWhenFocusTarget(false);
		btnSalir.setIconTextGap(2);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton button_3 = new JButton("Eliminar");
		button_3.setIcon(new ImageIcon(FrmConsultaClientes.class.getResource("/Recursos/AE9D39F1E.png")));
		button_3.setVerticalTextPosition(SwingConstants.TOP);
		button_3.setVerifyInputWhenFocusTarget(false);
		button_3.setIconTextGap(2);
		button_3.setHorizontalTextPosition(SwingConstants.CENTER);
		button_3.setForeground(new Color(0, 0, 128));
		button_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		button_3.setBorder(null);
		button_3.setBounds(222, 8, 90, 56);
		panel_1.add(button_3);
		setBounds(100, 100, 720, 458);

	}

	/**
	 * METODO PARA BUSCAR POR NOMBRE Y VALIDAR QUE SOLO SE INSTRODUSCA LETRA EN EL TEFIELD
	 */
	private void mtdBuscarPorNombre(final JTextField txtBuscarPorNombre) {
		txtBuscarPorNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // validar que solo se instrodusca letras en el textfield
				 validar.AdmitirSoloLetras(txtBuscarPorNombre);                         // se pasa por parametro el texfield@
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorNombreProveedor();
			}
		});
	}

	/**
	 * ESTE METODO BUSCA Y  VALIDA QUE SOLO SE ADMITAN NUMEROS EN EL TEXFIELLD
	 */
	private void mtdBuscarClientePorCodigo(final JTextField txtBuscarPorcodigo) {
		txtBuscarPorcodigo.addKeyListener(new KeyAdapter() {
			@ Override
			public void keyTyped(KeyEvent arg0) {
				 ValidarTextField validar = new ValidarTextField();           // validar que solo se instrodusca numeros en el textfield
				 validar.AdmitirSoloNumeros(txtBuscarPorcodigo);                         // se pasa por parametro el texfield@
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCodigoProducto();
			}
		});
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
