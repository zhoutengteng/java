import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.gui.*;
import java.awt.Color;
import info.gridworld.world.*;
import java.util.ArrayList;

/** Jumper class
 * @para currentLocation 
 *
 */


public  class Jumper extends Actor {
    private Location currentLocation;
    private Location nextLocation;
    private Location nextTwoLocation;
    private int direction;
    private Grid<Actor> grid;
    
    public Jumper() {
        direction = 90;
        setDirection(90);
    }
    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    public boolean canMove() {
        grid = getGrid();
        if (grid == null) {
            return false;
        }
        currentLocation =getLocation();
        direction = getDirection();
        nextLocation = currentLocation.getAdjacentLocation(direction);
        nextTwoLocation = nextLocation.getAdjacentLocation(direction);
        if (!grid.isValid(nextLocation) || !grid.isValid(nextTwoLocation)) {
            return false;
        }
        Actor neighbor = grid.get(nextLocation);
        Actor neighborTwo = grid.get(nextTwoLocation);
  
        if (((neighbor instanceof Flower) || (neighbor instanceof Rock) || (neighbor == null)) && ((neighborTwo == null) || ( neighborTwo instanceof Flower))) {
            return true;
        } else {
            return false;
        }
     }


      public void move() {
          if (grid == null) {
              return;
          }
          if (grid.isValid(nextTwoLocation)&&  !(grid.get(nextTwoLocation) instanceof Jumper)) {
             moveTo(nextTwoLocation);
          } else {
             removeSelfFromGrid();
          }
          if (grid.get(currentLocation) instanceof Flower) {
              grid.get(currentLocation).removeSelfFromGrid();
          }
      }

    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void act() {
        if (canMove()) {
            move();
        } else {
            turn();
            direction = (Location.HALF_RIGHT  + direction + Location.FULL_CIRCLE) % Location.FULL_CIRCLE;             
        }
    }


}

