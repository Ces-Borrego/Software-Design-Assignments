/*
* Cesar Borrego | September 25, 2020 | Homework 4: VendingMachine.java | Abstract: Vending Machine controlled
* by VendingMachineDemo.java and that can perform basic vending machine actions and memory tracking.
* */
import java.util.Scanner;

public class VendingMachine {
    private  final String[] contents = {"Water", "Coffee", "Chips", "Chocolate Bar"};
    private int[] contentStock = new int[4];
    private final double[] contentPrice = {1.50, 2.00, 1.00, 2.50};
    private int[] myOrder = new int[4];
    private int[] itemsSold = new int[4];
    private double myTotal = 0.0;
    private double myTotalTax = 0.0;
    private double Earnings = 0.0;
    private int myID;
    private String myLocation;

    public VendingMachine(){
        myID = 000;
        myLocation = "UNKNOWN";
    }

    public VendingMachine(int id){
        myID = id;
        myLocation = "UNKNOWN";
    }

    public VendingMachine(int id, String loc) {
        myID = id;
        myLocation = loc;
    }

    public void setName(int s){
        myID = s;
    }

    public void setLocation(String s){
        myLocation = s;
    }

    public void reset(int a, int b, int c, int d){
        contentStock[0] = a;
        contentStock[1] = b;
        contentStock[2] = c;
        contentStock[3] = d;
        System.out.print(this);
    }

    public void addItems(int a, int b, int c, int d){
        contentStock[0] += a;
        contentStock[1] += b;
        contentStock[2] += c;
        contentStock[3] += d;
    }

    public void displayMenu(){
        System.out.println("===== Vending Machine Menu =====");
        System.out.println(0 + ". " + contents[0] + "............$" + contentPrice[0] + 0);
        System.out.println(1 + ". " + contents[1] + "...........$" + contentPrice[1] + 0);
        System.out.println(2 + ". " + contents[2] + "............$" + contentPrice[2] + 0);
        System.out.println(3 + ". " + contents[3] + "....$" + contentPrice[3] + 0);
    }

    public void buyItem(){
        Scanner in = new Scanner(System.in);
        System.out.println("Select an item number: ");
        int a = in.nextInt();
        System.out.println("How many do you want to buy? ");
        int b = in.nextInt();
        System.out.println("You selected " +  contents[a-1] + ". Quantity: " + b);

        if(contentStock[a-1] >= b) {
            myOrder[a - 1] += b;
        } else {
            System.out.println("Selection Failed. We don't have enough " + contents[a - 1]);
        }
    }

    public boolean buyItem(int x, int y){
        System.out.println("Select an item number: "+x);
        System.out.println("How many do you want to buy? "+y);
        System.out.println("You selected " +  contents[x-1] + ". Quantity: " + y);

        if(contentStock[x-1] >= y) {
            myOrder[x - 1] += y;
            return true;
        } else {
            System.out.println("Selection Failed. We don't have enough " + contents[x - 1]);
            return false;
        }

    }

    public void returned(int x, int y){
        System.out.println("You selected " + contents[x-1] + ". Quantity: " + y);
        if(myOrder[x-1] >= y){
            myOrder[x - 1] -= y;
        }
    }

    public void orderClear(){
        for(int x = 0; x < 4; x++){
            myOrder[x] = 0;
        }
        myTotal = 0.0;
        myTotalTax = 0.0;
    }

    public boolean payment(){
        Scanner in = new Scanner(System.in);
        double money;
        System.out.print("Enter money amount: $"); money = in.nextDouble();

        for(int x = 0; x < 4; x++){
            if(myOrder[x] != 0){
                myTotal += myOrder[x] * contentPrice[x];
            }
        }
        myTotalTax += (myTotal * 0.10) ; //tax
        System.out.print(myTotalTax + " " + myTotal);
        if(money >= myTotal+myTotalTax){
            double diff = money - (myTotal+myTotalTax);
            System.out.printf("\nSufficient money. $%.2f returned.\n", diff);
            return true;
        } else {
            System.out.printf("\nInsufficient money. $%.2f  returned.\n", money);
            myTotal = 0.0; myTotalTax = 0.0;
            return false;
        }
    }

    public void displayReceipt(){
        for(int x = 0; x < 4; x ++){
            if(myOrder[x] != 0){
                System.out.printf("%s: $%.2f X %d = $%.2f\n", contents[x], contentPrice[x], myOrder[x],
                        (contentPrice[x]*myOrder[x]));
            }
        }
        System.out.print("Tax (10.0%): "); System.out.printf("$%.2f\n", myTotalTax);
        System.out.printf("Total: $%.2f", myTotal+= myTotalTax);

        for(int x = 0; x < 4; x ++){
            itemsSold[x] += myOrder[x];
            contentStock[x] -= myOrder[x];
        }
        Earnings += myTotal;

        this.orderClear();
    }

    public void status(){
        System.out.println("Serial Number: " + myID);
        System.out.println("Location: " + myLocation);
        System.out.println("Sold Items: ");
        for(int x = 0; x < 4; x++){
            System.out.println("\t" + contents[x] + ": " + itemsSold[x]);
        }
        System.out.println("Current Contents: ");
        for(int x = 0; x < 4; x++){
            System.out.println("\t" + contents[x] + ": " + contentStock[x]);
        }
        System.out.printf("Total Earnings: $%.2f", Earnings );
    }

    @Override
    public String toString(){
        String str = "Serial Number: " + myID + "\nLocation: " + myLocation + "\nContents: \n";
        for(int x = 0; x < 4; x++){
            str += "\t" + contents[x] + ": " + contentStock[x] + "\n";
        }
        return str;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        else if(!(obj instanceof VendingMachine)) return false;
        VendingMachine v = (VendingMachine) obj;
        return v.myID == myID && v.myLocation.equals(myLocation);
    }
}


