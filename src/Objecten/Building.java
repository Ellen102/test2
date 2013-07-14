package Objecten;

import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Building extends Figureke{
   private double height;
   private double width;
   private Shape shape;


   public Building(){
       super.setFill(Color.GRAY);
   }
    
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Rectangle(getX(), getY(), width, height);
            shape.setFill(getFill());
        }
        return shape;
    }
   

    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean hasAction() {
        return false;
    }

    @Override
    public void doAction(Label label, ObjectenOpslag opslag) {
        throw new RuntimeException("geen actie");
    }


}
