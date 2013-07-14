package Wereld;

import Objecten.BoringPerson;
import Objecten.Building;
import Objecten.Item;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Ellen
 */
@XmlRootElement(name="wereld")
public class World {
    
    private List<Building> buildings;
    private List<BoringPerson> persons;
    private List<Item> items;
    
    
    @XmlElementWrapper (name = "buildings")
    @XmlElement (name = "building")
    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    
    
    @XmlElementWrapper (name = "persons")
    @XmlElement (name = "person")
    public List<BoringPerson> getPersons() {
        return persons;
    }

    public void setPersons(List<BoringPerson> persons) {
        this.persons = persons;
    }

    
    
    @XmlElementWrapper (name = "items")
    @XmlElement (name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    
}
