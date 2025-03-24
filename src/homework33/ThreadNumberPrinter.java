package homework33;

import java.util.Random;

public class ThreadNumberPrinter {
    public static void main(String[] args) {
        int threadCount = 10;
        Random random = new Random();

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                int number = random.nextInt(101);
                System.out.println(Thread.currentThread().getName() + " -> " + number);
            }).start();
        }
    }
}

