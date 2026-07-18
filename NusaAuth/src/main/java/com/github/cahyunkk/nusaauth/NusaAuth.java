package com.github.cahyunkk.nusaauth;

import org.bukkit.plugin.java.JavaPlugin;

public class NusaAuth extends JavaPlugin {

    private static NusaAuth instance;
    private AuthManager authManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        this.authManager = new AuthManager(this);
        getCommand("nusaauth").setExecutor(new AuthCommand(this));
        getServer().getPluginManager().registerEvents(new AuthListener(this), this);

        getLogger().info("NusaAuth v" + getDescription().getVersion() + " enabled.");
        getLogger().info("Auth: automatic session tracking.");
        getLogger().info("Bedrock support: automatic resource pack (no manual config needed).");
    }

    @Override
    public void onDisable() {
        getLogger().info("NusaAuth disabled.");
    }

    public static NusaAuth getInstance() {
        return instance;
    }

    public AuthManager getAuthManager() {
        return authManager;
    }
}
