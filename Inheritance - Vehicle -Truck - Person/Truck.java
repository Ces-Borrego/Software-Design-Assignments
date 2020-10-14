//Cesar Borrego | October 14, 2020 | Homework 5 | Subclass to Vehicle and used by demo. Specific vehicle.
public class Truck extends Vehicle{
    double loadCapacity; //In Tons
    int towingCapacity; //In pounds

    public double getLoadCapacity(){return loadCapacity;}
    public int getTowingCapacity(){return towingCapacity;}

    public Truck(){
        super();
        loadCapacity = 0.0;
        towingCapacity = 0;
    }

    public Truck(String make, String model, double epm,double lc, int tc){
        super(make, model, epm);
        loadCapacity = lc;
        towingCapacity = tc;
    }

    @Override
    public String toString(){
        String ans = "The " + super.myMake + " " + super.myModel + ", owned by " + super.myOwner.getFirst() + ", ";
        if(emissionData > 0.4){
            ans += "is not street legal, ";
        } else {
            ans += "is street legal, ";
        }
        ans += String.format("with emissions per mile of %.2f.",super.emissionData);
        return ans;
    }
}
