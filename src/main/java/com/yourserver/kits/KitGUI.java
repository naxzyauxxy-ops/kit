package com.yourserver.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitGUI implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player p = (Player) sender;

        Inventory gui = Bukkit.createInventory(null, 27, "Kits");

        gui.setItem(11, new ItemStack(Material.IRON_SWORD));
        gui.setItem(13, new ItemStack(Material.DIAMOND_SWORD));
        gui.setItem(15, new ItemStack(Material.NETHERITE_SWORD));

        p.openInventory(gui);

        return true;
    }
}