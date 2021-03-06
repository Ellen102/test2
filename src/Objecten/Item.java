package Objecten;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;
import test2.ActionBenodigdheden;

/**
 *
 * @author Ellen
 */
public class Item  extends Spatiebaar{
   private double height;
   private double width;
   private Shape shape;
   private String afbeelding;
   private Image image;
   private int id;
   private String color;

   public Item() {
       super.setFill(Color.GREEN);
    }

   /*
    * voor tabel (mommenteel)
    */
    public String getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(String afbeelding) {
        this.afbeelding = afbeelding;
    }

    public Image getImage() {
        if(image == null){
            image = new Image(afbeelding);
        }
        return image;
    }

    
    
    /*
     * figuur
     */
    @Override
    public Node getNode() {
       return getShape();
   }
    
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        setFill(Color.valueOf(color));
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
    public String toString(){
        return getName() + id;
    }
   
   
   /*
    * id waaraan het item herkend kan worden
    * 
    */
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

       
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    /*
     * spatiebaar
     */
    public boolean hit(double nx, double ny){
        if(getX()== nx
                    &&
               getY() == ny
                    ){
                return true;
            }
        return false;
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(ActionBenodigdheden ab) {
        ab.getLabel().setText("je vond " + getName());
        /*
         * verplaatsen
         */
        ab.getObjectenOpslag().verwijder(this);
        ab.getRugzak().add(this);
    }

    @Override
    public String watIsHet() {
        return "Item";
    }

}
