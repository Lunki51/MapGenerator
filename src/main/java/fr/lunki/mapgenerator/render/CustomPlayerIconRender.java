package fr.lunki.mapgenerator.render;

import fr.lunki.mapgenerator.render.CustomCursorRender;
import fr.lunki.mapgenerator.utils.MapsUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursor;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class CustomPlayerIconRender extends MapRenderer {
    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {

        if(mapCanvas.getCursors().size()>0){
            for(int i=0;i<mapCanvas.getCursors().size();i++){
                mapCanvas.getCursors().removeCursor(mapCanvas.getCursors().getCursor(i));
            }
        }

        int mapsize = MapsUtil.getBlockSize(mapView.getScale())/2;
        Location loc = player.getLocation();
        int CenterX = mapView.getCenterX(), CenterZ = mapView.getCenterZ();
        int BlockX =loc.getBlockX(), BlockZ = loc.getBlockZ();

        if (CenterX-mapsize<BlockX && BlockX<CenterX+mapsize && CenterZ-mapsize<BlockZ && BlockZ<CenterZ+mapsize){
            try{
                MapCursor cursor = new MapCursor((byte)((BlockX-CenterX)*2),(byte)((BlockZ-CenterZ)*2),
                        (byte)Math.round(Math.abs((player.getLocation().getYaw()*15)/360)),
                        MapCursor.Type.WHITE_POINTER,true);
                mapCanvas.getCursors().addCursor(cursor);
            }catch (Exception e){}
        }
    }
}
