package _02_FactoryMethod;

public class GaConFactory extends ConVatFactory {

	@Override
	public ConVat createConVat() {
		return new GaCon();
	}

}
