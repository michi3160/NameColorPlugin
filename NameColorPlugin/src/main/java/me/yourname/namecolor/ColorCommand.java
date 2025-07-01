package me.yourname.namecolor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /namecolor <player> <color>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        String colorCode = args[1].toLowerCase().replace("&", "");
        ChatColor color = ChatColor.getByChar(colorCode);
        if (color == null || !color.isColor()) {
            sender.sendMessage(ChatColor.RED + "Invalid color. Use &0 to &f.");
            return true;
        }

        if (sender != target && !sender.hasPermission("namecolor.others")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to change others' name color.");
            return true;
        }

        if (sender == target && !sender.hasPermission("namecolor.self")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to change your name color.");
            return true;
        }

        ChatColorManager.setPlayerColor(target.getUniqueId().toString(), color);
        sender.sendMessage(ChatColor.GREEN + "Changed " + target.getName() + "'s name color to " + color + color.name());
        return true;
    }
}
