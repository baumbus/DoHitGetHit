package io.github.baumbus.dohitgethit;

import io.github.baumbus.dohitgethit.commands.CommandChange;
import io.github.baumbus.dohitgethit.commands.CommandShowConfig;
import io.github.baumbus.dohitgethit.commands.CommandToggle;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class DoHitGetHit extends JavaPlugin implements Listener {

    public static final String pluginName = "[DoHitGetHit]";
    public static ConfigLoader configs;

    @Override
    public void onEnable() {
        getLogger().info("Startup");
        configs = new ConfigLoader();
        configs.loadProperties();
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        try {
            this.getCommand("toggle").setExecutor(new CommandToggle());
            this.getCommand("change").setExecutor(new CommandChange());
            this.getCommand("show-config").setExecutor(new CommandShowConfig());
        } catch (Exception ex) {
            getLogger().log(Level.SEVERE, DoHitGetHit.pluginName + " Could not register commands", ex);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutdown");
        configs.saveProperties();
    }
}
