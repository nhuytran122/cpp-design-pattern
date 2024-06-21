package style2;

import abstractfactory.DongVatAnCo;
import abstractfactory.DongVatAnThit;

public class SoiRung implements DongVatAnThit {

	@Override
	public void duoitheo(DongVatAnCo dv) {
		System.out.print("Soi rung duoi theo ");
		dv.chay();
	}

}
