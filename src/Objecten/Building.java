package Objecten;

import javafx.scene.Node;
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
    public Node getNode() {
        return getShape();
    }

    public boolean erTegen(double nx, double ny){
         if (nx <= getX()+getWidth() && nx >= getX() 
                    && ny <= getY()+getHeight() && ny >= getY()){
                return true;
            }
         return false;
    }

    @Override
    public String watIsHet() {
        return "building";
    }


}
