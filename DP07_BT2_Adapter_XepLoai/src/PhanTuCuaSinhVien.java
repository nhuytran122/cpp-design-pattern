import com.peter.dp.SinhVien;

public class PhanTuCuaSinhVien implements PhanTu {
	private SinhVien sv;
	
	public PhanTuCuaSinhVien(SinhVien sv) {
		super();
		this.sv = sv;
	}

	@Override
	public String getXepLoai() {
		double dtb = sv.getDiemTrungBinh();
	    if (dtb >= 8.5)
	        return "A";
	    else if (dtb >= 7)
	        return "B";
	    else if (dtb >= 5.5)
	        return "C";
	    else if (dtb >= 4.0)
	        return "D";
	    else
	        return "X";
	}

	@Override
	public String getTen() {
		return sv.getHoTen();
	}

	@Override
	public String getLoaiDoiTuong() {
		return "SV";
	}

}
