package models;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class Database
{
    private static final int STORAGE_SIZE = 16;
    private Integer[] storage;
    private int firstFreeSell;

    public Database()
    {
        this.storage = new Integer[STORAGE_SIZE];
        this.firstFreeSell = 0;
    }

    public Database(Integer[] args)
    {
        this.storage = new Integer[STORAGE_SIZE];
        this.firstFreeSell = args.length - 1;
        System.arraycopy(args, 0, this.storage, 0, args.length);
    }

    public void addElement(Integer element) throws OperationNotSupportedException
    {
        if (element == null)
        {
            throw new OperationNotSupportedException("Must not be null");

        }
        if (this.firstFreeSell >= storage.length)
        {
            throw new OperationNotSupportedException("Max array size");
        }
        this.storage[firstFreeSell] = element;
        this.firstFreeSell++;
    }

    public void removeElement() throws OperationNotSupportedException
    {
        if (this.firstFreeSell <= 0)
        {
            throw new OperationNotSupportedException("not supported");
        }
        this.storage[firstFreeSell] = null;
        this.firstFreeSell--;
    }

    public int getFirstFreeSell()
    {
        return this.firstFreeSell;
    }

    public Integer[] getStorage()
    {
        return this.storage;
    }

    //да си тествам аз
    @Override
    public String toString()
    {
        return "Database{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}
