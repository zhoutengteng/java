import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;
import java.awt.Color;


final public class JumperRunner
{
    private JumperRunner() {
    }
    /**
     * 入口
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        Bug bb = new Bug();
        Rock cc = new Rock();
        alice.setColor(Color.ORANGE);
        world.add(new Location(4, 4), alice);
        world.add(new Location(5, 5), bb);
        world.add(new Location(6, 6), cc);         
        world.show();
    }
}
