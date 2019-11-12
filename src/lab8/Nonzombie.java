package lab8;
import edu.princeton.cs.introcs.StdDraw;
import java.awt.*;
import java.util.List;

public class Nonzombie implements Entity {
    private double x, y, radius;

    public Nonzombie(double x, double y) {
        this.radius = 0.005;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void draw() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(x, y, radius);
    }

    @Override
    public Entity updateEntity(List<Entity> entities) {
        Entity closestZ = EntityUtilities.findClosestZombie(this, entities);

        if(EntityUtilities.areTouching(this, closestZ)){
            if(Math.random()<0.8){
                Entity newZ = new Zombie(this.getX(), this.getY());
                return newZ;
            }
            else {
                if(closestZ.getRadius()<0.02)
                closestZ.setRadius(closestZ.getRadius()*1.2);
                return null;
            }
        }
        if(this.getX()>=0 && this.getX()<=1 && this.getY()>=0 && this.getY()<=1){
            EntityUtilities.moveAwayFrom(this, closestZ.getX(), closestZ.getY(), 0.005);
        }
        else {
            EntityUtilities.moveTowards(this, closestZ.getX(), closestZ.getY(), 0.005);
        }
        return this;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void setRadius(double r) {
        this.radius = r;
    }

    @Override
    public boolean isZombie() {
        return false;
    }
    // TODO: Complete this
}
