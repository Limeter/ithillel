package homework26;

import java.util.List;

public class Cappuccino extends Coffee {
    @Override
    public int cost() {
        return super.cost() + 3;
    }

    @Override
    public List<String> ingredients() {
        List<String> ingr = super.ingredients();
        ingr.add("milk");
        return ingr;
    }
}