package test2;

import Objecten.Me;
import Objecten.Spatiebaar;
import Rugzak.Rugzak;
import Wereld.ObjectenOpslag;
import java.io.File;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Ellen
 */
public class Test2 extends Application {
    
   private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private static ObjectenOpslag opslag; 
    private static Me me;
    private static Label label;
    private static Rugzak rz;
    private static ActionBenodigdheden ab;
    
    static {
        dX = new HashMap<>();
        dY = new HashMap<>();
        
        dX.put(KeyCode.RIGHT, OFFSET);
        dY.put(KeyCode.RIGHT, 0.0);
        
        dX.put(KeyCode.LEFT, -OFFSET);
        dY.put(KeyCode.LEFT, 0.0);
        
        dX.put(KeyCode.UP, 0.0);
        dY.put(KeyCode.UP, -OFFSET);
        
        dX.put(KeyCode.DOWN, 0.0);
        dY.put(KeyCode.DOWN, OFFSET);
    }
    
    private final Group root = new Group();
    @Override
    public void start(final Stage primaryStage) throws JAXBException {
        primaryStage.setTitle("een");
        
        opslag = new ObjectenOpslag(root, null);
        
        
        label = new Label("Welkom!!!!");
        root.getChildren().add(label);
        
        
        rz = new Rugzak();
        root.getChildren().add(rz);
        
        ab = new ActionBenodigdheden(label, opslag, rz);
        
        Button save = new Button();
        save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("----");
                 FileChooser fileChooser = new FileChooser();

              
              //Show save file dialog
              File file = fileChooser.showSaveDialog(primaryStage);
              
              if(file != null){
                opslag.save(file);
              }
                System.out.println("----");
            }
        });
        save.setText("Save");
        save.setTranslateX(400);
        save.setTranslateY(20);
        root.getChildren().add(save);
        
        me = new Me(5.0, 10.0);
        root.getChildren().add(me.getShape());
        
        root.getStylesheets().add("Opmaak/opmaak.css");
        
        primaryStage.setScene(new Scene(root));
        // waarom???? :(
        //primaryStage.getScene()
                rz.getTabel().setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                
                
                if(dX.get(t.getCode()) != null){
                    double nx = me.getX() + dX.get(t.getCode());
                    double ny = me.getY() + dY.get(t.getCode());
                    
                    if (!opslag.hitBuilding(nx, ny)){
                        me.verplaats(nx, ny);
                    }
                    label.setText(null);
                    
                    
                }else if(t.getCode() == KeyCode.SPACE){
                    Spatiebaar b = opslag.onSpatiebaarDing(me.getX(),me.getY());
                    
                    if(b != null && b.hasAction()){
                        b.doAction(ab);
                    }
                    
                    
                }
                
                
            }
            
        });
        
        
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
