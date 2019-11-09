package lab8;
import java.util.List;

/**
 * Interface for simulation entities
 *
 * DONE:  Do not change this file in any way!
 */
public interface Entity {

    /**
     * X location of entity
     * @return x location
     */
    double getX();

    /**
     * Y location of entity
     * @return y location
     */
    double getY();

    /**
     * Set the x location to the given value
     * @param x the new location of the x coordinate
     */
    void setX(double x);

    /**
     * Set the y location to the given value
     * @param y the new location of the y coordinate
     */
    void setY(double y);

    /**
     * Draw the entity
     */
    void draw();

    /**
     * Update, replace, or remove this entity
     * @param entities list of all other entities
     * @return the entity to use in the next round of the simulation; null if entity is removed
     */
    Entity updateEntity(List<Entity> entities);

    /**
     * Get the radius of the entity
     * @return the radius
     */
    double getRadius();

    /**
     * Set the radius
     * @param r the new value of the radius
     */
    void setRadius(double r);

    /**
     * Returns true for zombies, false otherwise
     * @return
     */
    boolean isZombie();
}
