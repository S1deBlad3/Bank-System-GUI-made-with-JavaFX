module com.example.banksystem_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens dalmar9.Uppgift_5 to javafx.fxml;
    exports dalmar9.Uppgift_5;
    exports dalmar9.Uppgift_5.FileActions;
    opens dalmar9.Uppgift_5.FileActions to javafx.fxml;
}