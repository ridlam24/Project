import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private GreenfootImage image = new GreenfootImage("DuelingRoom.jpg");
    private int x = getWidth();
    private int y = getHeight();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        imageSetup();
    }
    
    public void imageSetup() {
        image.scale(x, y);
        setBackground(image);
    }
}
// omgggg
//hiiiiii
//this is my change 
