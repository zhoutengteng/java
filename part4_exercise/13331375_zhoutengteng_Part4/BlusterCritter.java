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


import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>Critter</code> is an actor that moves through its world, processing
 * other actors in some way and then moving to a new location. Define your own
 * critters by extending this class and overriding any methods of this class
 * except for <code>act</code>. When you override these methods, be sure to
 * preserve the postconditions. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
    private int  criticalCount;
    private int  currentCount;
    private static final Color DEFAULT_COLOR = Color.PINK;
    private static final double DARKENING_FACTOR = 0.05;

    public BlusterCritter(int c) {
        criticalCount = c;
        currentCount = 0;
        setColor(Color.RED);
    }


    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        // to-do list  get rect  , scan it
        Location currentLocation = getLocation();
        Location leftUpLocation = new Location(currentLocation.getRow()-2, currentLocation.getCol()-2);
        Location leftDownLocation = new Location(currentLocation.getRow()+2,currentLocation.getCol()-2);
        Location rightUpLocation = new Location(currentLocation.getRow() -2, currentLocation.getCol()+2);
        Location rightDownLocation = new Location(currentLocation.getRow()+2,currentLocation.getCol()+2);

        
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (int rowc = leftUpLocation.getRow(); rowc <= leftDownLocation.getRow(); rowc++) {
            for (int colc = leftUpLocation.getCol(); colc <= rightUpLocation.getCol(); colc++) {
                Location  oneLocation = new Location(rowc, colc);
                if (getGrid().isValid(oneLocation) && (currentLocation.getRow() != rowc|| currentLocation.getCol() != colc)) {
                   Actor neighbor = getGrid().get(oneLocation);
                    //System.out.println(oneLocation);
                   if (neighbor != null && neighbor instanceof Critter) {
                       actors.add(neighbor);

                   }
                }
            
            }
        }
        return actors;

    }

    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to "eat" (i.e. remove) selected actors
     * that are not rocks or critters. Override this method in subclasses to
     * process actors in a different way. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
     /*
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
            setColor(new Color(0,0,0));
            return;
        }
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR) * (n + 1.0) / 10);
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR) * (n + 1.0) / 10);
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR)* (n+1.0)  / 10 );
        setColor(new Color(red, green, blue));

    }*/
    public void processActors(ArrayList<Actor> actors)
    {
        //System.out.println(criticalCount + "     " + actors.size());
        if (actors.size() < criticalCount) {
              // setColor(getColor().brighter());
            //    setColor(Color.RED);
              // setColor(new Color(10 * actors.size(),10 * actors.size(), 10 * actors.size() ));
            Color c = getColor();
            int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
            if (red > 200|| green > 200|| blue > 200) {
                setColor(new Color(200,200,200));
                return;
            }
            setColor(new Color(red, green, blue));
        } else {
               // setColor(Color.BLUE);
              //setColor(getColor().darker());
               //setColor(new Color(1 * actors.size(),2 * actors.size(), 3 * actors.size() ));
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            if (red < 10|| green < 10|| blue > 10) {
                setColor(new Color(10,10,10));
                return;
            }
            setColor(new Color(red, green, blue));

        }
    }
}
