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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ViewFunctions {


    private BankLogic logic = new BankLogic();
    private CustomersList customersList =  new CustomersList();





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


        for (int i = 0; i < customersList.size(); i++) {

            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + "ID " + currentCustomer.getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);

            Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
            ArrayList<Account> accountList = currentCustomer.getAccountList();

            for (int i = 0; i < accountList.size(); i++) {





                userAccounts.getItems().remove(accountList.get(i));
                userAccounts.getItems().add(accountList.get(i).getKontotyp() + " " + accountList.get(i).getKontoNummer());
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



                Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
                ArrayList<Account> accountList = currentCustomer.getAccountList();
                Account specificAccount = accountList.get(accountIndex);

                //label.setText(MainApplication.bank.getAccount(MainApplication.bank.customers.get(index).getPersonNummer(), MainApplication.bank.customers.get(index).accounts.get(accountIndex).getKontoNummer()));
                label.setText(logic.getAccount(currentCustomer.getPersonNummer(), specificAccount.getKontoNummer()));

                System.out.println("Info created " + specificAccount.getKontoNummer() + "Amount : ");


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


        Button button = new Button("Submit");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.index);

                label.setText(logic.getCustomer(currentCustomer.getPersonNummer()).toString());


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


        for (int i = 0; i < customersList.size(); i++) {


            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + "ID: " + currentCustomer.getPersonNummer());


        }


        users.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {


            userAccounts.getItems().clear();


            int AccountIndex = users.getSelectionModel().getSelectedIndex();
            UtilityClass.setAccountIndex(AccountIndex);


            Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
            ArrayList<Account> accountList = currentCustomer.getAccountList();




            for (int i = 0; i < accountList.size(); i++) {
                //Account specificAccount = accountList.get(accountIndex);
                userAccounts.getItems().remove(currentCustomer.getAccountList().get(i));
                userAccounts.getItems().add(accountList.get(i).getKontotyp() + " " + accountList.get(i).getKontoNummer());
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

                Customer currentCustomer = customersList.customerArrayList.get(UtilityClass.getIndex());
                ArrayList<Account> accountList = currentCustomer.getAccountList();
                Account specificAccount = accountList.get(accountIndex);

                label.setText(logic.getTransactions(currentCustomer.getPersonNummer(), specificAccount.getKontoNummer()).toString());


                System.out.println("Info created " + specificAccount.getKontoNummer());


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
                some = logic.getAllCustomers();

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
