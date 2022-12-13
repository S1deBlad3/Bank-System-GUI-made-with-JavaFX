package BankSystems;

import java.io.Serializable;
import java.util.ArrayList;
public class Customer implements Serializable {

	/*
	This is the class Customer
	It holds some private variables and a public list of its accounts

	1.The constructor sets the variables and also creates an account list
	2. Then we have getters and setters
	3. Then we have one method for adding an account to the list and one to remove an account in the list

	 */



	
	//Variables
	private String fornamn, efterNamn;
	private String personNummer;
	private ArrayList<Account> accounts;
	
	
	
	
	
	public Customer(String fornamn, String efternamn, String personNumber) {
		this.fornamn = fornamn;
		this.efterNamn = efternamn;
		this.personNummer = personNumber;
		
		accounts = new ArrayList<Account>();
		
		
		
		//accounts.add(new Account());
		
		
	}
	
	
	
	
	
	
	//Getters and setters
	public String getFornamn() {
		return fornamn;
	}
	public void setFornamn(String fornamn) {
		this.fornamn = fornamn;
	}
	public String getEfterNamn() {
		return efterNamn;
	}
	public void setEfterNamn(String efterNamn) {
		this.efterNamn = efterNamn;
	}
	public String getPersonNummer() {
		return personNummer;
	}

	public ArrayList getAccountList(){
		return accounts;
	}

	public void addSavingsAccount() {
		
		accounts.add(new SavingsAccount());

	}

	public void addCreditAccount(){

		accounts.add(new CreditAccount());


	}
	
	
	public void removeAccount(Account account) {
		
		
		accounts.remove(account);
		
		
		
		
	}
/*
This function finds an account
@param - kontonummer - the accountId you want to find
@return the account
 */
	public Account findAccount(int kontoNummer){

		Account accountToReturn = null;

		for (int i = 0; i < accounts.size(); i++){

			if (accounts.get(i).getKontoNummer() == kontoNummer){
				accountToReturn = accounts.get(i);
				break;
			}



		}




		return accountToReturn;
	}



	public String toString(){

		String toReturn = null;
		toReturn = personNummer + " " + fornamn + " " + efterNamn;



		return toReturn;
	}

	
	
	
	
	
	
	
	
}
