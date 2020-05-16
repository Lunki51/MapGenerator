package fr.lunki.mapgenerator.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class CommandCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList list = new ArrayList();
        if(s.equals("getcustommap") || s.equals("addicon")){
            if(strings.length == 1){
                list.add("CLOSEST");
                list.add("CLOSE");
                list.add("NORMAL");
                list.add("FAR");
                list.add("FARTHEST");
                return list;
            }
            if(strings.length == 2){
                list.add("BANNER_BLACK");
                list.add("BANNER_BLUE");
                list.add("BANNER_BROWN");
                list.add("BANNER_CYAN");
                list.add("BANNER_GRAY");
                list.add("BANNER_GREEN");
                list.add("BANNER_LIGHT_BLUE");
                list.add("BANNER_LIGHT_GRAY");
                list.add("BANNER_LIME");
                list.add("BANNER_MAGENTA");
                list.add("BANNER_ORANGE");
                list.add("BANNER_PINK");
                list.add("BANNER_PURPLE");
                list.add("BANNER_RED");
                list.add("BANNER_WHITE");
                list.add("BANNER_YELLOW");
                list.add("GREEN_POINTER");
                list.add("TEMPLE");
                list.add("BLUE_POINTER");
                list.add("MANSION");
                list.add("RED_MARKER");
                list.add("RED_POINTER");
                list.add("RED_X");
                list.add("SMALL_WHITE_CIRCLE");
                list.add("WHITE_CIRCLE");
                list.add("WHITE_CROSS");
                list.add("WHITE_POINTER");
                return list;
            }
            if(strings.length == 3){
                list.add("~");
                return list;
            }
            if(strings.length == 4){
                list.add("~");
                return list;
            }
            if(strings.length == 5){
                list.add("true");
                list.add("false");
                return list;
            }
            if(strings.length == 6){
                list.add("true");
                list.add("false");
                return list;
            }
            if(strings.length == 7){
                list.add("~");
                return list;
            }
            if(strings.length == 8){
                list.add("~");
                return list;
            }
        }
        return null;
    }
}
