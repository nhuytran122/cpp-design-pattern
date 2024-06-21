package style2;

import abstract_factory.DongVatAnCo;
import abstract_factory.DongVatAnThit;
import abstract_factory.DongVatFactory;

public class FactoryStyle2 extends DongVatFactory{

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new Soc();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SoiRung();
	}

}
