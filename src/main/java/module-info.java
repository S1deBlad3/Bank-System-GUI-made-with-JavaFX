module com.example.banksystem_remade {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.banksystem_remade to javafx.fxml;
    exports com.example.banksystem_remade;
}