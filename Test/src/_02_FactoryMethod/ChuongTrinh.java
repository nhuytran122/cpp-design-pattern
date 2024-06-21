package _02_FactoryMethod;

public class ChuongTrinh {
	public static void main(String[] args) {
		ConVat cv = new GaConFactory().createConVat();
		cv.keu();
	}
}
