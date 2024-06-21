@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class ThongTinVeOto extends ThongTinVe {
	private String tìnhTrạngLúcVào;
	private String tìnhTrạngLúcRa;
	private String biểnSố;
	
	@Override
	double getGiá() {
		double totalMs = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		double totalMsPerNuaGio = 30 * 60 * 1000;
		return Math.ceil(totalMs / totalMsPerNuaGio) * 5000;
	}

	@Override
	boolean cóThểTínhGiá() {
		if (this.getThoiDiemRa() == null)
			return false;
		
		if (this.getTìnhTrạngLúcVào() != this.getTìnhTrạngLúcRa())
			return false;
		
		return true;
	}

	@Override
	String getKey() {
		return String.format("%d;%s;%s", 4, this.getBiểnSố(), "Not Available");
	}

	@Override
	String getId() {
		return this.getBiểnSố();
	}

	@Override
	String getLoạiXe() {
		return "Ô tô";
	}

	@Override
	String getTìnhTrạng1() {
		return this.getTìnhTrạngLúcVào();
	}

	@Override
	String getTìnhTrạng2() {
		return this.getTìnhTrạngLúcRa();
	}

}
