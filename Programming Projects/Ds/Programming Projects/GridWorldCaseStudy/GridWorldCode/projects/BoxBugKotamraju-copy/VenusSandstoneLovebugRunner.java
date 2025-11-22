/* 
 * Based upon AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 * 
 * This class runs a world that contains Lovebugs,VenusFlyTraps,
 * Sandstones, and Actors. <br />
 * 
 * @author Susan King    Modifications for CheckStyle
 * @version October 8, 2018
 */

import java.awt.Color;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

/**
 * Tests a world that contains Lovebug,VenusFlyTraps,
 * Sandstones, and Actors.
 * 
 * @author Susan King    Modifications for CheckStyle
 * @version October 8, 2018
 */
public class VenusSandstoneLovebugRunner
{
    /**
     *  Tests the code for Lobebug objects, VenusFlyTraps objects,
     *  and Sandstone objects.
     *  
     * @param args  information from the command line
     */
    public static void main(String[] args)
    {
        int prob = 90;
        ActorWorld world = new ActorWorld();
        Lovebug alice = new Lovebug( );
        alice.setColor(Color.ORANGE);
        Lovebug bob = new  Lovebug(prob );
        bob.setColor(Color.BLUE);
        Lovebug betty = new Lovebug( );
        betty.setColor(Color.ORANGE);
        betty.setDirection(Location.SOUTH);
        Lovebug carl = new Lovebug( prob );
        carl.setColor(Color.WHITE);
        Lovebug dusty = new Lovebug( );
        dusty.setColor(Color.ORANGE);
        Lovebug ed = new Lovebug( prob );
        ed.setColor(Color.PINK);
        Lovebug felicia = new Lovebug( );
        felicia.setColor(Color.ORANGE);
        felicia.setDirection(Location.EAST);
        Lovebug greg = new Lovebug(prob  );
        greg.setColor(Color.YELLOW);
        Lovebug henry = new Lovebug( );
        henry.setColor(Color.ORANGE);
        Lovebug igor = new Lovebug( prob);
        igor.setColor(Color.ORANGE);
        Lovebug janet = new Lovebug( );
        janet.setColor(Color.ORANGE);
        janet.setDirection(Location.EAST);
        Lovebug karen = new Lovebug( );
        karen.setColor(Color.ORANGE);
        
        world.add(new Location(7, 8), alice);
        world.add(new Location(6, 0), bob);
        world.add(new Location(9, 0), betty);
        world.add(new Location(1, 1), carl);
        world.add(new Location(5, 1), dusty);
        world.add(new Location(7, 2), ed);
        world.add(new Location(0, 4), felicia);
        world.add(new Location(5, 5), greg);
        world.add(new Location(5, 8), henry);
        world.add(new Location(1, 8), igor);
        world.add(new Location(3, 8), janet);
        world.add(new Location(7, 9), karen);

        world.add(new Location(3, 9), new VenusFlyTrap( ));
        world.add(new Location(4, 1), new VenusFlyTrap( ));
        world.add(new Location(1, 4), new VenusFlyTrap( ));
        world.add(new Location(4, 5), new VenusFlyTrap( ));
        world.add(new Location(2, 6), new VenusFlyTrap( ));
        world.add(new Location(4, 7), new VenusFlyTrap( ));
        world.add(new Location(5, 0), new VenusFlyTrap( )); 
        world.add(new Location(3, 3), new VenusFlyTrap( ));
        world.add(new Location(5, 4), new VenusFlyTrap( )); 
        world.add(new Location(5, 6), new VenusFlyTrap( ));
        world.add(new Location(5, 7), new VenusFlyTrap( ));
        world.add(new Location(2, 8), new VenusFlyTrap( )); 
        world.add(new Location(2, 5), new VenusFlyTrap( ));
        world.add(new Location(6, 6), new VenusFlyTrap( ));
        world.add(new Location(6, 7), new VenusFlyTrap( ));
        world.add(new Location(6, 9), new VenusFlyTrap( ));
        world.add(new Location(0, 1), new VenusFlyTrap( ));
        world.add(new Location(7, 6), new VenusFlyTrap( ));
        world.add(new Location(7, 7), new VenusFlyTrap( ));
        world.add(new Location(7, 9), new VenusFlyTrap( ));
        world.add(new Location(3, 6), new VenusFlyTrap( ));
        world.add(new Location(8, 7), new VenusFlyTrap( ));
        world.add(new Location(8, 8), new VenusFlyTrap( ));
        
        world.add(new Location(0, 6), new VenusFlyTrap( ));
        world.add(new Location(0, 7), new VenusFlyTrap( ));
        world.add(new Location(0, 5), new VenusFlyTrap( ));
        world.add(new Location(0, 9), new VenusFlyTrap( ));
        world.add(new Location(1, 3), new VenusFlyTrap( ));
        world.add(new Location(3, 1), new VenusFlyTrap( ));
        world.add(new Location(3, 2), new VenusFlyTrap( ));
        world.add(new Location(3, 3), new VenusFlyTrap( ));
        world.add(new Location(6, 2), new VenusFlyTrap( ));
        world.add(new Location(6, 8), new VenusFlyTrap( ));
        world.add(new Location(9, 6), new VenusFlyTrap( ));
        world.add(new Location(9, 7), new VenusFlyTrap( ));
        world.add(new Location(9, 8), new VenusFlyTrap( ));
        
        world.add(new Location(0, 0), new VenusFlyTrap( ));
        world.add(new Location(0, 1), new VenusFlyTrap( ));
        world.add(new Location(0, 2), new VenusFlyTrap( ));
        world.add(new Location(0, 3), new VenusFlyTrap( ));
        world.add(new Location(1, 0), new VenusFlyTrap( ));
        world.add(new Location(1, 2), new VenusFlyTrap( ));
        world.add(new Location(2, 0), new VenusFlyTrap( ));
        world.add(new Location(2, 1), new VenusFlyTrap( ));
        world.add(new Location(2, 2), new VenusFlyTrap( ));
        world.add(new Location(2, 3), new VenusFlyTrap( ));
        world.add(new Location(3, 0), new VenusFlyTrap( ));
        world.add(new Location(4, 0), new VenusFlyTrap( ));
        
        world.add(new Location(0, 8), new Sandstone( Color.RED));
        world.add(new Location(1, 5), new Sandstone( Color.BLUE));
        world.add(new Location(2, 7), new Sandstone( Color.MAGENTA , 100));
        world.add(new Location(3, 4), new Sandstone( Color.GREEN, 1));
        world.add(new Location(6, 5), new Sandstone(Color.ORANGE ));
        world.add(new Location(7, 3), new Sandstone( ));
        world.add(new Location(9, 2), new Sandstone( ));
        world.show();
    }
}