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
public class KingCrab extends CrabCritter{
    public void processActors(ArrayList<Actor> actors) {
        int[] dirs =   { Location.AHEAD + getDirection(), Location.HALF_LEFT + getDirection(), Location.HALF_RIGHT + getDirection()};
        int count = 0;
       // System.out.println("总数" +  actors.size());
        for (Actor a : actors) {
            if (getGrid().get(getLocation().getAdjacentLocation(dirs[count])) == a) {
         //      System.out.println(count);
                break;
            }
            count++;
        }

        for (Actor a : actors) {
            if (getGrid().get(getLocation().getAdjacentLocation(dirs[count])) == a) {
           //    System.out.println(count);
                Location xx = getLocation().getAdjacentLocation(dirs[count]);
                Location newxx = xx.getAdjacentLocation(dirs[count]);
                if (getGrid().isValid(newxx)) {
                    a.moveTo(newxx);
                } else {
                    a.removeSelfFromGrid();
                }
                count++;
            }
        }
    }
}
