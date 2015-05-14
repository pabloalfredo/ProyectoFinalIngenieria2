package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import Clases.ValidarTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmCobroFactura extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCobroFactura frame = new FrmCobroFactura();
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
	public FrmCobroFactura() {
		
		setForeground(new Color(0, 0, 128));
		setFrameIcon(new ImageIcon(FrmCobroFactura.class.getResource("/com/birosoft/liquid/icons/computericon.png")));
		setTitle("Cobro de Factura");
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 557, 423);
		getContentPane().setLayout(null);
		
		JLabel lblCobroDeFactura = new JLabel("Cobro de Factura");
		lblCobroDeFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblCobroDeFactura.setForeground(new Color(25, 25, 112));
		lblCobroDeFactura.setFont(new Font("Verdana", Font.BOLD, 26));
		lblCobroDeFactura.setBounds(8, 11, 539, 45);
		getContentPane().add(lblCobroDeFactura);
		
		JLabel label_2 = new JLabel("Efectivo");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(-2, 55, 239, 33);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Total a Pagar ");
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(333, 68, 148, 25);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Resivido");
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(61, 117, 80, 25);
		getContentPane().add(label_4);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // PERMITE QUE SOLO SE INGRESEN NUMEROS EN EL TEXTFIELD
				validar.AdmitirSoloNumeros(textField_1);						// SE LE PASA POR PARAMETRO UN TEXTFIELD
			}
		});
		textField_1.setToolTipText("");
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("$0.00");
		textField_1.setForeground(new Color(0, 128, 0));
		textField_1.setFont(new Font("SansSerif", Font.BOLD, 39));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(230, 230, 250));
		textField_1.setBounds(8, 142, 219, 60);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setText("$0.00");
		textField_2.setForeground(new Color(178, 34, 34));
		textField_2.setFont(new Font("SansSerif", Font.BOLD, 39));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(230, 230, 250));
		textField_2.setBounds(261, 127, 270, 60);
		getContentPane().add(textField_2);
		
		JButton btnPagarenter = new JButton("Pagar [Enter]");
		btnPagarenter.setIcon(new ImageIcon(FrmCobroFactura.class.getResource("/Recursos/pagar.png")));
		btnPagarenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnPagarenter.setForeground(new Color(0, 0, 128));
		btnPagarenter.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnPagarenter.setBounds(8, 319, 168, 64);
		getContentPane().add(btnPagarenter);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setText("$0.00");
		textField_3.setForeground(new Color(0, 128, 0));
		textField_3.setFont(new Font("SansSerif", Font.BOLD, 39));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(230, 230, 250));
		textField_3.setBounds(8, 231, 219, 59);
		getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel("Devuelto");
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(61, 207, 80, 25);
		getContentPane().add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(-2, 46, 555, 10);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(239, 46, 10, 262);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(-2, 301, 555, 10);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 128, 128));
		panel_3.setBackground(new Color(47, 79, 79));
		panel_3.setBounds(-245, 91, 489, 2);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 128, 128));
		panel_4.setBackground(new Color(47, 79, 79));
		panel_4.setBounds(247, 91, 306, 2);
		getContentPane().add(panel_4);
		
		JLabel label_6 = new JLabel("Total:");
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setBounds(261, 101, 80, 25);
		getContentPane().add(label_6);
		
		JButton btnModificarenter = new JButton("Modificar [M]");
		btnModificarenter.setIcon(new ImageIcon(FrmCobroFactura.class.getResource("/Recursos/B86765EE0.png")));
		btnModificarenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarenter.setForeground(new Color(0, 0, 128));
		btnModificarenter.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnModificarenter.setBounds(186, 319, 168, 64);
		getContentPane().add(btnModificarenter);
		
		JButton btnCancelenter = new JButton("Cancel [ESC]");
		btnCancelenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelenter.setIcon(new ImageIcon(FrmCobroFactura.class.getResource("/Recursos/29C5898C8.png")));
		btnCancelenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelenter.setForeground(new Color(0, 0, 128));
		btnCancelenter.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelenter.setBounds(364, 319, 168, 64);
		getContentPane().add(btnCancelenter);
		
		 Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	     Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	     setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        

	}
}
