package io.github.baumbus.dohitgethit;

import java.util.UUID;
import java.util.Vector;

public class Config {
    private boolean status;
    private float modifier;
    private final Vector<UUID> immune = new Vector<>();

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getModifier() {
        return modifier;
    }

    public void setModifier(float modifier) {
        this.modifier = modifier;
    }

    public Vector<UUID> getImmune() {
        return immune;
    }

    public void addImmune(UUID id) {
        if (!immune.contains(id)) immune.add(id);
    }

    public void removeImmune(UUID id) {
        immune.remove(id);
    }
}
