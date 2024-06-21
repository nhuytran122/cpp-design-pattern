import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChuongTrinh {
	static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");

	static java.util.Date getNgayThang(String st) {
		java.util.Date kq = null;
		try {
			kq = sdf.parse(st);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	static List<ThongTinVe> readThongTinVao(String filename) throws IOException {
		var lst = new ArrayList<ThongTinVe>();

		var br = new BufferedReader(new FileReader(filename));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			// Tách thông tin của line & xử lý
			// Loại xe;Biển số xe;Số vé xe;Thời gian vào bãi;Tình trạng 1
			var info = line.split(";");
			String loaiXe = info[0];
			String bienSo = info[1];
			String soVe = info[2];
			String stThoiDiemVao = info[3];
			java.util.Date thoiDiemVao = getNgayThang(stThoiDiemVao);
			String tinhTrangVao = info[4];
			
			if (loaiXe.equals("0")) {
				var x = new ThongTinVeXeDap();
				x.setSốVé(soVe);
				x.setThoiDiemVao(thoiDiemVao);
				lst.add(x);
			} else if (loaiXe.equals("2")) {
				var x = new ThongTinVeXeMay();
				x.setBiểnSố(bienSo);
				x.setThoiDiemVao(thoiDiemVao);
				lst.add(x);
			} else if (loaiXe.equals("4")) {
				var x = new ThongTinVeOto();
				x.setBiểnSố(bienSo);
				x.setThoiDiemVao(thoiDiemVao);
				x.setTìnhTrạngLúcVào(tinhTrangVao);
				lst.add(x);
			}
		}

		br.close();

		return lst;
	}

	static void updateFromThongTinRa(List<ThongTinVe> lstVao, String filename) throws IOException {
		// đọc thông tin ở file ra.txt
		// với mỗi dòng của file
		// - tìm obj tương ứng trong lst & setThoiDiemRa, setTinhTrangLucRa
		
		var br = new BufferedReader(new FileReader(filename));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			// Tách thông tin của line & xử lý
			// Loại xe;Biển số xe;Số vé xe;Thời gian ra bãi;Tình trạng 2
			var info = line.split(";");
			String loaiXe = info[0];
			String bienSo = info[1];
			String soVe = info[2];
			String stThoiDiemRa = info[3];
			java.util.Date thoiDiemRa = getNgayThang(stThoiDiemRa);
			String tinhTrangRa = info[4];
			
			String key = String.format("%s;%s;%s", loaiXe, bienSo, soVe);
			
			//var obj = tìm phần tử trong lst sao cho x.getKey() == key
			ThongTinVe obj = null;
			for (ThongTinVe x: lstVao)
				if (x.getKey().equals(key)) {
					obj = x;
					break;
				}
			
			if (obj != null) {
				obj.setThoiDiemRa(thoiDiemRa);
				if (loaiXe.equals("4"))
					((ThongTinVeOto)obj).setTìnhTrạngLúcRa(tinhTrangRa);
			}
		}

		br.close();		
	}

	static void hienThiThongTinGiaVe(List<ThongTinVe> lst) {
		System.out.println("\nThông tin giá vé:");
		// in thông tin tiền giữ xe tính được trong lst
		System.out.printf("%4s %15s %15s %15s %20s %15s %20s %5s\n",
				"STT", "TĐ vào", "ID", "Loại xe", "Tình trạng 1", "TĐ ra", "Tình trạng 2", "Giá");
		int stt = 0;
		for (ThongTinVe x : lst) {
			if (x.cóThểTínhGiá()) {
				stt++;
				System.out.printf("%4d %15s %15s %15s %20s %15s %20s %5.0f\n", 
						stt, // 
						sdf.format(x.getThoiDiemVao()), // 
						x.getId(), //
						x.getLoạiXe(), // 
						x.getTìnhTrạng1(), // 
						sdf.format(x.getThoiDiemRa()), //
						x.getTìnhTrạng2(), //
						x.getGiá()
					);
			}
		}

	}

	static void hienThiXeConLai(List<ThongTinVe> lst) {
		System.out.println("\nXe còn lại: ");
		// in thông tin xe còn lại trong lst
		int stt = 0;
		for (ThongTinVe x : lst) {
			if (!x.cóThểTínhGiá()) {
				stt++;
				System.out.printf("%4d %15s %15s %15s %20s\n", stt, sdf.format(x.getThoiDiemVao()), x.getId(), x.getLoạiXe(),
						x.getTìnhTrạng1());
			}
		}
	}

	public static void main(String[] args) throws Exception {
//		test();
		var lstXe = readThongTinVao("vao.txt");

		hienThiXeConLai(lstXe);

		updateFromThongTinRa(lstXe, "ra.txt");

		hienThiThongTinGiaVe(lstXe);

		hienThiXeConLai(lstXe);
	}

	private static void test() {
		Double x;

		x = 3.1415926538;
		x = null;
		x = 0.2;

		System.out.println(Math.ceil(x));

//		double a;
//		a = null;

	}

}
