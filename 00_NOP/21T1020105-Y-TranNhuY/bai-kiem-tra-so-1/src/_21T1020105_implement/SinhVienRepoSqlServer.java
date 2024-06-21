package _21T1020105_implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import _21T1020105_model.DbHelper;
import _21T1020105_model.SinhVien;
import _21T1020105_service.SinhVienRepo;


public class SinhVienRepoSqlServer implements SinhVienRepo {
	private String chuoiKetNoi;

	public SinhVienRepoSqlServer(String cnnst) {
		this.chuoiKetNoi = cnnst;
	}

	@Override
	public List<SinhVien> selectAll() {
		List<SinhVien> lstSV = new ArrayList<>();
	    try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "SELECT * FROM SinhVien";
	        PreparedStatement stm = con.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	        	String masv = rs.getString("MaSinhVien");
				String hoten = rs.getString("HoTen");
				Date ngaysinh = rs.getDate("NgaySinh");
				Boolean gioitinhnam = rs.getBoolean("GioiTinhNam");
				lstSV.add(new SinhVien(masv, hoten, gioitinhnam, ngaysinh));
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return lstSV;
	}

	@Override
	public void insert(SinhVien sv) {
		try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setString(1, sv.getMaSinhVien());
	        stm.setString(2, sv.getHoTen());
	        stm.setBoolean(3, sv.isGioiTinhNam());
	        stm.setDate(4, new java.sql.Date(sv.getNgaySinh().getTime()));
	        stm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(String maSinhVien) {
		try {
	    	Connection con = DbHelper.getInstance().getConnection();
	    	String sql = "DELETE FROM SinhVien WHERE MaSinhVien = ?";
	        PreparedStatement stm = con.prepareStatement(sql);
	        stm.setString(1, maSinhVien);
	        stm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}