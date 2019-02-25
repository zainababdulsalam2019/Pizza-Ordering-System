import java.awt.*;
/**
 * A class to draw the Pineapple topping, it inherits from the pizza class
 * 
 * @author 849104
 * @version 1
 */
public class Pineapple extends Topping
{   
    /**
     * Constructor for Pineapple
     * 
     * @param win the Canvas where the topping will be drawn
     * @param xCoordinate the x coordinate of the point where topping will be drawn
     * @param yCoordinate the y coordinate of the point where topping will be drawn
     */
    public Pineapple(Canvas win, double xCoordinate, double yCoordinate)
    {   
        super(win, xCoordinate, yCoordinate);

    }

    /**
     * This method draws the pineapple topping
     */
    public void drawTopping()
    {

        canvas.setForegroundColor(Color.YELLOW);
        double x1points[] = {topLeftX + 45, topLeftX + 80, topLeftX + 75, topLeftX + 50};
        double y1points[] = {topLeftY + 45, topLeftY + 45, topLeftY + 80, topLeftY + 80};
        canvas.fillPolygon(x1points, y1points);

        double x2points[] = {topLeftX + 47.5, topLeftX + 77.5, topLeftX + 72.5, topLeftX + 52.5};
        double y2points[] = {topLeftY + 47.5, topLeftY + 47.5, topLeftY + 77.5, topLeftY + 77.5};
        canvas.erasePolygon(x2points, y2points);

        double x3points[] = {topLeftX + 50, topLeftX + 75, topLeftX + 70, topLeftX + 55};
        double y3points[] = {topLeftY + 50, topLeftY + 50, topLeftY + 75, topLeftY + 75};
        canvas.fillPolygon(x3points, y3points);

        double x4points[] = {topLeftX + 52.5, topLeftX + 72.5, topLeftX + 67.5, topLeftX + 57.5};
        double y4points[] = {topLeftY + 52.5, topLeftY + 52.5, topLeftY + 72.5, topLeftY + 72.5}; 
        canvas.erasePolygon(x4points, y4points);

        double x5points[] = {topLeftX + 55, topLeftX + 70, topLeftX + 65, topLeftX + 60};
        double y5points[] = {topLeftY + 55, topLeftY + 55, topLeftY + 70, topLeftY + 70};
        canvas.fillPolygon(x5points, y5points);

    }
}