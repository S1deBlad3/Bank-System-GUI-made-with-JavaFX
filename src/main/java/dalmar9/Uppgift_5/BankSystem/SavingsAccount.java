package dalmar9.Uppgift_5.BankSystem;

public class SavingsAccount  extends Account{



    public SavingsAccount(){
        super();

    }

    @Override
    public boolean setAccountType() {

        this.kontotyp = "SparKonto";

        return true;
    }




}
