package dalmar9.Uppgift_5.Actions;

import dalmar9.Uppgift_5.MainApplication;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveTrans {


    public static void saveTrans() {

        File homeFolder = new File(System.getProperty("user.dir"));
        File transactionFolder = new File(homeFolder.getPath() + "/Transactions");


        int number = 0;

        number = transactionFolder.list().length;


        File transaction = new File(transactionFolder, "Transaction_" + number + ".txt");


        try {


            System.out.println("Worked");
            FileWriter writer = new FileWriter(transaction);


            //Create a new and add information
            System.out.println("File created");

            for (int i = 0; i < MainApplication.bank.customers.size(); i++) {
                String representation = "Name: " + MainApplication.bank.customers.get(i).getFörNamn() + " ID: " + MainApplication.bank.customers.get(i).getPersonNummer() + "\n";
                writer.write(representation);

                for (int j = 0; j < MainApplication.bank.customers.get(i).accounts.size(); j++) {

                    ArrayList<String> localTransactions = MainApplication.bank.getTransactions(MainApplication.bank.customers.get(i).getPersonNummer(), MainApplication.bank.customers.get(i).accounts.get(j).getKontoNummer());
                    writer.write(localTransactions.toString() + "\n");


                }


            }

            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
