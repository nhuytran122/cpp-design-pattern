@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class ThongTinVeXeDap extends ThongTinVe {
	private String sốVé;

	@Override
	double getGiá() {
		double totalMs = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		double totalMsPerDay = 24 * 60 * 60 * 1000;
		return Math.ceil(totalMs / totalMsPerDay) * 2000;
	}

	@Override
	boolean cóThểTínhGiá() {
		return this.getThoiDiemVao() != null && this.getThoiDiemRa() != null;
	}

	@Override
	String getKey() {
		return String.format("%d;%s;%s", 0, "Not Available", this.getSốVé());
	}

	@Override
	String getId() {
		return this.getSốVé();
	}

	@Override
	String getLoạiXe() {
		return "Xe đạp";
	}

	@Override
	String getTìnhTrạng1() {
		return "-";
	}

	@Override
	String getTìnhTrạng2() {
		return "-";
	}
}
