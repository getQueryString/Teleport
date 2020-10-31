package main;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    String noperm = "§7[§cServer§7] §4§l Keine Rechte!";
    String pre = "§7[§cServer§7]";

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("§aDas §3Teleport-Plugin §awurde erfolgreich aktiviert!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§4Das §3Teleport-Plugin §4wurde erfolgreich deaktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        if (label.equalsIgnoreCase("ts")) {
            sender.sendMessage(pre + "  §3Unser §cTeamSpeak§b§§6§l-§3Server §6§l§ §flocalhost");
            p.playSound(p.getLocation(), Sound.WOLF_DEATH, 2, 2);
            return true;
        }


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("tp")) {
                if (args.length == 1) {
                    String Name = args[0];
                    if (Bukkit.getPlayer(Name) != null) {
                        Player target = (Player) Bukkit.getPlayer(Name);
                        player.teleport(target);
                        player.sendMessage(pre + " §aErfolgreich zu §e" + target.getDisplayName() + " §ateleportiert!");
                        return true;
                    } else {
                        player.sendMessage(pre + " §cDieser Spieler ist §c§lnicht §conline!");
                    }
                } else {
                    player.sendMessage(pre + " §6/tp §c[§eSpieler§c]");
                    return false;
                }
            }
        }

        return false;
    }

}