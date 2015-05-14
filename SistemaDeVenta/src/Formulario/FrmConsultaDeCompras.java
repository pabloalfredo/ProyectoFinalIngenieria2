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
import Clases.ValidarTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmConsultaDeCompras extends JInternalFrame {
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaDeCompras frame = new FrmConsultaDeCompras();
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
	public FrmConsultaDeCompras() {
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		setClosable(true);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("SansSerif", Font.BOLD, 18));
		setTitle("Consulta de Compras");
		setFrameIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/B86765EE0.png")));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 862, 587);
		getContentPane().setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_3.setText("$0.00");
		textField_3.setForeground(Color.RED);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(123, 516, 138, 34);
		getContentPane().add(textField_3);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setForeground(new Color(0, 0, 128));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(54, 516, 67, 28);
		getContentPane().add(lblTotal);
		
		JLabel lblTipoDeComprobante = new JLabel("Comprobante:");
		lblTipoDeComprobante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeComprobante.setForeground(new Color(0, 0, 128));
		lblTipoDeComprobante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeComprobante.setBounds(384, 207, 117, 28);
		getContentPane().add(lblTipoDeComprobante);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(507, 208, 213, 28);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroFactura = new JLabel("Numero Factura:");
		lblNumeroFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroFactura.setForeground(new Color(0, 0, 128));
		lblNumeroFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroFactura.setBounds(384, 237, 122, 28);
		getContentPane().add(lblNumeroFactura);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(507, 238, 213, 28);
		getContentPane().add(textField_4);
		
		JLabel lblNfc = new JLabel("NFC:");
		lblNfc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNfc.setForeground(new Color(0, 0, 128));
		lblNfc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNfc.setBounds(446, 266, 60, 28);
		getContentPane().add(lblNfc);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setColumns(10);
		textField_5.setBounds(507, 267, 213, 28);
		getContentPane().add(textField_5);
		
		JLabel label_7 = new JLabel("Fecha:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(715, 213, 49, 17);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Hora:");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(725, 243, 49, 17);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("05/09/2015");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(771, 208, 79, 28);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("05:45:23");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(760, 238, 67, 28);
		getContentPane().add(label_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(23, 332, 823, 178);
		getContentPane().add(scrollPane);
		String codigo ="<html><h4 font color = blue>Codigo</h3></html>";
		String descripcion ="<html><h4 font color = blue>Decripcion</h3></html>";
		String cantidad ="<html><h4 font color = blue>Cantidad</h3></html>";
		String precio ="<html><h4 font color = blue>Precio</h3></html>";
		String unidad ="<html><h4 font color = blue>Unidad</h3></html>";
		String descuento ="<html><h4 font color = blue>Descuento</h3></html>";
		String total ="<html><h4 font color = blue>Total</h3></html>";
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
				Integer.class, String.class, String.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(264);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel label_11 = new JLabel("Codigo");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setForeground(new Color(0, 0, 128));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_11.setBounds(54, 207, 60, 28);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("Nombre");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setForeground(new Color(0, 0, 128));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_12.setBounds(54, 237, 60, 28);
		getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("Direccion");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(new Color(0, 0, 128));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_13.setBounds(35, 266, 79, 28);
		getContentPane().add(label_13);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita numeros
				validar.AdmitirSoloNumeros(textField_6);						// resibe por parametro un textfield
			}
		});
		textField_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_6.setBackground(new Color(230, 230, 250));
		textField_6.setColumns(10);
		textField_6.setBounds(115, 208, 96, 28);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita letras
				validar.AdmitirSoloLetras(textField_7);					// resibe por parametro un textfield
			}
		});
		textField_7.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_7.setBackground(new Color(230, 230, 250));
		textField_7.setColumns(10);
		textField_7.setBounds(116, 238, 256, 28);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita letras
				validar.AdmitirSoloLetras(textField_8);						// resibe por parametro un textfield
			}
		});
		textField_8.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_8.setBackground(new Color(230, 230, 250));
		textField_8.setColumns(10);
		textField_8.setBounds(116, 268, 256, 28);
		getContentPane().add(textField_8);
		
		JButton btnf_1 = new JButton("Buscar [F4]");
		btnf_1.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/E937E1E0B.png")));
		btnf_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnf_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnf_1.setForeground(new Color(0, 0, 102));
		btnf_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnf_1.setBounds(212, 204, 160, 34);
		getContentPane().add(btnf_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane_1.setBounds(23, 39, 670, 156);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Nro Factura", "Fecha", "Hora", "Nombre-Proveedor", "Codigo-Proveedor", "Total", "Usuario"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(186);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(102);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(95);
		//scrollPane_1.setColumnHeaderView(table_1);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnSalir = new JButton("Salir [Esc]");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/salir.png")));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setVerifyInputWhenFocusTarget(false);
		btnSalir.setIconTextGap(2);
		btnSalir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnSalir.setBorder(null);
		btnSalir.setBounds(705, 156, 133, 40);
		getContentPane().add(btnSalir);
		
		JButton btnBuscarf = new JButton("Buscar [F3]");
		btnBuscarf.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscarf.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscarf.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarf.setForeground(new Color(0, 0, 102));
		btnBuscarf.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBuscarf.setBounds(212, 2, 160, 34);
		getContentPane().add(btnBuscarf);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();         // valida que el textfield solo admita numeros
				validar.AdmitirSoloNumeros(textField);						// resibe por parametro un textfield
			}
		});
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(89, 6, 122, 28);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("Codigo");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(23, 6, 60, 28);
		getContentPane().add(label);
		
		JButton btnImprimir = new JButton("Imprimir [P]");
		btnImprimir.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/impfv.png")));
		btnImprimir.setVerifyInputWhenFocusTarget(false);
		btnImprimir.setIconTextGap(2);
		btnImprimir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnImprimir.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprimir.setForeground(new Color(0, 0, 128));
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnImprimir.setBorder(null);
		btnImprimir.setBounds(705, 35, 133, 40);
		getContentPane().add(btnImprimir);
		
		JButton btnAnular = new JButton("Anular [F5]");
		btnAnular.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/abort.png")));
		btnAnular.setVerifyInputWhenFocusTarget(false);
		btnAnular.setIconTextGap(2);
		btnAnular.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAnular.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnular.setForeground(new Color(0, 0, 128));
		btnAnular.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAnular.setBorder(null);
		btnAnular.setBounds(705, 76, 133, 40);
		getContentPane().add(btnAnular);
		
		JButton btnBorrar = new JButton("Borrar [Del]");
		btnBorrar.setIcon(new ImageIcon(FrmConsultaDeCompras.class.getResource("/Recursos/eliminar.png")));
		btnBorrar.setVerifyInputWhenFocusTarget(false);
		btnBorrar.setIconTextGap(2);
		btnBorrar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBorrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnBorrar.setForeground(new Color(0, 0, 128));
		btnBorrar.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBorrar.setBorder(null);
		btnBorrar.setBounds(705, 115, 133, 40);
		getContentPane().add(btnBorrar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(0, 128, 128));
		comboBox_1.setBounds(116, 297, 256, 28);
		getContentPane().add(comboBox_1);
		
		JLabel lblFormaPago = new JLabel("Forma Pago: ");
		lblFormaPago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFormaPago.setForeground(new Color(0, 0, 128));
		lblFormaPago.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFormaPago.setBounds(23, 292, 96, 28);
		getContentPane().add(lblFormaPago);
		
		 Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	     Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	     setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        

	}
	
}
