import static org.junit.Assert.*;
import org.junit.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class JumperTest {
    private static Jumper jumper = new Jumper();
    private static Flower flower = new Flower();
    private static Rock rock = new Rock();
    private static ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(11, 11));

    @Before
    public void setUp() {
        // create the jumper
        if (jumper.getGrid() == null) {
            world.add(jumper);
        }
        // create the rock
        if (rock.getGrid() == null) {
            world.add(rock);
        }
        // create the flower
        if (flower.getGrid() == null) {
            world.add(flower);
        }
    }

    @After
    public void setDown() {
    }

    // test one is to ckeck to jumper meet rock and flower
    @Test
    public void testOne() {
        // initial the jumper's location and direction
        jumper.setDirection(90);
        jumper.moveTo(new Location(3, 3));
        flower.moveTo(new Location(3, 4));
        rock.moveTo(new Location(3, 7));
        jumper.act();
        assertEquals(new Location(3, 5), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(3, 5), jumper.getLocation());
    }

    // test two is to ckeck to jumper meet rock and flower
    @Test
    public void testTwo() {
        // initial the jumper's location and direction
        jumper.setDirection(0);
        jumper.moveTo(new Location(3, 3));
        flower.moveTo(new Location(1, 4));
        rock.moveTo(new Location(1, 6));
        jumper.act();
        assertEquals(new Location(1, 3), jumper.getLocation());
        jumper.act();
        jumper.act();
        assertEquals(new Location(1, 3), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(1, 5), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(1, 7), jumper.getLocation());
    }

    // test three is to ckeck to jumper meet rock and flower
    @Test
    public void testThree() {
        // initial the jumper's location and direction
        jumper.setDirection(0);
        jumper.moveTo(new Location(3, 3));
        flower.moveTo(new Location(1, 4));
        rock.moveTo(new Location(1, 6));
        jumper.act();
        assertEquals(new Location(1, 3), jumper.getLocation());
        jumper.act();
        jumper.act();
        assertEquals(new Location(1, 3), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(1, 5), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(1, 7), jumper.getLocation());
    }

    // test four is to check the jumper change its direction
    @Test
    public void testFour() {
        // initial the jumper's location and direction
        jumper.setDirection(180);
        jumper.moveTo(new Location(0, 0));
        flower.moveTo(new Location(6, 0));
        rock.moveTo(new Location(1, 6));
        jumper.act();
        assertEquals(new Location(2, 0), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(4, 0), jumper.getLocation());
        jumper.act();
        jumper.act();
        jumper.act();
        jumper.act();
        jumper.act();
        assertEquals(new Location(2, 0), jumper.getLocation());
    }

    // test five is to check the jumper at a corner
    @Test
    public void testFive() {
        // initial the jumper's location and direction
        jumper.setDirection(90);
        jumper.moveTo(new Location(10, 10));
        flower.moveTo(new Location(6, 0));
        rock.moveTo(new Location(1, 6));
        jumper.act();
        jumper.act();
        jumper.act();
        jumper.act();
        assertEquals(new Location(10, 10), jumper.getLocation());
        jumper.act();
        assertEquals(new Location(10, 8), jumper.getLocation());
        jumper.act();
        jumper.act();
        jumper.act();
        jumper.act();
        assertEquals(new Location(10, 0), jumper.getLocation());
    }

    // check the canJump function
    @Test
    public void testCanJump() {
        Location loc = jumper.getLocation();
        Location next = loc.getAdjacentLocation(jumper.getDirection());
        Location twoNext = next.getAdjacentLocation(jumper.getDirection());
        Grid<Actor> gr = jumper.getGrid();
        if (gr.isValid(twoNext)) {
            Actor neighbor = gr.get(twoNext);
            if (neighbor == null) {
                assertEquals(true, jumper.canMove());
            } else {
                assertEquals(false, jumper.canMove());
            }
        } else {
            assertEquals(false, jumper.canMove());
        }
    }

    // check the testJump function
    @Test
    public void testJump() {
        Location loc = jumper.getLocation();
        Location next = loc.getAdjacentLocation(jumper.getDirection());
        Location twoNext = next.getAdjacentLocation(jumper.getDirection());
        Grid<Actor> gr = jumper.getGrid();
        if (gr.isValid(twoNext)) {
            jumper.move();
            assertEquals(twoNext, jumper.getLocation());
        } else {
            jumper.move();
            assertEquals(null, jumper.getLocation());
        }
    }
}

