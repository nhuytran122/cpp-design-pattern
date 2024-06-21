import java.util.Date;

import com.peter.dp.CongNhan;

public class PhanTuCuaCongNhan implements PhanTu {
	private CongNhan cn;
	
	public PhanTuCuaCongNhan(CongNhan cn) {
		super();
		this.cn = cn;
	}

	@Override
	public String getXepLoai() {
		Date now = new Date();
        Date startDate = (Date) cn.getNgayBatDauLamViec();
        int namKinhNghiem = now.getYear() - startDate.getYear();
		if (namKinhNghiem < 1) {
            return "X";
        } else if (namKinhNghiem >= 1 && namKinhNghiem <= 5) {
            return "D"; 
        } else if (namKinhNghiem <= 10) {
            return "C"; 
        } else if (namKinhNghiem <= 20) {
            return "B";
        } else {
            return "A"; 
        }
	}

	@Override
	public String getTen() {
		return cn.getHoTen();
	}

	@Override
	public String getLoaiDoiTuong() {
		return "CN";
	}

}
