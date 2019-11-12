package lab8;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.List;


public class Zombie implements Entity {
    private double x, y, radius;

    public Zombie(double x, double y) {
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
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, radius);
    }

    @Override
    public Entity updateEntity(List<Entity> entities) {
        Entity closestNon = EntityUtilities.findClosestNonzombie(this, entities);
        if(this.getX()>=0 && this.getX()<=1 && this.getY()>=0 && this.getY()<=1){
            EntityUtilities.moveTowards(this, closestNon.getX(), closestNon.getY(), 0.01);
        }
        else{
            EntityUtilities.moveTowards(this, closestNon.getX(), closestNon.getY(), 0.01);
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
        return true;
    }

    // TODO: Complete this!

}
