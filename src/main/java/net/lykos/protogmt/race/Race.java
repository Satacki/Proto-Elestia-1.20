package net.lykos.protogmt.race;

public abstract class Race {
    protected String name;
    protected float baseSpeed;

    public Race(String name, float baseSpeed) {
        this.name = name;
        this.baseSpeed = baseSpeed;
    }

    public String getName() {
        return name;
    }

    public float getBaseSpeed() {
        return baseSpeed;
    }
}