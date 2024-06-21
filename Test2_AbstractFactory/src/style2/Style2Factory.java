package style2;

import abstractfactory.DongVatAnCo;
import abstractfactory.DongVatAnThit;
import abstractfactory.DongVatFactory;

public class Style2Factory extends DongVatFactory {

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new Soc();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SoiRung();
	}

}
