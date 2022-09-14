package dalmar9.Uppgift_5.BankSystem;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BankLogic {

    public ArrayList<Customer> customers = new ArrayList<Customer>();


    public BankLogic() {


    }


    /*
     * A function that creates the customers
     * 1. check if customer list is empty, if it is then we add one customer and return true
     * 2. we then just go through the list and check if there is a dublicate.
     * 3. we then return false if there is; else we create a new customer.
     *
     *
     * @param name - Name of the customer
     * @param surname - Surname of the customer
     * @param pNo - the personal number (social security number)
     * @return - boolean. True if it works, false if error
     *
     *
     */
    public boolean createCustomer(String name, String surname, String pNo) {

        boolean equals = false;

        if (customers.isEmpty()) {
            customers.add(new Customer(name, surname, pNo));
            return true;
        }


        for (int i = 0; i < customers.size(); i++) {


            if (customers.get(i).getPersonNummer().equals(pNo)) {
                equals = true;
            }


        }


        if (equals) {
            return false;
        } else {
            customers.add(new Customer(name, surname, pNo));
        }


        return true;


    }




    /*
     * A function that gets all the customers
     * 1. loop through all the customers and add them to the new list
     * 2. return the list
     *
     *
     *
     * @return arrayList - return a list with all customers
     *
     *
     */


    public ArrayList<String> getAllCustomers() {

        ArrayList<String> allCustomers = new ArrayList<String>();

        if (customers.isEmpty()) {
            return allCustomers;
        }

        for (int i = 0; i < customers.size(); i++) {

            allCustomers.add(customers.get(i).getPersonNummer() + " " + customers.get(i).getFörNamn() + " "
                    + customers.get(i).getEfterNamn());

        }

        return allCustomers;
    }



    /*
     * A function that gets all the customer details
     * 1. loop through the array and find the specific customer. We then get all the relevent information.
     * 2. add all the info to the list
     * 3. return the list.
     *
     *
     *
     * @param pNo - the personal number (social security number)
     * @return arrayList - return a list with all the customers details
     *
     *
     */

   //TODO: Fix the fucking formating you idiot spacstic
    public ArrayList<String> getCustomer(String pNo) {

        ArrayList<String> specificCustomers = new ArrayList<String>();

        boolean noErrors = false;


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {
                specificCustomers.add(customers.get(i).getPersonNummer() + " " + customers.get(i).getFörNamn() + " "
                        + customers.get(i).getEfterNamn());


                noErrors = true;
                float rent = 0f;

                // String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv",
                // "SE")).format(customers.get(i).bankAccount.getSaldo());
                // NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv",
                // "SE"));
                // percentFormat.setMaximumFractionDigits(1);
                // String percentStr =
                // percentFormat.format(customers.get(i).bankAccount.getRäntesats() / 100);


                String balanceStr;
                NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
                percentFormat.setMaximumFractionDigits(1);
                String percentStr;

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {



                   if (customers.get(i).accounts.get(j).getKontotyp().equals("SparKonto")){

                       balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                               .format(customers.get(i).accounts.get(j).getSaldo());

                       NumberFormat.getPercentInstance(new Locale("sv", "SE"));

                       percentFormat.format(customers.get(i).accounts.get(j).getRäntesats() / 100);

                       percentStr = percentFormat.format(customers.get(i).accounts.get(j).getRäntesats() / 100);

                       specificCustomers.add(customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " "
                               + customers.get(i).accounts.get(j).getKontotyp() + " " + percentStr);





                   }

                    if (customers.get(i).accounts.get(j).getKontotyp().equals("KreditKonto")){


                        balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                .format(customers.get(i).accounts.get(j).getSaldo());




                        if (customers.get(i).accounts.get(j).getSaldo() < 0){
                            rent = customers.get(i).accounts.get(j).getSkuldRänta();
                        }
                        if (customers.get(i).accounts.get(j).getSaldo() >= 0){
                            rent = customers.get(i).accounts.get(j).getKreditRänta();
                        }



                        NumberFormat.getPercentInstance(new Locale("sv", "SE"));

                        percentFormat.format(rent / 100);

                        percentStr = percentFormat.format(rent / 100);

                        specificCustomers.add(customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " "
                                + customers.get(i).accounts.get(j).getKontotyp() + " " + percentStr);



                    }






                    //noErrors = true;


                }

                // specificCustomers.add(customers.get(i).bankAccount.getKontoNummer() + " " +
                // balanceStr + " " + customers.get(i).bankAccount.getKontotyp() + " " +
                // percentStr);

                break;

            }

        }


        if (noErrors) {
            return specificCustomers;
        }


        return null;

    }



    /*
     * A function that changes the customers name or surname
     * 1. loop through the customers list
     * 2. check for the id
     * 3. check if the params are empty or not.
     * 4. change the name or surname depending on what the params are.
     *
     *
     * @param name - Name of the customer
     * @param surname - Surname of the customer
     * @param pNo - the personal number (social security number)
     * @return boolean
     *
     *
     */


    public boolean changeCustomerName(String name, String surname, String pNo) {

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                if (name.isBlank()) {

                } else {
                    customers.get(i).setFörNamn(name);
                }

                if (surname.isBlank()) {

                } else {
                    customers.get(i).setEfterNamn(surname);
                }

                if (!name.isBlank() || !surname.isBlank())
                    return true;
                else
                    break;

            }

        }

        return false;
    }



    /*
     * A function that creates a new savings account
     * 1. loop through and check if the person exists in the customers list
     * 2. then create a new account
     * 3. get the number of the account
     *
     *
     *
     * @param pNo - the personal number (social security number)
     * @return int - the account number
     *
     *
     */


    public int createSavingsAccount(String pNo) {

        int numberToReturn = -1;


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                customers.get(i).addAccount();

                int lastAccount = customers.get(i).accounts.size() - 1; // -1 or index out of bounds
                customers.get(i).accounts.get(lastAccount).setAccountType();
                numberToReturn = customers.get(i).accounts.get(lastAccount).getKontoNummer();
                break;
            }

        }


        return numberToReturn;

    }


    public int createCreditAccount(String pNo) {

        int numberToReturn = -1;


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                customers.get(i).addCreditAccount();

                int lastAccount = customers.get(i).accounts.size() - 1; // -1 or index out of bounds
                customers.get(i).accounts.get(lastAccount).setAccountType();
                numberToReturn = customers.get(i).accounts.get(lastAccount).getKontoNummer();
                break;
            }

        }


        return numberToReturn;

    }

    public ArrayList<String> getTransactions(String pNo, int accountId) {

        ArrayList<String> Tran = new ArrayList<String>();

        boolean runTrough = true;



        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {

                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {

                        //CODE GOES HERE
                        runTrough = false;
                        for (int k = 0; k < customers.get(i).accounts.get(j).transactions.size(); k++) {




                            Tran.add(customers.get(i).accounts.get(j).transactions.get(k).getTransaction());


                        }


                    }


                }


            }


        }


        if (runTrough){
            return null;
        }else {
            return Tran;
        }



    }




    /*
     * A function that gets the account information
     * 1. loop through all the customers and add them to the new list
     * 2. return the list
     *
     *
     * @param accountId - the id of the account
     * @param pNo - the personal number (social security number)
     * @return arrayList - return a list with the customers infomation
     *
     *
     */

    public String getAccount(String pNo, int accountId) {

        String stringToReturn = null;


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {

                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {


                        String balanceStr;
                        NumberFormat percentFormat;
                        String percentStr;


                        if (getAccountType(pNo, accountId).equals("SparKonto")){


                            balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                    .format(customers.get(i).accounts.get(j).getSaldo());
                             percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
                            percentFormat.setMaximumFractionDigits(1);
                            percentStr = percentFormat.format(customers.get(i).accounts.get(j).getRäntesats() / 100);

                            stringToReturn = customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentStr;



                        }


                        if (getAccountType(pNo, accountId).equals("KreditKonto")){


                            float rent;

                            if (customers.get(i).accounts.get(j).getSaldo() < 0){


                                rent = customers.get(i).accounts.get(j).getSkuldRänta();

                                balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                        .format(customers.get(i).accounts.get(j).getSaldo());
                                percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
                                percentFormat.setMaximumFractionDigits(1);
                                percentStr = percentFormat.format(rent / 100);

                                stringToReturn = customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentStr;




                            }
                            if (customers.get(i).accounts.get(j).getSaldo() >= 0){

                                rent = customers.get(i).accounts.get(j).getKreditRänta();

                                balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                        .format(customers.get(i).accounts.get(j).getSaldo());
                                percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
                                percentFormat.setMaximumFractionDigits(1);
                                percentStr = percentFormat.format(rent / 100);

                                stringToReturn = customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentStr;


                            }








                        }









                        break;
                    }

                }

            }

        }

        return stringToReturn;
    }



    /*
     * Adds money to the account
     * 1. loop through all the customers and find the correct ones
     * 2. add the money to the account
     *
     *
     *
     * @param pNo - the personal number (social security number)
     * @param accountId
     * @param amount
     * @return boolean
     *
     *
     */

    public boolean deposit(String pNo, int accountId, int amount) {

        boolean didItWork = false;


        if (amount <= 0) {
            return false;
        }

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {

                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {


                        if (getAccountType(pNo, accountId).equals("SparKonto")) {
                            customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() + amount);




                            //balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                   // .format(customers.get(i).accounts.get(j).getSaldo());


                            String action = "";





                            customers.get(i).accounts.get(j).addTransaction(pNo, accountId, action, customers.get(i).accounts.get(j), amount);


                            didItWork = true;
                        }

                        if (getAccountType(pNo, accountId).equals("KreditKonto")) {
                            customers.get(i).accounts.get(j).setKreditMax(customers.get(i).accounts.get(j).getCreditMax() + amount);
                            customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() + amount);



                            String action ="";


                            customers.get(i).accounts.get(j).addTransaction(pNo, accountId, action, customers.get(i).accounts.get(j), amount);
                            didItWork = true;
                        }


                    }

                }

            }

        }


        return didItWork;


    }

    public boolean withdraw(String pNo, int accountId, int amount) {


        boolean isItWorking = false;


        if (amount <= 0) {
            return false;
        }

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {


                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {


                        if (customers.get(i).accounts.get(j).getKontotyp().equals("SparKonto")) {

                            if (!customers.get(i).accounts.get(j).getFirstTake()) {
                                customers.get(i).accounts.get(j).setFirstTakeTrue();

                                if (customers.get(i).accounts.get(j).getSaldo() >= amount) {







                                    //Maybe add a -
                                    String action = "-";



                                    //String action = "-" + amount + " kr " + " Saldo: " + customers.get(i).accounts.get(j).getSaldo() + " ";

                                    if (customers.get(i).accounts.get(j).getSaldo() <= 0){
                                        isItWorking = false;
                                        return false;
                                    }else{

                                        customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() - amount);
                                        customers.get(i).accounts.get(j).addTransaction(pNo, accountId, action, customers.get(i).accounts.get(j), amount);

                                        isItWorking = true;
                                        return true;
                                    }



                                }


                            }


                            if (customers.get(i).accounts.get(j).getFirstTake()) {


                                if (customers.get(i).accounts.get(j).getSaldo() >= amount) {
                                    int rent = amount;
                                    rent = (int) (rent * 0.02);






                                    String action = "-";



                                    //String action = "-" + amount + " kr " + " Saldo: " + customers.get(i).accounts.get(j).getSaldo() + " ";


                                    if (customers.get(i).accounts.get(j).getSaldo() < 0 || customers.get(i).accounts.get(j).getSaldo() - amount - rent < 0){

                                        isItWorking = false;
                                        return false;

                                    }else{
                                        customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() - amount - rent);
                                        customers.get(i).accounts.get(j).addTransaction(pNo, accountId, action, customers.get(i).accounts.get(j), amount+rent);
                                        isItWorking = true;
                                        return true;

                                    }



                                }


                            }


                        }


                        if (customers.get(i).accounts.get(j).getKontotyp() == "KreditKonto") {

                            if (customers.get(i).accounts.get(j).getCreditMax() >= amount) {



                                float rent;
                                if (customers.get(i).accounts.get(j).getSaldo() < 0){
                                    rent = customers.get(i).accounts.get(j).getSkuldRänta();
                                }
                                if (customers.get(i).accounts.get(j).getSaldo() >= 0){
                                    rent = customers.get(i).accounts.get(j).getKreditRänta();
                                }


                                String action = "-";


                                customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() - amount);
                                customers.get(i).accounts.get(j).setKreditMax(customers.get(i).accounts.get(j).getCreditMax() - amount);
                                customers.get(i).accounts.get(j).addTransaction(pNo, accountId, action, customers.get(i).accounts.get(j), amount);


                                isItWorking = true;


                            } else {
                                System.out.println("You don't have enough Credit " + customers.get(i).accounts.get(j).getCreditMax());
                                isItWorking = false;
                            }


                        }





						/*
						if (customers.get(i).accounts.get(j).getSaldo() >= amount) {
						
							customers.get(i).accounts.get(j).setSaldo(customers.get(i).accounts.get(j).getSaldo() - amount);
							return true;
						}
						*/


                    }

                }

            }

        }


        return isItWorking;
    }

    public String closeAccount(String pNo, int accountId) {


        String stringToReturn = null;

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {

                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {

                        float rentPaid = 0f;

                        if (getAccountType(pNo, accountId).equals("SparKonto")) {

                            rentPaid = (customers.get(i).accounts.get(j).getSaldo() * ((customers.get(i).accounts.get(j).getRäntesats() / 100)));



                            String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                    .format(customers.get(i).accounts.get(j).getSaldo());

                            String percentFormat = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(rentPaid);




                            stringToReturn = customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentFormat;


                            customers.get(i).removeAccount(j);



                            break;




                        }

                        if (getAccountType(pNo, accountId).equals("KreditKonto")) {

                            if (customers.get(i).accounts.get(j).getSaldo() < 0){
                                float ränteFörändring = customers.get(i).accounts.get(j).getSkuldRänta() / 100;
                                rentPaid = ränteFörändring * customers.get(i).accounts.get(j).getSaldo();
                            }



                           /* if (customers.get(i).accounts.get(j).getCreditMax() < 5000) {
                                float ränteFörändring = customers.get(i).accounts.get(j).getSkuldRänta() / 100;
                                int skuldAttBetala = customers.get(i).accounts.get(j).getCreditMax() - 5000;
                                rentPaid = (skuldAttBetala * ((ränteFörändring)));


                            }*/ else {

                                rentPaid = (customers.get(i).accounts.get(j).getSaldo() * ((customers.get(i).accounts.get(j).getKreditRänta())));


                            }


                            //float rentPaid = (customers.get(i).accounts.get(j).getSaldo() * ((customers.get(i).accounts.get(j).getKreditRänta())));


                            String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                                    .format(customers.get(i).accounts.get(j).getSaldo());
                            String percentFormat = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(rentPaid);


                            stringToReturn = customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentFormat;


                            customers.get(i).removeAccount(j);


                            break;


                        }


                    }

                }

            }

        }


        return stringToReturn;
    }

    public ArrayList<String> deleteCustomer(String pNo) {


        ArrayList<String> quitCustomer = new ArrayList<String>();


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {


                quitCustomer.add(customers.get(i).getPersonNummer() + " " + customers.get(i).getFörNamn() + " " + customers.get(i).getEfterNamn());


                for (int j = 0; j < customers.get(i).accounts.size(); j++) {


                    float rentPaid = (customers.get(i).accounts.get(j).getSaldo() * ((customers.get(i).accounts.get(j).getRäntesats() / 100)));


                    String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                            .format(customers.get(i).accounts.get(j).getSaldo());
                    String percentFormat = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(rentPaid);

                    quitCustomer.add(customers.get(i).accounts.get(j).getKontoNummer() + " " + balanceStr + " " + customers.get(i).accounts.get(j).getKontotyp() + " " + percentFormat);


                }

                customers.remove(i);
                return quitCustomer;


            }

        }


        return null;
    }


    //Caused errors - fix later
    public boolean checkUserID(String pNo) {


        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer() == pNo) {
                return true;
            }


        }


        return false;
    }


    //Caused erors - fix later
    public boolean checkUserID_AndAccount(String pNo, int accountNr) {

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer() == pNo) {


                for (int j = 0; j < customers.get(i).accounts.size(); i++) {

                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountNr) {
                        return true;
                    }


                }


            }

        }

        return false;

    }


    public String getAccountType(String pNo, int accountId) {

        String accountType = null;


        for (int i = 0; i < customers.size(); i++) {


            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).accounts.size(); j++) {
                    if (customers.get(i).accounts.get(j).getKontoNummer() == accountId) {


                        accountType = customers.get(i).accounts.get(j).getKontotyp();

                        break;


                    }
                }
                break;


            }


        }


        return accountType;
    }


}
