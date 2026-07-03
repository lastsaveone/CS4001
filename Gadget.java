/**
 * Gadget.java
 *
 * Parent class representing a general gadget sold in the shop.
 * Holds the attributes and behaviour common to all gadgets:
 * model, price, weight and size.
 */
public class Gadget
{
    private String model;
    private double price;
    private int weight;
    private String size;

    /**
     * Constructor - initialises all four attributes of a gadget.
     *
     * @param model  the model name of the gadget
     * @param price  the price of the gadget in pounds
     * @param weight the weight of the gadget in grams
     * @param size   the physical dimensions of the gadget
     */
    public Gadget(String model, double price, int weight, String size)
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * @return the model name of the gadget
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @return the price of the gadget
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @return the weight of the gadget in grams
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * @return the size of the gadget
     */
    public String getSize()
    {
        return size;
    }

    /**
     * Displays the model, price, weight and size of the gadget
     * to the console, suitably annotated.
     */
    public void display()
    {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}
