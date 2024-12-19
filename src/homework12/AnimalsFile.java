package homework12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnimalsFile {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String[] animals = new String[5];


        System.out.println("Введіть назви 5 тварин");
        for (int i = 0; i < animals.length; i++) {
            System.out.print("Тварина " + (i + 1) + ": ");
            animals[i] = a.nextLine();
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/homework12/animals.txt"))) {
            for (String animal : animals) {
                writer.write(animal);
                writer.newLine();
            }
            System.out.println("Назви тварин успішно записано у файл animals.txt.");
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }

        a.close();
    }
}