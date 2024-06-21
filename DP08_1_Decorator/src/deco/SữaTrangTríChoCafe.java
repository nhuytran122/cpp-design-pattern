package deco;

import component.Cafe;

public class SữaTrangTríChoCafe extends TrangTríChoCafe {

	@Override
	public String getMôTả() {
		return this.cafe.getMôTả() + " + sữa";
	}

	@Override
	public double getGiá() {
		return this.cafe.getGiá() + 2000;
	}

	public SữaTrangTríChoCafe(Cafe cafe) throws Exception {
//		boolean daTrangTriSua = false;
//		Cafe x = cafe;
//		while (true) {
//			if (x instanceof TrangTríChoCafe) {
//				if (x instanceof SữaTrangTríChoCafe)
//					daTrangTriSua = true;
//				x = ((TrangTríChoCafe) x).cafe;
//			}
//			else
//				break;
//		}
//		if (daTrangTriSua)
//			throw new Exception("Không được thêm sữa 2 lần");
		this.cafe = cafe;
	}

}
