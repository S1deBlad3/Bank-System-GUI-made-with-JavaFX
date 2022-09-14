package dalmar9.Uppgift_5.BankSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

	
	
	//Variables
	private String förNamn, efterNamn;
	private String personNummer;
	public static int UniqueID;
	public int UniqueID_2;
	public ArrayList<Account> accounts;

	
	
	
	
	
	public Customer(String förnamn, String efternamn, String personNumber) {
		this.förNamn = förnamn;
		this.efterNamn = efternamn;
		this.personNummer = personNumber;
		
		accounts = new ArrayList<Account>();

		
		
		if (UniqueID == 0) {
			
			UniqueID = 1001;
			
		}else {
			UniqueID++;
		}
		
		
		UniqueID_2 = UniqueID;
		
		
		
		//accounts.add(new Account());
		
		
	}
	
	
	
	
	
	
	//Getters and setters
	public String getFörNamn() {
		return förNamn;
	}
	public void setFörNamn(String förNamn) {
		this.förNamn = förNamn;
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
	
	
	public void addAccount() {


		accounts.add(new SavingsAccount());
	
	}


	public void addCreditAccount(){
		accounts.add(new CreditAccount());
	}
	
	
	public void removeAccount(int index) {
		
		
		accounts.remove(index);
		
		
		
		
	}










	
	
	
	
	
	
	
	
	
	
}
