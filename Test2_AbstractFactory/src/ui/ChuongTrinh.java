package ui;

import abstractfactory.DongVatAnCo;
import abstractfactory.DongVatAnThit;
import style1.Style1Factory;

public class ChuongTrinh {

	public static void main(String[] args) {
		Style1Factory s1 = new Style1Factory();
		DongVatAnCo ac = s1.createDongVatAnCo();
		DongVatAnThit at = s1.createDongVatAnThit();
		at.duoitheo(ac);
	}

}
