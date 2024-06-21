package com.nvtrung.baixe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nvtrung.baixe.models.VeXe;
import com.nvtrung.baixe.models.VeXeDap;
import com.nvtrung.baixe.models.VeXeMay;
import com.nvtrung.baixe.models.VeXeOto;

public class ChuongTrinh {
	static SimpleDateFormat sdf = new SimpleDateFormat("H:mm dd/mm/yyyy");

	static void test() {
		String hoTen = "Nguyễn Văn Trung"; //
		String st = "Nguyễn Văn Trung";

		if (hoTen == st) // so sánh nội dung vùng nhớ mà hoTen và st đang trỏ đến
			System.out.println("Bằng nhau");
		else
			System.out.println("Khác nhau");
	}

	static Date convert(String st) {
		Date result = null;
		try {
			result = sdf.parse(st);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	static List<VeXe> đọcThôngTinVàoBãi(String filename) throws IOException {
		var lst = new ArrayList<VeXe>();

		BufferedReader br = null;
		br = new BufferedReader(new FileReader(filename));

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			// phân tích line --> tạo ra dữ liệu thôngTinXe
			// Loại xe;Biển số xe;Số vé xe;Thời gian vào bãi;Tình trạng vào
			var info = line.split(";");
			var loạiXe = info[0];
			var biểnSố = info[1];
			var sốVé = info[2];
			var thoiDiemVao = convert(info[3]);
			var tìnhTrạngKhiVào = info[4];

			if (loạiXe.equals(VeXe.XE_DAP)) {
				var x = new VeXeDap();
				x.setThoiDiemVao(thoiDiemVao);
				x.setSoVe(sốVé);
				lst.add(x);
			} else if (loạiXe.equals(VeXe.XE_MAY)) {
				var x = new VeXeMay();
				x.setBiểnSố(biểnSố);
				x.setThoiDiemVao(thoiDiemVao);
				lst.add(x);
			} else if (loạiXe.equals(VeXe.XE_OTO)) {
				var x = new VeXeOto();
				x.setBiểnSố(biểnSố);
				x.setThoiDiemVao(thoiDiemVao);
				x.setTìnhTrạngKhiVào(tìnhTrạngKhiVào);
				lst.add(x);
			}
		}

		br.close();

		return lst;
	}

	static void cậpNhậtThôngTinXeRaBãi(String filename, List<VeXe> lst) throws IOException {

		BufferedReader br = null;
		br = new BufferedReader(new FileReader(filename));

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			// phân tích line --> tạo ra dữ liệu thôngTinXe
			// Loại xe; Biển số xe; Số vé xe; Thời gian ra bãi; Tình trạng ra
			var info = line.split(";");
			var loạiXe = info[0];
			var biểnSố = info[1];
			var sốVé = info[2];
			var thoiDiemRa = convert(info[3]);
			var tìnhTrạngKhiRa = info[4];

			// Tìm xe (loạiXe + biểnSố/Vé) trong lst ==> obj
			// cập nhật obj.setThoiDiemRa, obj.setTìnhTrạngKhiRa
			var key = loạiXe + ";" + biểnSố + ";" + sốVé;
			VeXe obj = null;
			for (var x : lst)
				if (x.getKey().equals(key)) {
					obj = x;
					break;
				}

			if (obj != null) {
				obj.setThoiDiemRa(thoiDiemRa);
				if (loạiXe.equals(VeXe.XE_OTO)) {
					((VeXeOto) obj).setTìnhTrạngKhiRa(tìnhTrạngKhiRa);
				}
			}

		}

		br.close();
	}

	static void inGiáGiữXe(List<VeXe> lst) {
		int stt = 0;
		// STT Thời điểm vào Xe Loại xe Tt1 Thời điểm ra Tt2 Giá
		System.out.printf("%-3s %-18s %-12s %-10s %-30s %18s %-30s  %-10s\n", //
				"STT", //
				"Thời điểm vào", //
				"Xe", //
				"Loại xe", //
				"Tình trạng 1", //
				"Thời điểm ra", //
				"Tình trạng 2", //
				"Giá"//
		);
		for (VeXe x : lst) {
			if (x.getThoiDiemRa() != null) {
				stt++;

				System.out.printf("%-3d %-18s %-12s %-10s %-30s %-18s %-30s %10.0f\n", //
						stt, //
						sdf.format(x.getThoiDiemVao()), //
						x.getBiểnSốHoặcSốVé(), //
						x.getTênLoạiXe(), //
						x.getTìnhTrạng1(), //
						sdf.format(x.getThoiDiemRa()), //
						x.getTìnhTrạng2(), //
						x.getGiáGiữXe()//
				);
			}
		}
	}

	static void inThôngTinXeCònTrongBãi(List<VeXe> lst) {
		int stt = 0;
		// STT Thời điểm vào Xe Loại xe Tình trạng
		System.out.printf("%-3s %-18s %-12s %-10s %-30s\n", //
				"STT", //
				"Thời điểm vào", //
				"Xe", //
				"Loại xe", //
				"Tình trạng"//
		);
		for (VeXe x : lst) {
			if (x.getThoiDiemRa() == null) {
				stt++;

				System.out.printf("%-3d %-18s %-12s %-10s %-30s\n", //
						stt, //
						sdf.format(x.getThoiDiemVao()), //
						x.getBiểnSốHoặcSốVé(), //
						x.getTênLoạiXe(), //
						x.getTìnhTrạng1()//
				);
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		test();

		var lst = đọcThôngTinVàoBãi("vao.txt");

		cậpNhậtThôngTinXeRaBãi("ra.txt", lst);

		inGiáGiữXe(lst);

		inThôngTinXeCònTrongBãi(lst);
	}

}
