package dalmar9.Uppgift_5.FileActions;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class AreYouSureScreen {


    public static boolean confirmed;
    public static boolean safeGuard;

    public static void display(String title) {

        Stage options = new Stage();
        options.initModality(Modality.APPLICATION_MODAL);
        options.setTitle(title);
        options.setMaxHeight(150);
        options.setMaxWidth(500);
        options.setMinHeight(150);
        options.setMinWidth(350);
        GridPane layout = new GridPane();
        Button yes_button = new Button("Yes");
        yes_button.setOnAction(e -> {
            confirmed = true;
            System.out.println(confirmed);
            options.close();
        });
        Button no_button = new Button("No");
        no_button.setOnAction(e -> {
            confirmed = false;
            System.out.println(confirmed);
            options.close();
        });


        options.setOnCloseRequest(e -> {
            safeGuard = true;
            System.out.println("Safe guard is on");
            System.out.println(confirmed);


        });


        Label sure = new Label("Are you sure you want to ovveride the save file?");
        GridPane.setConstraints(sure, 1, 0);
        GridPane.setConstraints(yes_button, 0, 1);
        GridPane.setConstraints(no_button, 1, 1);
        layout.getChildren().addAll(sure, yes_button, no_button);


        Scene scene_1 = new Scene(layout);
        options.setScene(scene_1);
        options.showAndWait();


    }


}

