package dalmar9.Uppgift_5.Actions;

import dalmar9.Uppgift_5.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class EditFunctions {


    public void deposit() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();


        ComboBox users = new ComboBox();
        ComboBox userAccounts = new ComboBox();
        Button showAccounts = new Button("Show accounts");


        for (int i = 0; i < MainApplication.bank.customers.size(); i++) {


            users.getItems().add(MainApplication.bank.customers.get(i).getFörNamn() + " " + MainApplication.bank.customers.get(i).getEfterNamn() + " " + MainApplication.bank.customers.get(i).getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);

            for (int i = 0; i < MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.size(); i++) {
                userAccounts.getItems().remove(MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i));
                userAccounts.getItems().add(MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i).getKontotyp() + " " + MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i).getKontoNummer());
            }


        });

        users.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectionIndex = users.getSelectionModel().getSelectedIndex();
                UtilityClass.setIndex(selectionIndex);


            }
        });


    /*    showAccounts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = getIndex();

                for (int i = 0; i < bank.customers.get(index).accounts.size(); i++){
                   // userAccounts.getItems().add(bank.customers.get(index).accounts.get(i).getKontoNummer() + " " + bank.customers.get(index).accounts.get(i).kontotyp);
                }





            }
        });*/


        userAccounts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int index = userAccounts.getSelectionModel().getSelectedIndex();

                UtilityClass.setAccountIndex(index);

            }
        });


        TextField amount = new TextField();
        amount.setPromptText("amount");


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = UtilityClass.getIndex();
                int accountIndex = UtilityClass.getAccountIndex();

                int money = 0;

                try {
                    money = Integer.parseInt(amount.getText());
                } catch (Exception e) {
                    //TODO: Add a hint to see whts wrong
                }


                MainApplication.bank.deposit(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer(), money);
                System.out.println("Sent money too " + MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer() + "Amount : " + money);


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(amount, 1, 1);
        GridPane.setConstraints(userAccounts, 1, 0);
        //GridPane.setConstraints(showAccounts, 1, 2);

        center.getChildren().addAll(users, button, amount, userAccounts);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


    /*
       This function withdraws money into an account
       1. We create a combobox that shows all the users
       2. We then have a second combobox that displays all the accounts asscossited with that user
       3. We then put the info in to the bankLogic function
        */
    public void withdraw() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();


        ComboBox users = new ComboBox();
        ComboBox userAccounts = new ComboBox();
        Button showAccounts = new Button("Show accounts");


        for (int i = 0; i < MainApplication.bank.customers.size(); i++) {


            users.getItems().add(MainApplication.bank.customers.get(i).getFörNamn() + " " + MainApplication.bank.customers.get(i).getEfterNamn() + " " + MainApplication.bank.customers.get(i).getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);

            for (int i = 0; i < MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.size(); i++) {
                userAccounts.getItems().remove(MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i));
                userAccounts.getItems().add(MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i).getKontotyp() + " " + MainApplication.bank.customers.get(UtilityClass.getIndex()).accounts.get(i).getKontoNummer());
            }


        });

        users.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectionIndex = users.getSelectionModel().getSelectedIndex();
                UtilityClass.setIndex(selectionIndex);


            }
        });


    /*    showAccounts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = getIndex();

                for (int i = 0; i < bank.customers.get(index).accounts.size(); i++){
                   // userAccounts.getItems().add(bank.customers.get(index).accounts.get(i).getKontoNummer() + " " + bank.customers.get(index).accounts.get(i).kontotyp);
                }





            }
        });*/


        userAccounts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int index = userAccounts.getSelectionModel().getSelectedIndex();

                UtilityClass.setAccountIndex(index);

            }
        });


        TextField amount = new TextField();
        amount.setPromptText("amount");


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = UtilityClass.getIndex();
                int accountIndex = UtilityClass.getAccountIndex();

                int money = 0;

                try {
                    money = Integer.parseInt(amount.getText());
                } catch (Exception e) {
                    //TODO: Add a hint to see whts wrong
                }


                MainApplication.bank.withdraw(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer(), money);
                System.out.println("Took money from " + MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer() + "Amount : " + money);


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(amount, 1, 1);
        GridPane.setConstraints(userAccounts, 1, 0);
        //GridPane.setConstraints(showAccounts, 1, 2);

        center.getChildren().addAll(users, button, amount, userAccounts);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


    public void editName() {


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


        TextField name = new TextField();
        name.setPromptText("Name");
        TextField surName = new TextField();
        surName.setPromptText("Surname");


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = UtilityClass.getIndex();
                MainApplication.bank.changeCustomerName(name.getText(), surName.getText(), MainApplication.bank.customers.get(index).getPersonNummer());


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(name, 1, 0);
        GridPane.setConstraints(surName, 2, 0);
        center.getChildren().addAll(users, button, name, surName);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


}
