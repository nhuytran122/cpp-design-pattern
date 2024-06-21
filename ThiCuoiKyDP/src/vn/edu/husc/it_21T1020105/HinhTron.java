package vn.edu.husc.it_21T1020105;

public class HinhTron implements Shape {
	private double banKinh;
	
	public HinhTron(double banKinh) {
		super();
		this.banKinh = banKinh;
	}
	public HinhTron(HinhTron c) {
		this.banKinh = c.banKinh;
	}
	
	public double getBanKinh() {
		return banKinh;
	}
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	@Override
	public Shape taoBanSao() {
		return new HinhTron(this);
	}

	@Override
	public double getDienTich() {
		return (3.14 * this.banKinh * this.banKinh);
	}

	@Override
	public String getThongTin() {
		return "Hinh tron co ban kinh " + this.banKinh;
	}

}
