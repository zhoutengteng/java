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
 */


import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * A <code>Critter</code> is an actor that moves through its world, processing
 * other actors in some way and then moving to a new location. Define your own
 * critters by extending this class and overriding any methods of this class
 * except for <code>act</code>. When you override these methods, be sure to
 * preserve the postconditions. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class RockHound extends Critter
{
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Critter))
                a.removeSelfFromGrid();
        }
    }

}
