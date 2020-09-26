/*
 * Cesar Borrego | September 25, 2020 | Homework 4: Account.java | Abstract: Account class that is used by Bank class
 * and contains a Customer variable.
 * */

public class Account {
    int accNum;
    int accType;
    Customer accountHolder;
    double balance;

    Account(int num, int type, String name, int ssn, String address, double bal){
        accNum = num;
        accType = type;
        balance = bal;
        accountHolder = new Customer(name, ssn, address);
    }

    public int getNum(){return accNum;}
    public int getType(){return accType;}
    public double getBalance(){return balance;}
    public void setBalance(double newBal){balance = newBal;}
    public Customer getAccountHolder(){return accountHolder;}
}
