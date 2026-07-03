/**
 * MP3.java
 *
 * Subclass of Gadget representing an MP3 player.
 * Adds a single attribute, memory, which stores the amount
 * of available storage on the device.
 */
public class MP3 extends Gadget
{
    private int memory;

    /**
     * Constructor - passes the model, price, weight and size to the
     * Gadget constructor, and initialises the memory attribute.
     *
     * @param model  the model name of the MP3 player
     * @param price  the price of the MP3 player
     * @param weight the weight of the MP3 player in grams
     * @param size   the physical dimensions of the MP3 player
     * @param memory the initial available memory
     */
    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    /**
     * @return the available memory on the MP3 player
     */
    public int getMemory()
    {
        return memory;
    }

    /**
     * Downloads a piece of music of a given size. If there is enough
     * available memory, it is decreased accordingly. Otherwise an
     * error message is displayed.
     *
     * @param downloadSize the amount of memory the download will take up
     */
    public void downloadMusic(int downloadSize)
    {
        if (downloadSize <= memory)
        {
            memory -= downloadSize;
        }
        else
        {
            System.out.println("Error: not enough available memory to complete this download.");
        }
    }

    /**
     * Deletes a piece of music, freeing up the amount of memory it
     * used to occupy.
     *
     * @param size the amount of memory to free up
     */
    public void deleteMusic(int size)
    {
        memory += size;
    }

    /**
     * Displays the details of the MP3 player. Calls the display
     * method in the Gadget class to show the model, price, weight
     * and size, then displays the available memory.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Available Memory: " + memory + "MB");
    }
}
