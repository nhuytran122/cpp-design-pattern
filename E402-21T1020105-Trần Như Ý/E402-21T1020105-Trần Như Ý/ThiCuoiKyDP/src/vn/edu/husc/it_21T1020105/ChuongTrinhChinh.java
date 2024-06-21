package vn.edu.husc.it_21T1020105;

import java.util.ArrayList;
import java.util.List;

public class ChuongTrinhChinh {

	public static void main(String[] args) {
		//cau 1:
		List<Shape> lst = cau1.docDanhSach();
		
		//cau 2:
		System.out.println("\t\nDanh sách các đối tượng trong lst: ");
		inDs(lst);
		
		//cau 3:
		List<Shape> lst2 = new ArrayList<Shape>();
		for(Shape x : lst)
			lst2.add(x.taoBanSao());
		
		//cau 4:
		//4.1
		for(Shape x : lst2) {
			if(x instanceof HinhTron) {
				HinhTron tmp = (HinhTron)x;
				tmp.setBanKinh(tmp.getBanKinh() + 1);
			}
			else {
				HinhChuNhat tmp = (HinhChuNhat)x;
				// Tăng 2 đơn vị cho chiều dài của hình chữ nhật
				tmp.setChieuDai(tmp.getChieuDai() + 2);
				// hoặc: Tăng 2 đơn vị cho chiều rộng của hình chữ nhật
				// tmp.setChieuRong(tmp.getChieuRong() + 2);
			}
		}
		
		//4.2 
		System.out.println("\t\nDanh sách các đối tượng trong lst2: ");
		inDs(lst2);
		
		//4.3
		System.out.println("\t\nDanh sách các đối tượng trong lst: ");
		inDs(lst);
	}
		
	
	private static void inDs(List<Shape> lst) {
		int i = 1;
		System.out.println("STT \tThông tin ngắn gọn \t\t\t\tDiện tích");
		System.out.println("------------------------------------------------------------------");
		for(Shape x : lst) {
			if(x instanceof HinhTron) 
				System.out.println(i + "\t" + x.getThongTin() + "\t\t\t" + x.getDienTich());
			else
				System.out.println(i + "\t" + x.getThongTin() + "\t\t" + x.getDienTich());
			i++;
		}
	}
}
