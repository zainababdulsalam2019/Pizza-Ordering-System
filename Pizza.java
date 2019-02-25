import java.awt.*;
import java.util.*;

/**
 * Class to represent a single pizza.
 * @author 849104
 * @version 1
 */
public class Pizza 
{
    private Canvas canvas;
    private double topLeftX;
    private double topLeftY;

    private ArrayList<Topping> toppingsObjects;
    private ArrayList<String> toppings;

    private String pizzaSauce;
    private String pizzaSauceType;
    private String pizzaCrust;
    private String pizzaSize;

    private UserInput userInput;

    private double totalPrice;
    private int pizzaNo;

    /**
     * Constructor for pizza.
     * 
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw pizza on
     * @param startY the top-left y coordinate for the section of screen to draw pizza on
     */
    public Pizza(Canvas win, double startX, double startY)
    {        
        canvas = win;
        topLeftX = startX;
        topLeftY = startY;

        toppingsObjects = new ArrayList<Topping>();
        userInput = new UserInput();
        toppings = new ArrayList<String>();

        pizzaSize = null;
        pizzaCrust = null;
        pizzaSauce = null;
        pizzaSauceType = null;
        pizzaNo = 0;

        totalPrice = 0.00;

    }

    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza()
    {
        drawPizza();
        drawTopLine();
        drawBottomLine();
        drawSauce();
        drawToppings();

    }

    /**
     * Method to display the pizza on the screen.
     */
    private void drawPizza()
    {
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        canvas.eraseCircle(topLeftX + 150, topLeftY + 150, 180);

    }

    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen. 
     * This method will display the pizza number and size at the top of the 
     * screen (once completed)
     */
    private void drawTopLine()
    {
        String topLine = "Pizza";

        double stringX = topLeftX+10;
        double stringY = topLeftY + 25;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }

    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen.  
     * This method will display the type of crust and sauce ordered (once 
     * completed)
     */
    private void drawBottomLine()
    {
        String bottomLine = "Crust: ";

        double stringX = topLeftX+10;
        double stringY = topLeftY + 290;

        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }

    /**
     * Method to draw the sauce for the pizza
     */
    private void drawSauce()
    {

        if(pizzaSauce.equals("yes"))
        {
            canvas.setForegroundColor(Color.ORANGE);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 180);
            canvas.eraseCircle(topLeftX + 150, topLeftY + 150, 170);
        }
        else if(pizzaSauce.equals("no"))
        {
            canvas.setForegroundColor(Color.RED);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 180);
            canvas.eraseCircle(topLeftX + 150, topLeftY + 150, 170);

        }

    }

    /** 
     * This method will draw the toppings
     */
    private void drawToppings()
    {

        if(toppings.size() == 1)
        {
            for (int y = 0; y < 3; y++) 
            {
                for (int x = 0; x < 3; x++) 
                {
                    int toppingNumber = y * 3 + x;
                    if (toppingNumber % 2 == 0)
                    {
                        String topping = toppings.get(0);
                        double xPosition = topLeftX + 15 + (x) * 50;
                        double yPosition = topLeftY + 15 + (y) * 50;
                        if (topping.equals("pineapple"))
                        {
                            toppingsObjects.add(new Pineapple(canvas, xPosition + 30, yPosition + 30));
                        }
                        else 
                        {
                            toppingsObjects.add(new Prawn(canvas, xPosition - 65, yPosition - 65));
                        }
                    }
                }
            }
        }

        else if(toppings.size() == 2)
        {
            for (int y = 0; y < 3; y++) 
            {
                for (int x = 0; x < 3; x++) 
                {
                    int toppingNumber = y * 3 + x;
                    if (toppingNumber % 2 == 0)
                    {
                        String topping = toppings.get(0);
                        double xPosition = topLeftX + 15 + (x) * 50;
                        double yPosition = topLeftY + 15 + (y) * 50;
                        if (topping.equals("pineapple"))
                        {
                            toppingsObjects.add(new Pineapple(canvas, xPosition + 30, yPosition + 30));

                        }
                        else 
                        {
                            toppingsObjects.add(new Prawn(canvas, xPosition - 65, yPosition - 65));
                        }
                    }
                    else 
                    {
                        String topping = toppings.get(1);
                        double xPosition = topLeftX + 15 + (x) * 50;
                        double yPosition = topLeftY + 15 + (y) * 50;
                        if (topping.equals("pineapple"))
                        {
                            toppingsObjects.add(new Pineapple(canvas, xPosition + 30, yPosition + 30));
                        }
                        else 
                        {
                            toppingsObjects.add(new Prawn(canvas, xPosition - 65, yPosition - 65));
                        }
                    }
                }

            }
        }    

        for (Topping topping : toppingsObjects)
        {
            topping.drawTopping();
        }

    } 

    /**
     * This method will calculate the price of the pizza
     * 
     * @return the cost of the pizza
     */
    private double calculatePrice()
    {

        int pizzaSizeInches = 0;

        if (pizzaSize.equals("small"))
        {
            pizzaSizeInches = 10;

        }

        else if(pizzaSize.equals("medium"))
        {

            pizzaSizeInches = 12;

        }

        else if(pizzaSize.equals("large"))
        {

            pizzaSizeInches = 14;

        }
        if(pizzaCrust.equals("deep"))
        {
            double pizzaArea = Math.pow(pizzaSizeInches/2, 2);
            double pizzaAreaResult = Math.PI * pizzaArea;
            totalPrice += pizzaAreaResult * 0.11;

        }

        else if(pizzaCrust.equals("thin"))
        {

            double pizzaArea = Math.pow(pizzaSizeInches/2, 2);
            double pizzaAreaResult = Math.PI * pizzaArea;
            totalPrice += pizzaAreaResult * 0.08;

        }

        else if(pizzaCrust.equals("stuffed"))
        {

            double pizzaArea = Math.pow(pizzaSizeInches/2, 2);
            double pizzaAreaResult = Math.PI * pizzaArea;
            totalPrice += pizzaAreaResult * 0.14;

        }

        if(pizzaSauce.equals("yes"))
        {
            totalPrice += 0.5;
        }

        double priceOfToppings = 0.00;
        double toppingsCost = 0.00;

        if(toppings.size() == 1)
        {   

            toppingsCost = 0.06 * 5.00;
            priceOfToppings += toppingsCost;

        }
        else if(toppings.size() == 2)
        {

            toppingsCost = (0.06 * 5.00) + (0.06 * 4.00);
            priceOfToppings += toppingsCost;

        }
        totalPrice += priceOfToppings;

        return totalPrice;
    }

    /**
     * This method set the price of the pizza
     */
    public void setPrice()
    {
        totalPrice = calculatePrice();

    }

    /**
     * This method set the size of the pizza
     */
    public void setPizzaSize()
    {
        pizzaSize = userInput.getPizzaSize();

    }

    /**
     * This method set the crust of the pizza
     */
    public void setPizzaCrust()
    {
        pizzaCrust = userInput.getPizzaCrust();

    }

    /**
     * This method set the sauce for the pizza
     */
    public void setPizzaSauce()
    {
        pizzaSauce = userInput.getPizzaSauce();

    }

    /**
     * This method sets the pizza number
     * 
     * @param pizzaList this is the list of Pizza objects
     * @param pizza this a pizza object
     */
    public void setPizzaNo(ArrayList<Pizza> pizzaList, Pizza pizza)
    {
        pizzaNo = pizzaList.indexOf(pizza) + 1;

    }

    /**
     * This method sets the list of toppings that will be drawn on the pizza
     */
    public void setToppings()
    {
        toppings = userInput.getToppingsList(); 

    }

    /**
     * This method sets the sauce type for the pizza
     */
    public void setPizzaSauceType()
    {
        if(pizzaSauce.equalsIgnoreCase("yes"))
        {
            pizzaSauceType = "BBQ";

        }

        else
        {
            pizzaSauceType = "Tomato";

        }

    }

    /**
     * This method gets the total price for the pizza
     * 
     * @return the total price for the pizza
     */
    public double getTotalPrice()
    {
        return totalPrice; 

    }

    /**
     * Method gets the pizza number
     * 
     * @return the pizza number
     */
    public int getPizzaNo()
    {

        return pizzaNo;
    }

    /**
     * Method get the size of the pizza
     * 
     * @return the size of the pizza
     */
    public String getPizzaSize()
    {
        return pizzaSize;
    }

    /**
     * Method to get the crust of the pizza
     * 
     * @return the pizza crust
     */
    public String getPizzaCrust()
    {
        return pizzaCrust; 

    }

    /**
     * Method to get pizza sauce type
     * 
     * @return the pizza sauce type
     */
    public String getPizzaSauceType()
    {

        return pizzaSauceType; 

    }

    /**
     * Method to get the top left x coordinate
     * 
     * @return the top left x coordinate
     */
    public double getTopLeftX()
    {
        return topLeftX;

    }

    /**
     * Method to get the top left y coordinate
     * 
     * @return the top left y coordinate
     */

    public double getTopLeftY()
    {
        return topLeftY;

    }

    /**
     * Method to change a pizza
     * 
     * @param pizzaList a list of pizza objects
     * @param amountOfPizzas the amount of pizzas in the list currently
     * @param totalCost the the cost of all the pizzas
     */
    public void changePizza(ArrayList<Pizza> pizzaList, int amountOfPizzas, double totalCost)
    {
        boolean loop = false;
        double newPrice = 0;
        do{
            int pizzaNumber = userInput.getPizzaNoToChange(amountOfPizzas);

            if(pizzaNumber > 0)
            {
                Pizza pizzaToChange = pizzaList.get(pizzaNumber - 1);

                double oldX = pizzaToChange.getTopLeftX();
                double oldY = pizzaToChange.getTopLeftY();

                double oldPrice = pizzaToChange.getTotalPrice();

                int oldPizzaNo = pizzaToChange.getPizzaNo();

                Pizza newPizza = new Pizza(canvas, oldX, oldY);

                newPizza.setPizzaSize();
                newPizza.setPizzaCrust();
                newPizza.setPizzaSauce();
                newPizza.setPizzaSauceType();

                newPizza.setToppings();
                newPizza.setPrice();

                String newSauce = newPizza.getPizzaSauceType();
                String newCrust = newPizza.getPizzaCrust();
                String newSize = newPizza.getPizzaSize();
                double newPizzaPrice = newPizza.getTotalPrice();

                canvas.setForegroundColor(Color.BLACK);

                newPrice = (totalCost - oldPrice) + newPizzaPrice;
                System.out.println("new price " + newPrice);
                pizzaList.add(pizzaNumber - 1, newPizza);

                canvas.eraseRectangle(oldX + 1, oldY + 1, 298, 298);

                canvas.setFontSize(15);
                canvas.drawString(" " + oldPizzaNo + "(" + newSize + ")", oldX + 45,oldY + 25);
                canvas.drawString(" " + newCrust + ", " + newSauce + " Sauce", oldX + 45,oldY + 290);

                canvas.setFontSize(25);
                canvas.eraseString("Total Price of the Order: £ " + (double)Math.round(totalCost*100)/100 , 10, 640);
                System.out.println("String to Delete" + totalCost);

                canvas.drawString("Total Price of the Order: £ " + (double)Math.round(newPrice*100)/100 , 10, 640);

                pizzaList.remove(pizzaNumber - 1);

                totalCost = newPrice;
                System.out.println("TotalCost" + totalCost); 

                newPizza.displayPizza();
            }
            else
            {
                loop = true;
            }
        }while(!loop);
    }

    /**
     * Method to remove a pizza
     * 
     * @param pizzaList a list of pizza objects
     * @param amountOfPizzas the amount of pizzas in the list currently
     * @param totalCost the the cost of all the pizzas
     */
    public void removePizzaByIndex(ArrayList<Pizza> pizzaList, int amountOfPizzas, double totalCost)
    {
        boolean loop = false;
        double newPrice = 0;
        do
        {

            if(pizzaList.size() >= 1)
            {
                int pizzaIndex = userInput.getPizzaToRemoveIndex(amountOfPizzas);
                if(pizzaIndex > 0)
                {

                    Pizza pizzaToRemove = pizzaList.get(pizzaIndex - 1);

                    double oldPrice = pizzaToRemove.getTotalPrice();
                    double x = pizzaToRemove.getTopLeftX();
                    double y = pizzaToRemove.getTopLeftY();

                    canvas.setFontSize(25);
                    canvas.setForegroundColor(Color.BLACK);
                    canvas.eraseString("Total Price of the Order: £ " + (double)Math.round(totalCost*100)/100 , 10, 640);
                    canvas.eraseString("Total Price of the Order: £ " + (double)Math.round(newPrice*100)/100 , 10, 640);

                    newPrice = totalCost - oldPrice;

                    canvas.drawString("Total Price of the Order: £ " + (double)Math.round(newPrice*100)/100 , 10, 640);
                    pizzaList.remove(pizzaIndex - 1); 

                    totalCost = newPrice;

                    canvas.eraseRectangle(x + 1, y + 1, 298, 298);

                    for (Pizza pizza: pizzaList)
                    {
                        double xCoordinate = pizza.getTopLeftX();  
                        double yCoordinate = pizza.getTopLeftY();

                        canvas.setFontSize(15);
                        int oldPizzaNo = pizza.getPizzaNo();
                        canvas.eraseString(" " + oldPizzaNo, xCoordinate + 45,yCoordinate + 25);

                        pizza.setPizzaNo(pizzaList, pizza);
                        int pizzaNumber = pizza.getPizzaNo();

                        canvas.drawString(" " + pizzaNumber, xCoordinate + 45,yCoordinate + 25);
                    }

                }
                else
                {

                    loop = true;

                }
            }
            else
            {
                loop = true;

            }
        }while(!loop);
    }

}

