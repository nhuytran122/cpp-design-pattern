package style1;

import abstract_factory.DongVatAnCo;
import abstract_factory.DongVatAnThit;

public class SuTu implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sư tử châu Phi đuổi\n", this.toString());
		x.chạy();
	}
}
