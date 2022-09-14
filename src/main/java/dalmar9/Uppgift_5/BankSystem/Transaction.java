package dalmar9.Uppgift_5.BankSystem;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction implements Serializable {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String timeAndDate;
    private String transaction;






    public Transaction(String pNo, int accountId, String action, Account account, int amount){

        String strDate = sdf.format(new Date());

        timeAndDate = strDate;
        transaction = "";

        addToTransaction(action, account, amount);




    }

    public String getTimeAndDate(){
        return timeAndDate;
    }


    public void addToTransaction(String action, Account account, int amount){


        String balanceStr = NumberFormat.getCurrencyInstance(new Locale("sv",
        "SE")).format(account.getSaldo());

        String amountStr = NumberFormat.getCurrencyInstance(new Locale("sv", "SE")).format(amount);


        NumberFormat percentFormat = NumberFormat.getPercentInstance(new Locale("sv",
        "SE"));
         percentFormat.setMaximumFractionDigits(1);
         String percentStr =
         percentFormat.format(account.getRäntesats() / 100);



    transaction += timeAndDate + " " + action + amountStr + " Saldo: " + balanceStr;



    }

    public String getTransaction(){
        return transaction;
    }








}
