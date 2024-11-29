public class AnimalsDemo {
    public static void main(String[] args) {
        FlexibleZoo flexibleZoo = new FlexibleZoo();

        System.out.println("��������� �������� � FlexibleZoo...");
        flexibleZoo.addAnimal(new Animal("���"));
        flexibleZoo.addAnimal(new Animal("����"));
        flexibleZoo.addAnimal(new Animal("�������"));

        System.out.println("FlexibleZoo ������ �����:");
        flexibleZoo.makeNoise();

        System.out.println("��������� �������� �� FlexibleZoo (������ 1):");
        flexibleZoo.freeAnimal(1);

        System.out.println("FlexibleZoo ������ ����� ����� �������:");
        flexibleZoo.makeNoise();

        CriticallySmallZoo criticallySmallZoo = new CriticallySmallZoo();

        System.out.println("��������� �������� � CriticallySmallZoo...");
        criticallySmallZoo.addAnimal(new Animal("�����"));

        System.out.println("CriticallySmallZoo ������ �����:");
        criticallySmallZoo.makeNoise();

        System.out.println("��������� �������� �� CriticallySmallZoo:");
        criticallySmallZoo.freeAnimal(0);

        System.out.println("CriticallySmallZoo ������ ����� ����� �������:");
        criticallySmallZoo.makeNoise();
    }
}
