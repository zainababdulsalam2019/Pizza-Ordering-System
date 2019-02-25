import java.awt.*;
/**
 * Class to create a topping.
 * @author 849104
 * @version 1
 */

public class Topping
{
    protected Canvas canvas;
    protected double topLeftX;
    protected double topLeftY;

    /**
     * Constructor for objects of class Topping
     * 
     * @param win the Canvas where the topping will be drawn
     * @param xCoordinate the x coordinate of the point where topping will be drawn
     * @param yCoordinate the y coordinate of the point where topping will be drawn
     */

    public Topping(Canvas win, double xCoordinate, double yCoordinate)
    {
        canvas = win;
        topLeftX = xCoordinate;
        topLeftY = yCoordinate;

    }

    /**
     * Method to draw the topping
     */

    public void drawTopping()
    {

    }

    
    
    
}
