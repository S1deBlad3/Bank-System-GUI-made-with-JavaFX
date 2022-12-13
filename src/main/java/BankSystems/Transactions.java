package BankSystems;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transactions {


    private String transaction;
    private Account specificAccount;
    private int amount;


    public Transactions(int amount, Account specificAccount){



        this.specificAccount = specificAccount;
        this.amount = amount;





    }


    @Override
    public String toString() {


        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(specificAccount.saldo);
        String amountStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(amount);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(new Date());

        transaction = strDate + " " + amountStr + " " + "Saldo:" + " " + balanceStr;




        return transaction;
    }




}
