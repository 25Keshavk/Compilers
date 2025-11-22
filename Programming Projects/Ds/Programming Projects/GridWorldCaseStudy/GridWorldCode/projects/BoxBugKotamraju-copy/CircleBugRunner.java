/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Susan King    Modified documentation to pass CheckStyle
 * @version August 18, 2015
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

/**
 * This class runs a world that contains Circle bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Susan King 
 * @author Keshav Kotamraju
 * @version September 21, 2022 
 */
public class CircleBugRunner
{
    /**
     * Creates a world and populates the world with CircleBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(12,12));
        
        CircleBug alice = new CircleBug(5);
        
        CircleBug bob = new CircleBug(5);
        world.add(new Location(7, 8), alice);
        world.add(new Location(6, 10), bob);
        world.show();
    }
}