package _01_SimpleFactory;

public class ChuongTrinh {
	public static void main(String[] args) {
		ConVatFactory f = new ConVatFactory();
		ConVat cv = f.createConVat("Cho");
		cv.keu();
	}
}
