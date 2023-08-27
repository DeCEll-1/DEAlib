package DEA.helper.render.renderClassesFolder;

import org.lwjgl.util.vector.Vector2f;

import java.awt.*;

public class DEAlib_TriangleData {

    public DEAlib_TriangleData(Vector2f corner1, Vector2f corner2, Vector2f corner3, Color color, boolean filled) {
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.corner3 = corner3;
        this.color = color;
        this.filled = filled;
    }

    public Vector2f corner1;
    public Vector2f corner2;
    public Vector2f corner3;
    public boolean filled;
    public Color color;


}