import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laurel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laurel extends PhoenixTailFeather
{
    private GreenfootImage image;
    
    /**
     * Act - do whatever the Laurel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()/8, image.getHeight()/8);
        setImage(image);
        turn(-45);
    }
}
