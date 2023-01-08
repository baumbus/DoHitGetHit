package io.github.baumbus.dohitgethit;

import org.bukkit.Bukkit;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;

public class ConfigLoader {

    private final static String propertiesPath = "config/DHGH-config.properties";
    private final Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        setDefaultProperties();
    }

    public void setDefaultProperties() {
        properties.setProperty("modifier", "0.5");
        properties.setProperty("status", "true");
    }

    public void loadProperties() {
        try {
            properties.load(Files.newInputStream(Paths.get(propertiesPath)));
            float mod = Float.parseFloat(properties.getProperty("modifier"));
            if (mod < 0) {
                mod = 0.0f;
                Bukkit.getServer().getLogger().info(DoHitGetHit.pluginName + " Modifier was changed to 0.0");
            }
            if (1 < mod) {
                mod = 1.0f;
                Bukkit.getServer().getLogger().info(DoHitGetHit.pluginName + " Modifier was changed to 1.0");
            }
            properties.setProperty("modifier", Float.toString(mod));
        } catch (Exception ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, DoHitGetHit.pluginName + " Could not load config file");
            Bukkit.getServer().getLogger().log(Level.SEVERE, DoHitGetHit.pluginName + " Loaded default config");
            setDefaultProperties();
        }
    }

    public void saveProperties() {
        try {
            properties.store(Files.newOutputStream(Paths.get(propertiesPath)), null);
        } catch (Exception ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, DoHitGetHit.pluginName + " Could not save config file", ex);
        }
    }

    public boolean getStatus() {
        return Boolean.parseBoolean(properties.getProperty("status"));
    }

    public void setStatus(boolean status) {
        properties.setProperty("status", status ? "true" : "false");
    }

    public float getModifier() {
        return Float.parseFloat(properties.getProperty("modifier"));
    }

    public void setModifier(float modifier) {
        properties.setProperty("modifier", Float.toString(modifier));
    }
}
