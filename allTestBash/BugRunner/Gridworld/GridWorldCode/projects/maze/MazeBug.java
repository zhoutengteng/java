import info.gridworld.maze.*;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Stack;


import java.util.*;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
    public int directionCount[];
	public Stack<Location> path;
	boolean allTrue;
	boolean beginTrue;
	boolean willMove;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
    public Map<Location, Boolean> isComed; 
	boolean hasShown = false;//final message has been shown
	

	

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		beginTrue = true;
		setColor(Color.RED);
		allTrue = true;
		willMove = true;
		path = new Stack<Location>();
		isComed = new HashMap<Location, Boolean>();
		isComed.put(last, false);
		ArrayList<Location> arrList = new ArrayList<Location>();
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		if (beginTrue) {
			next = getLocation();
			crossLocation.push(getValid(next));
			beginTrue = false;
			isComed.put(next, true);
			return;
		}
		
        //如果栈为空　必然到了就设置hasShown = true 否则就设置为false 
        if (crossLocation.isEmpty()) {
            isEnd = true;
            System.out.println("还有多少组数组" + crossLocation.size());
            return;
        }
        //得到当前栈的第一个数组元素
        if (crossLocation.isEmpty()) {
        	return;
        }
           ArrayList<Location> arrlist = crossLocation.pop();
		// 只检测null和花能走
        allTrue = true;
        //如果第一个数组元素的为全部走过就返回，肯定不用执行，否则取得数组的第一个false元素，判断是否走过
        for (Location x : arrlist) {
            if (isComed.get(x) == false) {
                isComed.put(x,true);
                if (willMove) last = next;
                next = x;
                allTrue = false;
                break;
            }
        }
        crossLocation.push(arrlist);
		willMove = canMove();
        // 无路可走　pop
        if (allTrue && !crossLocation.isEmpty()&& !path.isEmpty()) {
        	crossLocation.pop();
   	        next = path.pop();
        	System.out.println(" back the grid  " + next);
        	move();
        	return;
        } else if (willMove) {

        	crossLocation.push(getValid(next));
        }
        

		System.out.println("可以走  " + willMove);

		
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
				
			}
		} else if (willMove) {
			move();
            path.push(last);
            this.setDirection(last.getDirectionToward(next));
	        System.out.println("go the grid in " + next  + "    sava the last grid "  + last);
			//increase step count when move 
			//System.out.println("ddddd");
			stepCount++;
		} 
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		Location left = new Location(next.getRow(), next.getCol() - 1);
		Location right = new Location(next.getRow(), next.getCol() + 1);
		Location up = new Location(next.getRow() - 1, next.getCol());
		Location down = new Location(next.getRow() + 1, next.getCol());
		ArrayList<Location> valid = new ArrayList<Location>();
		if (gr.isValid(left)){
			valid.add(left);
			if (!isComed.containsKey(left)) isComed.put(left, false);
		}
		if (gr.isValid(right)) {
			valid.add(right);
			if (!isComed.containsKey(right))isComed.put(right, false);
		}
		if (gr.isValid(up)) {
			valid.add(up);
			if (!isComed.containsKey(up))isComed.put(up, false);
		}
		if (gr.isValid(down)) {
			valid.add(down);
			if (!isComed.containsKey(down))isComed.put(down, false);
		}
		System.out.println("这添加的valid的点有几个　" + valid.size());
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
       // System.out.println("                                                                     next " + next);
        if ( getGrid().get(next) instanceof Rock && getGrid().get(next).getColor().getRed() == (Color.red).getRed() ) {
        	//System.out.println("ddddddddddddddddddddddddddddddd");
        	isEnd = true;
        	hasShown = false;
        	return false;
        }
        
        if (!gr.isValid(next))
            return false;

        Actor neighbor = gr.get(next);

        return (neighbor == null || neighbor instanceof Flower);
	}
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		System.out.println(next);
		if (gr.isValid(next)) {
			if (path.size() != 0) {
				Location a = path.pop();
			     setDirection(next.getDirectionToward(a));
			     path.push(a);
			}
			moveTo(next);
		} else {
			removeSelfFromGrid();
		}
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
