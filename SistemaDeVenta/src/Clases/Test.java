package Clases;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
 
 
public class Test {
 
        private JFrame frame;
        private JTextField txtNombre;
        private JTextField txtApellidos;
 
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        Test window = new Test();
                                        window.frame.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }
 
        /**
         * Create the application.
         */
        public Test() {
                initialize();
        }
 
        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
                frame = new JFrame();
                frame.setBounds(100, 100, 450, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);
               
                JPanel panel = new JPanel();
                panel.setBorder(new TitledBorder(null, "Formulario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                panel.setBounds(10, 11, 414, 141);
                frame.getContentPane().add(panel);
                panel.setLayout(null);
               
                txtNombre = new JTextField();
                txtNombre.addActionListener(new ValidateFieldListener());
                txtNombre.setBounds(10, 46, 86, 20);
                panel.add(txtNombre);
                txtNombre.setColumns(10);
               
                JLabel lblNewLabel = new JLabel("Nombre:");
                lblNewLabel.setBounds(10, 26, 46, 14);
                panel.add(lblNewLabel);
               
                JLabel lblApellidos = new JLabel("Apellidos:");
                lblApellidos.setBounds(10, 77, 46, 14);
                panel.add(lblApellidos);
               
                txtApellidos = new JTextField();
                txtApellidos.addActionListener(new ValidateFieldListener());
                txtApellidos.setColumns(10);
                txtApellidos.setBounds(10, 97, 86, 20);
                panel.add(txtApellidos);
        }
       
        public class ValidateFieldListener implements ActionListener {
               
                @Override
                public void actionPerformed(ActionEvent e) {   
                       
                        JTextField txt =  (JTextField)e.getSource();
                        if(txt.getText().equals("")){
                                txt.setBorder(new LineBorder(Color.RED));
                                JOptionPane.showMessageDialog(txt, "El campo no puede quedar vacío", "Error de validación", JOptionPane.ERROR_MESSAGE);
                        } else {                               
                                txt.setBorder(new LineBorder(Color.LIGHT_GRAY));
                                try {
                                        Robot r = new Robot();
                                        r.keyPress(KeyEvent.VK_TAB);
                                } catch (AWTException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                }
                        }
                }              
        }
}