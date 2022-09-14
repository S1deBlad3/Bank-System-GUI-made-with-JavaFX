package dalmar9.Uppgift_5.FileActions;

import dalmar9.Uppgift_5.MainApplication;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.File;

public class TransactionChooser {


    public static void display(String title) {

        //Stage addCustomer = new Stage();
        //addCustomer.initModality(Modality.APPLICATION_MODAL);
        //addCustomer.setTitle(title);


        File some = new File(System.getProperty("user.dir"));
        String test = some.getPath();
        File folder = new File(test + "/Transactions");

        javafx.stage.FileChooser filechoice = new javafx.stage.FileChooser();
        filechoice.setTitle("Load a save");

        filechoice.getExtensionFilters().add(new javafx.stage.FileChooser.ExtensionFilter("Transaction File.txt", "*.txt"));

        if (!folder.canRead()) {
            folder = new File("c:/");
        }
        filechoice.setInitialDirectory(folder);

        File chosenFile = filechoice.showOpenDialog(null);
        String path;
        if (chosenFile != null) {
            path = chosenFile.getPath();
            MainApplication.TransactionFile = chosenFile;
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
