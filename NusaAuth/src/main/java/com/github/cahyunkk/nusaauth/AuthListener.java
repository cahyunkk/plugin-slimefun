package com.github.cahyunkk.nusaauth;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AuthListener implements Listener {

    private final NusaAuth plugin;

    public AuthListener(NusaAuth plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getAuthManager().login(event.getPlayer().getUniqueId());
        event.getPlayer().sendMessage("§6[NusaAuth] §eAutentikasi berhasil. Selamat datang!");
        event.getPlayer().sendMessage("§7Java & Bedrock compatible — tanpa config manual Bedrock.");
    }
}
