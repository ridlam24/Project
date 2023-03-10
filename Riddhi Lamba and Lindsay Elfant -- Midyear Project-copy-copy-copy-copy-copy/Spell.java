import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Spell extends Actor
{
    public int damage;
    /**
     * Act - do whatever the Spell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void setDamage(int d) {
        damage = d;
    }
    
    public boolean touching() {
        return isTouching(Wand.class);
    }

    public abstract int randomDamage();
}
