//Cesar Borrego | Transaction.java | October 9, 2020 | Holds variables and methods for Transaction class, used by Bank.java

public class Transaction {
    String[] myTypes = {"Account closed","deposit","withdrawal"};
    int accNumber;
    int myType;
    String myDate;
    double myBalance;

    Transaction(int num, int type, String date){
        accNumber = num;
        myType = type;
        myDate = date;
    }

    Transaction(int num, int type, double bal, String date){
        accNumber = num;
        myType = type;
        myBalance = bal;
        myDate = date;
    }

    public int getAccNumber(){return accNumber;}

    @Override
    public String toString(){
        String print;
        if(myType > 0) {
            print = String.format(" - Account Number: %d, %s ($%.2f), %s",
                    accNumber, myTypes[myType], myBalance, myDate);
        } else {
            print = String.format(" - Account Number: %d, %s, %s",
                    accNumber, myTypes[myType], myDate);
        }
        return print;
    }

}
