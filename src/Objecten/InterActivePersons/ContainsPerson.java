/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objecten.InterActivePersons;

import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import javafx.scene.control.Label;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Ellen
 */
public class ContainsPerson extends InteractivePerson{
    private String hello;
    private String yes;
    private String no;
    private int idItem;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @XmlElement (name = "iditem")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    
    @Override
    public void doAction(Label label, ObjectenOpslag opslag, Rugzak rz) {
        label.setText(hello);
        try {
            System.out.println("sleep");
            Thread.sleep(100);
            System.out.println("wakker");
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println(idItem);
        
        if(rz.remove(idItem)){
            label.setText(yes);
        }else{
            label.setText(no);
        }
        
    }
    
}
