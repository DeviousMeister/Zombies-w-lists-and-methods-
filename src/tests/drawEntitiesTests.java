package tests;

import lab8.ZombieSimulator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import support.cse131.ArgsProcessor;
import static org.junit.Assert.*;
import lab8.Entity;
import lab8.Zombie;
import lab8.Nonzombie;
import lab8.ZombieSimulator.*;
import java.util.ArrayList;
/**
 * Methods that test the drawEntities() method.
 * These rely on human intervention to confirm the tests.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class drawEntitiesTests {

    /**
     * Draw a zombie and confirm its appearance
     */
    @Test
    public void testDrawAZombie() {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(new Zombie(0.75, 0.5));
        ZombieSimulator.drawEntities(entities);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show a single red dot of radius 0.005 at (0.75, 0.5)? true or false?"));
    }

    /**
     * Draw a large zombie and confirm its appearance
     */
    @Test
    public void testDrawABigZombie() {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        Entity z = new Zombie(0.5, 0.5);
        z.setRadius(0.25);
        entities.add(z);
        ZombieSimulator.drawEntities(entities);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show a single large red dot of radius 0.25 at (0.5, 0.5)? true or false?"));
    }
    
    /**
     * Draw a nonzombie and confirm its appearance
     */
    @Test
    public void testDrawANonzombie() {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(new Nonzombie(0.25, 0.5));
        ZombieSimulator.drawEntities(entities);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show a single black dot of radiut 0.005 at (0.25, 0.5)? true or false?"));
    }

    /**
     * Draw a zombie and a nonzombie confirm their appearance
     */
    @Test
    public void testDrawTwoEntities() {
        ArrayList<Entity> entities = new ArrayList<Entity>();
        entities.add(new Nonzombie(0.25, 0.5));
        entities.add(new Zombie(0.75, 0.5));
        ZombieSimulator.drawEntities(entities);
        ArgsProcessor ap = new ArgsProcessor(new String[] {});
        assertTrue(ap.nextBoolean("Does the screen show both a single black dot at (0.25, 0.5) and a single red dot at (0.75, 0.5)? true or false?"));
    }
}
