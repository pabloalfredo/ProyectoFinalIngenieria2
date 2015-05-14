package Formulario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hgiacoman
 */
public class validator {
 
    public validator() {
        String correo = "helmy_gb@gmail.com";
        if(isEmail(correo)){
            System.out.println("Mail correcto");
        }else{
            System.out.println("Mail incorrecto");
        }
        
        String fecha = "23/12/1987";
        if (isDate(fecha)) {
            System.out.println("Fecha correcta");
        }else{
            System.out.println("Fecha incorrecta");
        }
    }
    
    //metodo para validar si la fecha es correcta
    public boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
 
    //metodo para validar correo electronio
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else
        	System.out.println("[" + mat.group() + "]");
            return true;      
    }
 
    public static void main(String args[]) {
        new validator();
    }
}