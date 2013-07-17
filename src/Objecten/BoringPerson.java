package Objecten;

import Objecten.InterActivePersons.Person;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import test2.ActionBenodigdheden;

/**
 *
 * @author Ellen
 */
public class BoringPerson extends Person {
    private String zin;

   
   /*
    * todo: array van maken met meerdere zinnen die er om de beurt op kopen
    */
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
    public void doAction(ActionBenodigdheden ab) {
        ab.getLabel().setText(zin);
    }
    
}
