package dalmar9.Uppgift_5.FileActions;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class VideoPlayer {

    public static void display(String title) {

        Stage addCustomer = new Stage();
        addCustomer.initModality(Modality.APPLICATION_MODAL);
        addCustomer.setTitle(title);

        String path = "C:/Users/mariu/Desktop/BankSystem/src/main/Save/pepper.mp4";

        Button button = new Button("Hello");
        StackPane layout = new StackPane();


        //MediaPlayer mediaPlayer = new MediaPlayer(media);
        //MediaView mediaView = new MediaView(mediaPlayer);
        //mediaPlayer.setAutoPlay(true);


        layout.getChildren().addAll(button);

        Scene scene_1 = new Scene(layout);
        addCustomer.showAndWait();


    }


}
