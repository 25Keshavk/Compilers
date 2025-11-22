
import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

/**
 * Based upon AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 * 
 * This class runs a world that contains VenusFlyTraps objects, Sandstone objects,
 *  and JumperBug objects. <br />
 * 
 * @author Susan King
 * @version October 8, 2018
 */
public class VenusSandstoneJumperBugRunner
{
    // /**
     // *  Tests the code for VenusFlyTraps objects, Sandstone objects,
     // *  and JumperBug objects.
     // *  
     // * @param args  information from the command line
     // */
    // public static void main(String[] args)
    // {
        // ActorWorld world = new ActorWorld();
        // JumperBug alice = new JumperBug( );
        // alice.setColor(Color.ORANGE);
        // JumperBug bob = new  JumperBug( );
        // bob.setColor(Color.BLUE);
        // JumperBug betty = new JumperBug( );
        // betty.setColor(Color.ORANGE);
        // betty.setDirection(Location.SOUTH);
        // JumperBug carl = new JumperBug( );
        // carl.setColor(Color.WHITE);
        // JumperBug dusty = new JumperBug( );
        // dusty.setColor(Color.ORANGE);
        // JumperBug ed = new JumperBug( );
        // ed.setColor(Color.PINK);
        // JumperBug felicia = new JumperBug( );
        // felicia.setColor(Color.ORANGE);
        // felicia.setDirection(Location.EAST);
        // JumperBug greg = new JumperBug( );
        // greg.setColor(Color.YELLOW);
        // JumperBug henry = new JumperBug( );
        // henry.setColor(Color.ORANGE);
        // JumperBug igor = new JumperBug( );
        // igor.setColor(Color.ORANGE);
        // JumperBug janet = new JumperBug( );
        // janet.setColor(Color.ORANGE);
        // janet.setDirection(Location.EAST);
        // JumperBug karen = new JumperBug( );
        // karen.setColor(Color.ORANGE);
        
        // world.add(new Location(7, 8), alice);
        // world.add(new Location(6, 0), bob);
        // world.add(new Location(9, 0), betty);
        // world.add(new Location(1, 1), carl);
        // world.add(new Location(5, 1), dusty);
        // world.add(new Location(7, 2), ed);
        // world.add(new Location(0, 4), felicia);
        // world.add(new Location(5, 5), greg);
        // world.add(new Location(5, 8), henry);
        // world.add(new Location(1, 8), igor);
        // world.add(new Location(3, 8), janet);
        // world.add(new Location(7, 9), karen);

        // world.add(new Location(3, 9), new Rock( ));
        // world.add(new Location(4, 1), new VenusFlyTrap( ));
        // world.add(new Location(1, 4), new VenusFlyTrap( ));
        // world.add(new Location(4, 5), new Rock( ));
        // world.add(new Location(2, 6), new VenusFlyTrap( ));
        // world.add(new Location(4, 7), new VenusFlyTrap( ));
        // world.add(new Location(5, 0), new Rock( )); 
        // world.add(new Location(3, 3), new VenusFlyTrap( ));
        // world.add(new Location(5, 4), new Sandstone( )); 
        // world.add(new Location(5, 6), new Sandstone( ));
        // world.add(new Location(5, 7), new Sandstone( ));
        // world.add(new Location(2, 8), new Sandstone( )); 
        // world.add(new Location(2, 5), new VenusFlyTrap( ));
        // world.add(new Location(6, 6), new Sandstone( ));
        // world.add(new Location(6, 7), new Sandstone( ));
        // world.add(new Location(6, 9), new Sandstone( ));
        // world.add(new Location(0, 1), new VenusFlyTrap( ));
        // world.add(new Location(7, 6), new VenusFlyTrap( ));
        // world.add(new Location(7, 7), new Sandstone( ));
        // world.add(new Location(7, 9), new Sandstone( ));
        // world.add(new Location(3, 6), new VenusFlyTrap( ));
        // world.add(new Location(8, 7), new VenusFlyTrap( ));
        // world.add(new Location(8, 8), new VenusFlyTrap( ));
        
        // world.add(new Location(0, 6), new VenusFlyTrap( ));
        // world.add(new Location(0, 7), new VenusFlyTrap( ));
        // world.add(new Location(0, 5), new VenusFlyTrap( ));
        // world.add(new Location(0, 9), new VenusFlyTrap( ));
        // world.add(new Location(1, 3), new VenusFlyTrap( ));
        // world.add(new Location(3, 1), new VenusFlyTrap( ));
        // world.add(new Location(3, 2), new VenusFlyTrap( ));
        // world.add(new Location(3, 3), new VenusFlyTrap( ));
        // world.add(new Location(6, 2), new VenusFlyTrap( ));
        // world.add(new Location(6, 8), new VenusFlyTrap( ));
        // world.add(new Location(9, 6), new VenusFlyTrap( ));
        // world.add(new Location(9, 7), new VenusFlyTrap( ));
        // world.add(new Location(9, 8), new VenusFlyTrap( ));
        
        // world.add(new Location(0, 0), new VenusFlyTrap( ));
        // world.add(new Location(0, 1), new VenusFlyTrap( ));
        // world.add(new Location(0, 2), new VenusFlyTrap( ));
        // world.add(new Location(0, 3), new VenusFlyTrap( ));
        // world.add(new Location(1, 0), new VenusFlyTrap( ));
        // world.add(new Location(1, 2), new VenusFlyTrap( ));
        // world.add(new Location(2, 0), new VenusFlyTrap( ));
        // world.add(new Location(2, 1), new VenusFlyTrap( ));
        // world.add(new Location(2, 2), new VenusFlyTrap( ));
        // world.add(new Location(2, 3), new VenusFlyTrap( ));
        // world.add(new Location(3, 0), new VenusFlyTrap( ));
        // world.add(new Location(4, 0), new VenusFlyTrap( ));
        // world.show();
    // }
}