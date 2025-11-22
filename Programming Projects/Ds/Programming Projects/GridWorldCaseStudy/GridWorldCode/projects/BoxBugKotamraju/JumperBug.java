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
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

/**
 * A <code>JumperBug</code> jumps over objects <br />
 * A jumper bug that can jump over a rock, 
 * flower, or empty space. It can only land on an empty space or flower.
 * Otherwise it acts like a normal bug when it cannot jump. 
 * The bug never leaves a flower behind.
 * 
 * @author Susan King    Modified documentation to pass CheckStyle
 * @author Keshav Kotamraju
 * 
 * @version August 18, 2015
 */
public class JumperBug extends Bug
{

    /**
     * Constructs a Jumper bug that can jump.
     */
    public JumperBug()
    {
    }
    /**
     * Checks if Jumper bug can jump. It can
     * jump over a rock, flower, or empty space. 
     * It can only land on an empty space or flower. 
     * 
     * @return true if it can jump two spaces in front; otherwise, 
     *         false
     * 
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location nextTwo = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(nextTwo))
            return false;
        Actor neighbor = gr.get(next);
        Actor neighborTwo = gr.get(nextTwo);
        return (neighborTwo == null|| neighborTwo instanceof Flower)&&
               (neighbor == null|| neighbor instanceof Flower||neighbor instanceof Rock);
    }
    /**
     * Lands two spaces forward by jumping and does not leave a flower.
     * 
     */
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
          return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
          moveTo(next.getAdjacentLocation(getDirection()));
        else
          removeSelfFromGrid();
    }
    /**
     * Moves forward one space without placing flower.
     * 
     */
    @Override
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
          return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
          moveTo(next);
        else
          removeSelfFromGrid();
    }
    /**
     * If can jump, jumps and if not acts like a normal bug.
     * 
     */
    @Override
    public void act()
    {
        if (canJump())
            jump(); 
        else
            super.act();
    }
}
