import java.util.*;

/**
 * Prompts user for a purchase price and a cash amount, then is read and the computer prints out the change needed, with dollars and every coin type. User is then prompted
 * to input another customer, by typing in true or false.
 * 
 * The main goal of this program is to explore the uses of integer math, converting doubles to integers, and parameter uses in different methods.
 *
 * @author Keshav Kotamraju
 * @version September 9 2022
 */
public class ChangeMaker
{
    private Scanner in;

    /**
     * Constructor an instance variable for the ChangeMaker class.
     */
    public ChangeMaker()
    {
        in = new Scanner(System.in);
    }

    /**
     * Asks the customer for the purchase price.
     *
     * @return    the purchase price in cents
     */
    public int askForPurchasePrice()
    {
        System.out.println("\nWhat is your purchase price?($)");
        int price = (int) (in.nextDouble() * 100 + 0.5); //stored in cents
        in.nextLine();
        return price;//return is in cents
        
    }
    /**
     * Asks the customer for the ammount of cash to present
     * and allows them to add more if the ammount is insufficient. A zero input terminates the transaction. 
     * 
     * @param price       the purchase price in cents
     * @return      the ammount of cash in cents;
     *              0 indicates termination
     */
    public int askForCashPaid(int price)
    {
        System.out.println("How much cash would you like to give?($)");
        int cashPaid = (int)(in.nextDouble() * 100 +0.5);//stored in cents
        in.nextLine();
        while (cashPaid < price && cashPaid >=0 )
        {  
            System.out.println("That is not enough cash, please add more or terminate the transaction by entering 0.");
            int addedCash = (int) (in.nextDouble() * 100 + 0.5);// stored in cents
            in.nextLine();
            if (addedCash == 0)
            {
                cashPaid = -1;
                System.out.println("\nYou have terminated the transaction!");
            }
            else{
                cashPaid += addedCash;
            }
            
            
        }
        if (cashPaid == 0)
            cashPaid = -1;
            System.out.println("No transaction needed!");
        return cashPaid;
    }
    /**
     * Calculates and prints out the change, based on the user's inputs.
     * 
     * @precondition    cashPaid>=price   
     * 
     * @param price      price that the customer needs to pay in cents        
     * @param cashPaid      ammount of cash that the customer has paid in cents
     */
    public void giveChange(int price,int cashPaid)
    {
        //print ammount of purchase and cash tendered
        System.out.printf("\n\namount of purchase = $ %.2f \n",
                          price/100.0);
        System.out.printf("Cash tendered = $ %.2f\n",
                          cashPaid/100.0);
        
        //calculate change in cents as an int
        int change = cashPaid - price;
        int dollars = change/100;
        int coinChange = change%100;
        
        //print distribution
        if (change == 0)
        {
            System.out.println("\nThat is exactly enough money! No change needed");
        }
        else
        {
                //print change
            System.out.printf("Change = $ %d.%02d\n",
                              dollars, coinChange);
            
            //calculate coins needed
            int changeLeft = coinChange;
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
            int pennies = 0;
            
            while(changeLeft > 0)//prevents arithmetic exceptions of divide by 0 by ending loop when no more change
            {
                quarters = changeLeft/25;
                changeLeft %= 25;
                dimes = changeLeft/10;
                changeLeft %= 10;
                nickels = changeLeft/5;
                changeLeft %= 5;
                pennies = changeLeft;
                changeLeft %= 1;
    
            }        
            System.out.println("\nDistribution of change: ");
            if (dollars == 1)
                System.out.println("\t" + dollars + " dollar");
            else if (dollars > 1)
                System.out.println("\t" + dollars + " dollars");
            if (quarters == 1)
                System.out.println("\t" + quarters + " quarter");
            else if (quarters > 1)
                System.out.println("\t" + quarters + " quarters");
            if (dimes == 1)
                System.out.println("\t" + dimes + " dime");
            else if (dimes > 1)
                System.out.println("\t" + dimes + " dimes");
            if (nickels == 1)
                System.out.println("\t" + nickels + " nickel");
            else if (nickels > 1)
                System.out.println("\t" + nickels + " nickels");
            if (pennies == 1)
                System.out.println("\t" + pennies + " penny");
            else if (pennies > 1)
                System.out.println("\t" + pennies + " pennies");
                
        }
        
    }
    /**
     * Handles the transaction for one customer, including getting the purchase price and change given by the user. 
     */
    public void interactWithOneCustomer()
    {
        int price = askForPurchasePrice();
        int cashPaid = askForCashPaid(price);
        if (cashPaid != -1)
        {
            giveChange(price,cashPaid);
        }


    }
    /**
     * Manages the transaction for all customers; gives the user an option to terminate if no more customers.
     */
    public void processAllTransactions()
    {
        boolean moreCustomers = true;
        while (moreCustomers){
            interactWithOneCustomer();
            System.out.println(
            "\nAre There any more customers? Type 0 if there are no more customers, otherwise type any other number!");
            int userMoreCustomers = (int) (in.nextDouble() +0.5);
            in.nextLine();
            if (userMoreCustomers == 0)
                moreCustomers = false;
            

            
        }
    }
    /**
     * Runs ChangeMaker code.
     * 
     * @param args      information from the command line
     */
    public static void main(String args[])
    {
        
        ChangeMaker Cashier = new ChangeMaker();
        Cashier.processAllTransactions();

    }
        
}
