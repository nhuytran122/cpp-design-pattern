package _07_Adapter;

public class PhanTuCuaSinhVien implements PhanTu {
	private SinhVien sv;
	
	
	public PhanTuCuaSinhVien(SinhVien sv) {
		super();
		this.sv = sv;
	}

	@Override
	public String getTen() {
		return sv.getHoten();
	}

	@Override
	public String getLoai() {
		// TODO Auto-generated method stub
		return "SV";
	}

	@Override
	public String getDoUuTien() {
		double dtb = sv.getDtb();
		if(dtb >=8.5) return "A";
		else if(dtb >= 7) return "B";
		else if(dtb >=5.5) return "C";
		else if(dtb >= 4) return "D";
		else return "D";
	}

}
