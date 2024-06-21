package _01_SimpleFactory;

public class ConVatFactory {
	public ConVat createConVat(String type) {
		if(type.equals("Cho"))
			return new Cho();
		else return new Ga();
	}
}
