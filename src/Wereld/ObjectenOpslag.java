package Wereld;

import Objecten.BoringPerson;
import Objecten.Building;
import Objecten.InterActivePersons.ContainsPerson;
import Objecten.InterActivePersons.Person;
import Objecten.Item;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
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
    private final ObservableList<Person> persons = FXCollections.observableArrayList();
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
        
        /*
         * persons
         */
        for(BoringPerson b : w.getPersons()){
            persons.add(b);
            children.add(b.getShape());
        }
        
        for(ContainsPerson b : w.getContainsPersons()){
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

    public ObservableList<Person> getPersons() {
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
    
    public Person hitBoringPerson(double nx, double ny){
        for (Person p : persons){
            if(p.hit(nx, ny) ){
                return p;
            }
        }
        return null;
    }
    
     public Item onItem(double nx, double ny){
        for (Item s : items){
            if(s.hit(nx, ny)){
                return s;
            }
        }
        return null;
    }

}
