package me.yourname.namecolor;

import org.bukkit.plugin.java.JavaPlugin;

public class NameColorPlugin extends JavaPlugin {
    private static NameColorPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        ChatColorManager.loadPlayerColors();
        getCommand("namecolor").setExecutor(new ColorCommand());
        getServer().getPluginManager().registerEvents(new ChatColorManager(), this);
        getLogger().info("NameColorPlugin enabled.");
    }

    @Override
    public void onDisable() {
        ChatColorManager.savePlayerColors();
        getLogger().info("NameColorPlugin disabled.");
    }

    public static NameColorPlugin getInstance() {
        return instance;
    }
}
