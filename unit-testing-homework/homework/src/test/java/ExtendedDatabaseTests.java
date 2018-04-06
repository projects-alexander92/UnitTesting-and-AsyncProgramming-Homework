import models.ExtendedDatabase;
import models.User;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTests
{
    private static final Long INVALID_ID = 456654987894561L; //Invalid id must not be null or negative, just invalid, we test null negative separately
    private ExtendedDatabase extendedDatabase;
    private User user;
    private User user1;
    private User userWithNullId;
    private User userWithNegativeId;
    private static final String INVALID_USERNAME = "!###!#$@!^$%#^%&#$^FFSD%# %^!@! %";

    @Before
    public void initObjects()
    {
        this.extendedDatabase = new ExtendedDatabase();
        this.user = new User(1L, "pesho");
        this.user1 = new User(1L, "marin");
        this.userWithNullId = new User(null, "gosho");
        this.userWithNegativeId = new User(-2L, "negativeIdUser");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfWeCanAddMultipleUsersWithSameId() throws OperationNotSupportedException
    {
        this.extendedDatabase.addPerson(user);
        this.extendedDatabase.addPerson(user1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfWeCanAddUsersWithNullId() throws OperationNotSupportedException
    {
        this.extendedDatabase.addPerson(userWithNullId);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfWeCanAddUsersWithNegativeId() throws OperationNotSupportedException
    {
        this.extendedDatabase.addPerson(userWithNegativeId);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfNoUserWithThatUsernameIsPresent() throws OperationNotSupportedException
    {
        this.extendedDatabase.findByUserName(INVALID_USERNAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfUsernameParamIsNull() throws OperationNotSupportedException
    {
        this.extendedDatabase.findByUserName(null);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testIfNoUserIsPresentWithThatId() throws OperationNotSupportedException
    {

        this.extendedDatabase.findById(INVALID_ID);
    }
}
