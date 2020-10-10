//Cesar Borrego | Account.java | October 9, 2020 | Holds variables and methods for Account class, used by Bank.java

public class Account {
    String customerSsn;
    int accNumber, myType;
    double myBalance;
    String[] accountTypes = {"Checking", "Savings"};

    Account(String ssn, int num, int type, double balance){
        customerSsn = ssn;
        accNumber = num;
        myBalance = balance;
        myType = type;
    }

    public void printInfo(){
        System.out.printf(" - Number: %d\n",accNumber);
        System.out.printf(" - %s\n",accountTypes[myType]);
        System.out.printf(" - Balance: $%.2f\n",myBalance);
        System.out.print(" - Customer: ");
    }

    public int getType(){return myType;}
    public String getSType(){return accountTypes[myType];}

    public void deposit(double bal){
        myBalance += bal;
    }

    public void withdraw(double bal){
        myBalance -= bal;
    }

    public int getAccNumber(){ return accNumber;}
    public String getCustomerSsn(){return customerSsn;}
    public double getBalance(){return myBalance;}

    @Override
    public String toString(){
        return String.format("%d: $%.2f",accNumber,myBalance);
    }
}
