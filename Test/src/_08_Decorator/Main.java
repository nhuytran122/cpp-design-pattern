package _08_Decorator;

public class Main {
	public static void main(String[] args) {
        Coffee myCoffee = new SimpleCoffee();
        myCoffee = new MilkDecorator(myCoffee);
        myCoffee = new SugarDecorator(myCoffee);

        System.out.println("Description: " + myCoffee.getDes());
        System.out.println("Cost: $" + myCoffee.getCost());
    }
}
