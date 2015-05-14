package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;


import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

import Clases.ClassCiudades;
import Clases.ModeloTabla;
import Clases.ValidarTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class FrmCiudad extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCiudades;
	private JTable table;
	private JTextField txtBuscarCiudad;
	private String ciudad;
	private ModeloTabla modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCiudad frame = new FrmCiudad();
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
	public FrmCiudad() {
		
		setForeground(new Color(0, 0, 128));
		setFrameIcon(new ImageIcon(FrmCiudad.class.getResource("/com/birosoft/liquid/icons/computericon.png")));
		setTitle("Registro de Ciudades");
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 425, 400);
		
		JButton button = new JButton("");
		button.setBounds(239, 332, 64, 32);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCiudad frm = new FrmCiudad();
				frm.isClosed();
			}
		});
		getContentPane().setLayout(null);
		button.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/eliminar.png")));
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(button);
		
		JButton btnAgregarCiudad = new JButton("");
		agregarCiudad(btnAgregarCiudad);
		btnAgregarCiudad.setBounds(6, 332, 64, 32);
		btnAgregarCiudad.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/B61A1E0B3.png")));
		btnAgregarCiudad.setForeground(new Color(0, 0, 128));
		btnAgregarCiudad.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(btnAgregarCiudad);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(158, 332, 64, 32);
		button_3.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/902BCB3FC.png")));
		button_3.setForeground(new Color(0, 0, 128));
		button_3.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(button_3);
		
		JButton button_5 = new JButton("");
		button_5.setBounds(82, 332, 64, 32);
		button_5.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/impfv.png")));
		button_5.setForeground(new Color(0, 0, 128));
		button_5.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(button_5);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 101, 419, 219);
		tabbedPane.setBackground(new Color(0, 139, 139));
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Nueva Ciudad", new ImageIcon(FrmCiudad.class.getResource("/Recursos/B7D02FDEF.png")), panel_1, null);
		panel_1.setLayout(null);
		
		txtCiudades = new JTextField();
		txtCiudades.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // PERMITE QUE SOLO SE INGRESEN LETRAS EN EL TEXTFIELD
				validar.AdmitirSoloLetras(txtCiudades);						// SE LE PASA POR PARAMETRO UN TEXTFIELD
			}
		});
		txtCiudades.setBounds(165, 20, 248, 28);
		panel_1.add(txtCiudades);
		txtCiudades.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtCiudades.setForeground(new Color(0, 0, 128));
		txtCiudades.setBackground(new Color(230, 230, 250));
		txtCiudades.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCiudades.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Ciudad");
		lblNewLabel.setBounds(6, 26, 156, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Busqueda de Ciudades", new ImageIcon(FrmCiudad.class.getResource("/Recursos/6B6F6D5EB.png")), panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 37, 407, 142);
		panel.add(scrollPane_1);
		
		try{
			modeloTabla = new ModeloTabla("idCiudad as Id, descripcion as 'Nombre de la Ciudad'", "tblciudades", "1");
			modeloTabla.realizarBusqueda();
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		table = new JTable(modeloTabla);
		scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);
		
		txtBuscarCiudad = new JTextField();
		txtBuscarCiudad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // PERMITE QUE SOLO SE INGRESEN LETRAS EN EL TEXTFIELD
				validar.AdmitirSoloLetras(txtBuscarCiudad);						// SE LE PASA POR PARAMETRO UN TEXTFIELD
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCiudad();
			}
		});
		txtBuscarCiudad.setBounds(78, 7, 150, 28);
		panel.add(txtBuscarCiudad);
		txtBuscarCiudad.setForeground(new Color(0, 0, 128));
		txtBuscarCiudad.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtBuscarCiudad.setColumns(10);
		txtBuscarCiudad.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarCiudad.setBackground(new Color(230, 230, 250));
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(22, 15, 55, 16);
		panel.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setForeground(new Color(0, 0, 128));
		lblBuscar.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busquedaPorCiudad();
			}
		});
		button_4.setBounds(232, 2, 64, 37);
		panel.add(button_4);
		button_4.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/E937E1E0B.png")));
		button_4.setForeground(new Color(0, 0, 128));
		button_4.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 419, 92);
		panel_2.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCategoriasProductos = new JLabel("Ciudades");
		lblCategoriasProductos.setBounds(97, 19, 145, 40);
		lblCategoriasProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriasProductos.setForeground(new Color(248, 248, 255));
		lblCategoriasProductos.setFont(new Font("SansSerif", Font.BOLD, 31));
		panel_2.add(lblCategoriasProductos);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/menuart.png")));
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setBounds(6, 6, 79, 80);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(0, 326, 419, 44);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(349, 6, 64, 32);
		panel_3.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(FrmCiudad.class.getResource("/Recursos/salir.png")));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 18));	        

	}

	private void agregarCiudad(final JButton btnAgregarCiudad) {
		btnAgregarCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ciudad = txtCiudades.getText();
				ClassCiudades objetoCiudad = new ClassCiudades(ciudad);
				try{
					objetoCiudad.insertarCiudad();
				}
				catch(ClassNotFoundException  | SQLException e){
					e.printStackTrace();
				}
			}
		});
	}
	private void busquedaPorCiudad() {
		try{
			String condicion = "1";
			condicion = "Descripcion like '%" + txtBuscarCiudad.getText() + "%'";
			modeloTabla.establecerCondicion( condicion );
			modeloTabla.realizarBusqueda();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
}
