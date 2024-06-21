public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	
	// Bổ sung constructor với đối số là class đó
	public SinhVien(SinhVien x) {
		this.maSinhVien = x.maSinhVien;
		this.hoTen = x.hoTen;
	}

	public SinhVien(String maSinhVien, String hoTen) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
	}
	
	// Bổ sung hàm taoBanSao có dạng
	public SinhVien taoBanSao() {
		return new SinhVien(this);
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

	@Override
	public String toString() {
		return "Sinh viên " + this.getHoTen();				
	}
}