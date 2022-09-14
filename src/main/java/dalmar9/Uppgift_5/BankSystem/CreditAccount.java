package dalmar9.Uppgift_5.BankSystem;

public class CreditAccount extends Account{

    public CreditAccount(){
        super();
    }

    @Override
    public boolean setAccountType() {

        this.kontotyp = "KreditKonto";

        return true;
    }


}
