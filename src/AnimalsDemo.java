public class AnimalsDemo {

    public static void main(String... args) {
        Zoo zoo = buildZoo();
        System.out.println(zoo.addAnimal(new Cat("Simon")));
        System.out.println(zoo.addAnimal(new Dog("Patron")));
        System.out.println(zoo.addAnimal(new Cat("Matilda")));
        System.out.println(zoo.addAnimal(new Cat("Tom")));

        LinkedZoo linkedZoo = (LinkedZoo) zoo;
        linkedZoo.makeSound(2);

        linkedZoo.makeLastAnimalFree();
        linkedZoo.makeNoise();
    }

    public static Zoo buildZoo() {
        return new LinkedZoo();
    }
}
