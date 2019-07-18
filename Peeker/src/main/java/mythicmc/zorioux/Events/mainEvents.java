package mythicmc.zorioux.Events;


import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;



public class mainEvents implements Listener {

       @EventHandler
       public void ClickEvent(InventoryClickEvent e){
      if (e.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Peeker")) {
          e.setCancelled(true);
      }

    }
}
