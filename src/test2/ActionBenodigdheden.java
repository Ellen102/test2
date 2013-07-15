package test2;

import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;

/**
 *
 * @author Ellen
 */
public class ActionBenodigdheden {
    private Label label;
    private ObjectenOpslag opslag;
    private Rugzak rz;

    public ActionBenodigdheden(Label label, ObjectenOpslag opslag, Rugzak rz) {
        this.label = label;
        this.opslag = opslag;
        this.rz = rz;
    }

    public Label getLabel() {
        return label;
    }

    public ObjectenOpslag getObjectenOpslag() {
        return opslag;
    }

    public Rugzak getRugzak() {
        return rz;
    }
    
    
}
