package _21T1020105_ui;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import _21T1020105_implement.SinhVienRepoFactory;
import _21T1020105_model.CauHinh;
import _21T1020105_model.SinhVien;
import _21T1020105_service.SinhVienRepo;

public class ChuongTrinh {
	static SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) throws IOException {
		// Đọc cấu hình từ file config.txt
        CauHinh cfg = CauHinh.getInstance();

        SinhVienRepo repo = (new SinhVienRepoFactory()).createSinhVienRepo(cfg);
        
		// 1. Đọc & in danh sách sv
		var lst = repo.selectAll();
		System.out.println("Danh sách các sinh viên đọc được");
		inDanhSach(lst);

		// 2. Insert sv vào nguồn dữ liệu
		SinhVien svMoi = new SinhVien();
		svMoi.setMaSinhVien("21T1020123");
		svMoi.setHoTen("Nguyen Nhu Quynh");
		svMoi.setGioiTinhNam(false);
		try {
			svMoi.setNgaySinh(d.parse("12/06/2003"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		repo.insert(svMoi);
		System.out.println("\nDanh sách sinh viên sau khi insert");
		lst = repo.selectAll();
		inDanhSach(lst);

		// 3. Xoá sinh viên khỏi nguồn dữ liệu
		repo.delete("21T1020123");
		System.out.println("\nDanh sách sinh viên sau khi xóa");
		lst = repo.selectAll();
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
					d.format(sv.getNgaySinh()));//
		}
	}
}