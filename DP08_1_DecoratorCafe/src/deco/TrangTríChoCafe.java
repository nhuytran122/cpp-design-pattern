package deco;

import component.Cafe;

public abstract class TrangTríChoCafe extends Cafe { // IS-A

	protected Cafe cafe; // HAS-A

	public Cafe getCafe() {
		return this.cafe;
	}

	@Override
	public abstract String getMôTả();
	
	// chưa implement getGiá()
	// --> các lớp kế thừa TrangTríChoCafe PHẢI implement
	// hàm này
}
