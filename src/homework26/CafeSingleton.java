package homework26;

public class CafeSingleton {
    private static CafeSingleton instance;
    private int count = 0;

    private CafeSingleton() {}

    public static CafeSingleton getInstance() {
        if (instance == null) {
            instance = new CafeSingleton();
        }
        return instance;
    }

    public void addPayment(int amount) {
        count += amount;
    }

    public int getCount() {
        return count;
    }
}