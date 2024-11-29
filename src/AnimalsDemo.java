public class AnimalsDemo {
    public static void main(String[] args) {
        FlexibleZoo flexibleZoo = new FlexibleZoo();

        System.out.println("Добавляем животных в FlexibleZoo...");
        flexibleZoo.addAnimal(new Animal("Лев"));
        flexibleZoo.addAnimal(new Animal("Тигр"));
        flexibleZoo.addAnimal(new Animal("Медведь"));

        System.out.println("FlexibleZoo издает звуки:");
        flexibleZoo.makeNoise();

        System.out.println("Выпускаем животное из FlexibleZoo (индекс 1):");
        flexibleZoo.freeAnimal(1);

        System.out.println("FlexibleZoo издает звуки после выпуска:");
        flexibleZoo.makeNoise();

        CriticallySmallZoo criticallySmallZoo = new CriticallySmallZoo();

        System.out.println("Добавляем животное в CriticallySmallZoo...");
        criticallySmallZoo.addAnimal(new Animal("Панда"));

        System.out.println("CriticallySmallZoo издает звуки:");
        criticallySmallZoo.makeNoise();

        System.out.println("Выпускаем животное из CriticallySmallZoo:");
        criticallySmallZoo.freeAnimal(0);

        System.out.println("CriticallySmallZoo издает звуки после выпуска:");
        criticallySmallZoo.makeNoise();
    }
}
