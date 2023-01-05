package io.github.baumbus.dohitgethit;

import io.github.baumbus.dohitgethit.events.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoHitGetHit extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Startup");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutdown");
    }
}
