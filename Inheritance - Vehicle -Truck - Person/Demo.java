public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person("Jean", "Bartik", true);
        Person p2 = new Person("Leslie", "Lamport", true);
        Person p3 = new Person("Adi", "Shamir", true);
        Person p4 = new Person(p3);
        System.out.printf("Person 1: %s%n", p1);
        System.out.printf("Person 2: %s%n", p2);
        System.out.printf("Person 3: %s%n", p3);
        // vehicles manufactured
        Vehicle v1 = new Vehicle("Benvolio", "Cavaliere",.1);
        Truck t1 = new Truck("Abelard", "Ravageur", .3, 2.3, 12000);
        Vehicle v2 = new Vehicle(v1);
        // vehicles purchased
        v1.setOwner(p1);
        v2.setOwner(p2);
        t1.setOwner(p3);
        // emissions data after 3 months
        v1.checkEmissionsData(1140, 3600);
        v2.checkEmissionsData( 900, 2900);
        t1.checkEmissionsData(1500, 6000);
        // Person 4 lost their license.
        p4.lostLicense();
        // vehicle information after 3 months on the road
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(t1);
        // Does Person 3 still have their license?
        System.out.println(p3);
    }
}
