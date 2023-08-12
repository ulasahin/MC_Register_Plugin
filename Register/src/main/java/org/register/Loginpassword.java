package org.register;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class Loginpassword implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender oyuncu, Command girişşifre, String label, String[] şifre) {
        if(şifre.length == 0){
            oyuncu.sendMessage(ChatColor.RED +"Lütfen şifreyi giriniz.");
            return true;
        }
        if(şifre.length > 1){
            oyuncu.sendMessage(ChatColor.RED +"Şifrenizi yanlış girdiniz.");
            return true;
        }
        if (!(oyuncu instanceof Player player)) {
            oyuncu.sendMessage("Gürkan komutu rahat bırak.");
            return true;
        }

        if(player.getPersistentDataContainer().has(Register.passwordKey, PersistentDataType.STRING)){
            String password = player.getPersistentDataContainer().get(Register.passwordKey, PersistentDataType.STRING);
            if (şifre[0].equals(password) ){
                player.setWalkSpeed(0.2F);
                player.removePotionEffect(PotionEffectType.JUMP);
                oyuncu.sendMessage(ChatColor.GREEN + "Şifrenizi başarıyla girdiniz.");
                return true;
            }
            else {
                oyuncu.sendMessage(ChatColor.RED + "Şifrenizi yanlış girdiniz.");
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of();
    }
}
