package Formulario;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.naming.ldap.Rdn;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import Clases.ClassRegistrarCliente;
import Clases.ClassRegistrarProveedor;
import Clases.ModeloTabla;
import Clases.ClassRegistrarProducto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;




public class FrmBuscar extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private ModeloTabla modeloTabla;
	private JInternalFrame ventanaPadre;
	private JTextField txtDescripcion;
	private JLabel lblNombre;
	private JRadioButton rbDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscar frame = new FrmBuscar(new JInternalFrame());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmBuscar(final JInternalFrame jInternalFrame) throws SQLException {
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		setClosable(true);
		this.ventanaPadre = jInternalFrame;
		setTitle("Buscar Articulo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {// AL MOMENTO DE REALIZAR LA BUSQUEDAD LA CONDICION SE MODIFICA POR LO QUE ESTA EN EL TEXTBOX
					
					String condicion = "1";
					
					if(jInternalFrame instanceof FrmFacturaVenta)
					{
						condicion = "descripcion like '%" + txtDescripcion.getText() + "%'";
					}
					else if(ventanaPadre instanceof FrmFacturaCompras)
					{
						condicion = "nombreUsuario like '%" + txtDescripcion.getText() + "%'";
					}
					
					modeloTabla.establecerCondicion( condicion );
					modeloTabla.realizarBusqueda();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
				
		try {
			modeloTabla = new ModeloTabla("*", "tblarticulos", "1");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		modeloTabla.realizarBusqueda();
		table = new JTable(modeloTabla);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(jInternalFrame instanceof FrmFacturaVenta)
				{
					try{
						/*long Codigo = Long.parseLong( modeloTabla.getValueAt(table.getSelectedRow(), 0).toString() );
						String Descripcion =  modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
						double precio =  Double.parseDouble(modeloTabla.getValueAt(table.getSelectedRow(), 2).toString());
						
						 ClassRegistrarProducto nuevoProducto = new ClassRegistrarProducto(Codigo,Descripcion, precio);
						((FrmFacturaVenta)jInternalFrame).cargarDatosArticulo(nuevoProducto);*/
						int codigoCliente = Integer.parseInt(modeloTabla.getValueAt(table.getSelectedRow(), 0).toString());
						String nombres = modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
						String direccion = modeloTabla.getValueAt(table.getSelectedRow(), 2).toString();
					
						ClassRegistrarCliente cliente = new ClassRegistrarCliente(codigoCliente, nombres, direccion);
						((FrmFacturaVenta)jInternalFrame).cargarDatosClientes(cliente);
					}
					catch (Exception ex){
						ex.printStackTrace();
					}
					
					
				}
				
				if(jInternalFrame instanceof FrmRegistroDeClientes)
				{
					try{
						/*int codigoCliente = Integer.parseInt(modeloTabla.getValueAt(table.getSelectedRow(), 0).toString());
						String nombres = modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
						String direccion = modeloTabla.getValueAt(table.getSelectedRow(), 2).toString();
					
						ClassRegistrarCliente cliente = new ClassRegistrarCliente(codigoCliente, nombres, direccion);
						((FrmFacturaVenta)jInternalFrame).cargarDatosClientes(cliente);*/
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				
				if(jInternalFrame instanceof FrmRegistroDeProveedores)
				{
					try{
						int codigoProveedor = Integer.parseInt(modeloTabla.getValueAt(table.getSelectedRow(), 0).toString());
						String nombres = modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
						String direccion = modeloTabla.getValueAt(table.getSelectedRow(), 2).toString();
					
						ClassRegistrarCliente proveedor = new ClassRegistrarCliente(codigoProveedor, nombres, direccion);
						((FrmFacturaVenta)jInternalFrame).cargarDatosClientes(proveedor);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				dispose();			
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 139, 139)));
		scrollPane.setBounds(0, 60, 620, 174);
		contentPane.add(scrollPane);		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 620, 60);
		contentPane.add(panel);
		
		lblNombre = new JLabel("Articulo");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setForeground(new Color(230, 230, 250));
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblNombre.setBounds(6, 11, 104, 27);
		panel.add(lblNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try
				{// AL MOMENTO DE REALIZAR LA BUSQUEDAD LA CONDICION SE MODIFICA POR LO QUE ESTA EN EL TEXTBOX
					
					String condicion = "1";
					
					if(jInternalFrame instanceof FrmFacturaVenta)
					{
						condicion = "descripcion like '%" + txtDescripcion.getText() + "%'";
					}
					/*else if(ventanaPadre instanceof FormUsuarios)
					{
						condicion = "nombreUsuario like '%" + textField.getText() + "%'";
					}*/
					
					modeloTabla.establecerCondicion( condicion );
					modeloTabla.realizarBusqueda();
					
				} 
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		txtDescripcion.setForeground(new Color(0, 0, 128));
		txtDescripcion.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(135, 206, 235)));
		txtDescripcion.setBackground(new Color(230, 230, 250));
		txtDescripcion.setBounds(111, 11, 227, 27);
		panel.add(txtDescripcion);
		
		JRadioButton radioButton = new JRadioButton("Codigo");
		radioButton.setForeground(new Color(248, 248, 255));
		radioButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		radioButton.setBounds(350, 18, 85, 18);
		panel.add(radioButton);
		
		rbDescripcion = new JRadioButton("Descripcion");
		rbDescripcion.setForeground(new Color(248, 248, 255));
		rbDescripcion.setFont(new Font("SansSerif", Font.BOLD, 14));
		rbDescripcion.setBounds(434, 18, 115, 18);
		panel.add(rbDescripcion);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setIcon(new ImageIcon(FrmBuscar.class.getResource("/Recursos/222.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_1.setBounds(504, 238, 114, 31);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Anadir");
		button_2.setIcon(new ImageIcon(FrmBuscar.class.getResource("/Recursos/ok.png")));
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setForeground(new Color(0, 0, 128));
		button_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		button_2.setBounds(380, 237, 114, 33);
		contentPane.add(button_2);
		
		Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
        setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
        
	}

	public ModeloTabla getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(ModeloTabla modeloTabla) {
		this.modeloTabla = modeloTabla;
	}
}