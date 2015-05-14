package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import Clases.ClassRegistrarCliente;
import Clases.ClassRegistrarProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class FrmFacturaVenta extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField codigoProducto;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField txtDireccion;
	private JTextField txtNombres;
	private JTextField txtCodigoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFacturaVenta frame = new FrmFacturaVenta();
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
	public FrmFacturaVenta() {
		
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		setClosable(true);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("SansSerif", Font.BOLD, 18));
		setTitle("Nueva Venta");
		setFrameIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/B86765EE0.png")));
		//AplicarTemaVentana aplicar = new AplicarTemaVentana();
		//aplicar.temaNibus();
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 862, 587);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Codigo del Producto");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(4, 316, 201, 34);
		getContentPane().add(label);
		
		codigoProducto = new JTextField();
		codigoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		codigoProducto.setBackground(new Color(230, 230, 250));
		codigoProducto.setForeground(new Color(0, 0, 102));
		codigoProducto.setFont(new Font("MV Boli", Font.BOLD, 27));
		codigoProducto.setColumns(10);
		codigoProducto.setBounds(222, 310, 306, 42);
		getContentPane().add(codigoProducto);
		
		JButton btnAgregarProductoenter = new JButton("       Agregar Producto [Enter]");
		btnAgregarProductoenter.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/8EF214180.png")));
		btnAgregarProductoenter.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProductoenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarProductoenter.setForeground(new Color(0, 0, 102));
		btnAgregarProductoenter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregarProductoenter.setBounds(540, 310, 298, 42);
		getContentPane().add(btnAgregarProductoenter);
		
		JLabel lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setForeground(new Color(0, 0, 128));
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubtotal.setBounds(23, 432, 88, 40);
		getContentPane().add(lblSubtotal);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_1.setText("$0.00");
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(116, 429, 138, 34);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_2.setText("$0.00");
		textField_2.setForeground(Color.RED);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(116, 470, 138, 34);
		getContentPane().add(textField_2);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuento.setForeground(new Color(0, 0, 128));
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescuento.setBounds(4, 479, 107, 40);
		getContentPane().add(lblDescuento);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_3.setText("$0.00");
		textField_3.setForeground(Color.RED);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(116, 516, 138, 34);
		getContentPane().add(textField_3);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setForeground(new Color(0, 0, 128));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(44, 515, 67, 40);
		getContentPane().add(lblTotal);
		
		JLabel lblTipoDeComprobante = new JLabel("Tipo de Comprobante:");
		lblTipoDeComprobante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeComprobante.setForeground(new Color(0, 0, 128));
		lblTipoDeComprobante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeComprobante.setBounds(455, 11, 169, 28);
		getContentPane().add(lblTipoDeComprobante);
		
		JComboBox comboBox = new JComboBox<Object>();
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(625, 12, 213, 28);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroFactura = new JLabel("Numero Factura:");
		lblNumeroFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroFactura.setForeground(new Color(0, 0, 128));
		lblNumeroFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroFactura.setBounds(455, 41, 169, 28);
		getContentPane().add(lblNumeroFactura);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(625, 42, 213, 28);
		getContentPane().add(textField_4);
		
		JLabel lblNfc = new JLabel("NFC:");
		lblNfc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNfc.setForeground(new Color(0, 0, 128));
		lblNfc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNfc.setBounds(564, 71, 60, 28);
		getContentPane().add(lblNfc);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setColumns(10);
		textField_5.setBounds(625, 72, 213, 28);
		getContentPane().add(textField_5);
		
		JLabel label_7 = new JLabel("Fecha:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(585, 103, 49, 28);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Hora:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(718, 103, 51, 28);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("05/09/2015");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(626, 103, 98, 28);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("05:45:23");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(762, 103, 76, 28);
		getContentPane().add(label_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(15, 143, 823, 161);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel
		(
			new Object[][]
			{
				{
					null, null, null, null, null, null
				},
			},
			new String[]
			{
				"<html><h4 font color = navy>Codigo</h3></html>", "<html><h4 font color = navy>Decripcion</h3></html>", "<html><h4 font color = navy>Cantidad</h3></html>", "<html><h4 font color = navy>Precio</h3></html>", "<html><h4 font color = navy>Descuento</h3></html>", "<html><h4 font color = navy>Total</h3></html>"
			}
		)
		{
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, Double.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, true, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(264);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnCancelesc = new JButton("Cancel [Esc]");
		btnCancelesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarVenta();
			}
		});
		btnCancelesc.setBorder(null);
		btnCancelesc.setForeground(new Color(0, 0, 128));
		btnCancelesc.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/29C5898C8.png")));
		btnCancelesc.setVerticalTextPosition(SwingConstants.TOP);
		btnCancelesc.setVerifyInputWhenFocusTarget(false);
		btnCancelesc.setIconTextGap(2);
		btnCancelesc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelesc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelesc.setBounds(740, 353, 98, 63);
		getContentPane().add(btnCancelesc);
		
		JButton btnCantif = new JButton("Canti [F3]");
		btnCantif.setBorder(null);
		btnCantif.setForeground(new Color(0, 0, 128));
		btnCantif.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/D1F0AC18D.png")));
		btnCantif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidadArticulos();
			}
		});
		btnCantif.setVerticalTextPosition(SwingConstants.TOP);
		btnCantif.setVerifyInputWhenFocusTarget(false);
		btnCantif.setIconTextGap(2);
		btnCantif.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCantif.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCantif.setBounds(105, 353, 89, 63);
		getContentPane().add(btnCantif);
		
		JButton btnCobrarf = new JButton("Cobrar [F2]");
		btnCobrarf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				
					cobrar();
			}
		});
		btnCobrarf.setBorder(null);
		btnCobrarf.setForeground(new Color(0, 0, 128));
		btnCobrarf.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/5E1E8BF80.png")));
		btnCobrarf.setVerticalTextPosition(SwingConstants.TOP);
		btnCobrarf.setVerifyInputWhenFocusTarget(false);
		btnCobrarf.setIconTextGap(2);
		btnCobrarf.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCobrarf.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCobrarf.setAlignmentY(1.0f);
		btnCobrarf.setBounds(14, 353, 89, 63);
		getContentPane().add(btnCobrarf);
		
		JButton btnLimpiaresc = new JButton("Limpiar [F11]");
		btnLimpiaresc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				limpiarCampos();
			}
		});
		btnLimpiaresc.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/51BD969F7.png")));
		btnLimpiaresc.setVerticalTextPosition(SwingConstants.TOP);
		btnLimpiaresc.setVerifyInputWhenFocusTarget(false);
		btnLimpiaresc.setIconTextGap(2);
		btnLimpiaresc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiaresc.setForeground(new Color(0, 0, 128));
		btnLimpiaresc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiaresc.setBorder(null);
		btnLimpiaresc.setBounds(630, 354, 98, 63);
		getContentPane().add(btnLimpiaresc);
		
		JButton btnGlobalf_1 = new JButton("Global [F10]");
		btnGlobalf_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				descuentoGlobal();
			}
		});
		btnGlobalf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/desc.png")));
		btnGlobalf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnGlobalf_1.setVerifyInputWhenFocusTarget(false);
		btnGlobalf_1.setIconTextGap(2);
		btnGlobalf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGlobalf_1.setForeground(new Color(0, 0, 128));
		btnGlobalf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGlobalf_1.setBorder(null);
		btnGlobalf_1.setBounds(524, 354, 98, 63);
		getContentPane().add(btnGlobalf_1);
		
		JButton btnLineaf_1 = new JButton("Linea [F9]");
		btnLineaf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				descuentoLinea();
			}
		});
		btnLineaf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/desc.png")));
		btnLineaf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnLineaf_1.setVerifyInputWhenFocusTarget(false);
		btnLineaf_1.setIconTextGap(2);
		btnLineaf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLineaf_1.setForeground(new Color(0, 0, 128));
		btnLineaf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLineaf_1.setBorder(null);
		btnLineaf_1.setBounds(414, 354, 98, 63);
		getContentPane().add(btnLineaf_1);
		
		JButton btnQuitarf_1 = new JButton("Quitar  [F8]");
		btnQuitarf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarArticulosSeleccionados();
			}
		});
		btnQuitarf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/AE9D39F1E.png")));
		btnQuitarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnQuitarf_1.setVerifyInputWhenFocusTarget(false);
		btnQuitarf_1.setIconTextGap(2);
		btnQuitarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarf_1.setForeground(new Color(0, 0, 128));
		btnQuitarf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnQuitarf_1.setBorder(null);
		btnQuitarf_1.setBounds(304, 354, 98, 63);
		getContentPane().add(btnQuitarf_1);
		
		JButton btnBuscarf_1 = new JButton("Buscar [F7]");
		btnBuscarf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarArticulos();
			}
		});
		btnBuscarf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnBuscarf_1.setVerifyInputWhenFocusTarget(false);
		btnBuscarf_1.setIconTextGap(2);
		btnBuscarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarf_1.setForeground(new Color(0, 0, 128));
		btnBuscarf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscarf_1.setBorder(null);
		btnBuscarf_1.setBounds(195, 354, 98, 63);
		getContentPane().add(btnBuscarf_1);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtDireccion.setBackground(new Color(230, 230, 250));
		txtDireccion.setBounds(128, 97, 298, 34);
		getContentPane().add(txtDireccion);
		
		JLabel label_1 = new JLabel("Direccion");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(59, 95, 67, 28);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(68, 65, 58, 28);
		getContentPane().add(label_2);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombres.setBackground(new Color(230, 230, 250));
		txtNombres.setBounds(128, 67, 298, 28);
		getContentPane().add(txtNombres);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setDefaultLocale(null);
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCodigoCliente.setBackground(new Color(230, 230, 250));
		txtCodigoCliente.setBounds(127, 33, 98, 31);
		getContentPane().add(txtCodigoCliente);
		
		JLabel lblCodCliente = new JLabel("Cod Cliente");
		lblCodCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodCliente.setForeground(new Color(0, 0, 128));
		lblCodCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodCliente.setBounds(6, 35, 120, 28);
		getContentPane().add(lblCodCliente);
		
		JButton button = new JButton("Buscar [F4]");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busquedaCliente();
			}
		});
		button.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/E937E1E0B.png")));
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(new Color(0, 0, 102));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(226, 30, 200, 35);
		getContentPane().add(button);
		   
        suscribirComponetesAlManejoDeTeclas();
	}


	//SUSCRIBIR COMPONENTES AL MANEJO DE EVENTOS, ESTE METOD CAPTURA LOS EVENTOS DEL FORMULARIO
///////////////////////////////////////////////////////////////////
	public void suscribirComponetesAlManejoDeTeclas(){              /// metodo para suscribir componentes al manejo de teclas 
		Component [] componentes = getContentPane().getComponents();   // creacion de arreglo de componentes
		for (Component componente: componentes) {
			
			componente.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					
				}
				
				@Override                                      /// teclas de acceso rapido formularios de venta
				public void keyPressed(KeyEvent evento) {
					
					
					if(evento.getKeyCode() == KeyEvent.VK_F2){   // capturando la tecla precionada 
						cobrar();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F3){
						cantidadArticulos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F4){
						busquedaCliente();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F7){
						buscarArticulos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F8){
						eliminarArticulosSeleccionados();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F9){
						descuentoLinea();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F10){
						descuentoGlobal();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F11){
						limpiarCampos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_ESCAPE){
						cancelarVenta();
					}
					if(evento.getKeyCode() == KeyEvent.VK_ENTER){
						JOptionPane.showMessageDialog(null, "Se Preciono Enter");
					}
				}
			});
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// METODOS PARA LAS ACCCIONES DE LOS BOTONES DEL FORMULARIO DE VENTA DE ARTICULOS
	private void cobrar() {
		FrmCobroFactura frm = new FrmCobroFactura();
		getDesktopPane().add(frm);
		frm.setVisible(true);
	}
	private void cantidadArticulos() {
			FrmCantida frm = new FrmCantida();
			getDesktopPane().add(frm);
			frm.setVisible(true);
	}
// METODO PARA BUSCAR ATICULOS Y AGREGARLOS A LA TABLA
	private void buscarArticulos(){
		try {
			FrmBuscar busqueda = new FrmBuscar(FrmFacturaVenta.this);
			busqueda.getModeloTabla().establecerAtributos("codigoProducto, descripcion, efectivo, existencia");
			busqueda.getModeloTabla().establecerTabla("tblarticulos");
			busqueda.getModeloTabla().establecerCondicion("1");
			
			busqueda.getModeloTabla().realizarBusqueda();
			busqueda.getModeloTabla().fireTableStructureChanged();
			getDesktopPane().add(busqueda);
			busqueda.setVisible(true);
			
		}
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	
// METODO PARA BUSCAR CLIENTES Y AGREGARLOS A LOSS TXFIELD
	private void busquedaCliente() {                                                          
		try {
			FrmBuscar busqueda = new FrmBuscar(FrmFacturaVenta.this);
			busqueda.getModeloTabla().establecerAtributos("codigoCliente, nombres, direccion");
			busqueda.getModeloTabla().establecerTabla("tblclientes");
			busqueda.getModeloTabla().establecerCondicion("1");
			
			busqueda.getModeloTabla().realizarBusqueda();
			busqueda.getModeloTabla().fireTableStructureChanged();
			getDesktopPane().add(busqueda);
			busqueda.setVisible(true);
			
		}
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1);
		}
	}
	private void eliminarArticulosSeleccionados(){
			JOptionPane.showMessageDialog(null, "El articulo a sido eliminado");
		}
	private void descuentoGlobal() {
		FrmDescuentoGlobal frm = new FrmDescuentoGlobal();
		getDesktopPane().add(frm);
		frm.setVisible(true);
	}

	private void descuentoLinea() {
		FrmDescuentoLinea frm = new FrmDescuentoLinea();
	    getDesktopPane().add(frm);
		frm.setVisible(true);
	}
	private void limpiarCampos(){
			JOptionPane.showMessageDialog(null, "Campos Limpiados Correctamente");
		}
	private void cancelarVenta() {
		dispose();
	}

//CARGA LOS DATOS DEL ARTICULO A LA TABLA 
///////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void cargarDatosArticulo(ClassRegistrarProducto articulo) 
	{	
		DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		long codigoRecibido = articulo.getCodigoProducto();
		String descripcionRecibida = articulo.getDescripcion();
		double precioRecibido = articulo.getEfectivo();
		
		
		tabla.setValueAt(codigoRecibido, table.getSelectedRow(), 1);
        tabla.setValueAt(descripcionRecibida, table.getSelectedRow(), 2);
        tabla.setValueAt(precioRecibido, table.getSelectedRow(), 4);
		
		table.changeSelection(table.getSelectedRow(), 3, false, false);
		table.requestFocus(); 
		
	}
// CARGA LOS DATOS DEL CLIENTE A LA LOS TEXFIELD
///////////////////////////////////////////////////////////////////////////////////////////
	public void cargarDatosClientes(ClassRegistrarCliente cliente) {
		txtCodigoCliente.setText(Integer.toString(cliente.getCodigoCliente()));
		txtNombres.setText(cliente.getNombres());
		txtDireccion.setText(cliente.getDireccion());
	}
}
