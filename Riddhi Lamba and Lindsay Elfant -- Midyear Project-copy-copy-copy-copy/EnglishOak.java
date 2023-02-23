import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnglishOak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnglishOak extends UnicornHair
{
    private GreenfootImage image;
    /**
     * Act - do whatever the EnglishOak wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void imageSetup() {
        image = getImage();
        image.scale(image.getWidth()/5, image.getHeight()/5);
        setImage(image);
        turn(-45);
    }
}
