import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Expelliarmus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Expelliarmus extends Offensive
{
    public Expelliarmus() {
        setDamage(-12);
        getImage().scale(getImage().getWidth()/5, getImage().getHeight()/5);
    }
    
    /**
     * Act - do whatever the Expelliarmus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public int randomDamage() {
        return damage; 
    }
}
