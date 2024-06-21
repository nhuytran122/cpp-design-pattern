package com.nvtrung.quanlybaixe4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nvtrung.quanlybaixe4.models.VeXe;

public class ChuongTrinh {
	static SimpleDateFormat sdf = new SimpleDateFormat("H:mm dd/MM/yyyy");

	static Date convert(String st) {
		try {
			Date kq;
			kq = sdf.parse(st);
			return kq;
		} catch (ParseException e) {
			return null;
		}
	}

	static List<VeXe> đọcThôngTinVàoBãi(String filename) throws IOException {
		var lst = new ArrayList<VeXe>();

		var br = new BufferedReader(new FileReader(filename));
		while (true) {
			var line = br.readLine();
			if (line == null)
				break;

			// Loại xe; Biển số xe; Số vé xe; Thời gian vào bãi; Tình trạng xe lúc vào bãi
			var info = line.split(";");
			var loạiXe = info[0];
			var biểnSố = info[1];
			var sốVé = info[2];
			var stThờiGianVàoBãi = info[3];
			var tìnhTrạngLúcVào = info[4];

			var x = new VeXe();
			x.setLoạiXe(loạiXe);
			x.setBiểnSố(biểnSố);
			x.setSốVé(sốVé);
			x.setThờiĐiểmVào(convert(stThờiGianVàoBãi));

			x.setTìnhTrạngKhiVào(tìnhTrạngLúcVào);

			lst.add(x);
		}
		br.close();
		return lst;
	}

	static void cậpNhậtThôngTinXeRaBãi(String filename, List<VeXe> lst) throws IOException {
		var br = new BufferedReader(new FileReader(filename));
		while (true) {
			var line = br.readLine();
			if (line == null)
				break;

			// Loại xe; Biển số xe; Số vé xe; Thời gian ra bãi; Tình trạng xe lúc ra bãi
			var info = line.split(";");
			var loạiXe = info[0];
			var biểnSố = info[1];
			var sốVé = info[2];
			var stThờiGianRaBãi = info[3];
			var tìnhTrạngLúcRa = info[4];

			// tìm xe tương ứng trong lst khớp với (loạiXe, biểnSố/sốVé)
			// cập nhật thờiĐiểmRa & tìnhTrạngLúcRa cho nó
			var key = String.format("%s;%s;%s", loạiXe, biểnSố, sốVé);
			VeXe obj = null;
			for (VeXe x : lst)
				if (x.getKey().equals(key)) {
					obj = x;
					break;
				}

			if (obj != null) {
				obj.setThờiĐiểmRa(convert(stThờiGianRaBãi));
				obj.setTìnhTrạngKhiRa(tìnhTrạngLúcRa);
			}
		}
		br.close();
	}

	static void inGiáGiữXe(List<VeXe> lst) {
		int stt = 0;
		// STT - Thời điểm vào - Xe - Loại xe - Tt1 - Thời điểm ra - Tt2 - Giá
		for (VeXe x : lst) {
			if (x.getThờiĐiểmRa() != null) {
				stt++;
				System.out.printf("%d %18s %15s %10s %30s %18s %30s %7f\n", //
						stt, //
						sdf.format(x.getThờiĐiểmVào()), //
						x.getBiểnSốHoặcSốVé(), //
						x.getTênLoạiXe(), //
						x.getTìnhTrạng1(), //
						sdf.format(x.getThờiĐiểmRa()), //
						x.getTìnhTrạng2(), //
						x.getGiá() //
				);
			}
		}

	}

	static void inThôngTinXeCònTrongBãi(List<VeXe> lst) {
		int stt = 0;
		// STT - Thời điểm vào - Xe - Loại xe - Tt1 - Thời điểm ra - Tt2 - Giá
		for (VeXe x : lst) {
			if (x.getThờiĐiểmRa() == null) {
				stt++;
				System.out.printf("%d %18s %15s %10s %30s\n", //
						stt, //
						sdf.format(x.getThờiĐiểmVào()), //
						x.getBiểnSốHoặcSốVé(), //
						x.getTênLoạiXe(), //
						x.getTìnhTrạng1()//
				);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		var lst = đọcThôngTinVàoBãi("vao.txt");

		cậpNhậtThôngTinXeRaBãi("ra.txt", lst);

		System.out.println("Thông tin giá giữ xe");
		inGiáGiữXe(lst);

		System.out.println("\n\nThông tin xe còn trong bãi");
		inThôngTinXeCònTrongBãi(lst);
	}

}
