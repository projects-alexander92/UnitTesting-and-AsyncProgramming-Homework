package exercise02;

public class Start
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable task = () ->
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.printf("[%d] ", i);
            }
            Thread.yield();
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread thread : threads)
        {
            thread.join();
        }

        System.exit(1);
    }

}
