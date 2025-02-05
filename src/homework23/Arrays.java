package homework23;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Arrays {

    public static int[][] generateArray(int size) {
        Random rand = new Random();
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = rand.nextInt(10) + 10;
            }
        }
        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row) {
                System.out.printf("%3d ", num);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Map<Integer, Integer> countSpecificNumbers(int[][] array, int[] numbersToCount) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : numbersToCount) {
            countMap.put(num, 0);
        }

        for (int[] row : array) {
            for (int num : row) {
                if (countMap.containsKey(num)) {
                    countMap.put(num, countMap.get(num) + 1);
                }
            }
        }
        return countMap;
    }

    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 0;
        }
    }

    public static void multiplyAboveDiagonal(int[][] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                array[i][j] *= 10;
            }
        }
    }

    public static void main(String[] args) {
        int size = 4;
        int[][] array = generateArray(size);

        System.out.println("Початковий масив:");
        printArray(array);

        int[] numbersToCount = {7, 11, 18};
        Map<Integer, Integer> countMap = countSpecificNumbers(array, numbersToCount);

        System.out.println("Кількість входжень:");
        for (int num : numbersToCount) {
            System.out.println(num + ": " + countMap.get(num));
        }

        zeroDiagonal(array);
        System.out.println("Масив після заміни діагональних елементів на 0:");
        printArray(array);

        multiplyAboveDiagonal(array);
        System.out.println("Масив після множення елементів вище діагоналі на 10:");
        printArray(array);
    }
}

