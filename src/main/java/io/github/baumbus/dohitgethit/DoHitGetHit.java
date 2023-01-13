package io.github.baumbus.dohitgethit;

import io.github.baumbus.dohitgethit.commands.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class DoHitGetHit extends JavaPlugin implements Listener {

    public static final String pluginName = "[DoHitGetHit]";
    private static ConfigLoader configLoader;

    @Override
    public void onEnable() {
        getLogger().info("Startup");
        configLoader = new ConfigLoader();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            Objects.requireNonNull(this.getCommand("toggle")).setExecutor(new CommandToggle());
            Objects.requireNonNull(this.getCommand("change")).setExecutor(new CommandChange());
            Objects.requireNonNull(this.getCommand("show-config")).setExecutor(new CommandShowConfig());
            Objects.requireNonNull(this.getCommand("add-immune")).setExecutor(new CommandAddImmune());
            Objects.requireNonNull(this.getCommand("remove-immune")).setExecutor(new CommandRemoveImmune());
        } catch (Exception ex) {
            getLogger().log(Level.SEVERE, DoHitGetHit.pluginName + " Could not register commands", ex);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutdown");
        configLoader.saveConfig();
    }

    public static ConfigLoader getConfigLoader() {
        return configLoader;
    }
}
