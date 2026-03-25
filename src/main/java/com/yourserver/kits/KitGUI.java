package com.yourserver.kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(null, 9, "Kits");

        inv.setItem(2, new ItemStack(Material.IRON_SWORD));
        inv.setItem(4, new ItemStack(Material.DIAMOND_SWORD));
        inv.setItem(6, new ItemStack(Material.NETHERITE_SWORD));

        player.openInventory(inv);

        return true;
    }
