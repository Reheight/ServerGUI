package me.reheight.servergui.inventories;

import me.reheight.servergui.Main;
import me.reheight.servergui.events.retrievePlayerCount;
import me.reheight.servergui.events.retrieveServerStatus;
import me.reheight.servergui.utilities.SharedVariables;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SelectorGUI {
    Player selector = null;


    public static String selectorName = ChatColor.translateAlternateColorCodes('&', "&d&nExpeditions");
    public static Inventory serverGUI = Bukkit.createInventory(null, 45, selectorName);
    private retrievePlayerCount playerCount = new retrievePlayerCount(Main.getInstance());
    public SelectorGUI(Player player) {
        selector = player;
    }

    public void openSelector() {
        ItemStack barrier = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta barrierMeta = barrier.getItemMeta();
        barrierMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f"));
        barrier.setDurability((short)15);

        // Factions
        ItemStack factions = new ItemStack(Material.IRON_SWORD);
        ItemMeta factionsMeta = factions.getItemMeta();
        factionsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lFactions Expedition &7&o(Season 1)"));
        List<String> loreListFactions = new ArrayList<>();
        playerCount.getCount(selector, "Factions");
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&f" + SharedVariables.serverFactionsCount + "/300 Explorers"));

        if (retrieveServerStatus.online("Factions") == true) {
            loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&a&lOnline"));
        } else {
            loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&c&lOffline"));
        }

        loreListFactions.add("");
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&7&oThe Expedition created by highly advanced civilizations"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&7&owho are in constant battle, where many result"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&7&oto &c&nFighting&7&o for any possible chance of survival of"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&7&osuch harsh cruel conditions and possibility of defeating"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&7&othe &c&nColony&c &nEmperor&7&o for total control"));
        loreListFactions.add("");
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&dFeatures:"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Server Version: &d1.8.9+"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Retention System: &d1.0"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Custom Enchantments"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &71.8 PvP Mechanics"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &724 Player Factions"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&dInformation:"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Season: &d#1"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Owned by: &dReheight"));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListFactions.add(ChatColor.translateAlternateColorCodes('&', "&d&l(!) &dClick to be transported to &a&nFactions&a &nExpedition&d!"));

        factionsMeta.setLore(loreListFactions);
        factions.setItemMeta(factionsMeta);

        factionsMeta.setLore(loreListFactions);
        factions.setItemMeta(factionsMeta);


        // Cannon
        ItemStack cannon = new ItemStack(Material.TNT);
        ItemMeta cannonMeta = cannon.getItemMeta();
        cannonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lCannon Expedition &7&o(Plots)"));
        List<String> loreListCannon = new ArrayList<>();

        playerCount.getCount(selector, "Cannon");

        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&f" + SharedVariables.serverCannonCount + "/300 Explorers"));
        if (retrieveServerStatus.online("Cannon") == true) {
            loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&a&lOnline"));
        } else {
            loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&c&lOffline"));
        }

        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&7&oThe Expedition that was originally"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&7&oa conquest for the &c&nElite&c &nRaiders"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&7&ocolony whom are notorious for ransacking"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&7&oeven the poorest villages!"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&dFeatures:"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Server Type: &d1.8.9+"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Creative Mode"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Schematica Supported"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Controlled WorldEdit"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Plots"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&dInformation:"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &fSeason: &d#1"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Owned by: &dReheight"));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListCannon.add(ChatColor.translateAlternateColorCodes('&', "&d&l(!) &dclick to be transported to &c&nCannon&c &nExpedition&d!"));
        cannonMeta.setLore(loreListCannon);
        cannon.setItemMeta(cannonMeta);

        // KitPvP
        ItemStack KitPvP = new ItemStack(Material.CHEST);
        ItemMeta KitPvPMeta = KitPvP.getItemMeta();
        KitPvPMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lKitPvP Expedition &7&o(Season 1)"));
        List<String> loreListKitPvP = new ArrayList<>();

        playerCount.getCount(selector, "KitPvP");

        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&f" + SharedVariables.serverKitPvPCount + "/300 Explorers"));
        if (retrieveServerStatus.online("KitPvP") == true) {
            loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&a&lOnline"));
        } else {
            loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&c&lOffline"));
        }

        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&7&oThe Expedition that marked the end of the &c&nDark &c &nEra"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&7&oa conquest for the &c&nFiercest&c &nFighters&7&o and their"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&7&oallies, and the to-date most expensive Expedition to have"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&7&oever been carried out by a colony!"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&dFeatures:"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Server Type: &d1.8.9+"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &71.8 PvP Mechanics"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Colony Points"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Level System"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Weekly Challenges"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&dInformation:"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &fSeason: &d#1"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Owned by: &dxEnchantress"));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&d&l(!) &dclick to be transported to &b&nKitPvP&b &nExpedition&d!"));
        KitPvPMeta.setLore(loreListKitPvP);
        KitPvP.setItemMeta(KitPvPMeta);

        // KitPvP
        ItemStack Prison = new ItemStack(Material.IRON_FENCE);
        ItemMeta PrisonMeta = Prison.getItemMeta();
        PrisonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lPrison Expedition &7&o(Season 1)"));
        List<String> loreListPrison = new ArrayList<>();

        playerCount.getCount(selector, "Prison");

        loreListKitPvP.add(ChatColor.translateAlternateColorCodes('&', "&f" + SharedVariables.serverKitPvPCount + "/300 Explorers"));
        if (retrieveServerStatus.online("Prison") == true) {
            loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&a&lOnline"));
        } else {
            loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&c&lOffline"));
        }

        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&7&oThe Expedition to attempt &c&nrecovery&7&o from the greatest"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&7&odownfall that happened once a colony &c&nattempted&7&o total"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&7&ocontrol, and &c&nimprisoned&7&o any other colony who tried"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&7&oto ever overcome them or sabotage them!"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&dFeatures:"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Server Type: &d1.8.9+"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &71.8 PvP Mechanics"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Custom Enchantments"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Colony Points"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Level System"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Weekly Challenges"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&dInformation:"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &fSeason: &d#1"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l * &7Owned by: &dReheight"));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListPrison.add(ChatColor.translateAlternateColorCodes('&', "&d&l(!) &dclick to be transported to &e&nPrison&e &nExpedition&d!"));
        PrisonMeta.setLore(loreListPrison);
        Prison.setItemMeta(PrisonMeta);

        // Lobby
        ItemStack lobby = new ItemStack(Material.NETHER_STAR);
        ItemMeta lobbyMeta = lobby.getItemMeta();
        lobbyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lLobby"));
        List<String> loreListLobby = new ArrayList<>();
        loreListLobby.add("");

        if (retrieveServerStatus.online("Lobby") == true) {
            loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&a&lOnline"));
        } else {
            loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&c&lOffline"));
        }

        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&7&oHead back home to &nsafety&7&o where you"));
        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&7&oresigned in your previous life, free of "));
        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&7&o&nWar&7&o and lived in harmony!"));
        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', ""));
        loreListLobby.add(ChatColor.translateAlternateColorCodes('&', "&d&l(!) &dClick to be transported to &e&nHub&d!"));
        lobbyMeta.setLore(loreListLobby);
        lobby.setItemMeta(lobbyMeta);

        serverGUI.setItem(0, barrier); //1
        serverGUI.setItem(1, barrier); //2
        serverGUI.setItem(2, barrier); //3
        serverGUI.setItem(3, barrier); //4
        serverGUI.setItem(4, barrier); //5
        serverGUI.setItem(5, barrier); //6
        serverGUI.setItem(6, barrier); //7
        serverGUI.setItem(7, barrier); //8
        serverGUI.setItem(8, barrier); //9

        serverGUI.setItem(9, barrier); //10
        serverGUI.setItem(10, barrier); //11
        serverGUI.setItem(11, barrier); //12
        serverGUI.setItem(12, barrier); //13
        serverGUI.setItem(13, lobby); //14
        serverGUI.setItem(14, barrier); //15
        serverGUI.setItem(15, barrier); //16
        serverGUI.setItem(16, barrier); //17
        serverGUI.setItem(17, barrier); //18

        serverGUI.setItem(18, barrier); //19
        serverGUI.setItem(19, barrier); //20
        serverGUI.setItem(20, barrier); //12
        serverGUI.setItem(21, barrier); //22
        serverGUI.setItem(22, barrier); //23
        serverGUI.setItem(23, barrier); //24
        serverGUI.setItem(24, barrier); //25
        serverGUI.setItem(25, barrier); //26
        serverGUI.setItem(26, barrier); //27

        serverGUI.setItem(27, barrier); //28
        serverGUI.setItem(28, factions); //29
        serverGUI.setItem(29, barrier); //30
        serverGUI.setItem(30, cannon); // 31
        serverGUI.setItem(31, barrier); //32
        serverGUI.setItem(32, KitPvP); // 33
        serverGUI.setItem(33, barrier); //34
        serverGUI.setItem(34, Prison); //35
        serverGUI.setItem(35, barrier); //36
        serverGUI.setItem(36, barrier); //37
        serverGUI.setItem(37, barrier); //38
        serverGUI.setItem(38, barrier); //39
        serverGUI.setItem(39, barrier); //40
        serverGUI.setItem(40, barrier); //41
        serverGUI.setItem(41, barrier); //42
        serverGUI.setItem(42, barrier); //43
        serverGUI.setItem(43, barrier); //44
        serverGUI.setItem(44, barrier); //45


        Location selectorLocation = selector.getLocation();

        selector.playSound(selectorLocation, Sound.CLICK, 1, 1);
        selector.openInventory(serverGUI);
    }
}
