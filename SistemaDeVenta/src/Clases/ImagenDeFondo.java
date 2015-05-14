package Clases;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;


public class ImagenDeFondo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon imagen;
	/**
	 * Create the panel.
	 */
	public ImagenDeFondo(String rutaAbsoluta) {
		super();
		initialize();
		establecerImagen(rutaAbsoluta);
	}
	
	public void seleccionarImagen()
	{
		JFileChooser selector = new JFileChooser();
		selector.showOpenDialog(this.getParent());		
		establecerImagen( selector.getSelectedFile().getPath() );
		
	}

	public void establecerImagen(String rutaAbsoluta) {
		imagen = new ImageIcon(rutaAbsoluta);
		//setSize(imagen.getIconWidth(), imagen.getIconHeight());
		repaint();
	}
	
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//Dimension d = getSize();
		//g.drawImage(imagen.getImage(),0 , 0, d.width, d.height, null);
		g.drawImage(imagen.getImage(),0 , 0, this.getWidth(), this.getHeight(), null);
		this.setOpaque(false);
	}
	
	private void initialize(){
		this.setSize(300, 200);
		this.setLayout(new GridBagLayout());
	}
}
