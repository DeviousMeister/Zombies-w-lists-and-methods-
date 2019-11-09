package lab8;
import java.util.List;

public class EntityUtilities {
    /**
     * Find the distance between two entities
     * @param e1 an Entity
     * @param e2 another Entity
     * @return the Euclidean distance between e1 and e2
     */
    public static double distanceBetween(Entity e1, Entity e2) {
        if(e1==null || e2==null)
            return Double.MAX_VALUE;
        // TODO: Complete / Fix this!
        return 0;
    }

    /**
     * Are two entities touching?
     * @param e1 an Entity
     * @param e2 another Entity
     * @return true if the two entities are considered to be "touching", false otherwise
     */
    public static boolean areTouching(Entity e1, Entity e2) {
        if(e1==null || e2==null)
            return false;
        // TODO: Complete / Fix this! (hint: Use method the above)
        return false;
    }

    /**
     * Return the closest entity (or null if no other entities)
     * @param e the entity for which a "closest" needs to be found
     * @param entities a collection of entities to search
     * @return the entity that is closest or null if no other entities
     */
    public static Entity findClosest(Entity e, List<Entity> entities) {
        return findClosest(e, entities, true, true);
    }

    /**
     * Return the closest zombie (or null if no other zombies)
     * @param e the entity for which a "closest" needs to be found
     * @param entities a collection of entities to search
     * @return the entity that is closest or null if no other zombies
     */
    public static Entity findClosestZombie(Entity e, List<Entity> entities) {
        return findClosest(e, entities, true, false);
    }

    /**
     * Return the closest Non=zombie (or null if no other Non-zombies)
     * @param e the entity for which a "closest" needs to be found
     * @param entities a collection of entities to search
     * @return the entity that is closest or null if no other non-zombies
     */
    public static Entity findClosestNonzombie(Entity e, List<Entity> entities) {
        return findClosest(e, entities, false, true);
    }

    /**
     * Move the given entity towards (x,y) by the given amount
     * @param e entity to move
     * @param x x coordinate to move toward
     * @param y y coordinate to move toward
     * @param amount total distance to move
     */
    public static void moveTowards(Entity e, double x, double y, double amount) {
        double ang = Math.atan2(y-e.getY(), x-e.getX());
        e.setX(e.getX() + amount*Math.cos(ang));
        e.setY(e.getY() + amount*Math.sin(ang));
    }

    /**
     * Move the given entity away from (x,y) by the given amount
     * @param e entity to move
     * @param x x coordinate to move away from
     * @param y y coordinate to move away from
     * @param amount total distance to move
     */
    public static void moveAwayFrom(Entity e, double x, double y, double amount) {
        double ang = Math.atan2(y-e.getY(), x-e.getX());
        e.setX(e.getX() - amount*Math.cos(ang));
        e.setY(e.getY() - amount*Math.sin(ang));
    }

    /*
     * Find the closest entity of the given types (helper function for other types of finds)
     * @param e the entity for which a "closest" needs to be found
     * @param entities a collection of entities to search
     * @param canBeZombie true if zombies should be considered
     * @param canBeNonZombie true if non-zombies should be considered
     * @return the "closest" matching entity or null if none found
     */
    private static Entity findClosest(Entity e, List<Entity> entities, boolean canBeZombie, boolean canBeNonZombie) {
        if(e==null)
            return null;
        Entity closest = null;
        double closestDist = Double.MAX_VALUE;
        for(Entity other: entities) {
            if(other!=null) {
                double dist = distanceBetween(e, other);
                // If comparing it to another entity and the distance is better, update
                boolean typeOK = (canBeZombie && other.isZombie()==true) || (canBeNonZombie && other.isZombie()==false);
                if(e!=other && typeOK && dist<closestDist) {
                    closest = other;
                    closestDist = dist;
                }
            }
        }
        return closest;
    }
}
