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
 * A <code>DanceBug</code> Dances to  a given size. <br />
 * 
 * @author Susan King    Modified documentation to pass CheckStyle
 * @author Keshav Kotamraju
 * @version September 21, 2022
 */
public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int counter;
    private int[]routine;
    /**
     * Constructs a Dancing bug that dances a pattern of a
     * given side length.
     * 
     * @param length the side length 
     * @param aliceRoutine the array consisting of expected turns
     */
    public DancingBug(int length,int[]aliceRoutine)
    {
        steps = 0;
        sideLength = length;
        counter = 0;
        routine = aliceRoutine;
    }
    /**
     * New turn method for dancing bug
     */
    @Override
    public void turn()
    {
       setDirection((getDirection() + routine[counter] *Location.HALF_RIGHT) % 360);
       counter += 1;
       if (counter >= routine.length)
       {
           counter = 0;
        }
        
    }
    /**
     * Moves to the next location of the dance.
     */
    @Override
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }
    }
}
