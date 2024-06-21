package _21T1020105_service;

import java.util.List;

import _21T1020105_model.SinhVien;

public interface SinhVienRepo {
	List<SinhVien> selectAll();

	void insert(SinhVien sv);

	void delete(String maSinhVien);
}