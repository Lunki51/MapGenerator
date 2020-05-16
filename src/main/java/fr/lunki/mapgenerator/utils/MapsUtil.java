package fr.lunki.mapgenerator.utils;

import fr.lunki.mapgenerator.render.CustomCursorRender;
import fr.lunki.mapgenerator.render.CustomPlayerIconRender;
import net.minecraft.server.v1_13_R2.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_13_R2.CraftServer;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapCursor;
import org.bukkit.map.MapView;

public class MapsUtil {

    public static ItemStack addIconToMap(ItemStack map, MapCursor.Type cursor, Location location){

        MapMeta meta = ((MapMeta)map.getItemMeta());
        MapView mapView = meta.getMapView();

        int mapsize = MapsUtil.getBlockSize(mapView.getScale())/2;
        int CenterX = mapView.getCenterX(), CenterZ = mapView.getCenterZ();
        int BlockX =location.getBlockX(), BlockZ = location.getBlockZ();

        if (CenterX-mapsize<BlockX && BlockX<CenterX+mapsize && CenterZ-mapsize<BlockZ && BlockZ<CenterZ+mapsize){
            System.out.println("aa");
            mapView.getRenderers().add(new CustomCursorRender(cursor,location.getBlockX()-CenterX,location.getBlockZ()-CenterZ));
        }else{
            System.out.println("nn");
        }


        meta.setMapView(mapView);
        map.setItemMeta(meta);
        return map;
    }

    public static ItemStack getMap(World world, MapCursor.Type cursor,String scale, int X, int Z, boolean brown, boolean centered,int decX,int decZ) {
        MapView mapV = null;


            mapV = Bukkit.getServer().createMap(world);
            mapV.addRenderer(new CustomPlayerIconRender());

        //Set the Scale of the Map
        mapV.setScale(StringtoScale(scale));


        int randX = 0,randZ=0;
        //If the map is centered on the Cursor setting the center of
        if(!centered){
            int size = getBlockSize(mapV.getScale());

            randX = decX==0? (int) ((Math.random() * (size+size))-size)/2 : decX;
            randZ = decZ==0? (int) ((Math.random() * (size+size))-size)/2 : decZ;

        }

        mapV.setCenterX(X + randX);
        mapV.setCenterZ(Z + randZ);


        mapV.addRenderer(new CustomCursorRender(cursor,randX,randZ));


        ItemStack stack = new ItemStack(Material.FILLED_MAP, 1);
        MapMeta meta = (MapMeta) stack.getItemMeta();
        meta.setMapView(mapV);
        stack.setItemMeta(meta);


        if(brown){
            ItemWorldMap.applySepiaFilter(((CraftWorld)world).getHandle(),CraftItemStack.asNMSCopy(stack));
        }
        return stack;

    }

    public static MapView.Scale StringtoScale(String s){
        switch (s){
            case "CLOSEST": return MapView.Scale.CLOSEST;
            case "CLOSE": return MapView.Scale.CLOSE;
            case "NORMAL": return MapView.Scale.NORMAL;
            case "FAR": return MapView.Scale.FAR;
            case "FARTHEST": return MapView.Scale.FARTHEST;
        }
        return MapView.Scale.CLOSEST;
    }

    public static MapCursor.Type StringtoCursorType(String s){

        switch(s){
            case "BANNER_BLACK": return MapCursor.Type.BANNER_BLACK;
            case "BANNER_BLUE": return  MapCursor.Type.BANNER_BLUE;
            case "BANNER_BROWN": return  MapCursor.Type.BANNER_BROWN;
            case "BANNER_CYAN": return  MapCursor.Type.BANNER_CYAN;
            case "BANNER_GRAY": return  MapCursor.Type.BANNER_GRAY;
            case "BANNER_GREEN": return  MapCursor.Type.BANNER_GREEN;
            case "BANNER_LIGHT_BLUE": return  MapCursor.Type.BANNER_LIGHT_BLUE;
            case "BANNER_LIGHT_GRAY": return  MapCursor.Type.BANNER_LIGHT_GRAY;
            case "BANNER_LIME": return  MapCursor.Type.BANNER_LIME;
            case "BANNER_MAGENTA": return  MapCursor.Type.BANNER_MAGENTA;
            case "BANNER_ORANGE": return  MapCursor.Type.BANNER_ORANGE;
            case "BANNER_PINK": return  MapCursor.Type.BANNER_PINK;
            case "BANNER_PURPLE": return  MapCursor.Type.BANNER_PURPLE;
            case "BANNER_RED": return  MapCursor.Type.BANNER_RED;
            case "BANNER_WHITE": return  MapCursor.Type.BANNER_WHITE;
            case "BANNER_YELLOW": return  MapCursor.Type.BANNER_YELLOW;
            case "GREEN_POINTER": return  MapCursor.Type.GREEN_POINTER;
            case "TEMPLE": return  MapCursor.Type.TEMPLE;
            case "BLUE_POINTER": return  MapCursor.Type.BLUE_POINTER;
            case "MANSION": return  MapCursor.Type.MANSION;
            case "RED_MARKER": return MapCursor.Type.RED_MARKER;
            case "RED_POINTER": return  MapCursor.Type.RED_POINTER;
            case "RED_X": return  MapCursor.Type.RED_X;
            case "SMALL_WHITE_CIRCLE": return  MapCursor.Type.SMALL_WHITE_CIRCLE;
            case "WHITE_CIRCLE": return  MapCursor.Type.WHITE_CIRCLE;
            case "WHITE_CROSS": return  MapCursor.Type.WHITE_CROSS;
            case "WHITE_POINTER": return  MapCursor.Type.WHITE_POINTER;
        }

        return MapCursor.Type.RED_X;
    }

    public static int getBlockSize(MapView.Scale scale){
        switch(scale){
            case CLOSEST: return 128;
            case CLOSE: return 256;
            case NORMAL: return 512;
            case FAR: return 1024;
            case FARTHEST: return 2048;
        }
        return 0;
    }
}
