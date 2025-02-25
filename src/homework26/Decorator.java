package homework26;

public class Decorator {

    public static void main(String[] args) {
        Beverage b1 = new CoffeeBuilder().espresso().addMilk().addMilk().addSugar().build();
        System.out.println("Beverage: " + b1.ingredients() + " costs: " + b1.cost());

        Beverage b2 = new CoffeeBuilder().cappuccino().addMilk().addSugar().build();
        System.out.println("Beverage: " + b2.ingredients() + " costs: " + b2.cost());

        System.out.println("Total earnings: " + CafeSingleton.getInstance().getCount());
    }
}