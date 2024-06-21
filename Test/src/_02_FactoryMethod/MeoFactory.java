package _02_FactoryMethod;

public class MeoFactory extends ConVatFactory {

	@Override
	public ConVat createConVat() {
		return new Meo();
	}

}
