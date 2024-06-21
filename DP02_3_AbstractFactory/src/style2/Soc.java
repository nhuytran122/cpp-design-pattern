package style2;

import abstract_factory.DongVatAnCo;

public class Soc implements DongVatAnCo {

	@Override
	public void chạy() {
		System.out.printf("Sóc châu Á nhảy", this.toString());
	}

}
