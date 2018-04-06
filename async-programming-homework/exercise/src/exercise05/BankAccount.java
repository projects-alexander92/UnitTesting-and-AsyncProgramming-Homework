package exercise05;

public class BankAccount
{
    private int balance;

    public BankAccount()
    {
    }

    public BankAccount(int balance)
    {
        this.balance = balance;
    }

    public int getBalance()
    {
        return this.balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public synchronized void deposit(int sum)
    {
        this.balance += sum;
    }
}
