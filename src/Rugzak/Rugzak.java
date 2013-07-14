/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rugzak;

import Objecten.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

/**
 *
 * @author Ellen
 */
public class Rugzak {
    private TableView<Item> tabel;
    private final ObservableList<Item> lijst = FXCollections.observableArrayList();

    public Rugzak() {

    tabel = new TableView<>(lijst);
    
    TableColumn k = new TableColumn("Rugzak");
    
    k.setCellValueFactory( new PropertyValueFactory<Item,Image>("Image"));
    
    ItemImageCellFactory cf = new ItemImageCellFactory();
    k.setCellFactory(cf);
    k.setEditable(false);
    k.setMinWidth(75);
    tabel.getColumns().add(k);

    tabel.setMaxWidth(80);
    tabel.setTranslateX(500);
    tabel.setTranslateY(50);
    
    }
    
    
    public Node getTabel(){
        return tabel;
    }
    
    
    public void add(Item i){
        lijst.add(i);
    }
    
    public void remove(Item i){
        lijst.remove(i);
    }
    
    public Item getSelected(){
        int i = tabel.getSelectionModel().getSelectedIndex();
        return lijst.get(i);
    }
}
