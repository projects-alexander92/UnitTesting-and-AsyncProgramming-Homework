package tests;

import models.AxeImpl;
import models.DummyImpl;
import models.interfaces.Axe;
import models.interfaces.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeImplTests
{
    private Axe axe;
    private Dummy dummy;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXP = 20;

    @Before
    public void initObjects()
    {
        this.axe = new AxeImpl(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new DummyImpl(DUMMY_HEALTH, DUMMY_EXP);
    }

    @Test
    public void testIfAxeLosesDurability()
    {
        this.axe.attack(this.dummy);
        Assert.assertTrue("Wrong amount of durability points", axe.getDurabilityPoints() == 9);
        Assert.assertEquals("Wrong amount of durability points", 9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfThrowsException()
    {
        for (int i = 0; i <= axe.getDurabilityPoints(); i++)
        {
            this.axe.attack(this.dummy);
        }
    }
}
