package dalmar9.Uppgift_5.BankSystem;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Account implements Serializable {

	
	//Variabler
	
	private int saldo;
	private float räntesats = 1.2f;
	private int kontoNummer;
	public String kontotyp = "";
	public static int numberOfAccounts;

	//For Savings Account
	private boolean firstTake;
	
	//For CreditAccount
	private int kreditGräns = 5000;
	private final float  kreditRänta = 0.5f;
	private final float skuldRänta = 7.0f;


	public ArrayList<Transaction> transactions;




	public Account() {
		
		if (numberOfAccounts == 0) {
			numberOfAccounts = 1001;
		}else {
			numberOfAccounts++;
		}
		
		
		kontoNummer = numberOfAccounts;
		transactions = new ArrayList<Transaction>();

		firstTake = false;
		
	}
	
	
	
	//Getters and Setters
	public float getRäntesats() {
		return räntesats;
	}

	public void setRäntesats(int räntesats) {
		this.räntesats = räntesats;
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

	public abstract boolean setAccountType();


	public boolean getFirstTake(){
		return firstTake;
	}

	public void setFirstTakeTrue(){
		firstTake = true;
	}



	//For CreditAccount
	public int getCreditMax(){
		return kreditGräns;
	}

	public float getKreditRänta(){
		return kreditRänta;
	}

	public float getSkuldRänta(){
		return skuldRänta;
	}

	public int setKreditMax(int amount){

		kreditGräns = amount;

		return kreditGräns;

	}


	public void addTransaction(String pNo, int accountId, String action, Account account, int amount){

		transactions.add(new Transaction(pNo, accountId, action, account, amount));



	}





	
	
	
	
	
}

