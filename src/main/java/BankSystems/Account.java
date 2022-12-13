package BankSystems;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public abstract class Account implements Serializable {

/*
	This is the class Account
	It holds some private variables and a public list of its accounts

	1.The constructor sets the variables and also creates an unique id for the account using a static method (shared between objects)
	2. Then we have getters and setters


	 */

	
	//Variabler
	protected int saldo;
	//protected CustomersList customerList = new CustomersList();
	//protected ArrayList customers = customerList.getCustomerArrayList();

	//Big decimal variables
	protected BigDecimal rent = new BigDecimal("1.2");

	protected BigDecimal zero = BigDecimal.ZERO;


	protected int kontoNummer;
	protected String kontotyp = "";
	protected static int numberOfAccounts;

	protected ArrayList<String> transactions;
	
	
	
	
	
	public Account() {
		
		if (numberOfAccounts == 0) {
			numberOfAccounts = 1001;
		}else {
			numberOfAccounts++;
		}

		
		kontoNummer = numberOfAccounts;
		transactions = new ArrayList<>();


		
	}


	public int getKontoNummer() {
		return kontoNummer;
	}

	public void setKontoNummer(int kontoNummer) {
		this.kontoNummer = kontoNummer;
	}

	public String getKontotyp() {
		return kontotyp;
	}

	public void setKontotyp(String kontotyp) {
		this.kontotyp = kontotyp;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setBig(float rent){

		this.rent = zero;
		this.rent.add(BigDecimal.valueOf(rent));


	}

	public BigDecimal getRent(){
		return rent;
	}



	public abstract String toString();

	public abstract String closeAccountString();

	public String getBalanceStr(){


		return null;
	}

	public String getPercentStr(){

		return null;
	}


	public abstract void setAccountType();


/*
	public void deposit(String pNo, int accountId, int amount){

		for (int i = 0; i < customers.size(); i++){

			Customer specificCustomer = (Customer) customers.get(i);


			if (specificCustomer.getPersonNummer().equals(pNo)){


				Account customersAccount = specificCustomer.findAccount(accountId);

				customersAccount.saldo += amount;



			}


		}




	}
*/


	public abstract boolean deposit(String pNo, int accountId, int amount);
	public abstract boolean withdraw(String pNo, int accountId, int amount);

	public abstract void addTransaction(int amount);

	public ArrayList<String> getTransactions(){


		return transactions;
	}



	public int setLastAccountNumber(int number){

		numberOfAccounts = number;


		return number;
	}







}



