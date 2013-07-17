package Objecten;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import test2.ActionBenodigdheden;

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




}
