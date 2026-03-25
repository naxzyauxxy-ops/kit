package com.yourserver.kits;

import java.util.HashMap;
import java.util.UUID;

public class KitManager {

    private final HashMap<String, HashMap<UUID, Long>> cooldowns = new HashMap<>();

    public boolean onCooldown(UUID player, String kit, long cd) {

        cooldowns.putIfAbsent(kit, new HashMap<>());

        if (!cooldowns.get(kit).containsKey(player))
            return false;

        long last = cooldowns.get(kit).get(player);

        return System.currentTimeMillis() - last < cd;
    }

    public void set(UUID player, String kit) {

        cooldowns.putIfAbsent(kit, new HashMap<>());
        cooldowns.get(kit).put(player, System.currentTimeMillis());
    }

    public void clear(UUID player) {
        for (String kit : cooldowns.keySet())
            cooldowns.get(kit).remove(player);
    }
}