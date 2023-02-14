import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Health() {
        GreenfootImage image = getImage();
        image.scale(new HealthFrame().getImage().getWidth(), new HealthFrame().getImage().getHeight());
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
