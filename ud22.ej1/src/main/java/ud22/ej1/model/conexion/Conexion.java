package ud22.ej1.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {

	static String bd = "cliente";
	static String login = "tarjona";
	static String password = "Mek15Mor@";
	static String url = "jdbc:mysql://192.168.1.75:3306/" + bd + "?useTimezone=true&serverTimezone=UTC";

	Connection conn = null;

	public Conexion() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			// obtenemos la conexion
			conn = DriverManager.getConnection(url, login, password);

			if (conn != null) {
				System.out.print("Conexión a base de datos " + bd + "_SUCCESS at");
				fecha();
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn = null;
	}

	public static void fecha() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println(" - " + hourdateFormat.format(date));
	}

}
