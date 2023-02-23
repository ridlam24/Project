import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hazel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hazel extends DragonHeartstring
{
    /**
     * Act - do whatever the Hazel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        setImage(image);
        turn(-45);
    }
}
