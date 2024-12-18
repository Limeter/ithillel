import java.util.*;

public class ShipCollections {

    public Iterable<String> getFirstCollection() {
        return Arrays.asList("Коллекция 1", "Коллекция 2", "Коллекция 3", "Коллекция 4");
    }

    public Iterable<String> getSecondCollection() {
        return Arrays.asList("Коллекция 1", "Коллекция 2", "Коллекция 3", "Коллекция 4");
    }

    public boolean areCollectionsEqual(Iterable<String> first, Iterable<String> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }

        Set<String> firstSet = new HashSet<>();
        first.forEach(firstSet::add);

        Set<String> secondSet = new HashSet<>();
        second.forEach(secondSet::add);

        return firstSet.equals(secondSet);
    }

    public static void main(String[] args) {
        ShipCollections shipCollections = new ShipCollections();

        Iterable<String> firstCollection = shipCollections.getFirstCollection();
        Iterable<String> secondCollection = shipCollections.getSecondCollection();

        boolean areEqual = shipCollections.areCollectionsEqual(firstCollection, secondCollection);
        System.out.println("Коллекции равны? " + areEqual);
    }
}
