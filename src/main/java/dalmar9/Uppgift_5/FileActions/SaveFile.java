package dalmar9.Uppgift_5.FileActions;

import dalmar9.Uppgift_5.BankSystem.Transaction;
import dalmar9.Uppgift_5.MainApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveFile {

    private File homeFolder = new File(System.getProperty("user.dir"));
   private File savesFolder = new File(homeFolder.getPath() + "/Saves");

    public SaveFile() {


        if (MainApplication.choosenFile != null) {


            //Two options. Create one file and change it, or create a dump of files with Index?


            ArrayList<Transaction> transactions = new ArrayList<>();
            //int lastKontoNummer = 1001;


            int number = 0;
            File[] saves = savesFolder.listFiles();
            for (int i = 0; i < saves.length; i++) {


                // System.out.println(saves[i].toString());
                //System.out.println(choosenFile);
                //System.out.println(choosenFile.toString());


                //If the File exist
                if (saves[i].toString().equals(MainApplication.choosenFile.toString())) {

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


    public void createANewSaveFile() {


        ArrayList<Transaction> transactions = new ArrayList<>();
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

            outputStream.writeObject(MainApplication.bank.customers);


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

            outputStream.writeObject(MainApplication.bank.customers);


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
