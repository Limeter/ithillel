package homework14;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Файловый менеджер. Варианты использования: view, edit, copy");
        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "view":
                viewFile(scanner);
                break;
            case "edit":
                editFile(scanner);
                break;
            case "copy":
                copyFile(scanner);
                break;
            default:
                System.out.println("Неверный вариант. Пожалуйста выберите просмотр редактирование или копирование.");
        }
    }

    private static void viewFile(Scanner scanner) {
        System.out.println("Введите имя файла для просмотра:");
        String fileName = scanner.nextLine();

       //try {
       //    //String content = Files.readString(Path.of("src/homework14/" + fileName));
       //    System.out.println("Содержимое файла:");
       //    //System.out.println(content);
       //} catch (IOException e) {
       //    System.out.println("Ошибка чтения файла:" + e.getMessage());
       //}
    }

    // Добавлено. Если файл не существует, то автоматически создаёт новый файл. Если это не противоречит указаний из домашнего задания
    private static void editFile(Scanner scanner) {
        System.out.println("Введите желаемый текст. Введите «exit» в новой строке чтобы закончить:");

        StringBuilder content = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            content.append(line).append(System.lineSeparator());
        }

        System.out.println("Введите имя файла для сохранения:");
        String fileName = scanner.nextLine();

        //try {
        //    File file = new File("src/homework14/" + fileName);
        //    if (file.createNewFile()) {
        //        System.out.println("Файл создан: " + fileName);
        //    } else {
        //        System.out.println("Файл уже существует. Перезапись...");
        //    }
        //    Files.writeString(Path.of("src/homework14/" + fileName), content.toString());
        //    System.out.println("Файл успешно сохранен.");
        //} catch (IOException e) {
        //    System.out.println("Ошибка записи в файл: " + e.getMessage());
        //}
    }

    private static void copyFile(Scanner scanner) {
        System.out.println("Enter the source file name:");
        String sourceFile = scanner.nextLine();

        System.out.println("Enter the destination file name:");
        String destinationFile = scanner.nextLine();

        //try {
        //    //Files.copy(Path.of("src/homework14/" + sourceFile), Path.of("src/homework14/" + destinationFile), StandardCopyOption.REPLACE_EXISTING);
        //    System.out.println("File copied successfully.");
        //} catch (IOException e) {
        //    System.out.println("Error copying the file: " + e.getMessage());
        //}
    }
}
