package io.github.baumbus.dohitgethit.commands;

import io.github.baumbus.dohitgethit.DoHitGetHit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Level;

@SuppressWarnings("NullableProblems")
public class CommandRemoveImmune implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) return false;
        if (sender instanceof Player) {
            Player operator = (Player)sender;
            DoHitGetHit.getConfigLoader().getConfig().removeImmune(((Player) sender).getUniqueId());
            Bukkit.getServer().getLogger().log(Level.CONFIG, "Removed Player: " + operator.getName() + " --- " + operator.getUniqueId());
            return true;
        }
        if (args.length == 0) return false;
        for (Player p: Bukkit.getServer().getOnlinePlayers()) {
            if (p.getName().equals(args[0])) {
                DoHitGetHit.getConfigLoader().getConfig().removeImmune(p.getUniqueId());
                Bukkit.getServer().getLogger().log(Level.CONFIG, "Removed Player: " + p.getName() + " --- " + p.getUniqueId());
                return true;
            }
        }
        return false;
    }
}
