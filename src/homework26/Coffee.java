package homework26;


import java.util.List;

public class Coffee extends WaterCup {
    @Override
    public int cost() {
        return super.cost() + 3;
    }

    @Override
    public List<String> ingredients() {
        List<String> ingr = super.ingredients();
        ingr.add("coffee");
        return ingr;
    }
}