package models;

import models.interfaces.Dummy;

public class AxeImpl implements models.interfaces.Axe
{

    private int attackPoints;
    private int durabilityPoints;

    public AxeImpl(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    @Override
    public void attack(Dummy target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("models.AxeImpl is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
