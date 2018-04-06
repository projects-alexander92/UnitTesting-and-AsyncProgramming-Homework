package exercise06;

public class MyClass
{
    public String id;

    public MyClass(String id)
    {
        this.id = id;
    }

    public synchronized void methodA(MyClass other)
    {
        try
        {
            Thread.sleep(100);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.printf("%s called methodA on %s\n", this.id, other.id);
        other.methodB(this);
    }

    public synchronized void methodB(MyClass other)
    {
        System.out.printf("%s called methodB on %s\n", other.id, this.id);
        other.methodC();
    }

    public synchronized void methodC()
    {
        System.out.println("All done!");
    }

}
