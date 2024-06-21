import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
	Connection con = null;
	
	private static DbHelper instance = null;
	
	public DbHelper() throws SQLException, IOException {
		FileReader f = new FileReader("config.ini");
		BufferedReader br = new BufferedReader(f);
		String chuoiketnoi = br.readLine();
		br.close();
		con = DriverManager.getConnection(chuoiketnoi);
	}
	
	public Connection getConnection() {
		return con;
	}

	public static DbHelper getInstance() throws SQLException, IOException {
		if(instance == null)
			instance = new DbHelper();
		return instance;
	}
}
