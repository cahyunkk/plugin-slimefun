package com.github.cahyunkk.nusaengine;

import org.bukkit.plugin.java.JavaPlugin;

public class NusaEngine extends JavaPlugin {

    private static NusaEngine instance;
    private MobStatsManager statsManager;
    private MobAIManager aiManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.statsManager = new MobStatsManager(this);
        this.aiManager = new MobAIManager(this);

        getLogger().info("NusaEngine v" + getDescription().getVersion() + " enabled.");
        if (getServer().getPluginManager().getPlugin("NusaMobs") != null) {
            getLogger().info("NusaMobs detected — engine integration active.");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("NusaEngine disabled.");
    }

    public static NusaEngine getInstance() {
        return instance;
    }

    public MobStatsManager getStatsManager() {
        return statsManager;
    }

    public MobAIManager getAIManager() {
        return aiManager;
    }
}
