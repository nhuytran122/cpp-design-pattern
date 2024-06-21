package style1;

import abstract_factory.DongVatAnCo;

public class NguaVan implements DongVatAnCo {

	@Override
	public void chạy() {
		System.out.printf("Ngựa vằn châu Phi chạy :D", this.toString());
	}
}

