public class SnakeAlien extends Alien {
    public final int damage = 10;

    public SnakeAlien(){
        super(100,"Snake Alien");
    }

    @Override
    public int getDamage(){return damage;}

    @Override
    public String toString(){
        return super.name + ": Damge - " + damage;
    }
}
