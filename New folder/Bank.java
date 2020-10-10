//Cesar Borrego | Bank.java | October 9, 2020 | Main class to run the back end of a bank organization program.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bank {
    Account[] myAccounts = new Account[30];
    Customer[] myCustomers = new Customer[30];
    ArrayList<Transaction> myTransactions = new ArrayList<>(100);
    String myName;
    int numCustomers = 0;
    int numAccounts = 0;
    int numTransactions = 0;

    Bank(String s ){
        myName = s;
    }

    public void readData(String fileName){
        try{
            File myFile = new File(fileName);
            Scanner readFile = new Scanner(myFile);
            while(readFile.hasNextLine()){
                int numData = readFile.nextInt();String trash = readFile.nextLine();
                for(int x = 0; x < numData; x ++){
                    String data = readFile.nextLine();
                    int inOne = 0, inTwo = 0, inThree = 0;
                    for(int y = 0; y < data.length(); y++){
                        if(data.charAt(y) == ','&& inOne == 0) inOne = y;
                        else if(data.charAt(y) == ','&& inOne != 0 && inTwo == 0) inTwo = y;
                        else if(data.charAt(y) == ','&& inOne != 0 && inTwo != 0 && inThree == 0) inThree = y;
                    }
                    if(data.length() > 35){
//                        System.out.println(inOne + " " + inTwo + " " + inThree + "done");
//                        System.out.println(data.substring(0, inOne));
//                        System.out.println(data.substring(++inOne, inTwo));
//                        System.out.println(Integer.parseInt(data.substring(++inTwo, inThree)));
//                        System.out.println(data.substring(++inThree, data.length()));
                        myCustomers[x] = new Customer(data.substring(0, inOne),
                                data.substring(++inOne, inTwo),
                                Integer.parseInt(data.substring(++inTwo, inThree)),
                                data.substring(++inThree));
                        numCustomers++;
                    } else {
                        int type; String ssn;
//                        System.out.println(inOne + " " + inTwo + " " + inThree + " done!");
//                        System.out.println(data.substring(0,inOne));
//                        System.out.println(Integer.parseInt(data.substring(++inOne, inTwo)));
//                        System.out.println(Integer.parseInt(data.substring(++inTwo, inThree)));
//                        System.out.println(Double.parseDouble(data.substring(++inThree,data.length())));
                        myAccounts[x] = new Account(ssn = data.substring(0,inOne),
                                    Integer.parseInt(data.substring(++inOne, inTwo)),
                                    type = Integer.parseInt(data.substring(++inTwo, inThree))-1,
                                    Double.parseDouble(data.substring(++inThree)));
                        numAccounts++;
                        for(int i = 0; i < numCustomers; i++){
                            if(myCustomers[i].getMySsn().equals(ssn)) {
                                if(type == 1)myCustomers[i].openChecking();
                                if(type == 2)myCustomers[i].openSavings();
                            }
                        }
                    }
                }
            }
            readFile.close();
        } catch (FileNotFoundException e){
            System.out.println("File error occurred.");
            e.printStackTrace();
        }
    }

    public void bankInfo(){
        double totalBalance = 0.0;
        System.out.printf("Bank Name: %s\n", myName);
        System.out.printf("Number of Customers: %d\n", numCustomers);
        for(int x = 0; x < numCustomers; x++){
            if(myCustomers[x]!= null)System.out.print("\t"+myCustomers[x]+"\n");
        }
        System.out.printf("Number of Accounts: %d\n", numAccounts);
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x]!=null) {
                System.out.print("\t" + myAccounts[x] + "\n");
                totalBalance += myAccounts[x].getBalance();
            }
        }
        System.out.printf("Total Balance: $%.2f\n", totalBalance);
    }

    public void accountInfo(int num){
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x]!=null&&myAccounts[x].getAccNumber() == num) {
                myAccounts[x].printInfo();
                for(int i = 0; i < numCustomers; i++){
                    if(myAccounts[x].getCustomerSsn().equals(myCustomers[i].getMySsn())){
                        System.out.println(myCustomers[i].getMyName());
                    }
                }
                return;
            }
        }
        System.out.printf("Account (%d) does not exist.\n",num);
    }

    public void deposit(int num, double bal){
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x]!=null&&myAccounts[x].getAccNumber() == num) {
                myAccounts[x].deposit(bal);
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
                String formatDateTime = now.format(formatter);
                myTransactions.add(new Transaction(num, 1, bal, formatDateTime)); numTransactions++;
                return;
            }
        }
        System.out.printf("Account (%d) does not exist.\n", num);
    }

    public void withdraw(int num, double bal){
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x]!=null&&myAccounts[x].getAccNumber() == num) {
                myAccounts[x].withdraw(bal);
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
                String formatDateTime = now.format(formatter);
                myTransactions.add(new Transaction(num, 2, bal, formatDateTime)); numTransactions++;
                return;
            }
        }
        System.out.printf("Account (%d) does not exist.\n", num);
    }

    public void newCustomer(String name, String addy, int zip, String ssn){
        for(int x = 0; x < numCustomers; x++){
            if(myCustomers[x]!=null&&myCustomers[x].getMySsn().equals(ssn)){
                System.out.printf("%s is NOT added - Duplicated SSN.\n",name); return;
            }
        }
        System.out.printf("%s is added.\n",name);
        for(int x = 0; x < numCustomers; x++){
            if(myCustomers[x]==null){
                myCustomers[x] = new Customer(name, addy, zip, ssn);
                numCustomers++; return;
            }
        }
        myCustomers[numCustomers] = new Customer(name, addy, zip, ssn);
        numCustomers++;
    }

    public void newAccount(String ssn, int num, int type, double bal){
        for(int x = 0; x < numCustomers; x++){
            if(myCustomers[x]!=null&&ssn.equals(myCustomers[x].getMySsn())){
//                System.out.printf("%B",myCustomers[x].hasChecking());
                if(type == 1 && myCustomers[x].hasChecking()){
                    System.out.printf("Account creation failed - %s (%s) already has a checking account\n",
                            myCustomers[x].getMyName(), myCustomers[x].getMySsn()); return;
                } else if(type == 2 && myCustomers[x].hasSavings()){
                    System.out.printf("Account creation failed - %s (%s) already has a savings account\n",
                            myCustomers[x].getMyName(), myCustomers[x].getMySsn()); return;
                }
            }
        }
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x]!=null&&num == myAccounts[x].getAccNumber()){
                System.out.printf("Account creation failed - Account %d already exists\n", num);
                return;
            }
        }
        boolean f = true;
        for(int x = 0; x < numAccounts-1; x++){
            if(myAccounts[x] == null){
                myAccounts[x] = new Account(ssn, num, type, bal);
                numAccounts++; f = false;
            }
        }
        if(f){
            myAccounts[numAccounts] = new Account(ssn, num, type, bal);
            numAccounts++;
        }
        for (int x = 0; x < numCustomers; x++) {
            if (myCustomers[x].getMySsn().equals(ssn)) {
                if (type == 1) myCustomers[x].openChecking();
                if (type == 2) myCustomers[x].openSavings();
                System.out.printf("Account created - Number: %d, Customer: %s\n",
                        num, myCustomers[x].getMyName());
                return;
            }
        }

    }

    public boolean closeAccount(int num){
        for(int x = 0; x < numAccounts; x++){
            if(myAccounts[x].getAccNumber() == num) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
                String formatDateTime = now.format(formatter);
                myTransactions.add(new Transaction(num, 0, formatDateTime));
                numTransactions++;
                for(int i = 0; i < numCustomers; i++){
                    if(myCustomers[i].getMySsn().equals(myAccounts[x].getCustomerSsn())){
                        if(myAccounts[x].getType() == 0)myCustomers[i].closeChecking();
                        if(myAccounts[x].getType() == 1)myCustomers[i].closeSavings();
                    }
                }
                myAccounts[x] = null;
                return true;
            }
        }
        return false;
    }

    public void transaction(int num){
        boolean f = true;
        for(int x = 0; x < numTransactions; x++){
            if(myTransactions.get(x).getAccNumber() == num) {
                System.out.println(myTransactions.get(x));
                f = false;
            }
        }
        if(f)System.out.printf(" - No transaction info for account %d\n",num);
    }

    public void customerInfoWithSSN(int num){
        boolean t = true, f = true;
        for(int x = 0; x < numCustomers; x++){
            if(num == Integer.parseInt(myCustomers[x].getMySsn().substring(7))){
                myCustomers[x].printInfo();
                for(int i = 0; i < numAccounts; i++) {
                     if (myAccounts[i]!=null&&myAccounts[i].getCustomerSsn().equals(myCustomers[x].getMySsn())) {
                     System.out.printf("\t%s (%d), $%.2f\n",
                             myAccounts[i].getSType(),
                             myAccounts[i].getAccNumber(),
                             myAccounts[i].getBalance());
                     f = false;
                     }
                }
                t = false;
            }
        }
        if(f)System.out.print("\tNo account");
        if(t)System.out.printf("No customer with %d", num);
    }

    public void removeCustomer(String ssn){
        boolean f = true;
        for(int x = 0; x < numCustomers; x++){
            if(myCustomers[x].getMySsn().equals(ssn)){
                System.out.printf("Customer Remove - SSN: %s, Customer: %s\n",myCustomers[x].getMySsn(),myCustomers[x].getMyName());
                if(myCustomers[x].hasChecking() || myCustomers[x].hasSavings()) {
                    for(int i = 0; i < numAccounts; i++){
                        if(myAccounts[i] != null && ssn.equals(myAccounts[i].getCustomerSsn())){
                            System.out.printf("\tAccount closed - Number: %d, Balance: $%.2f\n",
                                    myAccounts[i].getAccNumber(), myAccounts[i].getBalance());
                            if(myAccounts[i].getType() == 0) myCustomers[x].closeChecking();
                            if(myAccounts[i].getType() == 1) myCustomers[x].closeSavings();
                            myAccounts[i] = null; numAccounts--;
                        }
                        f = false;
                    }
                }
                myCustomers[x] = null; numCustomers--;
            }
        }
        if(f)System.out.print("Customer remove failed. SSN does not exist.\n");
    }

}
