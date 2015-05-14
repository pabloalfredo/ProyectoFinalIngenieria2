package testClases;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.junit.Test;

import Clases.ClassBaseDeDatos;

import com.mysql.jdbc.ResultSet;

public class ValidarTextField {

	@Test
	public void testAdmitirSoloLetras() {
		//ValidarTextField  validar = new ValidarTextField();
		
		//validar.testAdmitirSoloLetras();
		assertEquals("alfredo", "alfredo");
		
		
		
	}


	@Test
	public void testAdmitirSoloNumeros() {
		
	}
	
	@Test
	public void testValidarCodigo(){
		
		ResultSet rs;
		int codigoObtendo = 0;
		String consulta = "SELECT codigoProducto FROM tblarticulos";
		try
		{
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery(consulta);
			while(rs.next())
			{
				codigoObtendo = rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error en ", codigoObtendo);
		}
		
		assertEquals(1872308448, codigoObtendo);
		
		
		
	}

}



















