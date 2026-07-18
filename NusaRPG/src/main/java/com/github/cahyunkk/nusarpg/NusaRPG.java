package com.github.cahyunkk.nusarpg;

import org.bukkit.plugin.java.JavaPlugin;

public class NusaRPG extends JavaPlugin {

    private static NusaRPG instance;
    private PlayerStatsManager statsManager;
    private JobSystem jobSystem;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.statsManager = new PlayerStatsManager(this);
        this.jobSystem = new JobSystem(this);

        getCommand("nusa").setExecutor(new RPGCommand(this));
        getServer().getPluginManager().registerEvents(new RPGListener(this), this);

        if (getServer().getPluginManager().getPlugin("NusaItems") != null) {
            getLogger().info("NusaItems integration active.");
        }
        if (getServer().getPluginManager().getPlugin("NusaSkills") != null) {
            getLogger().info("NusaSkills integration active.");
        }

        getLogger().info("NusaRPG v" + getDescription().getVersion() + " enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("NusaRPG disabled.");
    }

    public static NusaRPG getInstance() {
        return instance;
    }

    public PlayerStatsManager getStatsManager() {
        return statsManager;
    }

    public JobSystem getJobSystem() {
        return jobSystem;
    }
}
