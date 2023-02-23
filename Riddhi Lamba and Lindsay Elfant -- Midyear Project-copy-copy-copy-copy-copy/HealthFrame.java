import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthFrame extends Actor
{
    /**
     * Act - do whatever the HealthFrame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HealthFrame() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/10);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
