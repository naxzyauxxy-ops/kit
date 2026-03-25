package com.yourserver.kits;

import org.bukkit.plugin.java.JavaPlugin;

public class KitPlugin extends JavaPlugin {

    private static KitPlugin instance;
    private KitManager kitManager;

    @Override
    public void onEnable() {

        instance = this;

        kitManager = new KitManager();

        getCommand("kit").setExecutor(new KitCommand());
        getCommand("kits").setExecutor(new KitGUI());
        getCommand("kitcooldown").setExecutor(new KitCommand());

        getLogger().info("Kit Plugin Enabled!");
    }

    public static KitPlugin getInstance() {
        return instance;
    }

    public KitManager getKitManager() {
        return kitManager;
    }
}
