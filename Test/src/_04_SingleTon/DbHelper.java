package _04_SingleTon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private Connection con;
	private static DbHelper instance = null;
	
	
	public Connection getCon() {
		return con;
	}
	
	private DbHelper() throws SQLException {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName = SV; password = 123; encrypt = true; trustServerCertificate = true";
		con = DriverManager.getConnection(connectionUrl);
	}
	
	public static DbHelper getInstance() throws SQLException {
		if (instance == null)
			instance = new DbHelper();
		return instance;
	}
}
