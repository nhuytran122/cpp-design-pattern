import java.util.Date;
import java.util.List;

public class SinhVien {
	private String masv;
	private String hoten;
	boolean gioitinhnam;
	private Date ngaysinh;
	public static List<SinhVien> cacheLstSV;
	
	public SinhVien(String masv, String hoten, boolean gioitinhnam, Date ngaysinh) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.gioitinhnam = gioitinhnam;
		this.ngaysinh = ngaysinh;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public boolean isGioitinhnam() {
		return gioitinhnam;
	}
	public void setGioitinhnam(boolean gioitinhnam) {
		this.gioitinhnam = gioitinhnam;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", hoten=" + hoten + ", gioitinhnam=" + gioitinhnam + ", ngaysinh=" + ngaysinh
				+ "]";
	}
	
	
}
