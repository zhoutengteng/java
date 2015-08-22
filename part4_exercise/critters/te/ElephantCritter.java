import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.util.ArrayList;
import java.awt.Color;


public class ElephantCritter extends  Critter{

    private ArrayList<Location> locs;
    private int  targetLocx;
    private int targetLocy;
    private int health;
    private static int WHITE_ROCKHEALTH = -1;
    private static int WHITE_FLOWERHEALTH = +1;
    private static int YELLOW_ROCKHEALTH = -2;
    private static int YELLOW_FLOWERHEALTH = +2;
    private static int RED_ROCKHEALTH = -3;
    private static int RED_FLOWERHEALTH = +3;
    private static int PINK_ROCKERHEALTH = -4;
    private static int PINK_FLOWERHEALTH = +4;

    public ElephantCritter() {
        health = 40;
        targetLocx = 0;
        targetLocy = 0;
    }

    public ElephantCritter(Color r ) {
        health = 40;
        setColor(r);
        targetLocx = 0;
        targetLocy = 0;
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

        int n = locs.size();
        System.out.println(n);
        if (n != 0) {
            int r = (int) (Math.random() * n);
        System.out.println(r);
            if (r < actors.size() && getGrid().get(actors.get(r).getLocation())  != null) adjastColorAndHealth(actors.get(r).getColor(),actors.get(r));
            targetLocx = locs.get(r).getRow();
            targetLocy = locs.get(r).getCol();
            System.out.println(targetLocx + "   " + targetLocy); 
            System.out.println("ddddddddddddddddddddd");
            //actors.get(r).removeSelfFromGrid();
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

    public void adjastColorAndHealth(Color x, Actor c) {
        if (c instanceof Flower) {
            if (x == Color.WHITE) {
                health += WHITE_FLOWERHEALTH;

            } else if (x == Color.RED) {
                health += RED_FLOWERHEALTH;
            } else if (x == Color.YELLOW) {
                 health += YELLOW_FLOWERHEALTH;
            } else if (x == Color.PINK) {
                 health += PINK_FLOWERHEALTH;
            }
        } else {
            if (x == Color.WHITE) {
                health += WHITE_ROCKHEALTH;

            } else if (x == Color.RED) {
                health += RED_ROCKHEALTH;

            } else if (x == Color.YELLOW) {
                 health += YELLOW_ROCKHEALTH;

            } else if (x == Color.PINK) {
                 health += PINK_ROCKERHEALTH;
            }
        }
        int r = getColor().getRed();
        int g = getColor().getGreen();
        int b = getColor().getBlue();
        if (health < 100 && health > 0){
            b =  (b *  101 + 2)/ 99;
            if (b > 250) {
                setColor(new Color(r,g,250));
            } else {
                setColor(new Color(r,g,b));
            }
        } else if (health < 200) {
            r =  (r *  101 + 2)/ 99;
            if (r > 250) {
                setColor(new Color(250,g,b));
            } else {
                setColor(new Color(r,g,b));
            }

        } else if (health < 300) {
            g =  (g *  101 + 2)/ 99;
            if (g > 250) {
                setColor(new Color(r,250,g));
            } else {
                setColor(new Color(r,g,b));
            }
        }
        if (health >= 300) {
            //getGrid().get(new Location(0,0)).removeSelfFromGrid();
            getGrid().put(new Location(0,0), new ElephantCritter(Color.RED));
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
            getGrid().put(c_l, new Rock(Color.WHITE));
        }
        if (r == 1) {
            getGrid().put(c_l, new Rock(Color.YELLOW));
        }
        if (r == 2) {
            getGrid().put(c_l, new Rock(Color.RED));
        }
        if (r == 3) {
            getGrid().put(c_l, new Rock(Color.PINK));
        }
        if (r == 4) {
            getGrid().put(c_l, new Flower(Color.WHITE));
        }
        if (r == 5) {
            getGrid().put(c_l, new Flower(Color.YELLOW));
        }
        if (r == 6) {
            getGrid().put(c_l, new Flower(Color.RED));
        }
        if (r == 7) {
            getGrid().put(c_l, new Flower(Color.PINK));
        }
        r = (int) (Math.random()*1000);
       /** if (r  == 100) {
            getGrid().get(new Location(0,0)).removeSelfFromGrid();
            getGrid().put(new Location(0,0),new ElephantCritter(Color.RED));
        }*/
    }


    public ArrayList<Location> getMoveLocations()
    {
        System.out.println("可选择的点"+ locs.size());
        return locs;
    }




    public Location selectMoveLocation(ArrayList<Location> locs)
    {
        int n = locs.size();
        if (n == 0)
            return getLocation();

       // int r = (int) (Math.random() * n);
       // return locs.get(r);
        System.out.println("point " + targetLocx + "   " + targetLocy); 
        return (new Location(targetLocx,targetLocy));
    }



    public void makeMove(Location loc)
    {
        if (loc == null) {
            //removeSelfFromGrid();
        } else {
            System.out.println("zhou");
            moveTo(loc);
            System.out.println("teng");
            produceFLowerOrRock();
            if (health <= 0) {
                //removeSelfFromGrid();
            }
        }
    }
}
