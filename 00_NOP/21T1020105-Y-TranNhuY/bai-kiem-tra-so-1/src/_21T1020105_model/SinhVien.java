package _21T1020105_model;

import java.util.Date;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private Date ngaySinh;
}