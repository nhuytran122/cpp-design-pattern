package _07_Adapter;

import java.util.Date;

class CongNhan {
	private String hoten;
	private Date ngaybatdau;
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongNhan(String hoten, Date ngaybatdau) {
		super();
		this.hoten = hoten;
		this.ngaybatdau = ngaybatdau;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	
}
