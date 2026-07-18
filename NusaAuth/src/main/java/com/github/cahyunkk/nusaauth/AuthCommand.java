package com.github.cahyunkk.nusaauth;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AuthCommand implements CommandExecutor {

    private final NusaAuth plugin;

    public AuthCommand(NusaAuth plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            boolean logged = plugin.getAuthManager().isLoggedIn(p.getUniqueId());
            sender.sendMessage("§6[NusaAuth] §eStatus login: §f" + (logged ? "Aktif" : "Tidak aktif"));
        } else {
            sender.sendMessage("§6[NusaAuth] §cHanya pemain yang bisa menggunakan perintah ini.");
        }
        return true;
    }
}
