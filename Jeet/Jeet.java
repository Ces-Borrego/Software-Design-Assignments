/*
* Cesar Borrego | Homework 3 - CST338 | September 14,2020
* Abstract: Write complete Jeet class to work seamlessly with JitterDemo.java and JitterDate.java. Running JitterDemo
* should output every Jeet including its private member variable in the correct order.
*/

public class Jeet {
    private String favEmote;
    private String fullName;
    private String userName;
    private boolean verified;
    private String myEntry;
    private JitterDate myDate;
    public static int numJeets = 0;
    public static int numFakeJeets = 0;

    Jeet(){
        favEmote = "-_-";
        fullName = "Default Input";
        userName = "defaultuser";
        verified = false;
    }
    Jeet(String emote, String name, String user, boolean ver){
        favEmote = emote;
        fullName = name;
        userName = user;
        verified = ver;
        numJeets++;
    }
    void setJeet(String text){
        myEntry = text;
        if(myEntry.length() > 140){
            myEntry = myEntry.substring(0,137) + "...";
        }
    }
    void setDate(JitterDate date){myDate = date;}
    void plagiarismCheck(Jeet j){
        boolean sameDate = myDate.getDay() == j.myDate.getDay() && myDate.getMonth() == j.myDate.getMonth() && myDate.getYear() == j.myDate.getYear();
        if(this.myEntry.equals(j.myEntry) && sameDate){
            myEntry = "[Plagiarism Detected. Text removed.]";
            numFakeJeets++;
            numJeets--;
        }
    }
    static int getNumJeets(){return numJeets;}
    static int getNumFakeJeets(){return numFakeJeets;}

    @Override
    public String toString(){
        return favEmote + " " + fullName + " " + (verified ? " ✓ @" : "   @" ) + userName + "\n" + myEntry +
                "\n" + myDate + "\n";
    }
}

