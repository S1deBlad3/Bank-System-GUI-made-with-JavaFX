
/*
@autor Marius Daldorff Pedersen, dalmar-9
 */


package FileActions;

import BankSystems.Customer;
import BankSystems.CustomersList;
import BankSystems.Transactions;
import com.example.banksystem_remade.MainApplication;
import javafx.scene.effect.ImageInput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



//This class handles saving of the file
public class SaveFile {

    private ArrayList<Customer> customers = CustomersList.customerArrayList;


    private File homeFolder = new File(System.getProperty("user.dir"));
    private File savesFolder = new File(homeFolder.getPath() + "/Saves");


    /*
    1.We check if we have choosen a file.
    2. We get the amount of saves we have gotten already
    3. We then opens upp are you sure screen to save the file
    4. Else we create a new save file
     */

    public SaveFile() {



        if (MainApplication.choosenFile != null) {


            //Two options. Create one file and change it, or create a dump of files with Index?


            ArrayList<Transactions> transactions = new ArrayList<>();
            //int lastKontoNummer = 1001;


            int number = 0;
            File[] saves = savesFolder.listFiles();
            for (int i = 0; i < saves.length; i++) {


                // System.out.println(saves[i].toString());
                //System.out.println(choosenFile);
                //System.out.println(choosenFile.toString());


                //If the File exist
                if (saves[i].toString().equals(MainApplication.choosenFile.toString())) {

                    System.out.println(MainApplication.choosenFile.toString());
                    System.out.println(saves[i]);

                    System.out.println("This file exists");
                    AreYouSureScreen.display("Please confirm");

                    if (AreYouSureScreen.confirmed && !AreYouSureScreen.safeGuard) {
                        sureSave();
                    } else if (!AreYouSureScreen.confirmed && !AreYouSureScreen.safeGuard) {
                        System.out.println("You did not save");
                    } else if (AreYouSureScreen.safeGuard) {
                        //TODO: CREATE A NEW FILE
                        createANewSaveFile();
                    }


                }

            }


        } else {
            createANewSaveFile();
        }


    }


    /*
    1. We get the last number of the save file
    2. We then save the information into the file
     */
    public void createANewSaveFile() {


        ArrayList<Transactions> transactions = new ArrayList<>();
        //int lastKontoNummer = 1001;


        int number = 0;


        number = savesFolder.list().length;

        File savedFile = new File(savesFolder, "save_" + number + ".dat");


        MainApplication.choosenFile = savedFile;


        System.out.println("Started");

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(savedFile));


            System.out.println("Work");
            /*for (int i = 0; i < bank.customers.size(); i++){
                outputStream.writeObject(bank.customers.get(i));
            }*/

            outputStream.writeObject(customers);


            //lastKontoNummer = Account.numberOfAccounts;

            //outputStream.writeInt(lastKontoNummer);
            //Transactions // 1001 // transactions
            //                1002  // transactions
            //
            //
            //
            //
            //
            //


            outputStream.close();


        } catch (Exception e) {
            System.out.println("Did not work");
        }


        MainApplication.changeScene(MainApplication.window.getScene());


    }

/*
1. We override the savefile that we have
 */

    public void sureSave() {

        int number = 0;


        number = savesFolder.list().length;

        //File savedFile = new File(savesFolder, "save_" + number + ".dat");


        System.out.println("Started");

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(MainApplication.choosenFile));


            System.out.println("Work");
            /*for (int i = 0; i < bank.customers.size(); i++){
                outputStream.writeObject(bank.customers.get(i));
            }*/

            outputStream.writeObject(customers);


            //lastKontoNummer = Account.numberOfAccounts;

            //outputStream.writeInt(lastKontoNummer);
            //Transactions // 1001 // transactions
            //                1002  // transactions
            //
            //
            //
            //
            //
            //


            outputStream.close();


        } catch (Exception e) {
            System.out.println("Did not work");
        }


        MainApplication.changeScene(MainApplication.window.getScene());


    }


}
