package models;

import models.interfaces.Axe;
import models.interfaces.Dummy;

public class HeroImpl implements models.interfaces.Hero
{

    private String name;
    private int experience;
    private Axe weapon;

    public HeroImpl(String name) {
        this.name = name;
        this.experience = 0;
        this.weapon = new AxeImpl(10, 10);
    }

    public HeroImpl(String name, Axe weapon)
    {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getExperience() {
        return this.experience;
    }

    @Override
    public Axe getWeapon() {
        return this.weapon;
    }

    @Override
    public void attack(Dummy target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
