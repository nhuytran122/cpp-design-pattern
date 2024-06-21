@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class ThongTinVeXeMay extends ThongTinVe {
	private String biểnSố;

	@Override
	double getGiá() {
		double totalMs = this.getThoiDiemRa().getTime() - this.getThoiDiemVao().getTime();
		double totalMsPerDay = 24 * 60 * 60 * 1000;
		return Math.ceil(totalMs / totalMsPerDay) * 3000;
	}

	@Override
	boolean cóThểTínhGiá() {
		return this.getThoiDiemVao() != null && this.getThoiDiemRa() != null;
	}

	@Override
	String getKey() {
		return String.format("%d;%s;%s", 2, this.getBiểnSố(), "Not Available");
	}

	@Override
	String getId() {
		return this.getBiểnSố();
	}

	@Override
	String getLoạiXe() {
		return "Xe máy";
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
