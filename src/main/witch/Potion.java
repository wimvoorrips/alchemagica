package main.witch;

public class Potion {
    private double energy = 0;
    private double strength = 0;
    private double intellect = 0;
    private double dexterity = 0;
    private double healing = 0;

    public Potion(int energy, int strength, int intellect, int dexterity, int healing){
        this.dexterity = dexterity;
        this.energy = energy;
        this.strength = strength;
        this.intellect = intellect;
        this.healing = healing;

    }
    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getIntellect() {
        return intellect;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getHealing() {
        return healing;
    }

    public void setHealing(double healing) {
        this.healing = healing;
    }
}
