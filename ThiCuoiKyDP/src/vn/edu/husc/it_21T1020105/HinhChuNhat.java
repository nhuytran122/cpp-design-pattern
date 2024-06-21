package vn.edu.husc.it_21T1020105;

public class HinhChuNhat implements Shape {
	private double chieuDai;
	private double chieuRong;
	
	public HinhChuNhat(double chieuDai, double chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public HinhChuNhat(HinhChuNhat hcn) {
		this.chieuDai = hcn.chieuDai;
		this.chieuRong = hcn.chieuRong;
	}
	
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	@Override
	public Shape taoBanSao() {
		return new HinhChuNhat(this);
	}

	@Override
	public double getDienTich() {
		return this.chieuDai * this.chieuRong;
	}

	@Override
	public String getThongTin() {
		return "Hinh chu nhat co kich thuoc " + this.chieuDai + "x" + this.chieuRong; 
	}

}