public class FlexibleZoo implements Zoo {

    private Animal[] animals;

    @Override
    public boolean addAnimal(Animal a) {
        if (animals == null) {
            animals = new Animal[1];
            animals[0] = a;
            return true;
        }

        Animal[] tmp = new Animal[animals.length + 1];
        for (int i = 0; i < animals.length; i++) {
            tmp[i] = animals[i];
        }

        tmp[animals.length] = a;
        animals = tmp;
        return true;
    }

    @Override
    public void makeNoise() {
        if (animals != null) {
            for (Animal a : animals) {
                a.makeSound();
            }
        }
    }

    @Override
    public void freeAnimal(int i) {
        if (animals == null || i < 0 || i >= animals.length) {
            System.out.println("Invalid index or no animals to release.");
            return;
        }

        Animal[] tmp = new Animal[animals.length - 1];
        for (int j = 0, k = 0; j < animals.length; j++) {
            if (j != i) {
                tmp[k++] = animals[j];
            }
        }
        animals = tmp;
        System.out.println("Animal at index " + i + " has been released.");
    }
}

