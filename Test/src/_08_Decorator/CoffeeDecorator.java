package _08_Decorator;

public abstract class CoffeeDecorator implements Coffee {
	protected Coffee decoratedCoffee;
	
	public CoffeeDecorator(Coffee decoratedCoffee) {
		super();
		this.decoratedCoffee = decoratedCoffee;
	}

	@Override
	public abstract String getDes();

	@Override
	public abstract double getCost();
}
