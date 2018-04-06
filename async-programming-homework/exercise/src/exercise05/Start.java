package exercise05;

public class Start
{
    public static void main(String[] args) throws Exception
    {
        BankAccount bankAccount = new BankAccount();
        Runnable task = () ->
        {
            for (int i = 0; i < 10000; i++)
            {
                bankAccount.deposit(1);
            }
        };
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread thread : threads)
        {
            thread.join();
        }
        System.out.println(bankAccount.getBalance());
    }
}
