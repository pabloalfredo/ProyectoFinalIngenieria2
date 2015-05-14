package Formulario;


import java.awt.Container;
import java.awt.ScrollPane;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JInternalFrame;

import Clases.ClassBaseDeDatos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class ReporteArticulos extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.parser.constructor
	 */
	public ReporteArticulos (String fileName){
		this(fileName, null);
	}
	Container c = getContentPane();
	public ReporteArticulos(String fileName, HashMap  parametro) {
		super("Reporte de Articulos");
		try
		{
			JasperPrint print = JasperFillManager.fillReport(fileName, parametro, ClassBaseDeDatos.getConnection());
			JRViewer viewr = new JRViewer(print);
			viewr.setBackground(new Color(0, 128, 128));
			
			getContentPane().setLayout(null);
			final ScrollPane panel = new ScrollPane();
			panel.setBounds(10, 10, 881, 514);
			panel.add(viewr);
			c.add(panel);
			
			JButton btnNewButton = new JButton("Salir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBounds(897, 491, 90, 28);
			getContentPane().add(btnNewButton);
					
		}
		catch(ClassNotFoundException | SQLException | JRException e)
		{
			e.printStackTrace();
		}
		setBounds(10,10,999,556);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}

