package mythicmc.zorioux.Commands;

import mythicmc.zorioux.Peeker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.UUID;


public class PeekerCmd implements CommandExecutor {

    private Plugin plugin = Peeker.getPlugin(Peeker.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(command.getName().equalsIgnoreCase("Peeker"))) return false;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "only players may execute this command DERP!");
            return false;
        }

        Player p = (Player) sender;
        if (args.length == 0){
            p.sendMessage(ChatColor.BOLD + "" + ChatColor.AQUA + "usage: /peeker <player name>");
            return false;
        }


        if (!(p.hasPermission("Peeker.use"))) {
            p.sendMessage(ChatColor.DARK_RED + "you Don't have permission to use this command");
            return false;
        }

        Inventory gui = Bukkit.createInventory(p, 54, ChatColor.AQUA + "Peeker");

        OfflinePlayer player = args[0].split("-").length ==5
                 ? plugin.getServer().getOfflinePlayer(UUID.fromString(args[0]))
                : plugin.getServer().getPlayer(args[0]);

        if (player == null) {
            for (OfflinePlayer offlinePlayer : plugin.getServer().getOfflinePlayers()){
                if (offlinePlayer.hasPlayedBefore() && offlinePlayer.getName().equalsIgnoreCase(args[0])){
                    player = offlinePlayer;
                }
            }
        }

        if (player == null || !player.hasPlayedBefore()){
            p.sendMessage(ChatColor.DARK_RED + "this player does not exists");
            return false;
        }

        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        skull.getItemMeta().setDisplayName(ChatColor.AQUA + player.toString());
        ((SkullMeta) skull.getItemMeta()).setOwningPlayer(player);


        ItemStack glass_pane = new ItemStack(Material.STAINED_GLASS_PANE, 1 , (short) 15);

        ItemStack[ ] menu = {skull,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                             glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                             glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                             glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                             glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                             glass_pane,glass_pane,glass_pane,glass_pane, glass_pane,glass_pane,glass_pane,glass_pane,glass_pane,
                         };

        gui.setContents(menu);
        p.openInventory(gui);


        return false;
    }
}
