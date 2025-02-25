package homework26;

import java.util.List;

public class AdditionalSugar extends Beverage {
    private final Beverage base;

    public AdditionalSugar(Beverage base) {
        this.base = base;
    }

    @Override
    public int cost() {
        return base.cost() + 1;
    }

    @Override
    public List<String> ingredients() {
        List<String> ingr = base.ingredients();
        ingr.add("sugar");
        return ingr;
    }
}