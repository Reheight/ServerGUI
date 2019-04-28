package me.reheight.servergui.events;

import me.reheight.servergui.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class sendPlayerToServerEvent {
    Main plugin;
    public sendPlayerToServerEvent(Main instance) {
        plugin = instance;
    }


    public void sendPlayerToServer(Player player, String server) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (Exception e) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Celmic Network&8] &fThere was an problem connecting to " + server + "!"));
            return;
        }

        player.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
    }
}
