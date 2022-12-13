
/*
@autor Marius Daldorff Pedersen, dalmar-9
 */



package Layout;

import Actions.*;
import FileActions.*;
import com.example.banksystem_remade.MainApplication;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Layout {

    private BorderPane borderLayout;


    //Actions
    private AddFunctions addFunctions = new AddFunctions();
    private ViewFunctions viewFunctions = new ViewFunctions();
    private DeleteFunctions deleteFunctons = new DeleteFunctions();
    private EditFunctions editFunctions = new EditFunctions();

    public Layout(){

        //Setup the layout


        ////////////////////////////////////////////////////////////////////////////////////////////// Boiler Plate
        //Setup a borderPane
        borderLayout = new BorderPane();
        HBox topBar = new HBox();
        VBox bottomBox = new VBox();
        GridPane centerLayout = new GridPane();
        borderLayout.setTop(topBar);
        borderLayout.setBottom(bottomBox);
        borderLayout.setCenter(centerLayout);


        //MenuBar
        MenuBar menu = new MenuBar();
        Menu startMenu = new Menu("Start");
        Menu add = new Menu("Add");
        Menu edit = new Menu("Edit");
        Menu delete = new Menu("Delete");
        Menu view = new Menu("View");
        menu.getMenus().addAll(startMenu, add, edit, delete, view);


        MenuItem backToStart = new MenuItem("Home");
        backToStart.setOnAction(e -> MainApplication.changeScene(MainApplication.mainScene));


        MenuItem saveButton = new MenuItem("Save to file");
        saveButton.setOnAction(e-> new SaveFile());


        MenuItem loadSave = new MenuItem("Load from a file");
        loadSave.setOnAction(e-> {
            FileChooser.display("Load Save");
            new LoadFile(MainApplication.choosenFile);
        });


        MenuItem saveTransactions = new MenuItem("Save transactions");
        saveTransactions.setOnAction(e-> SaveTrans.saveTrans());


        MenuItem loadTransaction = new MenuItem("Load transaction");
        loadTransaction.setOnAction(e-> {
            TransactionChooser.display("Choose a transaction");
            viewTransactionWindow.Display("The Transaction");
        });

        MenuItem help = new MenuItem("Help");


        MenuItem addCustomer = new MenuItem("Add a customer");
        addCustomer.setOnAction(e -> addFunctions.addCustomer());


        MenuItem addAccount = new MenuItem("Add an account");
        addAccount.setOnAction(e -> addFunctions.addAccount());


        MenuItem deleteAccount = new MenuItem("Delete an account");
        deleteAccount.setOnAction(e -> deleteFunctons.deleteAccount());



        MenuItem deleteCustomer = new MenuItem("Delete a customer");
        deleteCustomer.setOnAction(e -> deleteFunctons.deleteCustomer());


        MenuItem editName = new MenuItem("Edit name");
        editName.setOnAction(e -> editFunctions.editName());


        MenuItem viewCustomers = new MenuItem("View current customers");
        viewCustomers.setOnAction(e -> viewFunctions.viewCustomers());


        MenuItem viewCustomer = new MenuItem("View a customer");
        viewCustomer.setOnAction(e -> viewFunctions.viewCustomer());


        MenuItem viewAccount = new MenuItem("View an account");
        viewAccount.setOnAction(e -> viewFunctions.viewAccount());


        MenuItem deposit = new MenuItem("Make a deposit");
        deposit.setOnAction(e -> editFunctions.deposit());


        MenuItem withDraw = new MenuItem("Make a withdraw");
        withDraw.setOnAction(e -> editFunctions.withdraw());


        MenuItem transactions = new MenuItem("View Transactions on an account");
        transactions.setOnAction(e -> viewFunctions.viewTransactions());



        topBar.getChildren().add(menu);
        startMenu.getItems().addAll(backToStart, saveButton, loadSave, help, saveTransactions, loadTransaction);
        add.getItems().addAll(addCustomer, addAccount);
        edit.getItems().addAll(editName, deposit, withDraw);
        delete.getItems().addAll(deleteAccount, deleteCustomer);
        view.getItems().addAll(viewAccount, viewCustomer, viewCustomers, transactions);
        ////////////////////////////////////////////////////////////////////////////////////////////// Boiler Plate


        centerLayout.setPadding(new Insets(10, 10, 10, 10));
        centerLayout.setVgap(5);
        centerLayout.setHgap(10);


        //Adding customers functionality




    }



    public BorderPane getBorderLayout() {
        return borderLayout;
    }



}




