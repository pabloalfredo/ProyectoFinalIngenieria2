package Formulario;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrmLoginTest {

	@Test
	public void testMtdValidarUsuario() {
		
		FrmLogin frm = new FrmLogin(); // instanciando el login
		assertTrue("El usuario o la contrase�a no estan correcto", frm.mtdValidarUsuario("pabloalfredo", "alfredo124"));
	
	}

}
