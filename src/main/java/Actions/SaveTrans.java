/*
@autor Marius Daldorff Pedersen, dalmar-9
 */



package Actions;

import BankSystems.Account;
import BankSystems.BankLogic;
import BankSystems.CustomersList;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;



//This class handles saving transactions to a file


/*
We simply get the user directory inside the folder for transactions.
We find the correct number to add to the file by checking how many files have been saved.
Then we access the information and save the information on the accounts.
 */

public class SaveTrans {

    public static void saveTrans() {

        File homeFolder = new File(System.getProperty("user.dir"));
        File transactionFolder = new File(homeFolder.getPath() + "/Transactions");
        CustomersList customersList = new CustomersList();
        BankLogic logic = new BankLogic();

        int number = 0;

        number = transactionFolder.list().length;


        File transaction = new File(transactionFolder, "Transaction_" + number + ".txt");


        try {


            System.out.println("Worked");
            FileWriter writer = new FileWriter(transaction);


            //Create a new and add information
            System.out.println("File created");

            for (int i = 0; i <customersList.size(); i++) {
                String representation = "Name: " + CustomersList.customerArrayList.get(i).getFornamn() + " ID: " + CustomersList.customerArrayList.get(i).getPersonNummer() + "\n";
                writer.write(representation);
                ArrayList<Account> accounts = CustomersList.customerArrayList.get(i).getAccountList();
                for (int j = 0; j < accounts.size(); j++) {



                    Account currentAccount = accounts.get(j);

                    //ArrayList<String> localTransactions = MainApplication.bank.getTransactions(MainApplication.bank.customers.get(i).getPersonNummer(), MainApplication.bank.customers.get(i).accounts.get(j).getKontoNummer());
                    ArrayList<String> localTransactions = logic.getTransactions(CustomersList.customerArrayList.get(i).getPersonNummer(), currentAccount.getKontoNummer());

                    writer.write(localTransactions.toString() + "\n");


                }


            }

            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}