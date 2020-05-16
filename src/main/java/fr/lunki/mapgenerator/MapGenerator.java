package fr.lunki.mapgenerator;

import fr.lunki.mapgenerator.commands.CommandCompleter;
import fr.lunki.mapgenerator.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MapGenerator extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        this.getCommand("getcustommap").setExecutor(new CommandHandler());
        this.getCommand("addicon").setExecutor(new CommandHandler());
        this.getCommand("getcustommap").setTabCompleter(new CommandCompleter());
        this.getCommand("addicon").setTabCompleter(new CommandCompleter());
    }
}
