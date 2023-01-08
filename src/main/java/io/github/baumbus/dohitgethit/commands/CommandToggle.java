package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandToggle implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return false;
        DoHitGetHit.configs.setStatus(!DoHitGetHit.configs.getStatus());
        sender.sendMessage("Status is now: " + (DoHitGetHit.configs.getStatus() ? "true" : "false"));
        return true;
    }
}
