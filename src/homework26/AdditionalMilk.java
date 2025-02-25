package homework26;

import java.util.List;

public class AdditionalMilk extends Beverage {
    private final Beverage base;

    public AdditionalMilk(Beverage base) {
        this.base = base;
    }

    @Override
    public int cost() {
        return base.cost() + 3;
    }

    @Override
    public List<String> ingredients() {
        List<String> ingr = base.ingredients();
        ingr.add("milk");
        return ingr;
    }
}
