package org.register;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.List;

public class resetpassword implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender oyuncu, Command resetpassword, String label, String[] nickname) {
        if (nickname.length == 0) {
            oyuncu.sendMessage(ChatColor.RED +"Lütfen nickname giriniz.");
            return true;
        }
        Player player = Bukkit.getPlayer(nickname[0]);
        if (player == null) {
            oyuncu.sendMessage(ChatColor.RED +"Oyuncu oyunda değil");
            return true;
        }
        player.getPersistentDataContainer().remove(Register.passwordKey);
        oyuncu.sendMessage("Admin kanka başarıyla şifreyi sıfırladın.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
