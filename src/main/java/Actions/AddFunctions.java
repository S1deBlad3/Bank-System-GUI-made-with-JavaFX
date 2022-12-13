/*
@autor Marius Daldorff Pedersen, dalmar-9
 */


package Actions;

import BankSystems.BankLogic;
import BankSystems.Customer;
import BankSystems.CustomersList;
import Layout.Layout;
import Utility.UtilityClass;
import com.example.banksystem_remade.MainApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


//This class handles all the functions that has with adding something.

public class AddFunctions {

    private int index;
    private BankLogic logic = new BankLogic();
    private CustomersList customersList = new CustomersList();


    public AddFunctions(){



    }


/*
1. We setup the layout as we want it
2. We create the components we want
3. We get the users click input depending on what they have pressed
4. We run the correct method in bankSystem folder.

 */
    public void addAccount(){

        BorderPane layout = new Layout().getBorderLayout();
        GridPane center = (GridPane) layout.getCenter();

        ComboBox users = new ComboBox<>();

        for (int i = 0; i < customersList.size(); i++){

            Customer currentCustomer = customersList.customerArrayList.get(i);

            users.getItems().add(currentCustomer.getFornamn() + " " + currentCustomer.getEfterNamn() + "ID " + currentCustomer.getPersonNummer());


        }



        //Actions
        users.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectedIndex = users.getSelectionModel().getSelectedIndex();
                UtilityClass.setIndex(selectedIndex);
            }
        });



        ToggleGroup group = new ToggleGroup();
        RadioButton savingsAccount = new RadioButton("Savings Account");
        savingsAccount.setToggleGroup(group);
        RadioButton creditAccount = new RadioButton("Credit Account");
        creditAccount.setToggleGroup(group);

        Button button = new Button("Submit");
        //Actions
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (group.getSelectedToggle().equals(savingsAccount)){
                    int index = UtilityClass.getIndex();
                    logic.createSavingsAccount(customersList.customerArrayList.get(index).getPersonNummer());
                }else if (group.getSelectedToggle().equals(creditAccount)){
                    int index = UtilityClass.getIndex();
                    logic.createCreditAccount(customersList.customerArrayList.get(index).getPersonNummer());
                }





            }
        });


        GridPane.setConstraints(users, 0, 0);
        GridPane.setConstraints(button, 0, 1);
        GridPane.setConstraints(savingsAccount, 1, 0);
        GridPane.setConstraints(creditAccount, 2, 0);
        center.getChildren().addAll(users, button, savingsAccount, creditAccount);


        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);



    }




    /*
    1. We setup the layout as we want it
    2. We create the components we want
    3. We get the users click input depending on what they have pressed
    4. We run the correct method in bankSystem folder.

     */
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
        button.setOnAction(e->{
            logic.createCustomer(name.getText(), surname.getText(), pNo.getText());


            name.clear();
            surname.clear();
            pNo.clear();




        });
        GridPane.setConstraints(button, 1, 2);

        Scene customerScene = new Scene(layout, 1000, 500);

        MainApplication.changeScene(customerScene);


        center.getChildren().addAll(nameLabel, name, surname, pNo, button);





    }

}
