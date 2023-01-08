package io.github.baumbus.dohitgethit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventListener implements Listener {
    @EventHandler
    public static void onHit(EntityDamageByEntityEvent event) {
        if (!DoHitGetHit.configs.getStatus()) return;
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player whoWasHit = (Player) event.getEntity();
            Player whoHit = (Player) event.getDamager();

            whoWasHit.setHealth(whoWasHit.getHealth() + event.getFinalDamage());
            whoHit.setHealth(whoHit.getHealth() * DoHitGetHit.configs.getModifier());
        }
    }
}
