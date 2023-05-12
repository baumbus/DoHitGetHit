package io.github.baumbus.dohitgethit;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;

public class EventListener implements Listener {
    @EventHandler
    public static void onHit(EntityDamageByEntityEvent event) {
        if (!DoHitGetHit.getConfigLoader().getConfig().getStatus()) return;
        if (event.getEntity() instanceof Player ) {
            Player whoWasHit = (Player) event.getEntity();

            if (event.getDamager() instanceof Player) hitHandler(whoWasHit, (Player) event.getDamager(), event);
            if (event.getDamager() instanceof Arrow) hitHandler(whoWasHit, (Player) Objects.requireNonNull(((Arrow) event.getDamager()).getShooter()), event);
        }
    }

    public static void hitHandler(Player whoHit, Player whoWasHit, EntityDamageByEntityEvent event) {
        double AttackedHealth = whoWasHit.getHealth() + event.getFinalDamage();
        double AttackerHealth = whoHit.getHealth() * DoHitGetHit.getConfigLoader().getConfig().getModifier();

        if (AttackedHealth > Objects.requireNonNull(whoWasHit.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue()) {
            AttackedHealth = Objects.requireNonNull(whoWasHit.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        } else if (AttackedHealth < 0.0d) {
            AttackedHealth = 0.0d;
        }

        if (AttackerHealth > Objects.requireNonNull(whoHit.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue()) {
            AttackerHealth = Objects.requireNonNull(whoHit.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        } else if (AttackerHealth < 0.0d) {
            AttackerHealth = 0.0d;
        }

        whoWasHit.setHealth(AttackedHealth);
        if (!DoHitGetHit.getConfigLoader().getConfig().getImmune().contains(whoHit.getUniqueId())) whoHit.setHealth(AttackerHealth);
    }
}
