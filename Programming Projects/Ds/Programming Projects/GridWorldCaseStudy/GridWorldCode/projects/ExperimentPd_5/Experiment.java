
/**
 * Write a description of class Experiment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Experiment implements Comparable
{
    private int x;
    public Experiment()
    {
        super();
        x = 5;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getX()
    {
        return x;
    }
    @Override
    public String toString()
    {
        return ("x: " + x);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Experiment)
        {
            Experiment xMan = (Experiment)obj;
            return this.getX() == xMan.getX();
        }
        return false;
    }
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Experiment)
        {
            Experiment xMan = (Experiment)obj;
            return this.getX() - xMan.getX();
        }
        throw new IllegalArgumentException("Needs an Experiment");
    }
}
