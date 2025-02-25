package homework26;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {
    public int cost() {
        return 0;
    }

    public List<String> ingredients() {
        return new ArrayList<>();
    }
}