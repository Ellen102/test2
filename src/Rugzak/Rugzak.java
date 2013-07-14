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

/**
 *
 * @author Ellen
 */
public class Rugzak {
    private TableView<Item> tabel;
    private final ObservableList<Item> lijst = FXCollections.observableArrayList();

    public Rugzak() {

    tabel = new TableView<>(lijst);
    
    
    TableColumn k = new TableColumn();
    k.setCellValueFactory( new PropertyValueFactory<Item,String>("afbeelding"));
    
//    ItemImageCellFactory cf = new ItemImageCellFactory();
//    k.setCellFactory(cf);
    
    tabel.getColumns().add(k);

    
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