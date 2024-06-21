package com.nvtrung.baikiemtraso1.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class NguonDuLieuVanBan implements NguonDuLieu {
	private String filename;

	public NguonDuLieuVanBan(String filename) {
		this.filename = filename;
	}

	private Date convertToDate(String stDMY) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date kq = null;
		try {
			kq = sdf.parse(stDMY);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public List<SinhVien> selectAll() {
		ArrayList<SinhVien> lst = new ArrayList<SinhVien>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(this.filename));

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				String[] info = line.split("\\,");

				if (info.length != 4)
					continue;

				String maSinhVien = info[0];
				String hoTen = info[1];
				boolean gioiTinhNam = info[2].equalsIgnoreCase("true");
				Date ngaySinh = convertToDate(info[3]);

				SinhVien sv = new SinhVien(maSinhVien, hoTen, gioiTinhNam, ngaySinh);
				lst.add(sv);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public void insert(SinhVien sv) {
		try {
			// mở file ở chế độ APPEND
			FileWriter fw = new FileWriter(this.filename, true);
			BufferedWriter bw = new BufferedWriter(fw);

			// ghi dòng tương ứng sv
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String stNewSV = String.format("\n%s,%s,%s,%s", //
					sv.getMaSinhVien(), //
					sv.getHoTen(), //
					sv.isGioiTinhNam(), //
					(sv.getNgaySinh() == null) ? "01/01/1900" : sdf.format(sv.getNgaySinh())//
			);
			bw.write(stNewSV);

			// đóng file lại
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String maSinhVien) {
		// Đọc danh sách SinhVien
		var lst = selectAll();

		// CÁCH XOÁ 1 PHẦN TỬ
//		// Tìm vị trí trong danh sách mà trùng với maSinhVien...
//		int viTri = -1;
//		for (int i = 0; i < lst.size(); i++)
//			if (lst.get(i).getMaSinhVien().equalsIgnoreCase(maSinhVien)) {
//				viTri = i;
//				break;
//			}
//
//		// ...remove phần tử tại vị trí {viTri}
//		if (viTri != -1)
//			lst.remove(viTri);

		// XOÁ NHIỀU PHẦN TỬ
//		var lstViTri = new ArrayList<Integer>();
//		for (int i = 0; i < lst.size(); i++)
//			if (lst.get(i).getMaSinhVien().equalsIgnoreCase(maSinhVien))
//				lstViTri.add(i);
//
//		for (int i = lstViTri.size() - 1; i >= 0; i--)
//			lst.remove((int)lstViTri.get(i)); // int       Integer
		
		var lstSVtoDel = new ArrayList<SinhVien>();
		for (SinhVien x: lst)
			if (x.getMaSinhVien().equalsIgnoreCase(maSinhVien))
				lstSVtoDel.add(x);
		
		for (SinhVien x: lstSVtoDel)
			lst.remove(x);
		
		// lst.removeIf(x->x.getMaSinhVien().equalsIgnoreCase(maSinhVien));

		// Ghi lst vào file
		// - Mở file ở chế độ ghi đè
		// - foreach sv
		// write dòng sv vào file
		// - Đóng file lại
		try {
			// mở file ở chế độ OVERWRITE
			FileWriter fw = new FileWriter(this.filename, false);
			BufferedWriter bw = new BufferedWriter(fw);

			// ghi dòng tương ứng sv
			boolean laDongDauTien = true;
			for (SinhVien sv : lst) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String stNewSV = String.format("%s,%s,%s,%s", //
						sv.getMaSinhVien(), //
						sv.getHoTen(), //
						sv.isGioiTinhNam(), //
						(sv.getNgaySinh() == null) ? "01/01/1900" : sdf.format(sv.getNgaySinh())//
				);
				if (laDongDauTien)
					laDongDauTien = false;
				else
					stNewSV = "\n" + stNewSV;

				bw.write(stNewSV);
			}

			// đóng file lại
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
