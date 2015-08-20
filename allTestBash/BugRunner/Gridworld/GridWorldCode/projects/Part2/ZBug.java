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

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int degree[];
    private int count;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     * @param length the side length
     * @param length the side length
     * @param length the side length
     * @param length the side length
     * @param length the side length
     */
    public ZBug(int length)
    {
        degree = new int[2];
        degree[0] = 225;
        degree[1] = 90;
        steps = 0;
        count = 0;
        sideLength = length;
        setDirection(90);
    }

    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if (!canMove()) {
            return;

        }
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            if (count == 2) {
                return;
            }
            setDirection(degree[count]);
            count++;
            steps = 0;
        }
    }
}
