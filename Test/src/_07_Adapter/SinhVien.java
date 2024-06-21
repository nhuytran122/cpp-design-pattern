package _07_Adapter;

public class SinhVien {
	private String msv, hoten;
	double dtb;
	public SinhVien(String msv, String hoten, double dtb) {
		super();
		this.msv = msv;
		this.hoten = hoten;
		this.dtb = dtb;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	
}
