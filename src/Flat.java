public class Flat {

    Animal animal;

    Flat nextFlat;

    public Flat getNextFlat() {
        return nextFlat;
    }

    public void setNextFlat(Flat nextFlat) {
        this.nextFlat = nextFlat;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}