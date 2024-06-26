package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private Connection cx;
	
	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			cx = DriverManager.getConnection("jdbc:sqlite:inventory.db");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}
	
	public void desconectar() {
		try {
			cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
