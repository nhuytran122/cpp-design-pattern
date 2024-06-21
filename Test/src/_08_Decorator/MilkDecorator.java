package _08_Decorator;

public class MilkDecorator extends CoffeeDecorator {

	public MilkDecorator(Coffee decoratedCoffee) {
		super(decoratedCoffee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDes() {
		return decoratedCoffee.getDes() + ", Milk";
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost() + 0.5;
	}

}
