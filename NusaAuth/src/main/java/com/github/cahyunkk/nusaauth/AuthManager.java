package com.github.cahyunkk.nusaauth;

import java.util.*;

public class AuthManager {

    private final NusaAuth plugin;
    private final Set<UUID> loggedIn = new HashSet<>();

    public AuthManager(NusaAuth plugin) {
        this.plugin = plugin;
    }

    public boolean login(UUID playerId) {
        loggedIn.add(playerId);
        plugin.getConfig().set("sessions." + playerId + ".login", System.currentTimeMillis());
        return true;
    }

    public boolean isLoggedIn(UUID playerId) {
        return loggedIn.contains(playerId);
    }

    public void logout(UUID playerId) {
        loggedIn.remove(playerId);
    }
}
