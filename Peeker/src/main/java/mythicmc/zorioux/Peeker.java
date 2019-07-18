package mythicmc.zorioux;

import mythicmc.zorioux.Commands.PeekerCmd;
import mythicmc.zorioux.Events.mainEvents;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Peeker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getCommand("Peeker").setExecutor(new PeekerCmd());

        getServer().getPluginManager().registerEvents(new mainEvents(),this);

        getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Peeker started correctly !");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
