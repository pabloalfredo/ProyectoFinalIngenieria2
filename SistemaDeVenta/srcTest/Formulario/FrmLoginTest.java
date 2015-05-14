package Formulario;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrmLoginTest {

	@Test
	public void testMtdValidarUsuario() {
		
		FrmLogin frm = new FrmLogin();
		assertTrue("El usuario o la contraseña no estan correcto", frm.mtdValidarUsuario("pabloalfredo", "alfredo124"));
	
	}

}
