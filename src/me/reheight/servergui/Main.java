package me.reheight.servergui;

import me.reheight.servergui.bungeecord.PluginMessage;
import me.reheight.servergui.commnads.server;
import me.reheight.servergui.events.SelectedServer;
import me.reheight.servergui.events.playerJoinEvent;
import me.reheight.servergui.events.selectorEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private server serverCMD = new server(this);
    private SelectedServer selectedServer = new SelectedServer(this);
    private PluginMessage pluginMessage = new PluginMessage();
    private selectorEvents SelectorEvents = new selectorEvents(this);
    private playerJoinEvent playerJoin = new playerJoinEvent(this);

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Initialization success!");
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage());

        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(selectedServer, this);
        pm.registerEvents(playerJoin, this);
        pm.registerEvents(SelectorEvents, this);

        if (getServer().getPort() == 38928) {
            Bukkit.getWorld("world").setSpawnLocation(-2050, 59, -493);
        }

        getCommand("server").setExecutor(serverCMD);
    }

    public static final Main getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        getLogger().info("Shutdown success!");
    }
}
