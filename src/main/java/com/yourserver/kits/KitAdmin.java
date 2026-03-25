package com.yourserver.kits;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class KitAdmin implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("kit.admin")) return true;

        if (args.length < 2) return true;

        if (args[0].equalsIgnoreCase("remove")) {

            Player target = Bukkit.getPlayer(args[1]);

            if (target == null) return true;

            KitPlugin.get().getManager().clear(target.getUniqueId());

            sender.sendMessage("Cooldowns removed.");
        }

        return true;
    }
}