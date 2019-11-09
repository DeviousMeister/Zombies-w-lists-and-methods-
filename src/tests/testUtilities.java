package tests;

import lab8.EntityUtilities;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import lab8.Nonzombie;
import lab8.Entity;
import lab8.Zombie;
import lab8.EntityUtilities.*;

import java.util.List;

/**
 * Methods that test the utility methods
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testUtilities {
    final double xs[] = {1.2, 1.1, 1.00, 2.00, 4.00, 4.00};
    final double ys[] = {3.4, 3.8, 1.00, 1.00, 4.00, 7.00};
    final double rs[] = {0.2, 0.1, 0.51, 1.00, 2.01, 0.98};
    private class Ent implements Entity {
        private final int i;
        Ent(int i) { this.i = i; }
        @Override public double getX() { return xs[i]; }
        @Override public double getY() { return ys[i]; }
        @Override public void setX(double x) { }
        @Override public void setY(double y) { }
        @Override public void draw() { }
        @Override public Entity updateEntity(List<Entity> entities) { return null; }
        @Override public double getRadius() { return rs[i]; }
        @Override public void setRadius(double r) { }
        @Override public boolean isZombie() { return false; }
    }

    final Entity e1 = new Ent(0);
    final Entity e2 = new Ent(1);
    final Entity e3 = new Ent(2 );
    final Entity e4 = new Ent(3 );
    final Entity e5 = new Ent(4 );
    final Entity e6 = new Ent(5 );

    /**
     * Check distances between entities
     */
    @Test
    public void testDistanceBetween() {
        assertEquals(0, EntityUtilities.distanceBetween(e1, e1) , 1e-4);
        assertEquals(0, EntityUtilities.distanceBetween(e2, e2) , 1e-4);

        assertEquals(0.41231056256, EntityUtilities.distanceBetween(e1, e2) , 1e-4);
        assertEquals(0.41231056256, EntityUtilities.distanceBetween(e2, e1) , 1e-4);
        assertEquals(2.40831891576, EntityUtilities.distanceBetween(e1, e3) , 1e-4);
        assertEquals(2.40831891576, EntityUtilities.distanceBetween(e3, e1) , 1e-4);

        assertEquals(1.0, EntityUtilities.distanceBetween(e3, e4) , 1e-4);
        assertEquals(4.24264068712, EntityUtilities.distanceBetween(e3, e5) , 1e-4);
    }
    /**
     * Check if the entites are touching
     */
    @Test
    public void testAreTouching() {
        assertFalse(EntityUtilities.areTouching(e1, e2));
        assertTrue(EntityUtilities.areTouching(e3, e4));
        assertFalse(EntityUtilities.areTouching(e3, e5));
        assertFalse(EntityUtilities.areTouching(e3, e5));
        assertFalse(EntityUtilities.areTouching(e4, e5));
    }


}
