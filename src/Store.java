public interface Store {

    boolean add(String a);

    boolean add(String a, int number);

    void remove(int number);

    String get(int number);

    int length();

    void printAll();
}