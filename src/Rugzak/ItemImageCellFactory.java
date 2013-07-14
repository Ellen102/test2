/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Rugzak;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author Ellen
 */
public class ItemImageCellFactory<S, Item> implements Callback<TableColumn<S, Item>, TableCell<S, Item>> {
     
    @Override
    public final TableCell<S, Item> call(TableColumn<S, Item> p) {
        return new ItemImageCell<>();
    }
    
    
    
    public class ItemImageCell<S,Item> extends TableCell<S, Item>{
        
    @Override
    public void updateItem(Item item, boolean empty) {
        super.updateItem(item, empty);
        
        if (empty) {
            setText("");
        } else {
            setText( item.toString());
        }
        setGraphic(null);
    }
    }
    
}
