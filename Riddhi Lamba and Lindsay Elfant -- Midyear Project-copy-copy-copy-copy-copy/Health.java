import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private int originalWidth; 
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Health() {
        GreenfootImage image = getImage();
        image.scale(new HealthFrame().getImage().getWidth()-7, new HealthFrame().getImage().getHeight()-16);
        originalWidth = image.getWidth(); 
        setImage(image);
    }

    public void changeHealthBar(int damage) {
        GreenfootImage image = getImage(); 
        double amount = (damage/100.0)* originalWidth; 
        double newWidth = image.getWidth + (int) amount; 
        if (newWidth <= 0) {
            image.scale(0, 0); 
        }
        else if(newWidth >= originalWidth) {
            image.scale(originalWidth, image.getHeight()); 
        }
        else {
            image.scale(image.getWidth() + (int) amount, image.getHeight()); 

        }
        setImage(image);
    }

    public void act()
    {
        // Add your action code here.
    }
}
