package dalmar9.Uppgift_5.Actions;

import dalmar9.Uppgift_5.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class DeleteFunctions {


    /* This function deletes an account of a selected customer
 1. We create a combobox that shows all the users
 2. We then have a second combobox that displays all the accounts asscossited with that user
 3. We then put the info in to the bankLogic function
 */
    public void deleteAccount() {


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

                try {
                    label.setText(MainApplication.bank.closeAccount(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer()));
                    System.out.println("Account deleted " + MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer() + "Amount : ");
                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("No more accounts on this customer");
                }


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        //GridPane.setConstraints(amount, 1, 1);
        GridPane.setConstraints(userAccounts, 1, 0);
        GridPane.setConstraints(label, 1, 1);

        center.getChildren().addAll(users, button, userAccounts, label);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }

    /*
This function deletes a customer
1. We create a combobox that shows all the users
2. We then have a second combobox that displays all the users
3. We then put the info in to the bankLogic function
*/
    public void deleteCustomer() {


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


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                int index = UtilityClass.getIndex();


                try {

                    MainApplication.bank.deleteCustomer(MainApplication.bank.customers.get(index).getPersonNummer());
                    System.out.println(MainApplication.bank.customers.get(index).getPersonNummer() + "IT WORKS");


                } catch (IndexOutOfBoundsException exception) {
                    System.out.println("No more customers");
                }


            }
        });
        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);

        center.getChildren().addAll(users, button);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


    }


}
