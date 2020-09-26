/*
* Cesar Borrego | September 25, 2020 | Homework 4: Customer.java | Abstract: Customer class that contains three variables
* and their respective getter and setter methods.
* */

public class Customer {
    String name;
    int ssn;
    String address;

    Customer(String n, int s, String a){
        name = n;
        ssn = s;
        address = a;
    }

    public String getName(){ return name;}
    public int getSsn(){return ssn;}
    public String getAddress(){return address;}
    public void setAddress(String newAddy){address = newAddy;}
}
