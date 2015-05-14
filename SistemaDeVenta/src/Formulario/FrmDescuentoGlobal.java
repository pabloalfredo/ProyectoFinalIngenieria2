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

public class FrmDescuentoGlobal extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDescuentoGlobal frame = new FrmDescuentoGlobal();
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
	public FrmDescuentoGlobal() {
		setResizable(true);
		
		setForeground(new Color(0, 0, 128));
		setFrameIcon(new ImageIcon(FrmDescuentoGlobal.class.getResource("/Recursos/desc.png")));
		setTitle("Descuento Global");
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
		button.setIcon(new ImageIcon(FrmDescuentoGlobal.class.getResource("/Recursos/17D7E1124.png")));
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("SansSerif", Font.BOLD, 18));
		button.setBounds(168, 68, 148, 64);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Aplicar");
		button_1.setIcon(new ImageIcon(FrmDescuentoGlobal.class.getResource("/Recursos/B61A1E0B3.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		button_1.setBounds(10, 68, 148, 64);
		getContentPane().add(button_1);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField.setBackground(new Color(230, 230, 250));
		textField.setForeground(new Color(0, 128, 0));
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setColumns(10);
		textField.setBounds(129, 11, 183, 41);
		getContentPane().add(textField);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setForeground(new Color(0, 0, 128));
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescuento.setBounds(10, 23, 107, 22);
		getContentPane().add(lblDescuento);
		
		 Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	     Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	     setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        

	}
}
