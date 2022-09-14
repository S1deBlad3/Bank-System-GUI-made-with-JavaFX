package dalmar9.Uppgift_5.FileActions;

import dalmar9.Uppgift_5.MainApplication;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class viewTransactionWindow {


    public static Label information;


    public static void Display(String title) {

        Stage addCustomer = new Stage();
        addCustomer.initModality(Modality.APPLICATION_MODAL);
        addCustomer.setTitle(title);


        //Button button = new Button("Hello");


        GridPane layout = new GridPane();

        information = new Label("MY DICK IS HARD");


        GridPane.setConstraints(information, 0, 0);
        layout.getChildren().addAll(information);


        Scene scene_1 = new Scene(layout);

        showInformation(MainApplication.TransactionFile);
        addCustomer.setScene(scene_1);


        addCustomer.show();


    }


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
