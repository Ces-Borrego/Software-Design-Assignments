public abstract class Alien {
    public int health; // 0=dead, 100=full strength
    public String name;

    public Alien(){
        health = 100;
        name = "ALIEN";
    }

    public Alien(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public abstract int getDamage();
}
