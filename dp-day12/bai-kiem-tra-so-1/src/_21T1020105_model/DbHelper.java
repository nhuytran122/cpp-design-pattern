package _21T1020105_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private Connection con = null;
	
	public Connection getConnection() {
		return this.con;
	}

	private static DbHelper _instance = null;
	
	
	private DbHelper() {
		String connectionUrl = CauHinh.getInstance().getChuoiKetNoi();
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DbHelper getInstance() throws SQLException {
		if (_instance == null)
			_instance = new DbHelper();
			
		return _instance;
	}
}