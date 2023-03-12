import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Protego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Protego extends Defensive
{
    public Protego() {
        setDamage(15);
        getImage().scale(getImage().getWidth()/12, getImage().getHeight()/12);
    }
    
    /**
     * Act - do whatever the Protego wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public int getRandomNumber() {
        return damage; 
    }
    
    public int randomDamage() {
        int random = Greenfoot.getRandomNumber(3); 
        if (random == 0) {
            return -15; 
        } else {
            return 22; 
        }
    }

}
