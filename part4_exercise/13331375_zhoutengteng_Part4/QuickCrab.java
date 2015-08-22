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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter
{


    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Location cl = getLocation();
        Location l1 = cl.getAdjacentLocation(getDirection()+Location.LEFT);
        Location r1 = cl.getAdjacentLocation(getDirection()+Location.RIGHT);
        Location l2 = l1.getAdjacentLocation(getDirection()+Location.LEFT);
        Location r2 = r1.getAdjacentLocation(getDirection()+Location.RIGHT);
        int open1 = 0;
        int openl1 = 0;
        int openl2 = 0;
        if (getGrid().isValid(l1) && getGrid().get(l1) == null) {
            openl1 = 1;
            if (getGrid().isValid(l2)&& getGrid().get(l2) == null) {
                locs.add(l2);
                open1 = 1;
            }
        }
        if (getGrid().isValid(r1) && getGrid().get(r1) == null) {
            openl2 = 1;
            if (getGrid().isValid(r2)&& getGrid().get(r2) == null) {
                locs.add(r2);
                open1 = 1;
            }
        }
        if (open1 == 0&& openl1 == 1) locs.add(l1); 
        if (open1 == 0&& openl2 == 1) locs.add(r1);
        return locs;
    }

    
}
