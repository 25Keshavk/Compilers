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
 */

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * A <code>ZBug</code> traces a Z of a given size. <br />
 * 
 * @author Susan King    Modified documentation to pass CheckStyle
 * @author Keshav Kotamraju
 * @version September 21, 2022
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int counter;
    /**
     * Constructs a Z bug that traces a Z pattern of a
     * given side length.
     * 
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        counter = 0;
        setDirection(Location.EAST);
    }

    /**
     * Moves to the next location of the Z.
     */
    @Override
    public void act()
    {
        if (steps < sideLength && canMove() && counter <=2)
        {
            move();
            steps++;
        }
        else if(counter == 0)
        {
            setDirection(Location.SOUTHWEST);
            steps = 0;
            counter++;
        }
        else if (counter == 1)
        {
           setDirection(Location.EAST); 
           steps = 0;
           counter++;
        }
    }
}
