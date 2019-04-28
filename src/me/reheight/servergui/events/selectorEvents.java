package me.reheight.servergui.events;

import me.reheight.servergui.Main;
import me.reheight.servergui.inventories.SelectorGUI;
import me.reheight.servergui.items.ServerSelector;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class selectorEvents implements Listener {
    Main plugin;
    public selectorEvents(Main instance) {
        plugin = instance;
    }

    ItemStack serverSelector = ServerSelector.serverSelector;

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent event) {
        if (event.getItemDrop() == null) {
            return;
        }

        if (plugin.getServer().getPort() == 38928) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickup(InventoryClickEvent event) {
        if (event.getCurrentItem() == null) {
            return;
        }
        if (event.getCurrentItem().equals(serverSelector)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemSwap(InventoryMoveItemEvent event) {
        if (event.getItem() == null) {
            return;
        }
        if (event.getItem().equals(serverSelector)) event.setCancelled(true);
    }

    @EventHandler
    public void onItemInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        SelectorGUI selectorGUI = new SelectorGUI(player);

        if (event.getItem() == null) {
            return;
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem().equals(serverSelector)) {
                event.setCancelled(true);
                selectorGUI.openSelector();
            }
        } else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().equals(serverSelector)) {
                event.setCancelled(true);
                selectorGUI.openSelector();
            }
        }

        return;
    }
}
