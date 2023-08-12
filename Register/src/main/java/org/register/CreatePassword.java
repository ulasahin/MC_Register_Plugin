package org.register;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class CreatePassword implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender oyuncu, Command şifre, String label, String[] girilenŞifre) {
        if (!(oyuncu instanceof Player player)) {
            oyuncu.sendMessage("Gürkan komutu rahat bırak.");
            return true;
        }
        if (girilenŞifre.length > 1) {
            oyuncu.sendMessage(ChatColor.RED +"Şifrenizde boşluk olamaz.");
            return true;
        }
        if (girilenŞifre.length == 0) {
            oyuncu.sendMessage(ChatColor.RED +"Lütfen şifrenizi giriniz.");
            return true;
        }
        if (player.getPersistentDataContainer().has(Register.passwordKey, PersistentDataType.STRING)) {
            oyuncu.sendMessage(ChatColor.RED +"Şifrenizi değiştirmek için Discord üzerinden ticket açınız.");
            return true;
        }
        player.getPersistentDataContainer().set(Register.passwordKey,
                PersistentDataType.STRING, girilenŞifre[0]);
        player.setWalkSpeed(0.2F);
        player.removePotionEffect(PotionEffectType.JUMP);
        oyuncu.sendMessage(ChatColor.GREEN +"Şifreniz başarıyla oluşturuldu.");

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of();
    }
}
