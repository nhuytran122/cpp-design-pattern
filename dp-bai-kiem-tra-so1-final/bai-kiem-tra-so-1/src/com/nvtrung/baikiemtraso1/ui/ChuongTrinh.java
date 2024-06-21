package com.nvtrung.baikiemtraso1.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nvtrung.baikiemtraso1.implement.NguonDuLieuSqlServer;
import com.nvtrung.baikiemtraso1.implement.NguonDuLieuVanBan;
import com.nvtrung.baikiemtraso1.model.CauHinh;
import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class ChuongTrinh {

	static void test() {
		String st = "a,b,ccc,def";
		var info = st.split("\\,");
		for (var x: info)
			System.out.printf("[%s]\n", x);
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

	static Date dmyToDate(String dmy) {
		try {
			return sdf.parse(dmy);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static CauHinh docCauHinhTuFile() throws IOException {
		var ch = new CauHinh();
		var br = new BufferedReader(new FileReader("config.txt"));
		String loaiNguon = br.readLine();
		ch.setLoaiNguon(loaiNguon);
		String chuoiKetNoi = br.readLine();
		ch.setChuoiKetNoi(chuoiKetNoi);
		br.close();
		
		return ch;
	}

	public static void main(String[] args) throws IOException {
//		test();
//		if (1==1) return;
		
		var ch = docCauHinhTuFile();
		
		NguonDuLieu ndl;
		if (ch.getLoaiNguon().equals(CauHinh.LOAI_TEXT_FILE))
			ndl = new NguonDuLieuVanBan(ch.getChuoiKetNoi());
		else
			ndl = new NguonDuLieuSqlServer(ch.getChuoiKetNoi());

		// 1. Đọc & in danh sách sv
		var lst = ndl.selectAll();
		System.out.println("Danh sách các sinh viên đọc được");
		inDanhSach(lst);

		// 2. Insert sv vào nguồn dữ liệu
		SinhVien nvtrung = new SinhVien();
		nvtrung.setMaSinhVien("1234");
		nvtrung.setHoTen("Nguyễn Thị Hoa Hồng 2");
		nvtrung.setGioiTinhNam(false);
		nvtrung.setNgaySinh(dmyToDate("1/4/1995"));

		ndl.insert(nvtrung);
		System.out.println("\n\nDanh sách sinh viên sau khi insert");
		lst = ndl.selectAll();
		inDanhSach(lst);

		// 3. Xoá sinh viên khỏi nguồn dữ liệu
		ndl.delete("sv1");
		System.out.println("\n\nDanh sách sinh viên sau khi delete");
		lst = ndl.selectAll();
		inDanhSach(lst);
	}

	/**
	 * In danh sách sinh viên trong danh sách lst ra màn hình
	 * 
	 * @param lst
	 */
	private static void inDanhSach(List<SinhVien> lst) {
		for (int i = 0; i < lst.size(); i++) {
			var sv = lst.get(i);
			System.out.printf("%5s %30s %8s %s\n", //
					sv.getMaSinhVien(), //
					sv.getHoTen(), //
					sv.isGioiTinhNam(), //
					sdf.format(sv.getNgaySinh()));//
		}
	}

}
