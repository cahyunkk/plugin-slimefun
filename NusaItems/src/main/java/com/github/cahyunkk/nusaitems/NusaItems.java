package com.github.cahyunkk.nusaitems;

import com.github.cahyunkk.nusaitems.command.NusaCommand;
import com.github.cahyunkk.nusaitems.hook.HookManager;
import com.github.cahyunkk.nusaitems.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public final class NusaItems extends JavaPlugin {

    private static NusaItems instance;
    private ConfigLoader configLoader;
    private ItemRegistry itemRegistry;
    private ResourcePackBuilder packBuilder;
    private PackServer packServer;
    private HookManager hookManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configLoader = new ConfigLoader(this);
        itemRegistry = new ItemRegistry(this);
        packBuilder = new ResourcePackBuilder(this);
        packServer = new PackServer(this);
        hookManager = new HookManager(this);
        reloadAll();
        NusaItemsAPI.init(this);
        Objects.requireNonNull(getCommand("nusaitems")).setExecutor(new NusaCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getScheduler().runTaskLater(this, () -> hookManager.loadAll(), 20L);
        getLogger().info("§a✅ NusaItems v" + getPluginMeta().getVersion() + " loaded! "
                + itemRegistry.getItemCount() + " items | pack " + (packServer.isRunning() ? "§2ON" : "§cOFF")
                + " | hooks: " + hookManager.getEnabledHookCount());
    }

    @Override
    public void onDisable() {
        if (hookManager != null) hookManager.unloadAll();
        if (packServer != null) packServer.stop();
        NusaItemsAPI.disable();
        getLogger().info("§cNusaItems disabled.");
    }

    public void reloadAll() {
        configLoader.reload(); itemRegistry.registerAll(); packBuilder.generate();
        if (configLoader.isPackServerEnabled() && !packServer.isRunning()) packServer.start();
        else if (!configLoader.isPackServerEnabled() && packServer.isRunning()) packServer.stop();
    }

    public static NusaItems getInstance() { return instance; }
    public ConfigLoader getConfigLoader() { return configLoader; }
    public ItemRegistry getItemRegistry() { return itemRegistry; }
    public ResourcePackBuilder getPackBuilder() { return packBuilder; }
    public PackServer getPackServer() { return packServer; }
    public HookManager getHookManager() { return hookManager; }
}
