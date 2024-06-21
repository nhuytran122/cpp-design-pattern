package com.peter.dp;

import java.util.Date;

public class CongNhan {
	private String hoTen;
	private Date ngayBatDauLamViec;
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongNhan(String hoTen, Date ngayBatDauLamViec) {
		super();
		this.hoTen = hoTen;
		this.ngayBatDauLamViec = ngayBatDauLamViec;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgayBatDauLamViec() {
		return ngayBatDauLamViec;
	}
	public void setNgayBatDauLamViec(Date ngayBatDauLamViec) {
		this.ngayBatDauLamViec = ngayBatDauLamViec;
	}
	@Override
	public String toString() {
		return "CongNhan [hoTen=" + hoTen + ", ngayBatDauLamViec=" + ngayBatDauLamViec + "]";
	}
	
}
