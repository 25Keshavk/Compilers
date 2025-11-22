
public class ExperimentRunner
{
    public static void main(String[]args)
    {
        Experiment scientist = new Experiment();
        (scientist).setX(7);
        System.out.println(scientist);
        System.out.println(scientist.toString());
        
        Experiment beaker = new AmazingExperiment();
        beaker.setX(Integer.MAX_VALUE);
         System.out.println(beaker);
        System.out.println(beaker.toString());
        
        System.out.println("scientist equals beaker =" + 
                            scientist.equals(beaker));
        System.out.println("beaker equals scientist =" + 
                            beaker.equals(scientist));     
        System.out.println("scientist compareTo beaker =" + 
                            scientist.compareTo(beaker));
        System.out.println("beaker compareTo scientist =" + 
                            beaker.compareTo(scientist));   
    }
}
