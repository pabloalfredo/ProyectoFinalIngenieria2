package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ClassBaseDeDatos {

	public static String URL ="jdbc:mysql://localhost/dbproyecto";    // la url de la conexion 
	public static String Usuario ="root"; // el usuario de la base de datos
	public static String Contrasena ="alfredo1234";  // la contrasena de la base de datos
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");  // drive de mysql para la conexion
		Connection conexion = (Connection) DriverManager.getConnection(URL,Usuario,Contrasena);  // parametros para la conexion
		return conexion; // retorna la conexion
	}
}
