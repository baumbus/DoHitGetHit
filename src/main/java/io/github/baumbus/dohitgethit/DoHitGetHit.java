package io.github.baumbus.dohitgethit;

import org.bukkit.plugin.java.JavaPlugin;

public final class DoHitGetHit extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Startup");
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutdown");
    }
}
