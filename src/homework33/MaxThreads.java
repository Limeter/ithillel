package homework33;

public class MaxThreads {
    public static void main(String[] args) {
        int count = 0;
        try {
            while (true) {
                Thread thread = new Thread(() -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
                count++;
                System.out.println("Створено потоків: " + count);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Досягнуто межі: " + count);
        } catch (Throwable e) {
            System.out.println("Досягнуто межі: " + count);
        }
    }
}
