package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class LansarAyuda {
	
	public void LansarLaAyuda(){
		
		//String ubicacionReporte = System.getProperty("user.dir")+"/Recursos/ayuda.chm";
		try{
			File archivo = new  File(getClass().getResource("").toURI());
			Desktop.getDesktop().open(archivo);
		}
		catch(IOException | URISyntaxException ex){
			JOptionPane.showMessageDialog(null, "Nose se Pudo Abrir el Archivo", null, JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
   }
	
}




























