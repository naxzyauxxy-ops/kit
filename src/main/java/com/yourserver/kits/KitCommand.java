package com.yourserver.kits;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        if (args.length == 0) {
            p.sendMessage("§eUse /kits to open kit menu");
            return true;
        }

        String kit = args[0].toLowerCase();

        long cd = KitPlugin.get().getConfig().getInt("cooldown-seconds") * 1000L;

        KitManager m = KitPlugin.get().getManager();

        if (m.onCooldown(p.getUniqueId(), kit, cd)) {
            p.sendMessage("§cKit on cooldown!");
            return true;
        }

        if (p.getInventory().firstEmpty() == -1) {
            p.sendMessage("§cInventory full!");
            return true;
        }

        if (kit.equals("starter")) {
            p.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
            p.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
        }

        if (kit.equals("vip")) {
            p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
        }

        if (kit.equals("mvp")) {
            p.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD));
        }

        m.set(p.getUniqueId(), kit);

        p.sendMessage("§aYou received the " + kit + " kit!");

        return true;
    }
}