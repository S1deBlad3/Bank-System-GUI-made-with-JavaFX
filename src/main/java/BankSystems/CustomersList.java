package BankSystems;

import java.util.ArrayList;

public class CustomersList {

    /*
    This class keeps all the customers in a private list
    It holds functions for adding customers to the list, finding a specific customers and retuning the list.
     */


    public static ArrayList<Customer> customerArrayList = new ArrayList<>();


    public CustomersList(){




    }


    public void addCustomer(Customer customer){
        customerArrayList.add(customer);
    }

    public ArrayList<Customer> getCustomerArrayList(){
        return customerArrayList;
    }

    public void removeCustomer(Customer customer){

        customerArrayList.remove(customer);

    }


    public int size(){
        return customerArrayList.size();
    }


    public Customer findSpecificCustomer(String pNo){

        for (int i = 0; i < customerArrayList.size(); i++){
            if (customerArrayList.get(i).getPersonNummer().equals(pNo)){
                return customerArrayList.get(i);
            }
        }


        return null;

    }




}
