// Đối với những class kế thừa class này thì phải thực hiện hai việc
public class SinhVienNuocNgoai extends SinhVien {
	private String quocGia; // thêm thuộc tính mới

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String qg) {
		this.quocGia = qg;
	}
	
	// Tạo constructor với đối số là class con
	public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
		super(x); // // gọi hàm này để khởi tạo các th.tính ở lớp cha
		this.quocGia = x.quocGia; // gán thêm th.tính mới, chỉ có ở lớp con
	}

	// Override hàm taoBanSao
	@Override
	public SinhVien taoBanSao() {
		return new SinhVienNuocNgoai(this);
	}

	public SinhVienNuocNgoai(String maSinhVien, String hoTen, String coQuanCongTac) {
		super(maSinhVien, hoTen);
		this.quocGia = coQuanCongTac;
	}

	@Override
	public String toString() {
		return "Sinh viên NUOC NGOAI " + this.getHoTen() + " có quốc tịch = " + this.getQuocGia();
	}
}