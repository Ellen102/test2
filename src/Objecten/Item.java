
package Objecten;

import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Item  extends Figureke{
   private double height;
   private double width;
   private Shape shape;

    public Item() {
       super.setFill(Color.GREEN);
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
        return true;
    }

    @Override
    public void doAction(Label label, ObjectenOpslag opslag, Rugzak rz) {
        label.setText("je vond " + getName());
        opslag.verwijder(this);
    }
}
