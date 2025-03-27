package homework33;

import java.util.Random;

public class ThreadDelayPrint {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                Random random = new Random();
                int number = random.nextInt(101);
                try {
                    Thread.sleep(500); // Додаємо затримку для наочності
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
            });
            thread.start();
        }
    }
}