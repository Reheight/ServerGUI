package me.reheight.servergui.events;

import me.reheight.servergui.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;

public class SelectedServer implements Listener {
    Main plugin;
    public SelectedServer(Main instance) {
        plugin = instance;
    }

    private sendPlayerToServerEvent sendPlayer = new sendPlayerToServerEvent(plugin);

    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @EventHandler
    public void serverSelect(InventoryClickEvent event) {
        Entity selectorEntity = event.getWhoClicked();

        if (!(selectorEntity instanceof Player)) return;

        Player selector = (Player)selectorEntity;

        if (event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase(color("&d&nExpeditions"))) {

            if (event.getCurrentItem() == null) {
                return;
            }

            List<Material> usedItems = new ArrayList<>();

            usedItems.add(Material.STAINED_GLASS_PANE);
            usedItems.add(Material.TNT);
            usedItems.add(Material.IRON_SWORD);
            usedItems.add(Material.CHEST);
            usedItems.add(Material.IRON_FENCE);

            if (!usedItems.contains(event.getCurrentItem().getType())) event.setCancelled(true);
            if (!event.getClickedInventory().getTitle().equals(color("&d&nExpeditions"))) {
                event.setCancelled(true);
                return;
            }

            if (event.getCurrentItem().getType().equals(Material.NETHER_STAR)) {
                selector.sendMessage(color("&8[&6Celmic Network&8] &fAttempting to connect you to Lobby!"));
                event.setCancelled(true);
                sendPlayer.sendPlayerToServer(selector, "Lobby");

            }

            if (event.getCurrentItem().getType().equals(Material.IRON_SWORD)) {
                selector.sendMessage(color("&8[&dCelmic Network&8] &fAttempting to connect you to Factions!"));
                event.setCancelled(true);
                sendPlayer.sendPlayerToServer(selector, "Factions");

            }

            if (event.getCurrentItem().getType().equals(Material.TNT)) {
                selector.sendMessage(color("&8[&dCelmic Network&8] &fAttempting to connect you to Cannon Practice!"));
                event.setCancelled(true);
                sendPlayer.sendPlayerToServer(selector, "Cannon");
            }

            if (event.getCurrentItem().getType().equals(Material.CHEST)) {
                selector.sendMessage(color("&8[&dCelmic Network&8] &fAttempting to connect you to KitPvP!"));
                event.setCancelled(true);
                sendPlayer.sendPlayerToServer(selector, "KitPvP");
            }

            if (event.getCurrentItem().getType().equals(Material.IRON_FENCE)) {
                selector.sendMessage(color("&8[&dCelmic Network&8] &fAttempting to connect you to Prison!"));
                event.setCancelled(true);
                sendPlayer.sendPlayerToServer(selector, "Prison");
            }

            event.setCancelled(true);
        }
    }
}
