/*
@autor Marius Daldorff Pedersen, dalmar-9
 */



package FileActions;

import com.example.banksystem_remade.MainApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;


//This class is a window that shows the transaction file that has been choosen
public class viewTransactionWindow {


    public static Label information;


    /*
    1. We setup the window that we want to display

     */

    public static void Display(String title) {

        Stage addCustomer = new Stage();
        addCustomer.initModality(Modality.APPLICATION_MODAL);
        addCustomer.setTitle(title);


        //Button button = new Button("Hello");


        GridPane layout = new GridPane();

        information = new Label("Information");


        GridPane.setConstraints(information, 0, 0);
        layout.getChildren().addAll(information);


        Scene scene_1 = new Scene(layout);

        showInformation(MainApplication.TransactionFile);
        addCustomer.setScene(scene_1);


        addCustomer.show();


    }


    /*
    1. We read the text from the file
    2. We then add that to a data string
    3. We then show the data in the text component

    @param File - The transaction file that the user wants to see
     */
    public static void showInformation(File transactions) {

        String data = "";
        try {

            Scanner myReader = new Scanner(transactions);
            while (myReader.hasNext()) {
                data += myReader.nextLine();
                information.setText(data);
            }
            myReader.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
