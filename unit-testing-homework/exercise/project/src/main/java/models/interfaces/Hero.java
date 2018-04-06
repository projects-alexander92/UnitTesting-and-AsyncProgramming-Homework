package models.interfaces;

public interface Hero
{
    String getName();

    int getExperience();

    Axe getWeapon();

    void attack(Dummy target);
}
