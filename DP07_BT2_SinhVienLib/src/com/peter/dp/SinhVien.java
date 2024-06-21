package com.peter.dp;

public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private double diemTrungBinh;

	
	public SinhVien() {
		super();
	}

	public SinhVien(String maSinhVien, String hoTen, double diemTrungBinh) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.diemTrungBinh = diemTrungBinh;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", diemTrungBinh=" + diemTrungBinh + "]";
	}
	
	

}