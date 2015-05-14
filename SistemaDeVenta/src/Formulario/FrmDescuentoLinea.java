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

public class FrmDescuentoLinea extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDescuentoLinea frame = new FrmDescuentoLinea();
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
	public FrmDescuentoLinea() {
		
		setForeground(new Color(0, 0, 128));
		setFrameIcon(new ImageIcon(FrmDescuentoLinea.class.getResource("/com/birosoft/liquid/icons/computericon.png")));
		setTitle("Descuento Lineal ");
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 338, 176);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("Cerrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(FrmDescuentoLinea.class.getResource("/Recursos/17D7E1124.png")));
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("SansSerif", Font.BOLD, 18));
		button.setBounds(168, 68, 148, 64);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Aplicar");
		button_1.setIcon(new ImageIcon(FrmDescuentoLinea.class.getResource("/Recursos/B61A1E0B3.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		button_1.setBounds(10, 68, 148, 64);
		getContentPane().add(button_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 128, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setColumns(10);
		textField.setBounds(142, 11, 170, 41);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("Descuento");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(22, 23, 118, 22);
		getContentPane().add(label);
		
		 Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	     Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	     setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        

	}
}
