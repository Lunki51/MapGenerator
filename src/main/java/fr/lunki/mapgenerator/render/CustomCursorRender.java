package fr.lunki.mapgenerator.render;

import org.bukkit.entity.Player;
import org.bukkit.map.*;

import javax.annotation.Nullable;

public class CustomCursorRender extends MapRenderer {

    MapCursor.Type cursor;
    int randX,randZ;

    public CustomCursorRender(MapCursor.Type cursor,int randX, int randZ) {
        this.cursor=cursor;
        this.randX=randX;
        this.randZ=randZ;
    }

    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        if(mapCanvas.getCursors().size()>0){
            for(int i=0;i<mapCanvas.getCursors().size();i++){
                mapCanvas.getCursors().removeCursor(mapCanvas.getCursors().getCursor(i));
            }
        }

        MapCursor cursor = new MapCursor( (byte)(0 - this.randX*2), (byte)(0 - this.randZ*2), (byte)8, this.cursor,true);
        mapCanvas.getCursors().addCursor(cursor);

        }

}
