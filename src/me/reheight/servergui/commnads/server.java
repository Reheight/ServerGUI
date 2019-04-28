package me.reheight.servergui.commnads;

import me.reheight.servergui.Main;
import me.reheight.servergui.bungeecord.PluginMessage;
import me.reheight.servergui.inventories.SelectorGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class server implements CommandExecutor {
    Main plugin;
    public server(Main instance) {
        plugin = instance;
    }

    private SelectorGUI selector = null;
    private PluginMessage pluginMessage = new PluginMessage();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be in game to perform this command!");
            return true;
        }

        Player player = (Player)sender;
        selector = new SelectorGUI(player);

        if (command.getName().equalsIgnoreCase("server")) {
            selector.openSelector();
        }

        return true;
    }
}
