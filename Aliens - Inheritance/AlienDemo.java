public class AlienDemo {
    public static void main(String[] args) {
        AlienPack pack = new AlienPack(5);

        OgreAlien oa = new OgreAlien();
        SnakeAlien sa = new SnakeAlien();
        MarhmelloManAlien mma = new MarhmelloManAlien();

        System.out.println(oa);
        System.out.println(sa);
        System.out.println(mma+"\n");

        MarhmelloManAlien monea = new MarhmelloManAlien();
        MarhmelloManAlien mtwoa = new MarhmelloManAlien();

        pack.addAlien(oa,0);
        pack.addAlien(sa,1);
        pack.addAlien(mma,2);
        pack.addAlien(monea,3);
        pack.addAlien(mtwoa,4);

        System.out.print("Total Damage: ");
        System.out.println(pack.calculateDamage()+ "\n");
        System.out.println("My Pack: ");
        for(Alien x:pack.getAliens()){
            System.out.println(x);
        }

    }
}
