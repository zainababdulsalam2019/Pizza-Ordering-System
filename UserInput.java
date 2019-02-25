import java.util.*;
/**
 * A class to get inputs from the user
 * 
 * @author 849104
 * @version 1
 */

public class UserInput
{   
    private KeyboardInput keyboardInput;
    private ArrayList<String> toppings;

    /**
     * Constructor for the UserInput class
     */

    public UserInput()
    {
        keyboardInput = new KeyboardInput();
        toppings = new ArrayList<String>();

    }

    /**
     * Method to get the pizza size from the user
     * 
     * @return the pizza size
     */
    public String getPizzaSize()
    {

        boolean validEntry = false;
        String pizzaSize;
        do
        {
            System.out.println("What size pizza do you want ie (small, medium, large): ");  

            pizzaSize = keyboardInput.getInputString();

            if(pizzaSize.equalsIgnoreCase("small")|| pizzaSize.equalsIgnoreCase("medium")|| pizzaSize.equalsIgnoreCase("large"))
            {

                validEntry = true;

            }

            else
            {

                System.out.println("Input is invalid ie (small, medium, large) ");

            }
        }while(!validEntry);

        return pizzaSize;
    }

    /**
     * Method to get the pizza crust from the user
     * 
     * @return the pizza crust
     */
    public String getPizzaCrust()
    {
        boolean validEntry = false;
        String pizzaCrust;

        do
        {

            System.out.println("What crust do you what for your pizza? ie (deep, thin, stuffed): ");
            pizzaCrust = keyboardInput.getInputString();

            if(pizzaCrust.equalsIgnoreCase("deep")|| pizzaCrust.equalsIgnoreCase("thin")|| pizzaCrust.equalsIgnoreCase("stuffed"))
            {
                validEntry = true;

            }
            else
            {
                System.out.println("The pizza crust type you has entered is invalid, ie (deep, thin, stuffed) ");

            }

        }while(!validEntry);

        return pizzaCrust;
    }

    /**
     * Method to get the pizza sauce from the user
     * 
     * @return the pizza sauce
     */
    public String getPizzaSauce()
    {
        boolean validEntry = false;
        String pizzaSauce;

        do
        {
            System.out.println("Would you like BBQ sauce?: ");
            pizzaSauce = keyboardInput.getInputString();
            if(pizzaSauce.equalsIgnoreCase("yes"))
            {
                validEntry = true;

            }
            else if(pizzaSauce.equalsIgnoreCase("no"))
            {
                validEntry = true;

            }

            else
            {
                System.out.println("Please enter 'yes' or 'no'");

            }

        }while(!validEntry);
        return pizzaSauce;

    }

    /**
     * Method to get the topping from the user
     * 
     * @return which topping they want
     */
    public String getTopping()
    {
        String topping;
        boolean validEntry = false;

        do
        {
            System.out.println("What topping would you like? ie('pineapple, prawn'): ");
            topping = keyboardInput.getInputString();

            if(topping.equalsIgnoreCase("pineapple") || topping.equalsIgnoreCase("prawn"))
            {
                validEntry = true;

            }

            else
            {
                System.out.println("Please enter a valid topping ie('pineapple, prawn')");

            }
        }while(!validEntry);
        return topping;

    }

    /**
     * Method to get list of toppings from the user
     * 
     * @return the list of toppings
     */
    public ArrayList<String> getToppingsList()
    {

        boolean validEntry = false;
        int numberOfToppings;

        String topping1;
        String topping2;

        do
        {
            System.out.println("How many toppings do you want? ie (0, 1, 2): ");
            numberOfToppings = keyboardInput.getInputInteger();

            if(numberOfToppings == 0)
            {
                validEntry = true;
            }

            else if(numberOfToppings == 1)
            {
                validEntry = true;

                topping1 = getTopping();
                toppings.add(topping1);

            }
            else if(numberOfToppings == 2)
            {
                validEntry = true;

                topping1 = getTopping();
                topping2 = getTopping();

                toppings.add(topping1);
                toppings.add(topping2);

            }
            else
            {
                System.out.println("Invalid input, enter '0', '1', '2'");

            }
        }while(!validEntry);
        return toppings;

    }

    /**
     * Method to ask the user whether they want another pizza
     * 
     * @return the user input on whether they want another pizza or not
     */

    public String getAdditionalPizzaRequest()
    {
        String userInput;
        boolean validEntry = false;

        do
        {
            System.out.println("Do you want another pizza? : ");
            userInput = keyboardInput.getInputString();

            if(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no"))
            {
                validEntry = true;

            }

            else
            {
                System.out.println("Please enter yes or no");

            }
        }while(!validEntry);

        return userInput;

    }

    /**
     * Method asks the user whether they want to change any of their pizzas
     *
     * @return the number pizza they want to change
     */
    public int getPizzaNoToChange(int numberOfPizzas)
    {

        String userRequest;
        boolean validEntry = false;
        int pizzaNoToChange = 0;

        do
        {
            System.out.println("Would like to change any of your pizza's? : ");
            userRequest = keyboardInput.getInputString();

            if(userRequest.equalsIgnoreCase("yes"))
            {
                pizzaNoToChange = getPizzaNo(numberOfPizzas);
                validEntry = true;

            }
            else if(userRequest.equalsIgnoreCase("no"))
            {
                pizzaNoToChange = 0;
                validEntry = true;

            }
            else
            {

                System.out.println("Please enter 'yes' or 'no'");   

            }
        }while(!validEntry);
        return pizzaNoToChange;
    }

    /**
     * Method to get which number pizza the user wants to change
     * 
     * @return the number pizza they want to change
     */
    public int getPizzaNo(int numberOfPizzas)
    {
        boolean validEntry = false;
        int pizzaNo = 0;

        do
        {
            System.out.println("What number pizza would you like to change?: ");
            pizzaNo = keyboardInput.getInputInteger(); 

            if(pizzaNo >=1 && pizzaNo <= numberOfPizzas)
            {
                validEntry = true;

            }

            else
            {
                System.out.println("Invalid input this is the number of pizzas you have " + numberOfPizzas);  

            }

        }while(!validEntry);

        return pizzaNo;
    }

    /**
     * Method to ask the user whether they want to remove any of the pizzas
     * 
     * @return the number of the pizza they want to remove
     */
    public int getPizzaToRemoveIndex(int numberOfPizzas)
    {
        boolean validEntry = false;
        String userInput;      
        int pizzaToRemoveIndex = 0;
        do
        {
            if(numberOfPizzas >= 1)
            {
                System.out.println("Would you like to remove a pizza from your order? : ");
                userInput = keyboardInput.getInputString();
                if(userInput.equalsIgnoreCase("yes"))
                {
                    pizzaToRemoveIndex = getPizzaIndex(numberOfPizzas);
                    validEntry = true;
                }
                else if(userInput.equalsIgnoreCase("no"))
                {
                    pizzaToRemoveIndex = 0;
                    validEntry = true;  
                }

                else
                {
                    System.out.println("Please enter 'yes' or 'no'");

                }

            }
        }while(!validEntry);
        return pizzaToRemoveIndex;
    }

    /**
     * Method to ask the user what number pizza they want to remove
     * 
     * @return the number of the pizza they want to remove
     */
    public int getPizzaIndex(int numberOfPizzas)
    {
        int pizzaIndex = 0;
        boolean validEntry = false;

        do
        {
            System.out.println("What number pizza do you want to remove? : ");
            pizzaIndex = keyboardInput.getInputInteger();
            if(pizzaIndex >=1 && pizzaIndex <= numberOfPizzas)
            {
                validEntry = true;

            }

            else
            {
                System.out.println("Invalid input this is the number of pizzas you have " + numberOfPizzas);  

            }
        }while(!validEntry);

        return pizzaIndex;
    }
}  