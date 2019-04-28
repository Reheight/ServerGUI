package me.reheight.servergui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ServerSelector {
    Player reciever = null;

    public static ItemStack serverSelector = new ItemStack(Material.NETHER_STAR, 1);

    public ServerSelector(Player player) {
        reciever = player;
    }

    public String color(String color) {
        return ChatColor.translateAlternateColorCodes('&', color);
    }

    public void giveItemSelector() {
        ItemMeta serverSelectorMeta = serverSelector.getItemMeta();
        serverSelectorMeta.setDisplayName(color("&d&nExpedition&d &nTeleporter&7 &o(Right Click)"));

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(color("&7&oThis tool is a long lost tool that"));
        lore.add(color("&7&oonly the luckiest expeditionists"));
        lore.add(color("&7&ohave access to!"));
        lore.add("");
        lore.add(color(" &d&l* &7Command: &d/server"));
        lore.add("");
        lore.add(color("&d&l(!) &dRight click to view the &nExpedition&d &nSelector&d!"));

        serverSelectorMeta.setLore(lore);
        serverSelector.setItemMeta(serverSelectorMeta);

        reciever.getInventory().clear();
        reciever.getInventory().setItem(4, serverSelector);
    }
}
