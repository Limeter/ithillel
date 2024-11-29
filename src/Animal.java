public class Animal implements Noisy {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println(name + " издаёт звук!");
    }

    @Override
    public String toString() {
        return name;
    }
}
