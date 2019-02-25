import java.awt.*;
import java.util.*;
import java.lang.*;

/**
 * Class to manage the pizza order.
 * @author 849104
 * @version 1
 */
public class OrderingSystem 
{
    private Canvas canvas;
    private ArrayList<Pizza> pizzas;

    /**
     * Constructor for the ordering system.
     */
    public OrderingSystem()
    {
        canvas = new Canvas("Pizza Ordering", 900, 650);       
        pizzas = new ArrayList<Pizza>();
    }

    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen()
    {

        // vertical dividers
        canvas.drawLine(300, 0, 300, 600);
        canvas.drawLine(600, 0, 600, 600);

        // halfway divider
        canvas.drawLine(0, 300, 900, 300);

        canvas.drawLine(0, 600, 900, 600);

    }

    /**
     * Method to manage the ordering of the pizzas (once completed).
     */
    public void startOrdering()
    {
        UserInput inputs = new UserInput();

        int x = 0;
        int y = 0;

        int textCoordinateX1 = 45;
        int textCoordinateY1 = 25;
        int textCoordinateX2 = 55;
        int textCoordinateY2 = 290;

        double totalCost = 0;

        boolean loop = false;
        int index = 0;

        do{
            Pizza currentPizza = new Pizza(canvas, x, y);
            pizzas.add(currentPizza);

            currentPizza.setPizzaSize();
            currentPizza.setPizzaCrust();
            currentPizza.setPizzaSauce();
            currentPizza.setToppings();
            currentPizza.setPizzaSauceType();
            currentPizza.setPizzaNo(pizzas, currentPizza);

            String sauce = currentPizza.getPizzaSauceType();
            String crust = currentPizza.getPizzaCrust();
            String size = currentPizza.getPizzaSize();
            int pizzaNo = currentPizza.getPizzaNo();

            currentPizza.setPrice();
            double price = currentPizza.getTotalPrice();

            canvas.eraseString("Total Price of the Order: £ " +  (double)Math.round(totalCost*100)/100, 10, 640);   
            totalCost += price;

            currentPizza.displayPizza();

            canvas.setForegroundColor(Color.BLACK);

            canvas.drawString(" " + pizzaNo + "(" + size + ")", textCoordinateX1 ,textCoordinateY1);
            canvas.drawString(crust + ", " + sauce + " Sauce", textCoordinateX2 ,textCoordinateY2);

            canvas.setFontSize(25);
            canvas.drawString("Total Price of the Order: £ " + (double)Math.round(totalCost*100)/100 , 10, 640);
            int pizzasListAmount = pizzas.size();

            if(pizzasListAmount < 6)
            {

                String input = inputs.getAdditionalPizzaRequest();

                if(input.equals("yes"))
                {
                    x += 300;
                    textCoordinateX1 += 300;
                    textCoordinateX2 += 300;

                        
                       
                    if(x == 900)
                    {
                        y += 300;
                        x = 0;

                        textCoordinateX1 = 45; 
                        textCoordinateX2 = 55; 
                        textCoordinateY1 += 300;
                        textCoordinateY2 += 300;
                    }

                }
                else
                {
                    currentPizza.changePizza(pizzas, pizzasListAmount, totalCost);
                    currentPizza.removePizzaByIndex(pizzas, pizzasListAmount, totalCost);

                    loop = true;

                }
                index ++;
            }
            else
            {
                System.out.println("You have reached maximum amount of pizzas you can order");
                
                currentPizza.changePizza(pizzas, pizzasListAmount, totalCost);
                currentPizza.removePizzaByIndex(pizzas, pizzasListAmount, totalCost);
                
                loop = true;

            }
        }while(!loop);
    }
}
