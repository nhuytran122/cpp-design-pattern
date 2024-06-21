package style1;

import abstract_factory.DongVatAnCo;
import abstract_factory.DongVatAnThit;
import abstract_factory.DongVatFactory;

public class FactoryStyle1 extends DongVatFactory {

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new NguaVan();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SuTu();
	}

}
