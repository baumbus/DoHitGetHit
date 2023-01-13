package io.github.baumbus.dohitgethit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.logging.Level;

public class ConfigLoader {

    private final String CONFIG_PATH = "config/DHGH.yaml";
    private ObjectMapper mapper;
    private Config config;

    public ConfigLoader() {
        mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        try {
            config = mapper.readValue(new File(CONFIG_PATH), Config.class);
        } catch (Exception ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Couldn't load configs", ex);
            config = new Config();
            config.setModifier(0.5f);
            config.setStatus(true);
        }
    }

    public void saveConfig() {
        mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        try {
            mapper.writeValue(new File(CONFIG_PATH), config);
        } catch (Exception ex) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Couldn't save the config", ex);
        }
    }

    public Config getConfig() {
        return config;
    }
}
