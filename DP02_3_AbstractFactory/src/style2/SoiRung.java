package style2;

import abstract_factory.DongVatAnCo;
import abstract_factory.DongVatAnThit;

public class SoiRung implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sói rừng châu Á đuổi\n", this.toString());
		x.chạy();
	}

}
