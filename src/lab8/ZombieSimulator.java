package lab8;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;
import java.util.LinkedList;
import java.util.List;

public class ZombieSimulator {
    public static final int ZOMBIE = 1;
    public static final int NONZOMBIE = 2;

    // TODO: Complete JavaDoc
    public static List<Entity> readEntities(String fileName) {
        In inputFile = new In(fileName);
        int n = inputFile.readInt();
        LinkedList<Entity> list = new LinkedList<Entity>();  // This line provided! / DONE
        // TODO: Complete implementation



        return list;
    }

    /**
     * Draw all the entities in the given list
     * @param entities
     */
    public static void drawEntities(List<Entity> entities) {
        // DONE
        StdDraw.clear();
        for (Entity e: entities) {
            e.draw();
        }
        StdDraw.show();
    }

    // TODO: JavaDoc
    // TODO: Complete this function. It should return true if there is at least one remaining non-zombie and false otherwise
    public static boolean nonzombiesRemain(List<Entity> entities) {
        // TODO:
        //      (Suggestion: Use the for-each style of loop shown in drawEntities()!)


        return false;
    }

    /**
     * Update all the entities
     * @param entities the list of entities to update
     * @return a new list of all the entities that should be used for the next round of the simulation
     */
    public static List<Entity> updateEntities(List<Entity> entities) {
        List<Entity> newList = new LinkedList<Entity>(); // This line done / provided
        for(Entity e: entities) {                        // This line done / provided

            // TODO: Update the entity e. Add the updated value to the new list as needed



        }
        return newList;  // This line done / provided
    }

    // TODO: Be sure you can explain how main() works (you may want to review it carefully and add comments!!!)
    public static void main(String[] args) {
        // DONE
        StdDraw.enableDoubleBuffering();
        ArgsProcessor ap = new ArgsProcessor(args);
        String fileName = ap.nextString("Which starting file: ");

        // Read Entities, Draw their initial locations, wait 1 second
        List<Entity> entities = readEntities(fileName);
        drawEntities(entities);
        StdDraw.pause(1000);

        // Run the simulation while there are nonzombies: Update the entities being used and redraw them!
        while (nonzombiesRemain(entities)) {
            entities = updateEntities(entities);
            drawEntities(entities);
        }
    }
}
