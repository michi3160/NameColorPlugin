package me.yourname.namecolor;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatColorManager implements Listener {
    private static final File file = new File(NameColorPlugin.getInstance().getDataFolder(), "players.yml");
    private static final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    private static final Map<String, ChatColor> playerColors = new HashMap<>();

    public static void setPlayerColor(String uuid, ChatColor color) {
        playerColors.put(uuid, color);
        config.set(uuid, color.name());
        savePlayerColors();
    }

    public static void loadPlayerColors() {
        if (file.exists()) {
            for (String uuid : config.getKeys(false)) {
                try {
                    ChatColor color = ChatColor.valueOf(config.getString(uuid));
                    playerColors.put(uuid, color);
                } catch (IllegalArgumentException ignored) {}
            }
        }
    }

    public static void savePlayerColors() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        ChatColor color = playerColors.getOrDefault(player.getUniqueId().toString(),
                LuckPermsHook.getGroupColor(player));
        event.setFormat(color + player.getName() + ChatColor.RESET + ": " + event.getMessage());
    }
}
