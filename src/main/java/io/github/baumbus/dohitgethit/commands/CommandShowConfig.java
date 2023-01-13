package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("NullableProblems")
public class CommandShowConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return false;
        sender.sendMessage(DoHitGetHit.pluginName + " The status is: " + DoHitGetHit.getConfigLoader().getConfig().getStatus());
        sender.sendMessage(DoHitGetHit.pluginName + " The modifier is: " + DoHitGetHit.getConfigLoader().getConfig().getModifier());
        sender.sendMessage(DoHitGetHit.pluginName + " List of immune players: ");
        if (DoHitGetHit.getConfigLoader().getConfig().getImmune() == null) {
            sender.sendMessage( DoHitGetHit.pluginName + " None");
            return true;
        }

        for (UUID id : DoHitGetHit.getConfigLoader().getConfig().getImmune()) {
            sender.sendMessage(Objects.requireNonNull(Bukkit.getServer().getOfflinePlayer(id).getName()) + " --- " + id);
        }
        return true;
    }
}
