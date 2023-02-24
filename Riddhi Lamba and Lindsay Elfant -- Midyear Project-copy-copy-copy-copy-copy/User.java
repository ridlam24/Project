import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Wizard
{
    private Health health = new Health();
        
    public User() {
        
    }
    
    /**
     * Act - do whatever the User wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        ((MyWorld) getWorld()).addObject(health, 138, 70);
    }
    
    public void addWand() {
        ((MyWorld) getWorld()).addObject(wand, getX()+getImage().getWidth(), getY()-getImage().getHeight()/2);
    }
}
