import java.awt.*;

/**
 * Created by realmx2000 on 2/3/17.
 */
public class ColorPoint {
    private Color color = Color.BLACK;
    private int xCoordinate;
    private int yCoordinate;

    public ColorPoint(Color newColor, int x, int y){
        color = newColor;
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getxCoordinate(){
        return xCoordinate;
    }

    public int getyCoordinate(){
        return yCoordinate;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }
}
