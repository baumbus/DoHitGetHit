package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandShowConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(DoHitGetHit.pluginName + " The status is: " + DoHitGetHit.configs.getStatus());
        sender.sendMessage(DoHitGetHit.pluginName + " The modifier is: " + DoHitGetHit.configs.getModifier());
        return true;
    }
}
