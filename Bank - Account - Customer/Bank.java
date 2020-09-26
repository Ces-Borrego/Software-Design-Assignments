/*
* Cesar Borrego | September 25, 2020 | Homework 4: Bank.java | Abstract: Bank class that uses Accounts and Customer
* classes to run and contain proper bank methods and variables.
* */

public class Bank {
    String name;
    Account[] accounts = new Account[5];
    String[] types = {"Savings Account", "Checking Account"};
    int numAccounts = 0;
    double totalBalance = 0.0;

    Bank(String s){
        name = s;
    }

    public boolean openAccount(String name, String addr, int ssn, int accNum, int accType, double balance){
        if(numAccounts == 5) {
            return false;
        } else {
            for (int x = 0; x < 5; x++) {
                if (accNum == accounts[x].getNum()) {
                    return false;
                } else if (ssn == accounts[x].getAccountHolder().getSsn()) {
                    return false;
                } else if (accounts[x] == null) {
                    accounts[x] = new Account(accNum, accType, name, ssn, addr, balance);
                    numAccounts++;
                }
            }
            totalBalance += balance;
            return true;
        }
    }

    public boolean updateBalance(int accNum, double newBalance){
        for(int x = 0; x < 5; x++){
            if(accNum == accounts[x].getNum()){
                if(newBalance >= 0.0){
                    accounts[x].setBalance(newBalance);
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public boolean closeAccount(int accNum){
        for(int x = 0; x < 5; x++){
            if(accounts[x].getNum() == accNum){
                accounts[x] = null;
                numAccounts--;
                return true;
            }
        }
        return false;
    }

    public boolean accountInfo(int accNum){
        for(int x = 0; x < 5; x++){
            if(accounts[x].getNum() == accNum){
                System.out.print("Account Info:");
                System.out.printf("Account Number: %d\n", accounts[x].getNum());
                System.out.printf("\t\t %s\n", types[accounts[x].getType()]);
                System.out.printf("\t\tBalance: $%.2f \n", accounts[x].getBalance());
                System.out.printf("Customer:\t %s\n", accounts[x].getAccountHolder().getName());
                System.out.printf("\t\t%s\n", accounts[x].getAccountHolder().getAddress());
                System.out.printf("\t\tSSN: %d\n", accounts[x].getAccountHolder().getSsn());
                return true;
            }
        }
        return false;
    }

    public boolean updateAddress(int accNum, String addr){
        for(int x = 0; x < 5; x++){
            if(accounts[x].getNum() == accNum){
                accounts[x].getAccountHolder().setAddress(addr);
                return true;
            }
        }
        return false;
    }

    public void bankInfo(){
        System.out.printf("Bank Name: %s\n", name);
        System.out.printf("Number of Accounts: %d\n", numAccounts);
        for(int x = 0; x < 5; x++){
            if(accounts[x] != null){
                System.out.printf("\t%d: $%.2f - %s: %d\n", accounts[x].getNum(), accounts[x].getBalance(),
                        accounts[x].getAccountHolder().getName(), accounts[x].getAccountHolder().getSsn());
            }
        }

        System.out.printf("Bank Total Balance: $%.2f\n", totalBalance);
    }
}
