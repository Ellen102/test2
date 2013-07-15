/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objecten.InterActivePersons;

import Objecten.BoringPerson;
import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import test2.ActionBenodigdheden;

/**
 *
 * @author Ellen
 */
public abstract class InteractivePerson extends BoringPerson{
    private Shape shape;

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

