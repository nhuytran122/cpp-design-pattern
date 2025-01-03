import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XuLyData {
	public List<SinhVien> selectAll(){
		if(SinhVien.cacheLstSV == null) {
			SinhVien.cacheLstSV = new ArrayList<>();
			try {
				Connection con = DbHelper.getInstance().getConnection();
				System.out.println("CONNECTING 1");
				String sql = "select * from SinhVien";
				PreparedStatement cmd = con.prepareStatement(sql);
				ResultSet rs = cmd.executeQuery();
				while(rs.next()) {
					String masv = rs.getString("MaSinhVien");
					String hoten = rs.getString("HoTen");
					boolean gtnam = rs.getBoolean("GioiTinhNam");
					Date ngaysinh = rs.getDate("NgaySinh");
					SinhVien sv = new SinhVien(masv, hoten, gtnam, ngaysinh);
					SinhVien.cacheLstSV.add(sv);
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SinhVien.cacheLstSV;
	}
	
	public void insertSV(SinhVien sv) {
		try {
			Connection con = DbHelper.getInstance().getConnection();
			System.out.println("CONNECTING 2");
			String sql = "insert into SinhVien(MaSinhVien, HoTen, GioiTinhNam, NgaySinh) values (?,?,?,?)";
			PreparedStatement cmd = con.prepareStatement(sql);
			cmd.setString(1, sv.getMasv());
			cmd.setString(2, sv.getHoten());
			cmd.setBoolean(3, sv.isGioitinhnam());
			cmd.setDate(4, new java.sql.Date(sv.getNgaysinh().getTime()));
			cmd.executeUpdate();
			SinhVien.cacheLstSV.add(sv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
