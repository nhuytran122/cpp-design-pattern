package _21T1020105_implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import _21T1020105_model.SinhVien;
import _21T1020105_service.SinhVienRepo;

public class SinhVienRepoTXT implements SinhVienRepo {
	private String chuoiKetNoi;

	public SinhVienRepoTXT(String filename) {
		this.chuoiKetNoi = filename;
	}

	private Date convertToDate(String stDMY) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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
		
		ArrayList<SinhVien> lstSV = new ArrayList<SinhVien>();
		try{
		     FileReader f = new FileReader(this.chuoiKetNoi);
		     BufferedReader b = new BufferedReader(f);
		     while(true){
		          String st = b.readLine();
		          if(st == null || st == "") break;
		          String[] tt = st.split(",");
		          lstSV.add(new SinhVien(tt[0], tt[1], Boolean.parseBoolean(tt[2]), convertToDate(tt[3])));
		     }
		     b.close();
		} catch(Exception e) {
		     e.printStackTrace();
		}
		return lstSV;
	}

	@Override
	public void insert(SinhVien sv) {
		try {
			// mở file ở chế độ APPEND
			FileWriter fw = new FileWriter(this.chuoiKetNoi, true);
			BufferedWriter bw = new BufferedWriter(fw);

			// ghi dòng tương ứng sv
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String stNewSV = String.format("%s,%s,%s,%s\n", //
					sv.getMaSinhVien(), //
					sv.getHoTen(), //
					sv.isGioiTinhNam(), //
					sdf.format(sv.getNgaySinh())//
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
		
		// Tìm vị trí trong danh sách mà trùng với maSinhVien
		int viTri = -1;
		for (int i = 0; i < lst.size(); i++)
			if (lst.get(i).getMaSinhVien().equals(maSinhVien)) {
				viTri = i;
				break;
			}
		
		if (viTri != -1)
			lst.remove(viTri);
		
		// Ghi toàn bộ danh sách này vào file
		// - Mở file ở chế độ ghi đè
		// - foreach sv
		// 		write dòng sv vào file
		// - Đóng file lại
		try {
			FileWriter w = new FileWriter(this.chuoiKetNoi);
	        PrintWriter ghi = new PrintWriter(w);
	        for (var sv : lst) {
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				String stNewSV = String.format("%s,%s,%s,%s\n", //
						sv.getMaSinhVien(), //
						sv.getHoTen(), //
						sv.isGioiTinhNam(), //
						sdf.format(sv.getNgaySinh())//
				);
				ghi.write(stNewSV);
	        }
	        ghi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}