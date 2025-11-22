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
 * <p><code>JumperBugColoredRunner2014</code>runs a world that contains 
 * actors, flowers, rocks and jumper bugs. <p />
 * 
 * @author Susan King
 * @version May 24, 2015
 */
public class JumperBugColoredRunner2014
{
    /**
     * Creates a world and populates the world with rocks, flowers
     * and actors as well as JumperBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        JumperBug alice = new JumperBug( );
        alice.setColor(Color.ORANGE);
        JumperBug bob = new JumperBug( );
        bob.setColor(Color.RED);
        JumperBug betty = new JumperBug( );
        betty.setColor(Color.GREEN);
        betty.setDirection(Location.SOUTH);
        JumperBug carl = new JumperBug( );
        carl.setColor(Color.BLUE);
        JumperBug dusty = new JumperBug( );
        dusty.setColor(Color.LIGHT_GRAY);
        JumperBug ed = new JumperBug( );
        ed.setColor(Color.DARK_GRAY);
        JumperBug felicia = new JumperBug( );
        felicia.setColor(Color.PINK);
        felicia.setDirection(Location.EAST);
        JumperBug greg = new JumperBug( );
        greg.setColor(Color.YELLOW);
        JumperBug henry = new JumperBug( );
        henry.setColor(Color.CYAN);
        JumperBug igor = new JumperBug( );
        igor.setColor(Color.MAGENTA);
        JumperBug janet = new JumperBug( );
        janet.setColor(Color.WHITE);
        janet.setDirection(Location.EAST);
        JumperBug karen = new JumperBug( );
        karen.setColor(Color.BLACK);
        
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

        world.add(new Location(3, 9), new Flower(Color.PINK));
        world.add(new Location(4, 1), new Flower(Color.PINK));
        world.add(new Location(4, 4), new Flower(Color.PINK));
        world.add(new Location(4, 5), new Flower(Color.PINK));
        world.add(new Location(4, 6), new Flower(Color.PINK));
        world.add(new Location(4, 7), new Flower(Color.PINK));
        world.add(new Location(5, 0), new Flower(Color.PINK)); 
        world.add(new Location(5, 3), new Flower(Color.PINK));
        world.add(new Location(5, 4), new Flower(Color.PINK)); 
        world.add(new Location(5, 6), new Flower(Color.PINK));
        world.add(new Location(5, 7), new Flower(Color.PINK));
        world.add(new Location(5, 8), new Flower(Color.PINK)); 
        world.add(new Location(6, 5), new Flower(Color.PINK));
        world.add(new Location(6, 6), new Flower(Color.PINK));
        world.add(new Location(6, 7), new Flower(Color.PINK));
        world.add(new Location(6, 9), new Flower(Color.PINK));
        world.add(new Location(7, 5), new Flower(Color.PINK));
        world.add(new Location(7, 6), new Flower(Color.PINK));
        world.add(new Location(7, 7), new Flower(Color.PINK));
        world.add(new Location(7, 9), new Flower(Color.PINK));
        world.add(new Location(8, 6), new Flower(Color.PINK));
        world.add(new Location(8, 7), new Flower(Color.PINK));
        world.add(new Location(8, 8), new Flower(Color.PINK));
        
        world.add(new Location(0, 6), new Rock(Color.GRAY));
        world.add(new Location(0, 7), new Rock(Color.GRAY));
        world.add(new Location(0, 5), new Rock(Color.GRAY));
        world.add(new Location(0, 9), new Rock(Color.GRAY));
        world.add(new Location(1, 3), new Rock(Color.GRAY));
        world.add(new Location(3, 1), new Rock(Color.GRAY));
        world.add(new Location(3, 2), new Rock(Color.GRAY));
        world.add(new Location(3, 3), new Rock(Color.GRAY));
        world.add(new Location(6, 2), new Rock(Color.GRAY));
        world.add(new Location(6, 8), new Rock(Color.GRAY));
        world.add(new Location(9, 6), new Rock(Color.GRAY));
        world.add(new Location(9, 7), new Rock(Color.GRAY));
        world.add(new Location(9, 8), new Rock(Color.GRAY));
        
        world.add(new Location(0, 0), new Actor( ));
        world.add(new Location(0, 1), new Actor( ));
        world.add(new Location(0, 2), new Actor( ));
        world.add(new Location(0, 3), new Actor( ));
        world.add(new Location(1, 0), new Actor( ));
        world.add(new Location(1, 2), new Actor( ));
        world.add(new Location(2, 0), new Actor( ));
        world.add(new Location(2, 1), new Actor( ));
        world.add(new Location(2, 2), new Actor( ));
        world.add(new Location(2, 3), new Actor( ));
        world.add(new Location(3, 0), new Actor( ));
        world.add(new Location(4, 0), new Actor( ));
        world.show();
    }
}