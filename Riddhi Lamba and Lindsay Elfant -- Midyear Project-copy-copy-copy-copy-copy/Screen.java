import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Screen extends Actor
{
    public Screen() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()*3/4, image.getHeight()/2);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Screen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
