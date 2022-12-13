package com.example.banksystem_remade;

import BankSystems.BankLogic;
import FileActions.AreYouSureScreen;
import FileActions.FileChooser;
import FileActions.LoadFile;
import FileActions.SaveFile;
import Layout.Layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainApplication extends Application {

    public static Stage window;
    private Layout layout;
    public static Scene mainScene;
    private BankLogic bankSystems;
    public static File choosenFile;
    public static File TransactionFile;

    public LoadFile loadFile;




    /*
    Here is the start of the application
    1. We create new instances of the bank
    2. We setup the layout the way we want it
    3. We then make this a scene and load it
    */

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;


        BorderPane layout =new Layout().getBorderLayout();
        bankSystems = new BankLogic();
        mainScene = new Scene(layout, 1000, 500);
        stage.setScene(mainScene);
        stage.show();


        FileChooser.display("File");
        new LoadFile(choosenFile);

        stage.setOnCloseRequest(event -> {
            AreYouSureScreen.display("Save file");
            new SaveFile();

        });




    }

    public static void main(String[] args) {
        launch();
    }

       /*
      This function changes the scene
      @param scene - a scene object
       */

    public static void changeScene(Scene scene){
    window.setScene(scene);
    }


}