import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * GadgetShop.java
 *
 * GUI class for the Gadget Shop application. Stores gadgets
 * (mobile phones and MP3 players) in an ArrayList, and provides
 * a Swing interface to add, display and interact with them.
 */
public class GadgetShop implements ActionListener
{
    // The main application window
    private JFrame frame;

    // Stores all the gadgets in the shop
    private ArrayList<Gadget> gadgets;

    // Text fields
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadField;
    private JTextField displayNumberField;

    // Buttons
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton clearButton;
    private JButton displayAllButton;
    private JButton makeCallButton;
    private JButton downloadMusicButton;

    /**
     * Constructor - builds the ArrayList and the GUI.
     */
    public GadgetShop()
    {
        gadgets = new ArrayList<Gadget>();
        buildGUI();
    }

    /**
     * Builds and lays out all of the GUI components.
     */
    private void buildGUI()
    {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 0 rows tells GridLayout to compute the row count automatically
        // from the fixed number of columns (4) and the number of
        // components added - this keeps every logical row (label row,
        // field row, button row, etc.) aligned as intended.
        frame.setLayout(new GridLayout(0, 4, 5, 5));

        // Row 1: Model, Price, Weight, Size
        frame.add(new JLabel("Model:"));
        frame.add(new JLabel("Price:"));
        frame.add(new JLabel("Weight:"));
        frame.add(new JLabel("Size:"));

        modelField = new JTextField();
        priceField = new JTextField();
        weightField = new JTextField();
        sizeField = new JTextField();
        frame.add(modelField);
        frame.add(priceField);
        frame.add(weightField);
        frame.add(sizeField);

        // Row 2: Credit, Memory, Add Mobile, Add MP3
        frame.add(new JLabel("Credit:"));
        frame.add(new JLabel("Memory:"));

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        frame.add(addMobileButton);
        frame.add(addMP3Button);

        creditField = new JTextField();
        memoryField = new JTextField();
        frame.add(creditField);
        frame.add(memoryField);

        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        frame.add(clearButton);
        frame.add(displayAllButton);

        // Row 3: Phone No, Duration, Download, Display Number labels
        frame.add(new JLabel("Phone No:"));
        frame.add(new JLabel("Duration:"));
        frame.add(new JLabel("Download:"));
        frame.add(new JLabel("Display Number:"));

        phoneNumberField = new JTextField();
        durationField = new JTextField();
        downloadField = new JTextField();
        displayNumberField = new JTextField();
        frame.add(phoneNumberField);
        frame.add(durationField);
        frame.add(downloadField);
        frame.add(displayNumberField);

        // Row 4: Make A Call, Download Music
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");
        frame.add(makeCallButton);
        frame.add(downloadMusicButton);
        frame.add(new JLabel(""));
        frame.add(new JLabel(""));

        // Register this class as the ActionListener for all buttons
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);

        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ---------------------------------------------------------------
    // Text field input methods
    // ---------------------------------------------------------------

    /**
     * @return the model entered in the model text field
     */
    private String getModel()
    {
        return modelField.getText();
    }

    /**
     * Reads the price text field and converts it to a double.
     * If the text cannot be converted, an error dialog is shown
     * and 0.0 is returned.
     *
     * @return the price entered, or 0.0 if invalid
     */
    private double getPrice()
    {
        double price = 0.0;
        try
        {
            price = Double.parseDouble(priceField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid number for the price.",
                    "Invalid Price", JOptionPane.ERROR_MESSAGE);
        }
        return price;
    }

    /**
     * Reads the weight text field and converts it to an int.
     * If the text cannot be converted, an error dialog is shown
     * and 0 is returned.
     *
     * @return the weight entered, or 0 if invalid
     */
    private int getWeight()
    {
        int weight = 0;
        try
        {
            weight = Integer.parseInt(weightField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid integer for the weight.",
                    "Invalid Weight", JOptionPane.ERROR_MESSAGE);
        }
        return weight;
    }

    /**
     * @return the size entered in the size text field
     */
    private String getSize()
    {
        return sizeField.getText();
    }

    /**
     * Reads the credit text field and converts it to an int.
     * If the text cannot be converted, an error dialog is shown
     * and 0 is returned.
     *
     * @return the credit entered, or 0 if invalid
     */
    private int getCredit()
    {
        int credit = 0;
        try
        {
            credit = Integer.parseInt(creditField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid integer for the credit.",
                    "Invalid Credit", JOptionPane.ERROR_MESSAGE);
        }
        return credit;
    }

    /**
     * Reads the memory text field and converts it to an int.
     * If the text cannot be converted, an error dialog is shown
     * and 0 is returned.
     *
     * @return the memory entered, or 0 if invalid
     */
    private int getMemory()
    {
        int memory = 0;
        try
        {
            memory = Integer.parseInt(memoryField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid integer for the memory.",
                    "Invalid Memory", JOptionPane.ERROR_MESSAGE);
        }
        return memory;
    }

    /**
     * @return the phone number entered in the phone number text field
     */
    private String getPhoneNumber()
    {
        return phoneNumberField.getText();
    }

    /**
     * Reads the duration text field and converts it to an int.
     * If the text cannot be converted, an error dialog is shown
     * and 0 is returned.
     *
     * @return the duration entered, or 0 if invalid
     */
    private int getDuration()
    {
        int duration = 0;
        try
        {
            duration = Integer.parseInt(durationField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid integer for the duration.",
                    "Invalid Duration", JOptionPane.ERROR_MESSAGE);
        }
        return duration;
    }

    /**
     * Reads the download size text field and converts it to an int.
     * If the text cannot be converted, an error dialog is shown
     * and 0 is returned.
     *
     * @return the download size entered, or 0 if invalid
     */
    private int getDownloadSize()
    {
        int downloadSize = 0;
        try
        {
            downloadSize = Integer.parseInt(downloadField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a valid integer for the download size.",
                    "Invalid Download Size", JOptionPane.ERROR_MESSAGE);
        }
        return downloadSize;
    }

    /**
     * Reads the display number text field. The display number
     * corresponds to the index of a gadget in the ArrayList.
     *
     * The value is first initialised to -1. If the input can be
     * parsed as an integer and lies within the range of valid
     * indices for the gadgets ArrayList, the display number is
     * updated to that value. Otherwise an appropriate error dialog
     * is shown and -1 is returned.
     *
     * @return the display number entered, or -1 if invalid
     */
    private int getDisplayNumber()
    {
        int displayNumber = -1;
        try
        {
            int number = Integer.parseInt(displayNumberField.getText());
            if (number >= 0 && number < gadgets.size())
            {
                displayNumber = number;
            }
            else
            {
                JOptionPane.showMessageDialog(frame,
                        "Invalid Display Number. There is no gadget with that number.",
                        "Invalid Display Number", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame,
                    "Invalid Display Number. Please enter an integer.",
                    "Invalid Display Number", JOptionPane.ERROR_MESSAGE);
        }
        return displayNumber;
    }

    /**
     * Clears the text in each of the ten text fields.
     */
    private void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayNumberField.setText("");
    }

    // ---------------------------------------------------------------
    // Button handling
    // ---------------------------------------------------------------

    /**
     * Handles all of the button click events for the GUI.
     *
     * @param e the event generated by the button that was clicked
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addMobileButton)
        {
            addMobile();
        }
        else if (e.getSource() == addMP3Button)
        {
            addMP3();
        }
        else if (e.getSource() == clearButton)
        {
            clearFields();
        }
        else if (e.getSource() == displayAllButton)
        {
            displayAll();
        }
        else if (e.getSource() == makeCallButton)
        {
            makeCall();
        }
        else if (e.getSource() == downloadMusicButton)
        {
            downloadMusic();
        }
    }

    /**
     * Reads the model, price, weight, size and credit from the GUI,
     * creates a new Mobile object and adds it to the gadgets ArrayList.
     */
    private void addMobile()
    {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int credit = getCredit();

        Mobile mobile = new Mobile(model, price, weight, size, credit);
        gadgets.add(mobile);

        JOptionPane.showMessageDialog(frame, "Mobile added successfully.");
        clearFields();
    }

    /**
     * Reads the model, price, weight, size and memory from the GUI,
     * creates a new MP3 object and adds it to the gadgets ArrayList.
     */
    private void addMP3()
    {
        String model = getModel();
        double price = getPrice();
        int weight = getWeight();
        String size = getSize();
        int memory = getMemory();

        MP3 mp3 = new MP3(model, price, weight, size, memory);
        gadgets.add(mp3);

        JOptionPane.showMessageDialog(frame, "MP3 player added successfully.");
        clearFields();
    }

    /**
     * Loops through the gadgets ArrayList and calls display() on
     * each gadget, printing its details (with its index number)
     * to the console.
     */
    private void displayAll()
    {
        if (gadgets.isEmpty())
        {
            System.out.println("There are no gadgets to display.");
            return;
        }

        for (int i = 0; i < gadgets.size(); i++)
        {
            System.out.println("Gadget " + i + ":");
            gadgets.get(i).display();
            System.out.println();
        }
    }

    /**
     * Reads the display number, phone number and duration from the
     * GUI. If the display number is valid, gets the corresponding
     * gadget from the ArrayList, casts it to Mobile, and calls
     * makeCall() on it.
     */
    private void makeCall()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1)
        {
            try
            {
                Gadget gadget = gadgets.get(displayNumber);
                Mobile mobile = (Mobile) gadget;

                String phoneNumber = getPhoneNumber();
                int duration = getDuration();

                mobile.makeCall(phoneNumber, duration);
            }
            catch (ClassCastException e)
            {
                JOptionPane.showMessageDialog(frame,
                        "The gadget selected is not a Mobile phone.",
                        "Invalid Gadget Type", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Reads the display number and download size from the GUI.
     * If the display number is valid, gets the corresponding
     * gadget from the ArrayList, casts it to MP3, and calls
     * downloadMusic() on it.
     */
    private void downloadMusic()
    {
        int displayNumber = getDisplayNumber();

        if (displayNumber != -1)
        {
            try
            {
                Gadget gadget = gadgets.get(displayNumber);
                MP3 mp3 = (MP3) gadget;

                int downloadSize = getDownloadSize();

                mp3.downloadMusic(downloadSize);
            }
            catch (ClassCastException e)
            {
                JOptionPane.showMessageDialog(frame,
                        "The gadget selected is not an MP3 player.",
                        "Invalid Gadget Type", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * The entry point of the application. Creates a GadgetShop
     * object, which builds and displays the GUI.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args)
    {
        new GadgetShop();
    }
}
