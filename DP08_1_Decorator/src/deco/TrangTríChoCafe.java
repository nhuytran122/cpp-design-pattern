package deco;

import component.Cafe;

public abstract class TrangTríChoCafe implements Cafe {
	
	protected Cafe cafe;
	
	public Cafe getCafe() {
		return cafe;
	}

	@Override
	public abstract String getMôTả();

	@Override
	public abstract double getGiá();

}
