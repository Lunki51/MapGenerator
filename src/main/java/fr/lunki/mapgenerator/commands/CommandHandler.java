package fr.lunki.mapgenerator.commands;

import fr.lunki.mapgenerator.utils.MapsUtil;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandHandler implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(s.equals("getcustommap")){
            if(strings.length < 6){
                commandSender.sendMessage(Color.RED + "Invalid syntax please use : getCustomMap -Scale- -Icon-" +
                        " -posX- -posY- -Brown- -Centered- -DecX- -DecZ-");
            }else{
                Player player = commandSender.getServer().getPlayer(commandSender.getName());
                int decX,decZ;
                if(strings.length<7){
                    decX=0;
                    decZ=0;
                }else{
                    decX=Integer.valueOf(strings[6]);
                    decZ=Integer.valueOf(strings[7]);
                }
                commandSender.getServer().getPlayer(commandSender.getName()).getInventory()
                        .addItem(MapsUtil.getMap(player.getWorld(),
                                MapsUtil.StringtoCursorType(strings[1]),strings[0],Integer.valueOf(strings[2]),
                                Integer.valueOf(strings[3]),Boolean.valueOf(strings[4]),Boolean.valueOf(strings[5]),
                                decX,decZ));
                return true;
            }
        }

        if(s.equals("addicon")){
            if(strings.length <1){
                commandSender.sendMessage("/addIcon -PosX- -PosY- -Icon-");
            }else{
                Player player = commandSender.getServer().getPlayer(commandSender.getName());
                player.getInventory().setItem(player.getInventory().getHeldItemSlot(),
                        MapsUtil.addIconToMap(player.getInventory().getItemInMainHand(),
                        MapsUtil.StringtoCursorType(strings[2]),new Location(player.getWorld(),
                        Integer.valueOf(strings[0]),0,Integer.valueOf(strings[1]))));
            }
            return true;
        }

        return false;

        }
}