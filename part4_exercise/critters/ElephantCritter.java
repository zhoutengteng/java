import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.ArrayList;
import java.awt.Color;


public class ElephantCritter extends  Critter{
    private ArrayList<Location> locs;
    private static int WHITE_ROCKHEALTH = -1;
    private static int WHITE_FLOWERHEALTH = +1;
    private static int YELLOW_ROCKHEALTH = -2;
    private static int YELLOW_FLOWERHEALTH = +2;
    private static int RED_ROCKHEALTH = -3;
    private static int RED_FLOWERHEALTH = +3;
    private static int PINK_ROCKERHEALTH = -4;
    private static int PINK_FLOWERHEALTH = +4;

    public ElephantCritter() {
    }

    public ElephantCritter(Color r ) {
        setColor(r);
    }


    public void act()
    {
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    /**
    *获得可以走的位置
    */
    public ArrayList<Actor> getActors()
    {
        locs = new ArrayList<Location>();
        Location currentLocation = getLocation();
        Location leftUpLocation = new Location(currentLocation.getRow()-2, currentLocation.getCol()-2);
        Location leftDownLocation = new Location(currentLocation.getRow()+2,currentLocation.getCol()-2);
        Location rightUpLocation = new Location(currentLocation.getRow() -2, currentLocation.getCol()+2);
        Location rightDownLocation = new Location(currentLocation.getRow()+2,currentLocation.getCol()+2);
        Location midLeftUpLocation = new Location(currentLocation.getRow()-1, currentLocation.getCol()-1);
        Location midLeftDownLocation = new Location(currentLocation.getRow()+1,currentLocation.getCol()-1);
        Location midRightUpLocation = new Location(currentLocation.getRow() -1, currentLocation.getCol()+1);
        Location midRightDownLocation = new Location(currentLocation.getRow()+1,currentLocation.getCol()+1);
        ArrayList<Actor> actors = new ArrayList<Actor>();

        if (getGrid().isValid(leftUpLocation)  && getGrid().get(midLeftUpLocation) == null) {
            if (getGrid().get(leftUpLocation) != null) actors.add(getGrid().get(leftUpLocation));
            locs.add(leftUpLocation);
        }
        if (getGrid().isValid(rightUpLocation)  && getGrid().get(midRightUpLocation) == null) {
            if (getGrid().get(rightUpLocation) != null) actors.add(getGrid().get(rightUpLocation));
            locs.add(rightUpLocation);
        }
        if (getGrid().isValid(leftDownLocation)  && getGrid().get(midLeftDownLocation) == null) {
            if (getGrid().get(leftDownLocation) != null) actors.add(getGrid().get(leftDownLocation));
            locs.add(leftDownLocation);
        }
        if (getGrid().isValid(rightDownLocation)  && getGrid().get(midRightDownLocation) == null) {
            if (getGrid().get(rightDownLocation) != null) actors.add(getGrid().get(rightDownLocation));
            locs.add(rightDownLocation);
        }

        
        return actors;
    }




    public void processActors(ArrayList<Actor> actors)
    {/*
        int n = actors.size();
        if (n == 0)
            return;
        int r = (int) (Math.random() * n);
        adjastColorAndHealth(actors.get(r).getColor(),actors.get(r));
        targetLocx = actors.get(r).getLocation().getRow();
        targetLocy = actors.get(r).getLocation().getCol();
        System.out.println(targetLocx + "   " + targetLocy); 
        System.out.println("ddddddddddddddddddddd");
        //actors.get(r).removeSelfFromGrid();
    */
    }

    public ArrayList<Location> getMoveLocations()
    {
        return locs;
    }




    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();

        int r = (int) (Math.random() * n);
        return locs.get(r);
    }



    public void makeMove(Location loc)
    {
        if (loc == null) {
            removeSelfFromGrid();
        } else {
            moveTo(loc);
            produceFLowerOrRock();
        }
    }

    
    public void produceFLowerOrRock() {
        int r = (int) (Math.random() * 20);
        int row = getGrid().getNumRows();
        int col = getGrid().getNumCols();
        int produc_x = (int) (Math.random()*row);
        int produc_y = (int) (Math.random()*col);
        while (getGrid().get(new Location(produc_x,produc_y)) != null ) {
            produc_x = (int) (Math.random()*row);
            produc_y = (int) (Math.random()*col);
        }
        Location c_l = new Location(produc_x, produc_y);

        if (r == 0) {
           // getGrid().add(c_l, new Rock(Color.WHITE));
                (new Rock(Color.WHITE)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 1) {
           // getGrid().put(c_l, new Rock(Color.YELLOW));
                (new Rock(Color.YELLOW)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 2) {
           // getGrid().put(c_l, new Rock(Color.RED));
                (new Rock(Color.RED)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 3) {
       //     getGrid().put(c_l, new Rock(Color.PINK));
                (new Rock(Color.PINK)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 4) {
         //   getGrid().put(c_l, new Flower(Color.WHITE));
                (new Flower(Color.WHITE)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 5) {
           // getGrid().put(c_l, new Flower(Color.YELLOW));
                (new Flower(Color.YELLOW)).putSelfInGrid(getGrid(),c_l);
            
        }
        if (r == 6) {
          //  getGrid().put(c_l, new Flower(Color.RED));
                (new Flower(Color.YELLOW)).putSelfInGrid(getGrid(),c_l);
        }
        if (r == 7) {
            //getGrid().put(c_l, new Flower(Color.PINK));
                (new Flower(Color.YELLOW)).putSelfInGrid(getGrid(),c_l);
        }
        r = (int) (Math.random()*1000);
       /** if (r  == 100) {
            getGrid().get(new Location(0,0)).removeSelfFromGrid();
            getGrid().put(new Location(0,0),new ElephantCritter(Color.RED));
        }*/
    }
    
}
