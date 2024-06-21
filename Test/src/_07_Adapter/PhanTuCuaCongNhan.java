package _07_Adapter;

import java.util.Date;

public class PhanTuCuaCongNhan implements PhanTu {
	private CongNhan cn;
	
	public PhanTuCuaCongNhan(CongNhan cn) {
		super();
		this.cn = cn;
	}

	@Override
	public String getTen() {
		
		return cn.getHoten();
	}

	@Override
	public String getLoai() {
		return "CN";
	}

	@Override
	public String getDoUuTien() {
		Date tmp = new Date();
		int kinhNghiem = tmp.getYear() - cn.getNgaybatdau().getYear();
		if(kinhNghiem > 20) return "A";
		else if(kinhNghiem > 10) return "B";
		else if(kinhNghiem > 5) return "C";
		else if(kinhNghiem > 1) return "D";
		else return "X";
	}

}
