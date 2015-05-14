package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import Clases.AplicarTemaVentana;
import Clases.ClassRegistrarProveedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmFacturaCompras extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtCodigoProveedor;
	private JTextField txtNombres;
	private JTextField txtDireccion;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFacturaCompras frame = new FrmFacturaCompras();
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
	public FrmFacturaCompras() {
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		setClosable(true);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("SansSerif", Font.BOLD, 18));
		setTitle("Nueva Compra");
		setFrameIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/B86765EE0.png")));
		//AplicarTemaVentana aplicar = new AplicarTemaVentana();
		//aplicar.temaNibus();
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 862, 501);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Codigo del Producto");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(4, 316, 201, 34);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField.setBackground(new Color(230, 230, 250));
		textField.setForeground(new Color(0, 0, 102));
		textField.setFont(new Font("MV Boli", Font.BOLD, 27));
		textField.setColumns(10);
		textField.setBounds(222, 310, 306, 42);
		getContentPane().add(textField);
		
		JButton btnAgregarProductoenter = new JButton("       Agregar Articulo [Enter]");
		btnAgregarProductoenter.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/8EF214180.png")));
		btnAgregarProductoenter.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProductoenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarProductoenter.setForeground(new Color(0, 0, 102));
		btnAgregarProductoenter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregarProductoenter.setBounds(540, 310, 298, 42);
		getContentPane().add(btnAgregarProductoenter);
		
		JLabel lblSubtotal = new JLabel("Total:");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setForeground(new Color(0, 0, 128));
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubtotal.setBounds(4, 431, 88, 40);
		getContentPane().add(lblSubtotal);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_1.setText("$0.00");
		textField_1.setForeground(Color.RED);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(104, 428, 139, 34);
		getContentPane().add(textField_1);
		
		JLabel lblTipoDeComprobante = new JLabel("Tipo de Comprobante:");
		lblTipoDeComprobante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeComprobante.setForeground(new Color(0, 0, 128));
		lblTipoDeComprobante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeComprobante.setBounds(455, 11, 169, 28);
		getContentPane().add(lblTipoDeComprobante);
		
		JComboBox comboBox = new JComboBox();
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
		textField_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		textField_4.setForeground(new Color(0, 0, 128));
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
		textField_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		textField_5.setForeground(new Color(0, 0, 128));
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"<html><h4 font color = blue>Codigo</h3></html>", "<html><h4 font color = blue>Decripcion</h3></html>", "<html><h4 font color = blue>Marca</h3></html>", "<html><h4 font color = blue>Cantidad</h3></html>", "<html><h4 font color = blue>Precio</h3></html>", "<html><h4 font color = blue>Total</h3></html>"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(264);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JButton btnCancelesc = new JButton("Cancel [Esc]");
		btnCancelesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelesc.setBorder(null);
		btnCancelesc.setForeground(new Color(0, 0, 128));
		btnCancelesc.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/29C5898C8.png")));
		btnCancelesc.setVerticalTextPosition(SwingConstants.TOP);
		btnCancelesc.setVerifyInputWhenFocusTarget(false);
		btnCancelesc.setIconTextGap(2);
		btnCancelesc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelesc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelesc.setBounds(699, 353, 139, 63);
		getContentPane().add(btnCancelesc);
		
		JButton btnCantif = new JButton("Cantidad [F3]");
		btnCantif.setBorder(null);
		btnCantif.setForeground(new Color(0, 0, 128));
		btnCantif.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/D1F0AC18D.png")));
		btnCantif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCantida frm = new FrmCantida();
				getDesktopPane().add(frm);
				frm.setVisible(true);
			}
		});
		btnCantif.setVerticalTextPosition(SwingConstants.TOP);
		btnCantif.setVerifyInputWhenFocusTarget(false);
		btnCantif.setIconTextGap(2);
		btnCantif.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCantif.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCantif.setBounds(153, 353, 121, 63);
		getContentPane().add(btnCantif);
		
		JButton btnCobrarf = new JButton("Precio [F2]");
		btnCobrarf.setBorder(null);
		btnCobrarf.setForeground(new Color(0, 0, 128));
		btnCobrarf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCobroFactura frm = new FrmCobroFactura();
				getDesktopPane().add(frm);
				frm.setVisible(true);
			}
		});
		btnCobrarf.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/B86765EE0.png")));
		btnCobrarf.setVerticalTextPosition(SwingConstants.TOP);
		btnCobrarf.setVerifyInputWhenFocusTarget(false);
		btnCobrarf.setIconTextGap(2);
		btnCobrarf.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCobrarf.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCobrarf.setAlignmentY(1.0f);
		btnCobrarf.setBounds(14, 353, 127, 63);
		getContentPane().add(btnCobrarf);
		
		JLabel lblCodigoProveedor = new JLabel("Cod Proveedor");
		lblCodigoProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigoProveedor.setForeground(new Color(0, 0, 128));
		lblCodigoProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoProveedor.setBounds(14, 11, 120, 28);
		getContentPane().add(lblCodigoProveedor);
		
		JLabel label_12 = new JLabel("Nombre");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setForeground(new Color(0, 0, 128));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(76, 41, 58, 28);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("Direccion");
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setForeground(new Color(0, 0, 128));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(67, 71, 67, 28);
		getContentPane().add(label_13);
		
		txtCodigoProveedor = new JTextField();
		txtCodigoProveedor.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtCodigoProveedor.setForeground(new Color(0, 0, 128));
		txtCodigoProveedor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCodigoProveedor.setBackground(new Color(230, 230, 250));
		txtCodigoProveedor.setColumns(10);
		txtCodigoProveedor.setBounds(135, 9, 98, 31);
		getContentPane().add(txtCodigoProveedor);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtNombres.setForeground(new Color(0, 0, 128));
		txtNombres.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtNombres.setBackground(new Color(230, 230, 250));
		txtNombres.setColumns(10);
		txtNombres.setBounds(136, 43, 298, 28);
		getContentPane().add(txtNombres);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("SansSerif", Font.BOLD, 13));
		txtDireccion.setForeground(new Color(0, 0, 128));
		txtDireccion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtDireccion.setBackground(new Color(230, 230, 250));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(136, 73, 298, 34);
		getContentPane().add(txtDireccion);
		
		JButton btnLimpiaresc = new JButton("Nuevo Art [F12]");
		btnLimpiaresc.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/B7D02FDEF.png")));
		btnLimpiaresc.setVerticalTextPosition(SwingConstants.TOP);
		btnLimpiaresc.setVerifyInputWhenFocusTarget(false);
		btnLimpiaresc.setIconTextGap(2);
		btnLimpiaresc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiaresc.setForeground(new Color(0, 0, 128));
		btnLimpiaresc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiaresc.setBorder(null);
		btnLimpiaresc.setBounds(420, 353, 131, 63);
		getContentPane().add(btnLimpiaresc);
		
		JButton btnQuitarf_1 = new JButton("Quitar  [F8]");
		btnQuitarf_1.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/AE9D39F1E.png")));
		btnQuitarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnQuitarf_1.setVerifyInputWhenFocusTarget(false);
		btnQuitarf_1.setIconTextGap(2);
		btnQuitarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarf_1.setForeground(new Color(0, 0, 128));
		btnQuitarf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnQuitarf_1.setBorder(null);
		btnQuitarf_1.setBounds(556, 353, 139, 63);
		getContentPane().add(btnQuitarf_1);
		
		JButton btnBuscarf_1 = new JButton("Buscar [F7]");
		btnBuscarf_1.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnBuscarf_1.setVerifyInputWhenFocusTarget(false);
		btnBuscarf_1.setIconTextGap(2);
		btnBuscarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarf_1.setForeground(new Color(0, 0, 128));
		btnBuscarf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscarf_1.setBorder(null);
		btnBuscarf_1.setBounds(281, 353, 131, 63);
		getContentPane().add(btnBuscarf_1);
		
		JButton btnf_1 = new JButton("Buscar [F4]");
		btnf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					FrmBuscar frm = new FrmBuscar(FrmFacturaCompras.this);
					frm.getModeloTabla().establecerAtributos("codigoProveedor, nombres, direccion");
					frm.getModeloTabla().establecerTabla("tblproveedor");
					frm.getModeloTabla().establecerCondicion("1");
					
					frm.getModeloTabla().realizarBusqueda();
					frm.getModeloTabla().fireTableStructureChanged();
					getDesktopPane().add(frm);
					frm.setVisible(true);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		btnf_1.setIcon(new ImageIcon(FrmFacturaCompras.class.getResource("/Recursos/E937E1E0B.png")));
		btnf_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnf_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnf_1.setForeground(new Color(0, 0, 102));
		btnf_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnf_1.setBounds(234, 6, 200, 35);
		getContentPane().add(btnf_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(0, 128, 128));
		comboBox_1.setBounds(135, 108, 299, 28);
		getContentPane().add(comboBox_1);
		
		JLabel lblCondPago = new JLabel("Cond. Pago");
		lblCondPago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCondPago.setForeground(new Color(0, 0, 128));
		lblCondPago.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCondPago.setBounds(46, 103, 88, 28);
		getContentPane().add(lblCondPago);


	}
	public void cargarDatosProveedor(ClassRegistrarProveedor NuevaFila) 
	{	
		txtCodigoProveedor.setText(Integer.toString(NuevaFila.getCodigoProveedor()));
		txtNombres.setText(NuevaFila.getNombres());
		txtDireccion.setText(NuevaFila.getDireccion());
	}
	
	
}
