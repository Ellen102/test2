package Objecten.InterActivePersons;

import javafx.scene.paint.Color;
import test2.ActionBenodigdheden;

/**
 *
 * @author Ellen
 */
public abstract class InteractivePerson extends Person{

    public InteractivePerson() {
    super.setFill(Color.BLUE);
    }
    
    
    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public abstract void doAction(ActionBenodigdheden ab) ;
    
}

