package style1;

import abstractfactory.DongVatAnCo;
import abstractfactory.DongVatAnThit;

public class SuTu implements DongVatAnThit{

	@Override
	public void duoitheo(DongVatAnCo dv) {
		System.out.print("Su tu duoi theo ");
		dv.chay();
	}
	
}
