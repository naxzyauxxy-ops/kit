package com.yourserver.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitCommand implements CommandExecutor {

    long cooldown = 600000;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("kit")) {

            if (args.length == 0) {
                player.sendMessage("§6Available Kits: starter, vip, mvp");
                return true;
            }

            String kit = args[0];

            KitManager manager = KitPlugin.getInstance().getKitManager();

            if (manager.isOnCooldown(player.getUniqueId(), kit, cooldown)) {
                player.sendMessage("§cKit is on cooldown!");
                return true;
            }

            if (player.getInventory().firstEmpty() == -1) {
                player.sendMessage("§cInventory full!");
                return true;
            }

            if (kit.equalsIgnoreCase("starter")) {

                player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));

                manager.setCooldown(player.getUniqueId(), kit);

                player.sendMessage("§aStarter kit received!");
            }
        }

        if (cmd.getName().equalsIgnoreCase("kitcooldown")) {

            if (!player.hasPermission("kit.admin"))
                return true;

            if (args.length < 2) return true;

            if (args[0].equalsIgnoreCase("remove")) {

                Player target = Bukkit.getPlayer(args[1]);

                KitPlugin.getInstance().getKitManager()
                        .removeCooldowns(target.getUniqueId());

                player.sendMessage("Cooldown removed.");
            }
        }

        return true;
    }
}
