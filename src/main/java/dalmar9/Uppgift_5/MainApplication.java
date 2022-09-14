package dalmar9.Uppgift_5;

import dalmar9.Uppgift_5.Actions.Layout;
import dalmar9.Uppgift_5.BankSystem.BankLogic;
import dalmar9.Uppgift_5.FileActions.FileChooser;
import dalmar9.Uppgift_5.FileActions.LoadFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;


public class MainApplication extends Application {


    //Public access variables
    public static Stage window;
    public Scene mainScene;
    public static BankLogic bank;

    public static File choosenFile;
    public static File TransactionFile;

    //public SaveFile saveFile;
    public LoadFile loadFile;


    /*
 Here is the start of the application
 1. We create new instances of the bank
 2. We setup the layout the way we want it
 3. We then make this a scene and load it
  */
    @Override
    public void start(Stage stage) throws IOException {

        //Create a basic start
        stage.setTitle("Bank System");
        window = stage;


        bank = new BankLogic();

        BorderPane layout = new Layout().getBorderLayout();


        mainScene = new Scene(layout, 1000, 500);
        stage.setScene(mainScene);
        stage.show();

        FileChooser.display("File");
        new LoadFile(choosenFile);


    }

    public static void main(String[] args) {
        launch();
    }

    /*
      This function changes the scene
      @param scene - a scene object
       */
    public static void changeScene(Scene scene) {

        window.setScene(scene);


    }

}