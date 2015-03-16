package me.MrConHD.whitelist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Connor on 3/15/2015.
 */
public class Core extends JavaPlugin implements Listener {



    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }

    public void onDisable() {

    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST && !e.getPlayer().isWhitelisted()) {
            e.setKickMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("whitelistmsg")));
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            e.setKickMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("fullmsg")));
        }
    }
}
