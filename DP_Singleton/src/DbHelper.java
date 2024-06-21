import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	private Connection con;

	private static DbHelper instance = null;
	
	private DbHelper() throws SQLException {
		//jdbc:sqlserver://DESKTOP-6HUBDCV;databaseName=DB_KTra_DP;user=sa;password=nhuytran;encrypt=true;trustServerCertificate=true
		String connectionUrl = "jdbc:sqlserver://DESKTOP-6HUBDCV:1433; databaseName = DB_KTra_DP; user=sa;"
				+ " password=nhuytran; encrypt=true; trustServerCertificate=true";
		con = DriverManager.getConnection(connectionUrl);
	}
	public Connection getConnection() {
		return con;
	}
	
	public static DbHelper getInstance() throws SQLException {
		if(instance == null)
			instance = new DbHelper();
		return instance;
	}
}
