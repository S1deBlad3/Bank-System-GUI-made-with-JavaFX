
/*
@autor Marius Daldorff Pedersen, dalmar-9
 */


package Utility;

public class UtilityClass {




    public static int accountIndex;
    public static int index;

    //this function gets the accountIndex
    public static int getAccountIndex() {
        return accountIndex;
    }

    //This function sets the accountIndex number @param - the number from the selection
    public static void setAccountIndex(int index) {
        accountIndex = index;
    }

    //returns the index of the combobox
    public static int getIndex() {
        return index;
    }

    //sets the index of the combobox
    public static void setIndex(int num) {
        index = num;
    }




}
