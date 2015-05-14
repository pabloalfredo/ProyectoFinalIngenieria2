package Formulario;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrmRegistroDeProductosTest {

	@Test
	public void testGenerarCodigoProductoAleatorio() {
		
		FrmRegistroDeProductos frm = new FrmRegistroDeProductos();
		long codigo = 1795894988;
		assertNotEquals(codigo, frm.generarCodigo()); //  COMPARA QUE EL CODIGO QUE SE GENERA NO SEA IGUAL AL UN CODIGO EN LA BASE DE DATOS
		
	}


}
