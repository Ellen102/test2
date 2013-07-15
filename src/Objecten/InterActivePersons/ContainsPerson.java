/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objecten.InterActivePersons;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import test2.ActionBenodigdheden;

/**
 *
 * @author Ellen
 */
@XmlRootElement(name="containsperson")
public class ContainsPerson extends InteractivePerson{
    private String hello;
    private String yes;
    private String no;
    private int idItem;
 
    
    @XmlElement (name = "hello")
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
    
    @XmlElement (name = "hello")
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
    public void doAction(ActionBenodigdheden ab) {
        
        
        /*
         * WAAROM KOMT DE TEKST ER NI OP :(
         */
        ab.getLabel().setText(hello);
        
        /*
         * wacht om de tekst te lezen
         */
        
        long t0,t1;
        t0=System.currentTimeMillis();
        do{
            t1=System.currentTimeMillis();
        }
        while (t1-t0<1000);
        
                
        if(ab.getRugzak().remove(idItem)){
            ab.getLabel().setText(yes);
        }else{
            ab.getLabel().setText(no);
        }
        
    }
    
}
