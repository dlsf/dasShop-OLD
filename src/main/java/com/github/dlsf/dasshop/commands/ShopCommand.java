package com.github.dlsf.dasshop.commands;

import com.github.dlsf.dasshop.configuration.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class ShopCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.NO_PLAYER.get());
            return false;
        }

        Player player = (Player) sender;
        // TODO: Permissions check

        if (args.length == 0) {
            ShopGUI.open(player); // TODO: Implement shop GUI
        } else {
            // TODO: Category exists check
            ShopGUI.open(player, args[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }

}
