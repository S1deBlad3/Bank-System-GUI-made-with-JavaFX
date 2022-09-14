package dalmar9.Uppgift_5.FileActions;

import dalmar9.Uppgift_5.BankSystem.Customer;
import dalmar9.Uppgift_5.MainApplication;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadFile {


    private ArrayList<Customer> testArray = new ArrayList<>();
    private ArrayList<Customer> input = new ArrayList<>();
    private Label label = new Label();
    private int lastKontoNummer = 1001;


    File homeFolder = new File(System.getProperty("user.dir"));
    File savesFolder = new File(homeFolder.getPath() + "/Saves");


    boolean isExist = true;
    int index = 0;


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


            for (int i = 0; i < testArray.size(); i++) {
                label.setText(label.getText() + testArray.get(i).getFörNamn() + testArray.get(i).accounts.size() + "\n");
            }


            MainApplication.bank.customers = testArray;
            Customer.UniqueID = lastKontoNummer;


            //changeScene(loadScene);


        } else {


            System.out.println("No file was selected");

        }


    }


}
