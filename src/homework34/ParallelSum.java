package homework34;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSum {
    private static final int SIZE = 100_000_000;
    private static final int THREADS = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] numbers = new int[SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            numbers[i] = random.nextInt(100);
        }

        long startTime = System.currentTimeMillis();
        int parallelSum = parallelSum(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("Параллельная сумма: " + parallelSum);
        System.out.println("Затраченное время (параллельно): " + (endTime - startTime) + "мс");

        startTime = System.currentTimeMillis();
        int sequentialSum = sequentialSum(numbers);
        endTime = System.currentTimeMillis();

        System.out.println("Последовательная сумма: " + sequentialSum);
        System.out.println("Затраченное время (последовательно): " + (endTime - startTime) + "мс");
    }

    private static int sequentialSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private static int parallelSum(int[] numbers) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        int partSize = SIZE / THREADS;
        Future<Integer>[] futures = new Future[THREADS];

        for (int i = 0; i < THREADS; i++) {
            int start = i * partSize;
            int end = (i == THREADS - 1) ? numbers.length : (i + 1) * partSize;
            futures[i] = executor.submit(new SumTask(numbers, start, end));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }
}