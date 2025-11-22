
/**
 * Write a description of class Monitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monitor
{
    // instance variables - replace the example below with your own
    private int size;//diagonaly
    private boolean isOn;
    private double length;
    private double width;
    private String color;
    

    /**
     * Constructor for objects of class Monitor
     */
    public Monitor(int siz,boolean on, double monitorLength, double monitorWidth, String monitorColor)
    {
        // initialise instance variables
        size = siz;
        isOn = on;
        length = monitorLength;
        width = monitorWidth;
        color = monitorColor;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void turnOn()
    {
        // put your code here
        System.out.println("Monitor is on.");
        isOn = true;
    }
    public void turnOff()
    {
        System.out.println("Monitor is off.");
        isOn = false;
    }
    public boolean checkIfOn()
    {
       return isOn;
    }
    public double getPrice(int size)
    {
        double price = size * 5.25;
        return price;
    }
    public double findArea(double length, double width)
    {
        double area = length * width;
        return area;
    }
    public String getColor(String color)
    {
        return color;
    }
    public void useMonitor()
    {
        if (!checkIfOn())
        {
        turnOn();
        System.out.println("Monitor is now in use.");
        }
        else
        {
            System.out.println("Monitor is already in use");
        }
        
    }
    public static void main(String[] args)
    {
        Monitor m = new Monitor(20, false, 12.00, 9.00, "blue");
        m.useMonitor();
        
    }
}
