package homework26;


import java.util.List;

public class WaterCup extends Beverage {
    @Override
    public int cost() {
        return super.cost() + 1;
    }

    @Override
    public List<String> ingredients() {
        List<String> ingr = super.ingredients();
        ingr.add("water");
        return ingr;
    }
}