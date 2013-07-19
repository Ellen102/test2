package Wereld;

import Objecten.BoringPerson;
import Objecten.Building;
import Objecten.Figureke;
import Objecten.InterActivePersons.ContainsPerson;
import Objecten.Item;
import Objecten.Spatiebaar;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
    private final ObservableList<Spatiebaar> spatiesdingen = FXCollections.observableArrayList();
    
    private World w;

    public ObjectenOpslag(Group root) {
            this.children=root.getChildren();
            
        try {
            JAXBContext jc = JAXBContext.newInstance(World.class);
            w = (World) jc.createUnmarshaller().unmarshal(ObjectenOpslag.class.getResource("Wereld.xml"));
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
        for(Building b : w.getBuildings()){
           buildings.add(b);
           children.add(b.getNode());
        }
        
        /*
         * persons
         */
        for(BoringPerson b : w.getPersons()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        
        for(ContainsPerson b : w.getContainsPersons()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        
        for(Item b : w.getItems()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        

    }

    public void verwijder(Item item){
        children.remove(item.getNode());
        spatiesdingen.remove(item);
        w.remove((Figureke) item);
        /*
         * to do: ook verwijderen uit world zodat terug naar schrijven 
         * wrs een verplichte methode maken met string en een hashmap om te weten welke methode op te roepen
         */
    }
    
    public boolean hitBuilding(double x, double y){
        for (Building b : buildings){
            if (b.erTegen(x, y)){
                return true;
            }
        }
        return false;
    }
    
    public Spatiebaar onSpatiebaarDing(double nx, double ny){
        for (Spatiebaar s : spatiesdingen){
            if(s.hit(nx, ny)){
                return s;
            }
        }
        return null;
    }
    
    public void save(){
        try {
            //schrijven
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(World.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(w, System.out);
            // Write to File
            //m.marshal(ls, new File("./schrijf.xml"));
        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    }

}
