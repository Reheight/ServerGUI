package me.reheight.servergui.events;

import me.reheight.servergui.Main;
import me.reheight.servergui.items.ServerSelector;
import me.reheight.servergui.utilities.CenteredText;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {
    Main plugin;
    public playerJoinEvent(Main instance) {
        plugin = instance;
    }

    public String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @EventHandler
    public void serverSpawn(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage("");
        CenteredText.sendCenteredMessage(player, "&d&lCelmic Network");
        player.sendMessage("");
        CenteredText.sendCenteredMessage(player, "&d&lSHOP: &f&nstore.celmicnetwork.tk");
        CenteredText.sendCenteredMessage(player, "&d&lFORUMS: &f&nforums.celmicnetwork.tk");
        CenteredText.sendCenteredMessage(player, "&d&lDISCORD: &f&ndiscord.celmicnetwork.tk");
        player.sendMessage("");

        ServerSelector serverSelector = new ServerSelector(player);

        if (plugin.getServer().getPort() == 38928) {
            Location spawnLocation = Bukkit.getWorld("world").getSpawnLocation();
            serverSelector.giveItemSelector();
            player.teleport(spawnLocation);
        }
    }
}
