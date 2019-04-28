package me.reheight.servergui.bungeecord;


import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import me.reheight.servergui.utilities.SharedVariables;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessage implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;

        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subchannel = input.readUTF();

        if (subchannel.equals("PlayerCount")) {
            String server = input.readUTF();
            int playerCount = input.readInt();

            if (server.equals("Factions")) {
                SharedVariables.serverFactionsCount = playerCount;
            }

            if (server.equals("Cannon")) {
                SharedVariables.serverCannonCount = playerCount;
            }

            if (server.equals("KitPvP")) {
                SharedVariables.serverKitPvPCount = playerCount;
            }

            if (server.equals("Prison")) {
                SharedVariables.serverPrisonCount = playerCount;
            }
        }
    }
}
