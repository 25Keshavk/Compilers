
public class AmazingExperiment extends Experiment 
{
    private double z;
    public AmazingExperiment()
    {
        super();
        z = Math.E;
    }
    public void setZ(int z)
    {
        this.z = z;
    }
    public double  getZ()
    {
        return z;
    }
    @Override
    public String toString()
    {
        return ("I am amazzzzzingly good my z is " + z + " "+ super.toString());
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Experiment)
        {
            Experiment spiderman = (Experiment)obj;
            double diffZ = this.getZ() - spiderman.getZ();
            if (super.equals(spiderman) && diffZ
        }
        return false;
    }
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Experiment)
        {
            Experiment spiderman = (Experiment)obj;
            return this.getZ() - spiderman.getZ();
        }
        throw new IllegalArgumentException("Needs an AjazingExperiment");
    }
}
