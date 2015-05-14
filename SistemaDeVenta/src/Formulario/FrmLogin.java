package Formulario;
import javax.swing.*;

import Clases.AplicarTemaVentana;
import Clases.ClassBaseDeDatos;
import Clases.Variable;

import java.awt.*;

import javax.swing.border.MatteBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrmLogin extends JFrame{
	
	        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private JButton btnAceptar;
	        private JButton btnCancelar;
	        private JTextField txtNombreUsuario;
	        private JPasswordField txtContrasena;
	        private String nombreObtenido;
	      
	    public static void main(String[] args) {
	    	EventQueue.invokeLater(new Runnable() {
	    	public void run() {
	    		try {
	    			FrmLogin frame = new FrmLogin();
	    			frame.setVisible(true);
	    		} 
	    		catch (Exception e) {
	    				e.printStackTrace();
	    			}
	    	}
	    });
	  }
	    public FrmLogin()
	    {
	    	
	    	AplicarTemaVentana aplicar = new AplicarTemaVentana();
			aplicar.temaNibus();;
			setBackground(new Color(135, 206, 235));
			getContentPane().setLayout(null);
			 setUndecorated(true);
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
			panel.setBackground(new Color(135, 206, 235));
			panel.setBounds(0, 0, 378, 221);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre de Usuario:");
			lblNewLabel.setForeground(new Color(0, 0, 128));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(22, 110, 138, 16);
			panel.add(lblNewLabel);
			
			txtNombreUsuario = new JTextField("pabloalfredo");
			txtNombreUsuario.setFont(new Font("SansSerif", Font.BOLD, 14));
			txtNombreUsuario.setForeground(new Color(0, 0, 128));
			txtNombreUsuario.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			txtNombreUsuario.setBounds(161, 102, 203, 33);
			panel.add(txtNombreUsuario);
			txtNombreUsuario.setColumns(10);
			
			JLabel lblContrasena = new JLabel("Contrasena:");
			lblContrasena.setHorizontalAlignment(SwingConstants.RIGHT);
			lblContrasena.setForeground(new Color(0, 0, 128));
			lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblContrasena.setBounds(38, 148, 122, 16);
			panel.add(lblContrasena);
/////////////////////////////////////////////////////////////////////////////////////////////////////LOGIN PARA ENTRAR AL SISTEMA			
			btnAceptar = new JButton("Entrar [Enter]");
			btnAceptar.setMnemonic('E');
			//btnAceptar.setMnemonic(KeyEvent.VK_ENTER);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					accederAlSistema();  // LLAMADA A LA FUNCION 
				}
				
			});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FIN, DESPUES DEL CONSTRUCTOR			
			btnAceptar.setIcon(new ImageIcon(FrmLogin.class.getResource("/Recursos/157809D10.png")));
			btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 14));
			btnAceptar.setForeground(new Color(0, 0, 128));
			btnAceptar.setBounds(22, 175, 165, 40);
			panel.add(btnAceptar);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////CANCELAR LA ENTRADA AL SISTEMA			
			btnCancelar = new JButton("Cancelar [Esc]");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cancelarEntradaAlSistema();  //LLAMADA A LA FUNCION 
				}
			});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////FIN
			btnCancelar.setIcon(new ImageIcon(FrmLogin.class.getResource("/Recursos/20DC4B327.png")));
			btnCancelar.setForeground(new Color(0, 0, 128));
			btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 14));
			btnCancelar.setBounds(199, 175, 165, 40);
			panel.add(btnCancelar);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(FrmLogin.class.getResource("/Recursos/loguin.png")));
			label.setForeground(new Color(0, 0, 128));
			label.setFont(new Font("Tahoma", Font.BOLD, 14));
			label.setBounds(6, 0, 138, 123);
			panel.add(label);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 128, 128));
			panel_1.setBounds(0, 0, 378, 90);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblIniciarSeccion = new JLabel("Iniciar Sesion");
			lblIniciarSeccion.setBounds(133, 0, 239, 27);
			lblIniciarSeccion.setHorizontalAlignment(SwingConstants.CENTER);
			lblIniciarSeccion.setForeground(new Color(230, 230, 250));
			lblIniciarSeccion.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
			panel_1.add(lblIniciarSeccion);
			
			JLabel lblGren = new JLabel("Gren");
			lblGren.setHorizontalAlignment(SwingConstants.CENTER);
			lblGren.setForeground(new Color(154, 205, 50));
			lblGren.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
			lblGren.setBounds(126, 31, 106, 33);
			panel_1.add(lblGren);
			
			JLabel lblSoft = new JLabel("Soft");
			lblSoft.setHorizontalAlignment(SwingConstants.LEFT);
			lblSoft.setForeground(new Color(0, 0, 128));
			lblSoft.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
			lblSoft.setBounds(217, 31, 106, 33);
			panel_1.add(lblSoft);
			
			JLabel label_1 = new JLabel((String) null);
			label_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/Recursos/0863E5DD6.png")));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setForeground(new Color(0, 0, 128));
			label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			label_1.setBounds(273, 31, 64, 53);
			panel_1.add(label_1);
			
			txtContrasena = new JPasswordField("alfredo1234");
			txtContrasena.setFont(new Font("Wide Latin", Font.BOLD, 22));
			txtContrasena.setForeground(new Color(0, 0, 128));
			txtContrasena.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
			txtContrasena.setBounds(161, 138, 203, 33);
			panel.add(txtContrasena);
			
	
	        setSize(378,221);
	        //Centrar la ventana de autentificacion en la pantalla
	        Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	        Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	        setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        
	        setUndecorated(true);
	        setVisible(true);           // Hacer visible al frame 
	        
	        suscribirComponetesAlManejoDeTeclas();  // LLAMADA AL METODO SUSCRIBIR  COMPONENTES AL MANEJO DE TECLAS
	 
	    }   // fin de constructor
	 

//SUSCRIBIR COMPONENTES AL MANEJO DE EVENTOS, ESTE METOD CAPTURA LOS EVENTOS DEL FORMULARIO
///////////////////////////////////////////////////////////////////
	public void suscribirComponetesAlManejoDeTeclas(){              /// metodo para suscribir componentes al manejo de teclas 
		Component [] componentes = getContentPane().getComponents();   // creacion de arreglo de componentes
		for (Component componente: componentes) {
			
			componente.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent evento) {	
					
				}
				@Override
				public void keyReleased(KeyEvent arg0) {	
				}
				@Override                                      /// teclas de acceso rapido formularios de venta
				public void keyPressed(KeyEvent evento) {
					
					if(evento.getKeyCode() == KeyEvent.VK_ENTER ){   // capturando la tecla precionada 
						accederAlSistema();
					}
					if(evento.getKeyCode() == KeyEvent.VK_ESCAPE){
						cancelarEntradaAlSistema();
					}
				}
			});
		}
	}
	
// METODO PARA ACCEDER AL SISTEMA 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void accederAlSistema()
	{
		mtdValidarPermisos();
		mtdValidarUsuario(txtNombreUsuario.getText(), new String(txtContrasena.getPassword()));
			
	}
/// METODO PARA VALIDAR LOS PERMISOS DE USUARIO	
	public void mtdValidarPermisos() {
		
		ResultSet resultado;
		try{
				resultado = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT nombreUsuario, contrasena, nombre, pConfiguracion, pBackup, pNUsuario, pCUsuario, pSalirSistema, pRVenta, pCVenta, pRCompra, pCCompra, pNArticulo, pCArticulo, pNCliente, pCCliente, pNProveedores, pCProveedores, pTablasAxu, pReporteVenta, pReporteCompras, pRArticulo, pRCliente, pRProveedores, pCajaDiaria, pInformeVentaD, pBusquedaFactura, pListaArti, pManualUsu, pAcercaApli FROM tblusuario WHERE nombreUsuario = '"+txtNombreUsuario.getText() +"'");
				while(resultado.next()){
					String nombreu = resultado.getString(1);
					String contras = resultado.getString(2);
					nombreObtenido = resultado.getString(3);
					Variable.configuracion = resultado.getBoolean(4);
					Variable.backup_Restauracion = resultado.getBoolean(5);
					Variable.nuevoUsuario = resultado.getBoolean(6);
					Variable.cambiarDeUsuario = resultado.getBoolean(7);
					Variable.salirDelSistema = resultado.getBoolean(8);
					Variable.realizarNuevaVenta = resultado.getBoolean(9);
					Variable.consultarVentas = resultado.getBoolean(10);
					Variable.realizarNuevaCompra = resultado.getBoolean(11);
					Variable.consultarCompra = resultado.getBoolean(12);
					Variable.registrarNuevoArticulo = resultado.getBoolean(13);
					Variable.consultarArticulos = resultado.getBoolean(14);
					Variable.registrarNuevoCliente = resultado.getBoolean(15);
					Variable.consultarClientes = resultado.getBoolean(16);
					Variable.registrarNuevoProveedor = resultado.getBoolean(17);
					Variable.consultarProveedores = resultado.getBoolean(18);
					Variable.tablasAuxiliares = resultado.getBoolean(19);
					Variable.reporteDeVentas = resultado.getBoolean(20);
					Variable.reporteDecompras = resultado.getBoolean(21);
					Variable.reporteDeArticulos = resultado.getBoolean(22);
					Variable.reporteDeClientes = resultado.getBoolean(23);
					Variable.reportedeProveedores = resultado.getBoolean(24);
					Variable.cajaDiaria = resultado.getBoolean(25);
					Variable.informeDeVentaDiaria = resultado.getBoolean(26);
					Variable.busquedaFacturasdemitidas = resultado.getBoolean(27);
					Variable.listadoDeArticulos = resultado.getBoolean(28);
					Variable.manualDeUsuario = resultado.getBoolean(29);
					Variable.acercaDeLaAplicacion = resultado.getBoolean(30);
				}
		}
		catch(ClassNotFoundException | SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());	
			
		}
	}

// METODO PARA COMPARAR QUE EL NOMBRE Y LA CONTRASENA DIGITADA SEAN CORRECTAS
	public boolean mtdValidarUsuario(String nombreUsuarioRecibido, String contrasenaRecibida) {
		ResultSet resultado;
		String nombreUsuarioObtenido = null;
		String contrasenaObtenida = null;
		try{
				resultado = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT nombreUsuario, contrasena FROM tblusuario WHERE nombreUsuario = '"+nombreUsuarioRecibido +"'");
				while(resultado.next()){
					nombreUsuarioObtenido = resultado.getString(1);
					contrasenaObtenida = resultado.getString(2);
				}
		}
		catch(ClassNotFoundException | SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());	
		}
		
		if(nombreUsuarioRecibido.equals(nombreUsuarioObtenido) && new String (contrasenaRecibida).equals(contrasenaObtenida)){
			
				dispose();
				setVisible(false);
				FrmPrincipal frm = new FrmPrincipal();
				frm.nombreDelUsuario(nombreObtenido);
				frm.mostrarFormulario();
				return true;
			
		}
		else{
				JOptionPane.showMessageDialog(null, "Nombre de Usuario y/o Contrasena Invalidos");
				txtContrasena.setText("");
				return false;
		}
	}
	
	//CUANDO SE PRESIONA LA TECLA ESCAPE SE LLAMA ESTA FUNCION 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void cancelarEntradaAlSistema() {
			System.exit(0);
		}
	
}