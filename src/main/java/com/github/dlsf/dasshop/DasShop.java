package com.github.dlsf.dasshop;

import com.github.dlsf.dasshop.commands.EditShopCommand;
import com.github.dlsf.dasshop.commands.ShopCommand;
import com.github.dlsf.dasshop.configuration.Config;
import com.github.dlsf.dasshop.configuration.Message;
import org.bukkit.plugin.java.JavaPlugin;

public class DasShop extends JavaPlugin {

    private static DasShop instance;

    private Config messageConfig;

    public DasShop() {
        instance = this;
    }

    @Override
    public void onEnable() {
        initializeConfigs();
        registerCommands();

        getLogger().info("dasShop has been started successfully!");
    }

    private void initializeConfigs() {
        messageConfig = new Config("messages.yml", this);

        for (Message message : Message.values()) {
            messageConfig.setDefault(message.getConfigKey(), message.getDefaultValue());
        }

        messageConfig.save();
    }

    private void registerCommands() {
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("editshop").setExecutor(new EditShopCommand());
    }

    public static DasShop getInstance() {
        return instance;
    }

    public Config getMessageConfig() {
        return messageConfig;
    }

}
