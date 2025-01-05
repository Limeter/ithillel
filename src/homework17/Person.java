package homework17;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    // Конструктор, геттеры и сеттеры
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age;
    }
}

class PersonStorage {
    private List<Person> persons = new ArrayList<>();

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(String name, int age) {
        persons.add(new Person(name, age));
    }

    public boolean removePerson(String name) {
        return persons.removeIf(person -> person.getName().equalsIgnoreCase(name));
    }

    public void listPersons() {
        if (persons.isEmpty()) {
            System.out.println("Нет записей.");
        } else {
            persons.forEach(System.out::println);
        }
    }

    public void findPerson(String name) {
        Person foundPerson = persons.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        if (foundPerson != null) {
            System.out.println(foundPerson);
        } else {
            System.out.println("Человек не найден.");
        }
    }

}

class Main {
    private static final String FILE_NAME = "persons.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void save(PersonStorage personStorage) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), personStorage.getPersons());
        } catch (IOException e) {
            System.err.println("Ошибка сохранения данных: " + e.getMessage());
        }
    }

    public static PersonStorage load() {
        PersonStorage personStorage = new PersonStorage();
        try {
            File file = new File(FILE_NAME);
            if (file.exists()) {
                List<Person> persons = objectMapper.readValue(file, new TypeReference<List<Person>>() {});
                personStorage.setPersons(persons);
            }
        } catch (IOException e) {
            System.err.println("Ошибка загрузки данных: " + e.getMessage());
        }
        return personStorage;
    }

    public static void main(String[] args) {
        PersonStorage personStorage = load();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду (add, remove, list, find, exit):");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Введите возраст: ");
                    try {
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        personStorage.addPerson(name, age);
                        save(personStorage);
                        System.out.println("Человек добавлен.");
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный возраст.");
                    }
                    break;

                case "remove":
                    System.out.print("Введите имя для удаления: ");
                    String nameToRemove = scanner.nextLine().trim();
                    if (personStorage.removePerson(nameToRemove)) {
                        save(personStorage);
                        System.out.println("Человек удалён.");
                    } else {
                        System.out.println("Человек не найден.");
                    }
                    break;

                case "list":
                    personStorage.listPersons();
                    break;

                case "find":
                    System.out.print("Введите имя для поиска: ");
                    String nameToFind = scanner.nextLine().trim();
                    personStorage.findPerson(nameToFind);
                    break;

                case "exit":
                    System.out.println("Выход из программы.");
                    return;

                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}

