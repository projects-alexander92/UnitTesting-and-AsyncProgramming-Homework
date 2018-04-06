package models.interfaces;

public interface Axe
{
    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Dummy target);
}
