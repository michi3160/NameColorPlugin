package me.yourname.namecolor;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LuckPermsHook {
    public static ChatColor getGroupColor(Player player) {
        try {
            LuckPerms api = LuckPermsProvider.get();
            User user = api.getUserManager().getUser(player.getUniqueId());
            if (user == null) return ChatColor.WHITE;
            String group = user.getPrimaryGroup();
            String colorStr = NameColorPlugin.getInstance().getConfig().getString("groups." + group, "&f");
            return ChatColor.getByChar(colorStr.replace("&", ""));
        } catch (Exception e) {
            return ChatColor.WHITE;
        }
    }
}
