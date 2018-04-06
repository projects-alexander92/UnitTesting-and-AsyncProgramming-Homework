package exercise04;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Start
{
    private static List<Integer> numbers;

    public static void main(String[] args) throws Exception
    {
        numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberCount = Integer.parseInt(br.readLine());

        long start = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Boolean>[] results = new Future[numberCount];
        Callable<Boolean> callable;
        for (int i = 0; i < numberCount; i++)
        {
            int primeCandidate = i;
            callable = () -> isPrime(primeCandidate);
            results[i] = executorService.submit(callable);
        }

        executorService.shutdown();
        executorService.awaitTermination(22, TimeUnit.NANOSECONDS);

        System.out.println("Executed time: " + (System.nanoTime() - start));
//        for (int i = 0; i < results.length; i++)
//        {
//            System.out.printf("%d: %s\n", i, results[i].get());
//        }
        System.exit(0);
    }

    //must use a slow algorithm to test the threads
    private static boolean isPrime(int number)
    {
        boolean isPrime = true;
        if (number < 2)
        {
            isPrime = false;
        }
        for (int i = 2; i < number; i++)
        {
            if (number % i == 0)
            {
                isPrime = false;
            }
        }
        return isPrime;
    }
}
