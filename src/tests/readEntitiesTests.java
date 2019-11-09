package tests;

import lab8.ZombieSimulator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import java.util.List;
import lab8.ZombieSimulator.*;
import lab8.Entity;

/**
 * Methods that test the readEntities() method
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class readEntitiesTests {

    /**
     * Test if all values from aNonZombie.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadANonZombie() {
        // Test "aNonZombie"'s value
        List<Entity> values = ZombieSimulator.readEntities("aNonZombie.sim");
        assertEquals(1, values.size());
        assertTrue(values.get(0) instanceof lab8.Nonzombie);
        assertEquals(0.5, values.get(0).getX(), 1e-4);
        assertEquals(0.5, values.get(0).getY(), 1e-4);
    }

    /**
     * Test if all values from aZombie.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadAZombie() {
        // Test "aNonZombie"'s value
        List<Entity> values = ZombieSimulator.readEntities("aZombie.sim");
        assertEquals(1, values.size());
        assertTrue(values.get(0) instanceof lab8.Zombie);
        assertEquals(0.5, values.get(0).getX(), 1e-4);
        assertEquals(0.5, values.get(0).getY(), 1e-4);
    }

    /**
     * Test if all values from zombies.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadZombies() {
        // Test "aNonZombie"'s value
        List<Entity> values = ZombieSimulator.readEntities("zombies.sim");

        assertEquals(5, values.size());
        assertTrue(values.get(0) instanceof lab8.Zombie);
        assertEquals(0.1, values.get(0).getX(), 1e-4);
        assertEquals(0.9, values.get(0).getY(), 1e-4);
        assertTrue(values.get(1) instanceof lab8.Zombie);
        assertEquals(0.2, values.get(1).getX(), 1e-4);
        assertEquals(0.8, values.get(1).getY(), 1e-4);
        assertTrue(values.get(2) instanceof lab8.Zombie);
        assertEquals(0.3, values.get(2).getX(), 1e-4);
        assertEquals(0.7, values.get(2).getY(), 1e-4);
        assertTrue(values.get(3) instanceof lab8.Zombie);
        assertEquals(0.4, values.get(3).getX(), 1e-4);
        assertEquals(0.6, values.get(3).getY(), 1e-4);
        assertTrue(values.get(4) instanceof lab8.Zombie);
        assertEquals(0.5, values.get(4).getX(), 1e-4);
        assertEquals(0.5, values.get(4).getY(), 1e-4);
    }

    /**
     * Test if all values from nonzombies.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadNonzombies() {
        // Test "aNonZombie"'s value
        List<Entity> values = ZombieSimulator.readEntities("nonzombies.sim");

        assertEquals(5, values.size());
        assertTrue(values.get(0) instanceof lab8.Nonzombie);
        assertEquals(0.9, values.get(0).getX(), 1e-4);
        assertEquals(0.1, values.get(0).getY(), 1e-4);
        assertTrue(values.get(1) instanceof lab8.Nonzombie);
        assertEquals(0.8, values.get(1).getX(), 1e-4);
        assertEquals(0.2, values.get(1).getY(), 1e-4);
        assertTrue(values.get(2) instanceof lab8.Nonzombie);
        assertEquals(0.7, values.get(2).getX(), 1e-4);
        assertEquals(0.3, values.get(2).getY(), 1e-4);
        assertTrue(values.get(3) instanceof lab8.Nonzombie);
        assertEquals(0.6, values.get(3).getX(), 1e-4);
        assertEquals(0.4, values.get(3).getY(), 1e-4);
        assertTrue(values.get(4) instanceof lab8.Nonzombie);
        assertEquals(0.5, values.get(4).getX(), 1e-4);
        assertEquals(0.5, values.get(4).getY(), 1e-4);
    }

    /**
     * Test if all select values from zombieWorls.sim are read correctly (assumes file is unchanged!)
     */
    @Test
    public void testReadNZombieWorld() {
        // Test "aNonZombie"'s value
        List<Entity> values = ZombieSimulator.readEntities("zombieWorld.sim");

        assertEquals(3454, values.size());
        // 2 0.07958084190886894 0.5812935597950022
        assertTrue(values.get(0) instanceof lab8.Nonzombie);
        assertEquals(0.07958084190886894, values.get(0).getX(), 1e-4);
        assertEquals(0.5812935597950022, values.get(0).getY(), 1e-4);

        //1 0.6132873446925958 0.25900102588653595
        assertTrue(values.get(3453) instanceof lab8.Zombie);
        assertEquals(0.6132873446925958, values.get(3453).getX(), 1e-4);
        assertEquals(0.25900102588653595, values.get(3453).getY(), 1e-4);
    }
}
