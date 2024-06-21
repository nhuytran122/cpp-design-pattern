package com.nvtrung.baikiemtraso1.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.SimpleAttributeSet;

import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class NguonDuLieuSqlServer implements NguonDuLieu {
	private String chuoiKetNoi;

	public NguonDuLieuSqlServer(String cnnst) {
		this.chuoiKetNoi = cnnst;
	}

	private Connection _cnn = null;

	private Connection getConnection() throws SQLException {
		if (_cnn == null || _cnn.isClosed()) {
			_cnn = DriverManager.getConnection(this.chuoiKetNoi);
		}
		return _cnn;
	}

	@Override
	public List<SinhVien> selectAll() {
		List<SinhVien> lst = new ArrayList<>();

		try {
			// 1. tạo connection
			Connection con = getConnection();

			// 2. Tạo stmt
			Statement stmt = con.createStatement();
			String SQL = "select MaSinhVien, HoTen, GioiTinhNam, NgaySinh from SInhVien";

			// 3. Thực thi stmt --> trả về tập kq
			ResultSet rs = stmt.executeQuery(SQL);

			// 4. Xử lý kq
			while (rs.next()) {
				var maSinhVien = rs.getString(1);
				var hoTen = rs.getString(2);
				var gioiTinhNam = rs.getBoolean(3);
				var ngaySinh = rs.getDate(4);

				var sv = new SinhVien(maSinhVien, hoTen, gioiTinhNam, ngaySinh);

				lst.add(sv);
			}

			// 5. Giải phóng rsc
			rs.close();
//			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void insert(SinhVien sv) {
		try {
			// 1. tạo cnn
			var cnn = getConnection();

			// 2. tạo stmt
			var stmt = cnn.prepareStatement(
					"insert into SinhVien (maSinhVien, HoTen, GIoiTinhNam, NgaySinh) values (?, ?, ?, ?)");
			stmt.setString(1, sv.getMaSinhVien());
			stmt.setString(2, sv.getHoTen());
			stmt.setBoolean(3, sv.isGioiTinhNam());

			java.sql.Date ngaySinh = new java.sql.Date(sv.getNgaySinh().getTime());
			stmt.setDate(4, ngaySinh);
			
			// 3. thực thi insert
			stmt.executeUpdate();
			
			// SQL INJECTION
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			String sql = String.format("INSERT INTO SinhVien (maSinhVien, HoTen, GIoiTinhNam, NgaySinh) VALUES ('%s', '%s', %d, '%s')", 
//					sv.getMaSinhVien(),
//					sv.getHoTen(),
//					sv.isGioiTinhNam()?1:0,
//					sdf2.format(sv.getNgaySinh())
//			);
//			var stmt = cnn.createStatement();
//			stmt.execute(sql);

			// 4. giải phóng tài nguyên
			stmt.close();
//			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String maSinhVien) {
		try {
			// 1. tạo cnn
			var cnn = getConnection();

			// 2. tạo stmt
			var stmt = cnn.prepareStatement(
					"delete SinhVien where MaSinhVien = ?");
			stmt.setString(1, maSinhVien);

			// 3. thực thi insert
			stmt.executeUpdate();
			
			// 4. giải phóng tài nguyên
			stmt.close();
//			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
