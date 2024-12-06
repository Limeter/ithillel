public class LinkedZoo implements Zoo {

    Flat first;

    @Override
    public boolean addAnimal(Animal a) {
        if (first == null) {
            first = new Flat();
            first.setAnimal(a);
            return true;
        }
        Flat last = getLast();

        Flat newFlat = new Flat();
        newFlat.setAnimal(a);

        last.setNextFlat(newFlat);
        return true;
    }

    private Flat getLast() {
        Flat f = this.first;

        while (f.getNextFlat() != null) {
            f = f.getNextFlat();
        }
        return f;
    }

    private Flat getFlatByIndex(int index) {
        Flat current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current;
            }
            current = current.getNextFlat();
            count++;
        }
        return null;
    }

    @Override
    public void makeAnimalFree(int j) { /*/ Почему-то метод пустой ну ладно /*/ }

    @Override
    public void makeNoise() {
        if (this.first == null) {
            return;
        }
        Flat f = this.first;

        while (f.getNextFlat() != null) {
            f.getAnimal().makeSound();
            f = f.getNextFlat();
        }

        f.getAnimal().makeSound();
    }

    public void makeSound(int i) {
        Flat targetFlat = getFlatByIndex(i);
        if (targetFlat != null) {
            targetFlat.getAnimal().makeSound();
            targetFlat.getAnimal().makeSound();
        }
    }

    public void makeLastAnimalFree() {
        if (first == null) {
            return;
        }

        if (first.getNextFlat() == null) {
            first = null;
            return;
        }

        Flat current = first;
        while (current.getNextFlat().getNextFlat() != null) {
            current = current.getNextFlat();
        }

        current.setNextFlat(null);
    }
}
