package Clases;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class ValidarTextField {               // SE CREARON DOS FUNCIONES QUE RECIBEN COMO PARAMETRO UN TEXFIELD Y SE HACEN LAS CORRESPONDIENTE VALIDACIONES
	public void AdmitirSoloLetras(final JTextField textfield){
		textfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){        // valida que solo se pueda introducir letras en el textfield
				int letra =(int) e.getKeyChar();
				if(letra>=48 && letra<=57 || letra>=0 && letra <=31 || letra>=33 && letra <=64 || letra>=91 && letra <=96 || letra>=123 && letra <=129 || letra>=131 && letra <=159 || letra>=166 && letra <=255 ){
					e.consume();
					
				}
			}
		});
	}
	public void AdmitirSoloNumeros(final JTextField textfield){
		textfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {       // valida que solo se pueda introducir numeros en el texfield
				int letra =(int) e.getKeyChar();
				if(letra>=0 && letra<=31 || letra>=33 && letra<=47 || letra>=58 && letra<=255 ){
					e.consume();
					
				}
			}
		});
	}
	
}
