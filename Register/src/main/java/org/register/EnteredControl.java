package org.register;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnteredControl implements Listener {
    @EventHandler
    public void getControlEvent(PlayerJoinEvent event) {
        Player oyuncu = event.getPlayer();
        oyuncu.sendMessage(ChatColor.RED + "[Vexonia Roleplay]");
        if (!oyuncu.getPersistentDataContainer().has(Register.passwordKey, PersistentDataType.STRING)) {
            oyuncu.sendMessage(ChatColor.GRAY + "Sunucuya giriş için lütfen '/şifre' komutuyla şifrenizi oluşturun.");
        }
        else {
            oyuncu.sendMessage(ChatColor.GREEN + "'/girişşifre' komutuyla giriş yapınız.");
        }
        event.getPlayer().setWalkSpeed(-1);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 200));
    }
}

