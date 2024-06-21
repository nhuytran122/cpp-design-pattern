package _07_Adapter;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		List<PhanTu> lst = new ArrayList<>();
		List<SinhVien> sv = SinhVienReader.loadFromFile("sv.txt");
		List<CongNhan> cn = CongNhanReader.loadFromFile("cn.txt");
		
		for(SinhVien svt : sv)
			lst.add(new PhanTuCuaSinhVien(svt));
		for(CongNhan cnt : cn)
			lst.add(new PhanTuCuaCongNhan(cnt));
		
		for(int i = 0; i < lst.size()-1; i++) {
			for(int j = i+1; j < lst.size(); j++) {
				if((lst.get(i).getDoUuTien()).compareTo(lst.get(j).getDoUuTien())  > 0) {
					PhanTu tmp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, tmp);
				}
			}
		}
		inDanhSach(lst);
		
	}
	
	private static void inDanhSach(List<PhanTu> lst) {
		for (int i = 0; i < lst.size(); i++) {
			var tmp = lst.get(i);
			System.out.printf("%5s %30s %8s %s\n", //
					i+1, //
					tmp.getTen(), //
					tmp.getLoai(), //
					tmp.getDoUuTien());//
		}
	}

}


