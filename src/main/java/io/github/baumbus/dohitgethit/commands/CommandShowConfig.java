package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandShowConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("The status is: " + Boolean.toString(DoHitGetHit.configs.getStatus()));
        sender.sendMessage("The modifier is: " + Float.toString(DoHitGetHit.configs.getModifier()));
        return true;
    }
}
