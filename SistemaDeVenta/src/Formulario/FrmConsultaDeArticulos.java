package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import Clases.ModeloTabla;
import Clases.ValidarTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class FrmConsultaDeArticulos extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBuscarPorCodigo;
	private JTextField txtBuscarPorDescripcion;
	private JTable table;
	private ModeloTabla modeloTabla;
	private JComboBox<Object> cmbCategoria;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaDeArticulos frame = new FrmConsultaDeArticulos();
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
	public FrmConsultaDeArticulos() {
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		setClosable(true);
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(10, 181, 701, 193);
		getContentPane().add(scrollPane);
		
		cargarDatosEnTabla();  // LLAMADA AL METODO CARGAR LOS DATOS EN LA TABLA 
		table = new JTable(modeloTabla);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		txtBuscarPorCodigo = new JTextField();
		txtBuscarPorCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita numeros
				validar.AdmitirSoloNumeros(txtBuscarPorCodigo);						// resibe por parametro un textfield
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCodigoProducto();
			}
		});
		txtBuscarPorCodigo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorCodigo.setBackground(new Color(230, 230, 250));
		txtBuscarPorCodigo.setBounds(102, 117, 128, 26);
		getContentPane().add(txtBuscarPorCodigo);
		txtBuscarPorCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(37, 127, 59, 16);
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setForeground(new Color(0, 0, 128));
		lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblCodigo);
		
		txtBuscarPorDescripcion = new JTextField();
		txtBuscarPorDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita letras
				validar.AdmitirSoloLetras(txtBuscarPorDescripcion);						// resibe por parametro un textfield
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorDescripcionaProducto();
			}
		});
		txtBuscarPorDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarPorDescripcion.setBackground(new Color(230, 230, 250));
		txtBuscarPorDescripcion.setBounds(101, 147, 357, 26);
		txtBuscarPorDescripcion.setColumns(10);
		getContentPane().add(txtBuscarPorDescripcion);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(0, 153, 97, 16);
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setForeground(new Color(0, 0, 128));
		lblDescripcion.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblDescripcion);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(230, 121, 80, 16);
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setForeground(new Color(0, 0, 128));
		lblCategoria.setFont(new Font("SansSerif", Font.BOLD, 14));
		getContentPane().add(lblCategoria);
		
		cmbCategoria = new JComboBox<Object>();
		cmbCategoria.setBackground(new Color(0, 128, 128));
		cmbCategoria.setBounds(314, 117, 144, 26);
		getContentPane().add(cmbCategoria);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmConsultaDeArticulos.class.getResource("/Recursos/20DC4B327.png")));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setBorder(null);
		btnSalir.setVerticalTextPosition(SwingConstants.TOP);
		btnSalir.setVerifyInputWhenFocusTarget(false);
		btnSalir.setIconTextGap(2);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnSalir.setBounds(621, 386, 90, 58);
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 718, 113);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(22, 6, 99, 89);
		panel.add(label_2);
		label_2.setIcon(new ImageIcon(FrmConsultaDeArticulos.class.getResource("/Recursos/333.jpg")));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(0, 100, 0));
		label_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblListadoDeArticulos = new JLabel("Listado de Articulos");
		lblListadoDeArticulos.setHorizontalAlignment(SwingConstants.LEFT);
		lblListadoDeArticulos.setForeground(new Color(248, 248, 255));
		lblListadoDeArticulos.setFont(new Font("SansSerif", Font.BOLD, 37));
		lblListadoDeArticulos.setBounds(133, 22, 585, 46);
		panel.add(lblListadoDeArticulos);
		
		JButton button_2 = new JButton("Buscar");
		button_2.setIcon(new ImageIcon(FrmConsultaDeArticulos.class.getResource("/Recursos/E937E1E0B.png")));
		button_2.setForeground(new Color(0, 0, 128));
		button_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_2.setBounds(470, 144, 120, 33);
		getContentPane().add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(0, 381, 718, 65);
		getContentPane().add(panel_1);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 100, 0));
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setBounds(22, 6, 99, 89);
		panel_1.add(label);
		
		JButton button_1 = new JButton("Imprimir");
		button_1.setBounds(6, 6, 90, 58);
		panel_1.add(button_1);
		button_1.setIcon(new ImageIcon(FrmConsultaDeArticulos.class.getResource("/Recursos/273065992.png")));
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setBorder(null);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setVerticalTextPosition(SwingConstants.TOP);
		button_1.setVerifyInputWhenFocusTarget(false);
		button_1.setIconTextGap(2);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(108, 8, 90, 56);
		panel_1.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmConsultaDeArticulos.class.getResource("/Recursos/eliminar.png")));
		btnEliminar.setVerticalTextPosition(SwingConstants.TOP);
		btnEliminar.setVerifyInputWhenFocusTarget(false);
		btnEliminar.setIconTextGap(2);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEliminar.setForeground(new Color(0, 0, 128));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnEliminar.setBorder(null);
		setBounds(100, 100, 721, 474);

	}// fin del constructor

	private void cargarDatosEnTabla() {
		try {
			modeloTabla = new ModeloTabla("codigoProducto as 'Codigo de Producto' , descripcion as 'Nombre del Producto' , idCategoriaProducto as 'Categoria' , idMarcaProducto as 'Marca',idUnidadMedida as Unidad, costo as Costo, efectivo as 'Precio de Venta', stockMaximo as 'Stock Maximo', stockMinimo as 'Stock Minimo'  ", "tblarticulos", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
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
}
