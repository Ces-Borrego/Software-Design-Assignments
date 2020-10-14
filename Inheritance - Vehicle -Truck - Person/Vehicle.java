//Cesar Borrego | October 14, 2020 | Homework 5 | Superclass Vehicle extended by Truck and used by demo.
public class Vehicle {
    String myMake;
    String myModel;
    double emissionData;
    Person myOwner; //One per vehicle

    public String getMake(){return myMake;}
    public String getModel(){return myModel;}
    public Person getOwner(){return myOwner;}

    public Vehicle(){
        myMake = "";
        myModel = " ";
        emissionData = 0.0;
    }

    public Vehicle(String make, String model, double epm){
        myMake = make;
        myModel = model;
        emissionData = epm;
    }

    public Vehicle(Vehicle v){
        myMake = v.myMake;
        myModel = v.myModel;
        emissionData = v.emissionData;
        myOwner = v.myOwner;
    }

    public void checkEmissionsData(int a, int b){
        emissionData = (double)a/(double)b;
    }

    public void setOwner(Person p){myOwner = p;}

    @Override
    public String toString(){
        String ans = "The " + myMake + " " + myModel + ", owned by " + myOwner.getFirst() + ", ";
        if(emissionData > 0.2){
            ans += "is not street legal, ";
        } else {
            ans += "is street legal, ";
        }
        ans += String.format("with emissions per mile of %.2f.",emissionData);
        return ans;
    }

}
