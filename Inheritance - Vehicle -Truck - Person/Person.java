//Cesar Borrego | October 14, 2020 | Homework 5 | Person class used by Demo.
public class Person {
    String fName;
    String lName;
    boolean hasLicense;

    public String getFirst(){return fName;}
    public String getLast(){return lName;}

    public void lostLicense(){
        hasLicense = false;
    }

    public Person(){
        fName = " ";
        lName = " ";
        hasLicense = false;
    }

    public Person(String name, String last, boolean license){
        fName = name;
        lName = last;
        hasLicense = license;
    }

    public Person(Person p){
        fName = p.fName;
        lName = p.lName;
        hasLicense = p.hasLicense;
    }

    @Override
    public String toString(){
        if(hasLicense) return String.format("%s %s has a driver's license.", fName, lName);
        else return String.format("%s %s does not have a driver's license.", fName, lName);
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Person)){
            return false;
        }
        Person p = (Person)o;
        return fName.equals(p.fName) &&  lName.equals(p.lName) && hasLicense == p.hasLicense;
    }

}
