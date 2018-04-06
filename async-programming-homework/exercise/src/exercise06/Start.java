package exercise06;

public class Start
{
    public static void main(String[] args) throws InterruptedException
    {
        MyClass first = new MyClass("first");
        MyClass second = new MyClass("second");

        Thread t1 = new Thread(()-> first.methodA(second));
        Thread t2 = new Thread(()-> second.methodA(first));
        t1.start();
        t2.start();
            //Expecting that program wont work

        t1.join();
        t2.join();
    }
}
