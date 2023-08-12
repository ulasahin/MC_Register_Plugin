package org.register;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class Register extends JavaPlugin {
    public static  NamespacedKey passwordKey;
    private static Register plugin;
    public static Register inst(){
        return plugin;
    }
    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EnteredControl(),this);
        getCommand("resetpassword").setExecutor(new resetpassword());
        getCommand("şifre").setExecutor(new CreatePassword());
        getCommand("girişşifre").setExecutor(new Loginpassword());
        passwordKey = new NamespacedKey(Register.inst(),"passwordManager");
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
