package exercise03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Start
{
    private static List<Integer> numbers;

    public static void main(String[] args) throws IOException
    {
        //Init params
        numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boundary = Integer.parseInt(br.readLine());

        //Init and start thread
        Runnable task = () -> primesInRange(boundary);
        Thread thread = new Thread(task);
        thread.start();

        while (true)
        {
            String command = br.readLine();
            if (command.equals("stop"))
            {
                thread.interrupt();
                printAndExit();
            }
        }
    }

    private static void printAndExit()
    {
        System.out.println("Interrupted...");
        System.out.println(numbers);
        System.out.println(numbers.size() + " prime numbers calculated");
        System.exit(0);
    }

    private static void primesInRange(int number)
    {
        for (int i = 0; i < number; i++)
        {
            if (isPrime(i))
            {
                numbers.add(i);
            }
            if (Thread.currentThread().isInterrupted())
            {
                break;
            }
        }
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
