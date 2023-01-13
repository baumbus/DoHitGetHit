package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@SuppressWarnings("NullableProblems")
public class CommandToggle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return false;
        DoHitGetHit.getConfigLoader().getConfig().setStatus(!DoHitGetHit.getConfigLoader().getConfig().getStatus());
        sender.sendMessage(DoHitGetHit.pluginName + " Status is now: " + DoHitGetHit.getConfigLoader().getConfig().getStatus());
        return true;
    }
}
