//Cesar Borrego | Customer.java | October 9, 2020 | Holds variables and methods for Customer class, used by Bank.java

public class Customer {
    int myAccounts = 0;
    boolean hasSavings;
    boolean hasChecking;
    String myName;
    String myAddress;
    int myZip;
    String mySsn;

    Customer(String name, String addy, int zip, String ssn){
        myName = name;
        myAddress = addy;
        myZip = zip;
        mySsn = ssn;
    }

    public void printInfo(){
        System.out.printf("Name: %s\n", myName);
        System.out.print("\t" + myAddress + "\n");
        System.out.printf("\tSSN: %s\n",mySsn);
    }

    public void openSavings(){hasSavings = true;}
    public void openChecking(){hasChecking = true;}
    public void closeSavings(){hasSavings = false;}
    public void closeChecking(){hasChecking = false;}
    public boolean hasSavings(){return hasSavings;}
    public boolean hasChecking(){return hasChecking;}
    public String getMySsn(){return mySsn;}
    public String getMyName(){return myName;}

    @Override
    public String toString(){
       return myName + ": " + mySsn;
    }
}
