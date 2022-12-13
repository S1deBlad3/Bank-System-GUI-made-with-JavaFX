/*
@autor Marius Daldorff Pedersen, dalmar-9
 */



package Actions;

import BankSystems.Account;
import BankSystems.BankLogic;
import BankSystems.Customer;
import BankSystems.CustomersList;
import Layout.Layout;
import Utility.UtilityClass;
import com.example.banksystem_remade.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


//This class handles all edit functions
public class EditFunctions {


    private BankLogic logic = new BankLogic();
    private CustomersList customersList = new CustomersList();


/*
1. We setup the layout as we want it
2. We create the components we want
3. We get the users click input depending on what they have pressed
4. We run the correct method in bankSystem folder.

 */

    public void deposit() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();


        ComboBox users = new ComboBox();
        ComboBox userAccounts = new ComboBox();
        Button showAccounts = new Button("Show accounts");


        for (int i = 0; i < customersList.size(); i++) {

            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + " " + currentCustomer.getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);

            Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
            ArrayList<Account> accountList = currentCustomer.getAccountList();


            for (int i = 0; i < accountList.size(); i++) {

                Account currentAccount = accountList.get(i);

                userAccounts.getItems().remove(currentAccount);
                userAccounts.getItems().add(currentAccount.getKontotyp() + " " + currentAccount.getKontoNummer());
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

                Customer currentCustomer = customersList.customerArrayList.get(index);
                ArrayList<Account> accounts = currentCustomer.getAccountList();
                Account currentAccount = accounts.get(accountIndex);


                int money = 0;

                try {
                    money = Integer.parseInt(amount.getText());
                } catch (Exception e) {
                    //TODO: Add a hint to see whts wrong
                }


                logic.deposit(currentCustomer.getPersonNummer(), currentAccount.getKontoNummer(), money);
                System.out.println("Sent money too " +currentAccount.getKontoNummer() + "Amount : " + money);

                amount.clear();



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


        for (int i = 0; i < customersList.size(); i++) {

            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + " " + currentCustomer.getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);

            Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
            ArrayList<Account> accountList = currentCustomer.getAccountList();


            for (int i = 0; i < accountList.size(); i++) {

                Account currentAccount = accountList.get(i);

                userAccounts.getItems().remove(currentAccount);
                userAccounts.getItems().add(currentAccount.getKontotyp() + " " + currentAccount.getKontoNummer());
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

                Customer currentCustomer = customersList.customerArrayList.get(index);
                ArrayList<Account> accountList = currentCustomer.getAccountList();
                Account currentAccount = accountList.get(accountIndex);


                int money = 0;

                try {
                    money = Integer.parseInt(amount.getText());
                } catch (Exception e) {
                    //TODO: Add a hint to see whts wrong
                }


                logic.withdraw(currentCustomer.getPersonNummer(), currentAccount.getKontoNummer(), money);
                System.out.println("Took money from " + currentAccount.getKontoNummer() + "Amount : " + money);


                amount.clear();

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
    1. We setup the layout as we want it
    2. We create the components we want
    3. We get the users click input depending on what they have pressed
    4. We run the correct method in bankSystem folder.

     */
    public void editName() {


        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();

        ComboBox users = new ComboBox<>();


        for (int i = 0; i < customersList.size(); i++) {

            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + "ID: " + currentCustomer.getPersonNummer());


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
                Customer currentCustomer = customersList.customerArrayList.get(index);
                logic.changeCustomerName(name.getText(), surName.getText(), currentCustomer.getPersonNummer());


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
