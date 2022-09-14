package dalmar9.Uppgift_5.Actions;

import dalmar9.Uppgift_5.MainApplication;
import dalmar9.Uppgift_5.FileActions.SaveFile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class AddFunctions {


     private int index;


    public void addAccount() {

        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();

        ComboBox users = new ComboBox<>();


        for (int i = 0; i < MainApplication.bank.customers.size(); i++) {

            users.getItems().add(MainApplication.bank.customers.get(i).getFörNamn() + " " + MainApplication.bank.customers.get(i).getEfterNamn() + "ID: " + MainApplication.bank.customers.get(i).getPersonNummer());


        }


        users.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int selectedIndex = users.getSelectionModel().getSelectedIndex();
                UtilityClass.setIndex(selectedIndex);


            }
        });


        ToggleGroup group = new ToggleGroup();
        RadioButton savingAccount = new RadioButton("Savings account");
        savingAccount.setToggleGroup(group);
        RadioButton creditAccount = new RadioButton("Credit Account");
        creditAccount.setToggleGroup(group);


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (group.getSelectedToggle().equals(savingAccount)) {

                    int index = UtilityClass.getIndex();
                    MainApplication.bank.createSavingsAccount(MainApplication.bank.customers.get(index).getPersonNummer());
                    System.out.println(MainApplication.bank.customers.get(index).getPersonNummer());

                } else if (group.getSelectedToggle().equals(creditAccount)) {

                    int index = UtilityClass.getIndex();

                    MainApplication.bank.createCreditAccount(MainApplication.bank.customers.get(index).getPersonNummer());
                    System.out.println(MainApplication.bank.customers.get(index).getPersonNummer() + "IT WORKS");


                } else {

                }


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(savingAccount, 1, 0);
        GridPane.setConstraints(creditAccount, 2, 0);
        center.getChildren().addAll(users, button, savingAccount, creditAccount);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


    public void addCustomer() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();

        //Adding customers functionality

        Label nameLabel = new Label("Please type name, surname and Personal ID into the corresponding box");

        GridPane.setConstraints(nameLabel, 2, 0);


        TextField name = new TextField();
        name.setPromptText("Name");
        GridPane.setConstraints(name, 0, 0);
        TextField surname = new TextField();
        surname.setPromptText("Surname");
        GridPane.setConstraints(surname, 0, 1);
        TextField pNo = new TextField();
        pNo.setPromptText("Personal ID");
        GridPane.setConstraints(pNo, 1, 1);
        Button button = new Button("Register");
        button.setOnAction(e -> MainApplication.bank.createCustomer(name.getText(), surname.getText(), pNo.getText()));
        GridPane.setConstraints(button, 1, 2);


        MainApplication.window.setOnCloseRequest(e -> {

            new SaveFile();


        });


        center.getChildren().addAll(nameLabel, name, surname, pNo, button);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


}
