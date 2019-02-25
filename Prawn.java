import java.awt.*;
/**
 * A class to draw the Prawn topping, it inherits from the topping class
 * 
 * @author 849104
 * @version 1
 */
public class Prawn extends Topping
{

    /**
     * Constructor for Prawn 
     * 
     * @param win the Canvas where the topping will be drawn
     * @param xCoordinate the x coordinate of the point where topping will be drawn
     * @param yCoordinate the y coordinate of the point where topping will be drawn
     */

    public Prawn(Canvas win, double xCoordinate, double yCoordinate)
    {   
        super(win, xCoordinate, yCoordinate);

    }

    /**
     * This method draws the prawn topping
     */
    public void drawTopping()
    {  
        canvas.setForegroundColor(Color.PINK);  

        //draws circle
        canvas.fillCircle(topLeftX + 150, topLeftY + 151, 24);

        //draws polygon shape
        double xpoints[] = {topLeftX + 160, topLeftX + 169, topLeftX + 165.5, topLeftX + 158};
        double ypoints[] = {topLeftY + 145, topLeftY + 160, topLeftY + 165, topLeftY + 165};

        canvas.fillPolygon(xpoints, ypoints);

        //draws rectangle
        canvas.fillRectangle(topLeftX + 159,topLeftY + 165, 8, 10);

        //draws triangle
        canvas.fillTriangle(topLeftX + 157, topLeftY + 175,topLeftX + 165,topLeftY + 175,topLeftX + 139, topLeftY + 185);

    }

}

