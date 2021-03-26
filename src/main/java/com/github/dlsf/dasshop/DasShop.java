package com.github.dlsf.dasshop;

import com.github.dlsf.dasshop.configuration.Config;
import org.bukkit.plugin.java.JavaPlugin;

public class DasShop extends JavaPlugin {

    private static DasShop instance;

    private Config messageConfig;

    public DasShop() {
        instance = this;
    }

    @Override
    public void onEnable() {
        messageConfig = new Config("messages.yml", this);

        getLogger().info("dasShop has been started successfully!");
    }

    public static DasShop getInstance() {
        return instance;
    }

    public Config getMessageConfig() {
        return messageConfig;
    }

}
