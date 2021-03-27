package com.github.dlsf.dasshop.configuration;

import com.github.dlsf.dasshop.DasShop;
import org.bukkit.ChatColor;

public enum Message {

    PREFIX("prefix", ChatColor.DARK_AQUA + "DasShop " + ChatColor.DARK_GRAY + "» " + ChatColor.GRAY),
    NO_PLAYER("no_player", ChatColor.RED + "You have to be a player to execute this command."),
    NO_PERMISSIONS("no_permissions", ChatColor.RED + "You don't have permissions to execute this command.");

    private final String configKey;
    private final String defaultValue;

    Message(String configKey, String defaultValue) {
        this.configKey = configKey;
        this.defaultValue = defaultValue;
    }

    public String getConfigKey() {
        return configKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String get() {
        return PREFIX.getColored() + getColored();
    }

    // TODO: Implement get() with placeholders

    private String getColored() {
        return ChatColor.translateAlternateColorCodes('&', DasShop.getInstance().getMessageConfig().getString(configKey));
    }

}
