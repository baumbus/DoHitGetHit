package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandChange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return false;
        float mod = Float.parseFloat(args[0]);
        if (mod < 0) mod = 0.0f;
        if (1 < mod) mod = 1.0f;
        DoHitGetHit.configs.setModifier(mod);
        sender.sendMessage(DoHitGetHit.pluginName + " The modifier is now: " + DoHitGetHit.configs.getModifier());
        return true;
    }
}
