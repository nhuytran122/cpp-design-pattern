package _06_Prototype;

public class SinhVienNuocNgoai extends SinhVien {
	private String quoctich;

	public SinhVienNuocNgoai(SinhVienNuocNgoai sv) {
		super(sv);
		this.quoctich = sv.quoctich;
		// TODO Auto-generated constructor stub
	}

	public SinhVienNuocNgoai(String msv, String hoten) {
		super(msv, hoten);
		// TODO Auto-generated constructor stub
	}
	@Override 
	public SinhVien taoBanSao() {
		return new SinhVienNuocNgoai(this);
	}
	

}
