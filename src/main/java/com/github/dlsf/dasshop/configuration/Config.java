package com.github.dlsf.dasshop.configuration;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Config extends YamlConfiguration {

    private String name;
    private JavaPlugin javaPlugin;

    private File file;

    public Config(String name, JavaPlugin javaPlugin) {
        this.name = name;
        this.javaPlugin = javaPlugin;

        reload();
    }

    private void reload() {
        file = new File(javaPlugin.getDataFolder(), name);

        try {
            if (!file.exists())
                if (!file.createNewFile())
                    throw new RuntimeException("Could not create ${NAME} " + name);

            load(file);
        } catch (IOException | InvalidConfigurationException e) {
            // Do nothing
        }
    }

    public void save() {
        try {
            save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefault(String path, Object value) {

        if(!isSet(path)) {
            set(path, value);
        }

    }

}