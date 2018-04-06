package tests;

import models.AxeImpl;
import models.DummyImpl;
import models.HeroImpl;
import models.interfaces.Axe;
import models.interfaces.Dummy;
import models.interfaces.Hero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests
{
    private Dummy dummy;
    private Axe axe;
    private Hero hero;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXP = 20;

    @Before
    public void initObjects()
    {
        this.axe = new AxeImpl(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new DummyImpl(DUMMY_HEALTH, DUMMY_EXP);
        this.hero = new HeroImpl("pesho");
    }

    @Test
    public void testIfDummyLosesHealthIfAttacked()
    {
        this.axe.attack(this.dummy);
        Assert.assertTrue("Dummies health is not correct", this.dummy.getHealth() == 10);
    }

    @Test(expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsException()
    {
        for (int i = 0; i < 3; i++)
        {
            this.axe.attack(this.dummy);
        }

    }

    @Test
    public void deadDummyCanGiveXp()
    {
        for (int i = 0; i < 2; i++)
        {
            this.hero.attack(dummy);
        }
        Assert.assertTrue("Hero Didn't receive correct XP", this.hero.getExperience() == DUMMY_EXP);
    }

    @Test
    public void aliveDummyCantGiveXp()
    {
        this.hero.attack(this.dummy);
        Assert.assertEquals("Hero should had 0 xp", true, this.hero.getExperience() == 0);
    }
}
