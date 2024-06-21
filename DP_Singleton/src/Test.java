import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws SQLException {
		Connection con = DbHelper.getInstance().getConnection();
		List<SinhVien> lstSV = new ArrayList<>();
	    try {
	    	String sql = "SELECT * FROM SinhVien";
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	        	String masv = rs.getString("MaSinhVien");
				String hoten = rs.getString("HoTen");
				Date ngaysinh = rs.getDate("NgaySinh");
				Boolean gioitinhnam = rs.getBoolean("GioiTinhNam");
				lstSV.add(new SinhVien.Builder(masv, hoten).ngaySinh(ngaysinh).gioiTinhNam(gioitinhnam).build());
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    for(SinhVien sv : lstSV)
	    	System.out.println(sv);
//		@lombok.Builder
//		@lombok.Getter
//		@lombok.Setter
//		public class SinhVien {
//			private String maSinhVien;
//			private String hoTen;
//			private boolean gioiTinhNam;
//			private java.sql.Date ngaySinh;
//			private int maNganhDaoTao; // mã ngành đào tạo
//		}
				
	}
}
