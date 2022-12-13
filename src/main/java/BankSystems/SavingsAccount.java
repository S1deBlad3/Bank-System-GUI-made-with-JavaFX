package BankSystems;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class SavingsAccount extends Account{


    private BigDecimal withdrawRent = new BigDecimal("0.02");
    private boolean firstTake;


    public SavingsAccount(){
        super();
        setAccountType();
        firstTake = false;
    }






    @Override
    public void setAccountType() {
        kontotyp = "Sparkonto";
    }

    @Override
    public boolean deposit(String pNo, int accountId, int amount) {

                saldo += amount;
                addTransaction(amount);

        return true;
    }

    @Override
    public boolean withdraw(String pNo, int accountId, int amount) {













                if (!firstTake){

                    if (saldo - amount <= 0){
                        return false;
                    }



                    saldo -= amount;
                    addTransaction(-amount);
                    firstTake = true;

                }else{

                    if (saldo - (amount * (1 + withdrawRent.floatValue())) <= 0){
                        return false;
                    }

                    saldo -= amount * (1 + withdrawRent.floatValue());
                    addTransaction(-amount);

                }















        return true;
    }


    public String toString(){
        String toReturn = null;

        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(saldo);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
        percentFormat.setMaximumFractionDigits(1);
        String percentStr = percentFormat.format(rent.floatValue() / 100);

        toReturn = kontoNummer + " " + balanceStr + " " + kontotyp + " " + percentStr;



        return toReturn;
    }

    public String closeAccountString(){

        BigDecimal rentPaidBig = new BigDecimal(saldo * rent.floatValue() / 100);


        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                .format(saldo);
        String percentFormat = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(rentPaidBig);


        return kontoNummer + " " + balanceStr + " " + "Sparkonto " + percentFormat;

    }


    @Override
    public void addTransaction(int amount) {



        if (firstTake){
            float rent = amount * withdrawRent.floatValue();
            amount += rent;
        }

        transactions.add(new Transactions(amount, this).toString());
      

    }
}
