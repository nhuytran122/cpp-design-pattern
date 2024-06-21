//@lombok.Builder

import java.util.Date;
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private Date ngaySinh;
	private boolean gioiTinhNam;
	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinhNam="
				+ gioiTinhNam + "]";
	}
	
	public static class Builder{
		private String maSinhVien;
		private String hoTen;
		private Date ngaySinh;
		private boolean gioiTinhNam;
		
		public Builder(String maSinhVien, String hoTen) {
			this.maSinhVien = maSinhVien;
			this.hoTen = hoTen;
		}
		
		Builder ngaySinh(Date value) {
			this.ngaySinh = value;
			return this;
		}
		
		Builder gioiTinhNam(boolean value) {
			this.gioiTinhNam = value;
			return this;
		}
		
		public SinhVien build() {
			return new SinhVien(this);
		}
	}
	
	private SinhVien(Builder b) {
		this.maSinhVien = b.maSinhVien;
		this.hoTen = b.hoTen;
		this.ngaySinh = b.ngaySinh;
		this.gioiTinhNam = b.gioiTinhNam;
	}
	

	
	
}