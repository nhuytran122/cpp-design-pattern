package _08_Decorator;

public class SimpleCoffee implements Coffee {

	@Override
	public String getDes() {
		return "Simple Coffee";
	}

	@Override
	public double getCost() {
		return 2.0;
	}

}
