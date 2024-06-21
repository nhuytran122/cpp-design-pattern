import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DbHelper {
	private Connection con = null;
	public Connection getConnection() {
		return this.con;
	}

	// 1. tạo biến static của chính lớp này
	private static DbHelper _instance = null;
	
	// 2. định nghĩa hàm constructor cho lớp này: private
	private DbHelper() throws SQLException{
		String connectionUrl = "jdbc:sqlserver://DESKTOP-6HUBDCV;databaseName=YourDB;user=YourUsername;password=nhuytran";
		con = DriverManager.getConnection(connectionUrl);
	}
	
	// 3. định nghĩa hàm getInstance()
	public static DbHelper getInstance () throws SQLException {
		if (_instance == null)
			_instance = new DbHelper();
			
		return _instance;
	}
}

// Dung voi SingleTon
/*
 			1. tạo connection
			Connection con = (DbHelper.getInstance()).getConnection();			

			// 2. Tạo stmt
			Statement stmt = con.createStatement();
			String SQL = "SELECT MaMonHoc, TenMonHoc FROM MonHoc";
				
			// 3. Thực thi stmt --> trả về tập kq
			ResultSet rs = stmt.executeQuery(SQL);
*/
