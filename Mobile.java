/**
 * Mobile.java
 *
 * Subclass of Gadget representing a mobile phone.
 * Adds a single attribute, credit, which stores the whole
 * number of minutes of calling credit remaining.
 */
public class Mobile extends Gadget
{
    private int credit;

    /**
     * Constructor - passes the model, price, weight and size to the
     * Gadget constructor, and initialises the credit attribute.
     *
     * @param model  the model name of the mobile phone
     * @param price  the price of the mobile phone
     * @param weight the weight of the mobile phone in grams
     * @param size   the physical dimensions of the mobile phone
     * @param credit the initial calling credit, in minutes
     */
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model, price, weight, size);
        this.credit = credit;
    }

    /**
     * @return the remaining calling credit, in minutes
     */
    public int getCredit()
    {
        return credit;
    }

    /**
     * Adds calling credit to the mobile phone.
     * If the amount supplied is greater than zero it is added to the
     * current credit, otherwise an error message is displayed.
     *
     * @param minutes the number of minutes of credit to add
     */
    public void addCredit(int minutes)
    {
        if (minutes > 0)
        {
            credit += minutes;
        }
        else
        {
            System.out.println("Error: please enter a positive amount of credit.");
        }
    }

    /**
     * Simulates making a phone call. If there is enough credit,
     * the phone number is printed and the duration is subtracted
     * from the remaining credit. Otherwise an "Insufficient credit"
     * message is displayed.
     *
     * @param phoneNumber the number being called
     * @param duration    the length of the call, in minutes
     */
    public void makeCall(String phoneNumber, int duration)
    {
        if (duration <= credit)
        {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minute(s)...");
            credit -= duration;
        }
        else
        {
            System.out.println("Insufficient credit");
        }
    }

    /**
     * Displays the details of the mobile phone. Calls the display
     * method in the Gadget class to show the model, price, weight
     * and size, then displays the remaining credit.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Remaining Credit: " + credit + " minute(s)");
    }
}
