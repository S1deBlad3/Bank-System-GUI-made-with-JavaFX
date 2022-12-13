package BankSystems;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CreditAccount extends Account{


    private int creditLimit = 5000;
    private int usedCredit = 0;
    private BigDecimal nonCreditRent = new BigDecimal("0.5");
    private BigDecimal debtCredit = new BigDecimal("7.0");
    private boolean inDebt;


    public CreditAccount(){
        super();
        setAccountType();

    }



    @Override
    public void setAccountType() {
    kontotyp = "Kreditkonto";
    }

    @Override
    public boolean deposit(String pNo, int accountId, int amount) {


                    if (usedCredit <= 0) {
                        usedCredit -= amount;
                    }


                    saldo += amount;
                    addTransaction(amount);

                    if (saldo >= 0) inDebt = false;


    return true;

    }

    @Override
    public boolean withdraw(String pNo, int accountId, int amount) {


                if (saldo - amount <= -creditLimit) {
                return false;
                }

                    saldo -= amount;
                    addTransaction(-amount);
                    usedCredit += amount;


                if (saldo < 0) inDebt = true;












        return true;
        }




    public String toString(){

        BigDecimal something = null;

        if (inDebt){
            something = debtCredit;
        } else if (!inDebt) {
            something = nonCreditRent;
        }


        String toReturn = null;

        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(saldo);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv", "SE"));
        percentFormat.setMaximumFractionDigits(1);
        String percentStr = percentFormat.format(something.floatValue() / 100);

        toReturn = kontoNummer + " " + balanceStr + " " + kontotyp + " " + percentStr;



        return toReturn;
    }

    public String closeAccountString(){

        BigDecimal something = null;

        if (inDebt){
            something = debtCredit;
        } else if (!inDebt) {
            something = nonCreditRent;
        }


        float interestToPay = (float) saldo * (something.floatValue() / 100);


        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE"))
                .format(saldo);
        String percentFormat = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(interestToPay);



        return kontoNummer + " " + balanceStr + " " + kontotyp + " " + percentFormat;

    }


    @Override
    public void addTransaction(int amount) {

        transactions.add(new Transactions(amount, this).toString());

    }
}
