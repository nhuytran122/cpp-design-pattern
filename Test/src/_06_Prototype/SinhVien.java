package _06_Prototype;

public class SinhVien {
	private String msv;
	private String hoten;
	public SinhVien(String msv, String hoten) {
		super();
		this.msv = msv;
		this.hoten = hoten;
	}
	
	public SinhVien(SinhVien sv) {
		this.msv = sv.msv;
		this.hoten = sv.hoten;
	}
	
	public SinhVien taoBanSao() {
		return new SinhVien(this);
	}
}
