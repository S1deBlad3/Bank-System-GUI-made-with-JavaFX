/*
@autor Marius Daldorff Pedersen, dalmar-9
 */



package FileActions;

import BankSystems.Account;
import BankSystems.Customer;
import BankSystems.CustomersList;
import com.example.banksystem_remade.MainApplication;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//This class loads the file and puts the correct information into the main bankSystem classes



/*
1. We create two arrays

 */
public class LoadFile {


    private ArrayList<Customer> testArray = new ArrayList<>();
    private ArrayList<Customer> input = new ArrayList<>();
    private Label label = new Label();
    private int lastKontoNummer = 1001;


    File homeFolder = new File(System.getProperty("user.dir"));
    File savesFolder = new File(homeFolder.getPath() + "/Saves");


    boolean isExist = true;
    int index = 0;


    /*
    1. We check if a file have been choosen if so we go to 2
    2. We read the input stream
    3. We then set the customerArrayList to the new array we have created overriding the old one.

@param file - The saved file the user wants to load
 */

    public LoadFile(File saveFile) {

        if (MainApplication.choosenFile != null) {


            try {
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(MainApplication.choosenFile));
                System.out.println("Work");


                //setKontoNummer(lastKontoNummer);


                testArray = (ArrayList<Customer>) inputStream.readObject();
                System.out.println(testArray.toString());
                //lastKontoNummer = inputStream.readInt();
                //System.out.println(lastKontoNummer + "Sista nummret");

                inputStream.close();


          /*  while (isExist){
                if (inputStream.available() != 0){
                    testArray.add((Customer) inputStream.readObject());
                    index++;
                }else {
                    label.setText("Came here" + index);
                    isExist = false;
                }
            }*/


            } catch (Exception e) {
                System.out.println("The Data file exist and can not be overloaded");

                e.printStackTrace();
            }

            //WTF DO YOU EVEN DO?????
          /*  for (int i = 0; i < testArray.size(); i++) {
                label.setText(label.getText() + testArray.get(i).getFornamn() + testArray.get(i).getAccountList().size() + "\n");
            }*/

            //TODO: Get the last number of account


            CustomersList.customerArrayList = testArray;
            //Customer.UniqueID = lastKontoNummer;
            Customer lastCustomer = testArray.get(testArray.size() - 1);
            Account lastAccountCreated = (Account) lastCustomer.getAccountList().get(lastCustomer.getAccountList().size() - 1);
            lastKontoNummer = lastAccountCreated.getKontoNummer();


            lastAccountCreated.setLastAccountNumber(lastKontoNummer);


            //changeScene(loadScene);


        } else {


            System.out.println("No file was selected");

        }


    }


}
