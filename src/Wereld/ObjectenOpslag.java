/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wereld;

import Objecten.BoringPerson;
import Objecten.Building;
import Objecten.Item;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ellen
 */
public class ObjectenOpslag {
  
    /*
     * 
     * beste manier om verandering weer te geven??
     */
    private List children;
    
    private final ObservableList<Building> buildings = FXCollections.observableArrayList();
    private final ObservableList<BoringPerson> persons = FXCollections.observableArrayList();
    private final ObservableList<Item> items = FXCollections.observableArrayList();

    public ObjectenOpslag(Group root) {
            this.children=root.getChildren();
            
        World w;
        try {
            JAXBContext jc = JAXBContext.newInstance(World.class);
            w = (World) jc.createUnmarshaller().unmarshal(ObjectenOpslag.class.getResource("Wereld.xml"));
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
        for(Building b : w.getBuildings()){
           buildings.add(b);
           children.add(b.getShape());
        }
        
        for(BoringPerson b : w.getPersons()){
            persons.add(b);
            children.add(b.getShape());
        }
        
        for(Item b : w.getItems()){
            items.add(b);
            children.add(b.getShape());
        }

    }

    public ObservableList<Building> getBuildings() {
        return buildings;
    }

    public ObservableList<BoringPerson> getPersons() {
        return persons;
    }

    public ObservableList<Item> getItems() {
        return items;
    }
    
    public void verwijder(Item item){
        children.remove(item.getShape());
        items.remove(item);
    }
    
    public boolean hitBuilding(double x, double y){
        
        for (Building rect : buildings){
            if (x <= rect.getX()+rect.getWidth() && x >= rect.getX() 
                    && y <= rect.getY()+rect.getHeight() && y >= rect.getY()){
                return true;
            }
        }
        
        return false;
        
    }
    
    public BoringPerson hitBoringPerson(double nx, double ny){
        for (BoringPerson p : persons){
            Circle c = (Circle) p.getShape();
            if(c.getCenterX()+2*c.getRadius()>nx && c.getCenterX()-2*c.getRadius()<nx
                    &&
               c.getCenterY()+2*c.getRadius()>ny && c.getCenterY()-2*c.getRadius()<ny 
                    ){
                return p;
            }
        }
        return null;
    }
    
     public Item onItem(double nx, double ny){
        for (Item s : items){
            if(s.getX()== nx
                    &&
               s.getY() == ny
                    ){
                return s;
            }
        }
        return null;
    }

}
