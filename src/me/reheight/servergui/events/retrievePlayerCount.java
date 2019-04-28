package me.reheight.servergui.events;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.reheight.servergui.Main;
import org.bukkit.entity.Player;

public class retrievePlayerCount {
    Main plugin;
    public retrievePlayerCount(Main instance) {
        plugin = instance;
    }

    public void getCount(Player player, String server) {
        if (server == null) {
            server = "ALL";
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);

        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
