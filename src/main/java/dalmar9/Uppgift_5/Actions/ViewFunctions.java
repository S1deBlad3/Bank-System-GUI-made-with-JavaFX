package dalmar9.Uppgift_5.Actions;

import dalmar9.Uppgift_5.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ViewFunctions {


    /* This function views all the accounts of a user
 1. We create a combobox that shows all the users
 2. We then have a second combobox that displays all the accounts asscossited with that user
 3. We then put the info in to the bankLogic function
 */
    public void viewAccount() {

        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();


        ComboBox users = new ComboBox();
        ComboBox userAccounts = new ComboBox();
        Button showAccounts = new Button("Show accounts");
        Label label = new Label();


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


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = UtilityClass.getIndex();
                int accountIndex = UtilityClass.getAccountIndex();

                label.setText(MainApplication.bank.getAccount(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer()));

                System.out.println("Info created " + MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer() + "Amount : ");


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(label, 1, 1);
        GridPane.setConstraints(userAccounts, 1, 0);
        //GridPane.setConstraints(showAccounts, 1, 2);

        center.getChildren().addAll(users, button, label, userAccounts);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }
       /*
This function views a customer
1. We create a combobox that shows all the users
2. We then have a second combobox that displays all the users
3. We then put the info in to the bankLogic function
 */

    public void viewCustomer() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();

        ComboBox users = new ComboBox<>();
        Label label = new Label();


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


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                label.setText(MainApplication.bank.getCustomer(MainApplication.bank.customers.get(UtilityClass.index).getPersonNummer()).toString());


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(label, 1, 0);

        center.getChildren().addAll(users, button, label);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);

    }

    /*
This function shows all the transactions of an account
1. We create a combobox that shows all the users
2. We then have a second combobox that displays all the accounts asscossited with that user
3. We then put the info in to the bankLogic function
4. We print the information out on a label
*/
    public void viewTransactions() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();


        ComboBox users = new ComboBox();
        ComboBox userAccounts = new ComboBox();
        Button showAccounts = new Button("Show accounts");
        Label label = new Label();


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


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int index = UtilityClass.getIndex();
                int accountIndex = UtilityClass.getAccountIndex();

                label.setText(MainApplication.bank.getTransactions(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer()).toString());


                System.out.println("Info created " + MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer());


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(label, 1, 1);
        GridPane.setConstraints(userAccounts, 1, 0);
        //GridPane.setConstraints(showAccounts, 1, 2);

        center.getChildren().addAll(users, button, label, userAccounts);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


    /*
       This function gives us information on all the customers
       1. Setup the layout
       2. Make it so that when you push the button it puts all the customers in a new list
       3. this list shows up in the combo box
        */
    public void viewCustomers() {


        //Adding customers functionality


        BorderPane layout = new Layout().getBorderLayout();


        GridPane center = (GridPane) layout.getCenter();

        Label info = new Label("BLBALABLABBAABLBALBALBLABLABLABLALBL");
        ChoiceBox panel = new ChoiceBox();


        Button button = new Button("Get Info");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<String> some = new ArrayList();
                some = MainApplication.bank.getAllCustomers();

                for (int i = 0; i < some.size(); i++) {

                    panel.getItems().add(some.get(i));


                }


            }
        });
        GridPane.setConstraints(button, 0, 0);
        GridPane.setConstraints(panel, 0, 1);

        center.getChildren().addAll(button, panel);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


}
