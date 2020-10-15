public class OgreAlien extends Alien{
    public final int damage = 6;

    public OgreAlien(){
        super(100, "Ogre ALien");
    }

    @Override
    public int getDamage(){return damage;}

    @Override
    public String toString(){
        return super.name + ": Damge - " + damage;
    }
}
