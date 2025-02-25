package homework26;

public class CoffeeBuilder {
    private Beverage beverage = new Coffee();

    public CoffeeBuilder espresso() {
        beverage = new Coffee();
        return this;
    }

    public CoffeeBuilder cappuccino() {
        beverage = new Cappuccino();
        return this;
    }

    public CoffeeBuilder addMilk() {
        beverage = new AdditionalMilk(beverage);
        return this;
    }

    public CoffeeBuilder addSugar() {
        beverage = new AdditionalSugar(beverage);
        return this;
    }

    public Beverage build() {
        CafeSingleton.getInstance().addPayment(beverage.cost());
        return beverage;
    }
}