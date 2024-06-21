package style1;

import abstractfactory.DongVatAnCo;
import abstractfactory.DongVatAnThit;
import abstractfactory.DongVatFactory;

public class Style1Factory extends DongVatFactory {

	@Override
	public DongVatAnCo createDongVatAnCo() {
		// TODO Auto-generated method stub
		return new Nai();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		// TODO Auto-generated method stub
		return new SuTu();
	}

}
