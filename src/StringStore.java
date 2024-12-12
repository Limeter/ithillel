import java.util.ArrayList;

public class StringStore implements Store {
    private ArrayList<String> storage;

    public StringStore() {
        this.storage = new ArrayList<>();
    }

    @Override
    public boolean add(String a) {
        if (a == null) {
            return false;
        }
        storage.add(a);
        return true;
    }

    @Override
    public boolean add(String a, int number) {
        if (a == null || number < 0 || number > storage.size()) {
            return false;
        }
        storage.add(number, a);
        return true;
    }

    @Override
    public void remove(int number) {
        if (number >= 0 && number < storage.size()) {
            storage.remove(number);
        } else {
            throw new IndexOutOfBoundsException("Ахътунг неверный индекс: " + number);
        }
    }

    @Override
    public String get(int number) {
        if (number >= 0 && number < storage.size()) {
            return storage.get(number);
        } else {
            throw new IndexOutOfBoundsException("Ахътунг неверный индекс: " + number);
        }
    }

    @Override
    public int length() {
        return storage.size();
    }

    @Override
    public void printAll() {
        for (String item : storage) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Store store = new StringStore();

        store.add("Это");
        store.add("обычный");
        store.add("текст");
        store.add("примера", 2);

        System.out.println("Длинна: " + store.length());

        store.printAll();

        System.out.println("Получение индекса: " + store.get(2));

        store.remove(1);
        store.printAll();
    }
}
