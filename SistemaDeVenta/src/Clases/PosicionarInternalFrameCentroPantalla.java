package Clases;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class PosicionarInternalFrameCentroPantalla {
	
	public static void centrarFormularioEnPantalla(final JDesktopPane desktopPane, final JInternalFrame internalFrame) {
		int x = (desktopPane.getWidth() / 2) - internalFrame.getWidth() / 2;
		int y = (desktopPane.getHeight() / 2) - internalFrame.getHeight() / 2;
 
		if (internalFrame.isShowing()) {
			internalFrame.setLocation(x, y);
		} else {
		    desktopPane.add(internalFrame);
		    internalFrame.setLocation(x, y);
		    internalFrame.show();
		}
	}
}
