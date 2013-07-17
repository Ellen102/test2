/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objecten.InterActivePersons;

import Objecten.Figureke;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public abstract class Person extends Figureke{
    private double radius;
    private Shape shape;

    public Person() {
    super.setFill(Color.BLUE);
    }

   
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Circle(getX(), getY(), getRadius());
            shape.setFill(getFill());
        }
        return shape;
    }
   
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
}