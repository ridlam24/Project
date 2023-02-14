import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hornbeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hornbeam extends UnicornHair
{
    private GreenfootImage image;
    /**
     * Act - do whatever the Hornbeam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/4);
        setImage(image);
        turn(-45);
    }
}
