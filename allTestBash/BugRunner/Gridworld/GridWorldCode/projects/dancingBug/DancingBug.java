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

/**
 * A <code>BoxBug</code> traces out a square "box" of a given size. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */

public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int[] directionArray;
    private int count;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public DancingBug(int[] inputArray)
    {
        steps = 1;
        count = 0;
        sideLength = 1;
        setDirection(90);
        int num = inputArray.length;
        directionArray = new int[num];
        System.arraycopy(inputArray,0,directionArray,0,num);
        count++;
    }
    /**
    *  根据整数进行旋转n次
    */

    public void directionByNumOfTurn(int x) {
        for (int i = 0; i < x; i++) {
            turn();
        }
    }

    /**
     * Moves to the next location of the square.
     * 移动一步调转方向
     */
    public void act()
    {
     /** 不能运动后就停止   
      *  if (!canMove()) {
      *      return;
      *  }
      */
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            directionByNumOfTurn(directionArray[count]);
            count++;
            count = count % directionArray.length;

            steps = 0;
        }
    }
}
