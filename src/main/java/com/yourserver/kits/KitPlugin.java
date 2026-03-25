package com.yourserver.kits;

import org.bukkit.plugin.java.JavaPlugin;

public class KitPlugin extends JavaPlugin {

    private static KitPlugin instance;
    private KitManager manager;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        manager = new KitManager();

        getCommand("kit").setExecutor(new KitCommand());
        getCommand("kits").setExecutor(new KitGUI());
        getCommand("kitcooldown").setExecutor(new KitAdmin());

        getLogger().info("ProKits enabled.");
    }

    public static KitPlugin get() {
        return instance;
    }

    public KitManager getManager() {
        return manager;
    }
}