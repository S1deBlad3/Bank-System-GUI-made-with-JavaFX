
/*
@autor Marius Daldorff Pedersen, dalmar-9
 */


package FileActions;


import BankSystems.BankLogic;
import com.example.banksystem_remade.MainApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.File;


//This class opens up the file chooser window and selects a file to load.
public class FileChooser {


    /*
    1. We check the users save directory.
    2. We then set up the window.
    3. We then get the choosen file that the user decides.
    4. If it is null we know the user didn't select anything


     */
    public static void display(String title) {



        File some = new File(System.getProperty("user.dir"));
        String test = some.getPath();
        File folder = new File(test + "/Saves");

        javafx.stage.FileChooser filechoice = new javafx.stage.FileChooser();
        filechoice.setTitle("Load a save");

        filechoice.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Save Data file", "*.dat"));

        if (!folder.canRead()) {
            folder = new File("c:/");
        }
        filechoice.setInitialDirectory(folder);

        File chosenFile = filechoice.showOpenDialog(null);
        String path;
        if (chosenFile != null) {
            path = chosenFile.getPath();
            MainApplication.choosenFile = chosenFile;
        } else {
            path = null;
        }


        Button button = new Button("Hello");
        StackPane layout = new StackPane();

        layout.getChildren().addAll(button);

        Scene scene_1 = new Scene(layout);
        //addCustomer.showAndWait();


    }


}