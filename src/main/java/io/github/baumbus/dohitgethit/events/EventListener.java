package io.github.baumbus.dohitgethit.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventListener implements Listener {

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            Player whoWasHit = (Player) e.getEntity();
            Player whoHit = (Player) e.getDamager();

            whoHit.setHealth(whoHit.getHealth() * 0.5);
            whoHit.sendTitle(ChatColor.RED + "Schlage keine anderen Spieler!", "Sonst wird dein Leben halbiert.", 2, 10, 2);
        }
    }
}
