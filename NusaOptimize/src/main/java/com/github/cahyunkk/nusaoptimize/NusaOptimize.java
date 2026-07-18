package com.github.cahyunkk.nusaoptimize;

import org.bukkit.plugin.java.JavaPlugin;

public class NusaOptimize extends JavaPlugin {

    private static NusaOptimize instance;
    private OptimizeManager optimizeManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.optimizeManager = new OptimizeManager(this);
        getCommand("nusaoptimize").setExecutor(new OptimizeCommand(this));
        getServer().getPluginManager().registerEvents(new OptimizeListener(this), this);

        getLogger().info("NusaOptimize v" + getDescription().getVersion() + " enabled.");
        getLogger().info("Anti-lag: automatic entity & chunk optimization active.");
        getLogger().info("Bedrock support: automatic resource pack (no manual config needed).");
    }

    @Override
    public void onDisable() {
        getLogger().info("NusaOptimize disabled.");
    }

    public static NusaOptimize getInstance() {
        return instance;
    }

    public OptimizeManager getOptimizeManager() {
        return optimizeManager;
    }
}
