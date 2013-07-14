package Objecten;

import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class BoringPerson extends Figureke{
    private String zin;
    private double radius;
    private Shape shape;

    public BoringPerson() {
    super.setFill(Color.BLUE);
    }

    
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
   
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Circle(getX(), getY(), radius);
            shape.setFill(getFill());
        }
        return shape;
    }
    public String getZin() {
        return zin;
    }

    public void setZin(String zin) {
        this.zin = zin;
    }
    
    
    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(Label label, ObjectenOpslag opslag, Rugzak rz) {
        label.setText(zin);
    }
    
}
