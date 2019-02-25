
/**
 * Class to start the running of the Pizza Ordering System.
 * @author 849104
 * @version 1
 */
public class PizzaMain 
{

    public static void main(String[] args) 
    {
        OrderingSystem orders = new OrderingSystem();
        orders.drawOrderScreen();
        orders.startOrdering();

    }
}
