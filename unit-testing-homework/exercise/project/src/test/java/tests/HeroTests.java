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
import org.mockito.Mockito;

public class HeroTests
{
    private Dummy dummy;
    private Axe axe;
    private Hero hero;
    private static final int TARGET_XP = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    public static final String HERO_NAME = "pesho";

    @Before
    public void initObjects()
    {
        this.axe = Mockito.mock(AxeImpl.class);
        Mockito.when(axe.getDurabilityPoints()).thenReturn(AXE_DURABILITY);
        Mockito.when(axe.getAttackPoints()).thenReturn(AXE_ATTACK);
        this.dummy = Mockito.mock(DummyImpl.class);
        Mockito.when(this.dummy.getHealth()).thenReturn(0);
        Mockito.when(this.dummy.giveExperience()).thenReturn(TARGET_XP);
        Mockito.when(this.dummy.isDead()).thenReturn(true);
        this.hero = new HeroImpl(HERO_NAME, axe);
    }

    @Test
    public void attackGainsExperienceIfTargetIsDead()
    {
        this.hero.attack(this.dummy);
        Assert.assertTrue("Wrong exp", this.hero.getExperience() == TARGET_XP);
    }
}
