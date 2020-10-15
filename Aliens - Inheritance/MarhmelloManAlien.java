public class MarhmelloManAlien extends Alien{
    public final int damage = 1;

    public MarhmelloManAlien(){
        super(100,"Marshmello Man Alien");
    }

    @Override
    public int getDamage(){return damage;}

    @Override
    public String toString(){
        return super.name + ": Damge - " + damage;
    }
}
