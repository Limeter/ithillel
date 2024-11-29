public class CriticallySmallZoo implements Zoo {

    private Animal animal;

    @Override
    public boolean addAnimal(Animal animal) {
        if (this.animal == null) {
            this.animal = animal;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void makeNoise() {
        if (animal != null) {
            animal.makeSound();
        }
    }

    @Override
    public void freeAnimal(int i) {
        if (animal != null) {
            System.out.println("�������� ���� ��������.");
            animal = null;
        } else {
            System.out.println("���� ��������� ����� ���������.");
        }
    }
}

