package BankSystems;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BankLogic {


    private CustomersList customersList = new CustomersList();

    //private ArrayList<Customer> customers = customersList.getCustomerArrayList();
    public BankLogic() {

  /*  createCustomer("Marius", "Pedersen", "000518");
    createSavingsAccount("000518");
    createCreditAccount("000518");
    System.out.println(getAccount("000518", 1001));
    deposit("000518", 1001, 500);
    withdraw("000518", 1001, 100);
    withdraw("000518", 1001, 100);
    System.out.println(getAccount("000518", 1001));
    deposit("000518", 1001, -10);
    System.out.println(getAccount("000518", 1001));
    withdraw("000518", 1001, 300);
    System.out.println(getAccount("000518", 1001));


       // deposit("000518", 1002, 500);
        withdraw("000518", 1002, 3000);
        withdraw("000518", 1002, 3000);
        deposit("000518", 1002, 2000);
        deposit("000518", 1002, 3000);
        System.out.println(getAccount("000518", 1002));
        System.out.println(getTransactions("000518", 1002));*/

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

        if (customersList.customerArrayList.isEmpty()) {
            customersList.addCustomer(new Customer(name, surname, pNo));

            return true;
        }


        for (int i = 0; i < customersList.size(); i++) {


            if (customersList.findSpecificCustomer(pNo) != null){
                equals = true;
            }





        }


        if (equals) {
            return false;
        } else {
            customersList.addCustomer(new Customer(name, surname, pNo));

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

        if (customersList.customerArrayList.isEmpty()) {
            return allCustomers;
        }

        for (int i = 0; i < customersList.size(); i++) {

            allCustomers.add(customersList.customerArrayList.get(i).getPersonNummer() + " " + customersList.customerArrayList.get(i).getFornamn() + " "
                    + customersList.customerArrayList.get(i).getEfterNamn());

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


    public ArrayList<String> getCustomer(String pNo) {

        ArrayList<String> specificCustomers = new ArrayList<String>();

        boolean noErrors = false;


        for (int i = 0; i < customersList.size(); i++) {


            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {
                specificCustomers.add(customersList.customerArrayList.get(i).toString());


                noErrors = true;


                for (int j = 0; j < customersList.customerArrayList.get(i).getAccountList().size(); j++) {

                    Account acc = (Account) customersList.customerArrayList.get(i).getAccountList().get(j);


                    specificCustomers.add(acc.toString());


                }


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

        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {

                if (name.isBlank()) {

                } else {
                    customersList.customerArrayList.get(i).setFornamn(name);
                }

                if (surname.isBlank()) {

                } else {
                    customersList.customerArrayList.get(i).setEfterNamn(surname);
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


        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {

                customersList.customerArrayList.get(i).addSavingsAccount();
                int lastAccount = customersList.customerArrayList.get(i).getAccountList().size() - 1; // -1 or index out of bounds
                Account acc = (Account) customersList.customerArrayList.get(i).getAccountList().get(lastAccount);
                numberToReturn = acc.getKontoNummer();
                break;
            }

        }


        return numberToReturn;

    }


    /*
     * A function that creates a new Credit account
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

    public int createCreditAccount(String pNo){

        int numberToReturn = -1;


        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {

                customersList.customerArrayList.get(i).addCreditAccount();
                int lastAccount = customersList.customerArrayList.get(i).getAccountList().size() - 1; // -1 or index out of bounds
                Account acc = (Account) customersList.customerArrayList.get(i).getAccountList().get(lastAccount);
                numberToReturn = acc.getKontoNummer();
                break;
            }

        }


        return numberToReturn;
    }


    /*
    This function gets the transactions for a specific account
    @param - pNo - the personal id
    @param - accountId - the account number
    return - the transaction list for the account
     */

    public ArrayList<String> getTransactions(String pNo, int accountId){




        for (int i = 0; i < customersList.size(); i++){

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)){

                Customer specificCustomer = customersList.customerArrayList.get(i);
                Account specificAccount = specificCustomer.findAccount(accountId);
                if (specificAccount == null) return null;
                return specificAccount.transactions;








            }


        }




        return null;
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


        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {


                Account acc = customersList.customerArrayList.get(i).findAccount(accountId);

                if (acc != null) {


                    String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                            .format(acc.getSaldo());
                    NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
                    percentFormat.setMaximumFractionDigits(1);
                    String percentStr = percentFormat.format(acc.getRent().floatValue() / 100);

                    stringToReturn = acc.toString();


                    break;

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

    /*public boolean deposit(String pNo, int accountId, int amount) {

        boolean didItWork = false;


        if (amount <= 0) {
            return false;
        }

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {


                Account acc = customers.get(i).findAccount(accountId);

                if (acc != null) {

                    acc.setSaldo(acc.getSaldo() + amount);
                    didItWork = true;
                }

            }

        }


        return didItWork;


    }*/


    public boolean deposit(String pNo, int AccountId, int amount){

        boolean didItDeposit = false;


        if (amount <= 0){
            return false;
        }



        for (int i = 0; i < customersList.size(); i++){

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)){

                Customer desiredCustomer = customersList.customerArrayList.get(i);
                Account desiredAccount = desiredCustomer.findAccount(AccountId);

                if (desiredAccount == null) return false;

               didItDeposit = desiredAccount.deposit(pNo, AccountId, amount);

                return didItDeposit;



            }


        }



        return didItDeposit;
    }


    public boolean withdraw(String pNo, int accountId, int amount){


        boolean didItWithdraw = false;


        if (amount <= 0){
            return false;
        }


        for (int i = 0; i < customersList.size(); i++){

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)){

                Customer desiredCustomer = customersList.customerArrayList.get(i);
                Account desiredAccount = desiredCustomer.findAccount(accountId);
                if (desiredAccount == null) return false;
                didItWithdraw = desiredAccount.withdraw(pNo, accountId, amount);

                return didItWithdraw;



            }


        }



        return didItWithdraw;
    }



   /* public boolean withdraw(String pNo, int accountId, int amount) {

		*//*
		This function takes money from an account
		1. We check if the amount given is more than 0 return false else continue
		2. we first loop through all the customers, get their ids and getAccountList() and checks if it is the one we are looking for.
		3. we then take the money out of the account
		4. we return true else false


		@param pNo - the player personal number
		@param accountId - the account number
		@param amount - the amount of money that is wished to withdraw
		 *//*


        if (amount <= 0) {
            return false;
        }

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getPersonNummer().equals(pNo)) {

                for (int j = 0; j < customers.get(i).getAccountList().size(); j++) {

                    Account acc = (Account) customers.get(i).getAccountList().get(j);

                    if (acc.getKontoNummer() == accountId) {


                        if (acc.getSaldo() >= amount) {

                            acc.setSaldo(acc.getSaldo() - amount);
                            return true;
                        }


                    }

                }

            }

        }


        return false;
    }

*/

		/*
		This function closes the account
		1. Loop through the customers and getAccountList() to find the desired one
		2. We do some math and set the correct format
		3. we then create a string to return
		4. return the string


		@param pNo - the player personal number
		@param accountId - the account number
		@param return - information about the closed account
		 */

    public String closeAccount(String pNo, int accountId) {


        String stringToReturn = null;

        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {
                Account acc = customersList.customerArrayList.get(i).findAccount(accountId);

                if (acc != null) {
                    stringToReturn = acc.closeAccountString();
                    customersList.customerArrayList.get(i).removeAccount(acc);
                    break;


                }


            }

        }


        return stringToReturn;
    }


		/*
		This function deletes a customer
		1. We loop through the customers and get the correct one
		2. We then add the information to a new array list
		3. We then loop the getAccountList()
		4. We add the account information to the new array
		5. We then remove the customer from the customers list
		6. we return the ArrayList we created



		@param pNo - the player personal number
		@param return - Array list of the deleted acounts information
		 */


    public ArrayList<String> deleteCustomer(String pNo) {


        ArrayList<String> quitCustomer = new ArrayList<String>();


        for (int i = 0; i < customersList.size(); i++) {

            if (customersList.customerArrayList.get(i).getPersonNummer().equals(pNo)) {


                quitCustomer.add(customersList.customerArrayList.get(i).toString());


                for (int j = 0; j < customersList.customerArrayList.get(i).getAccountList().size(); j++) {

                    Account acc = (Account) customersList.customerArrayList.get(i).getAccountList().get(j);
                    quitCustomer.add(acc.closeAccountString());

                }
                customersList.removeCustomer(customersList.customerArrayList.get(i));
                return quitCustomer;


            }

        }


        return null;
    }


  /*  public static void main(String[] args){

        new BankLogic();


    }*/



}
