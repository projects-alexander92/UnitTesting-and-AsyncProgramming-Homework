import models.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseTest
{
    private Database database;
    private Database databaseWithArray;
    private static final int TOTAL_CAPACITY_ALLOWED = 16;
    private static final Integer[] STARTING_ARRAY = {1, 2, 3, 4, 455, 5, 5, null, null, null, null, null, null, null, null, null};

    @Before
    public void initObjects()
    {
        this.database = new Database();
        this.databaseWithArray = new Database(STARTING_ARRAY);
    }

    @Test
    public void testStoringArrayCapacityWithBothConstructors()
    {
        int totalCapacity = this.database.getStorage().length;
        int totalCapacity1 = this.databaseWithArray.getStorage().length;
        Assert.assertTrue("Total capacity must be 16", totalCapacity == TOTAL_CAPACITY_ALLOWED);
        Assert.assertTrue("Total capacity must be 16", totalCapacity1 == TOTAL_CAPACITY_ALLOWED);
    }

    @Test
    public void testIfFirstFreeCellIsCorrectForRemoveAndAddOperation() throws OperationNotSupportedException
    {
        Assert.assertTrue("First Free Cell Not Correct", 0 == this.database.getFirstFreeSell());
        this.database.addElement(1);
        Assert.assertTrue("First Free Cell Not Correct", 1 == this.database.getFirstFreeSell());
        this.database.removeElement();
        Assert.assertTrue("First Free Cell Not Correct", 0 == this.database.getFirstFreeSell());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfWeCanAddNullElements() throws OperationNotSupportedException
    {
        for (int i = 0; i <= TOTAL_CAPACITY_ALLOWED; i++)
        {
            this.database.addElement(i);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfWeRemoveElementsFromEmptyDb() throws OperationNotSupportedException
    {
        this.database.removeElement();
    }

    @Test
    public void testIfFetchMethodReturnsCorrectArray()
    {
        Assert.assertEquals("Arrays are not equal", true, Arrays.equals(STARTING_ARRAY, this.databaseWithArray.getStorage()));
    }
}
