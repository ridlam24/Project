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
    
    public String currentWand = "";
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        imageSetup();
        showText("Your Health: ", 75, 30);
        showText("Opponent Health: ", 905, 30);
        addObject(new HealthFrame(), 138, 70);
        addObject(new HealthFrame(), getWidth()-138, 70);
        //addObject(new User(), 138, getHeight()/3 * 2); 

    }
    
    public void act() {
        if (currentWand.equals("")) {
            chooseWand();   
        }
    }
    
    public void imageSetup() {
        image.scale(x, y);
        setBackground(image);
    }
    
    public void chooseWand() {
        String prompt = String.format("\n\n1: Dragon Heartstring Core Wands\n\ta: Cypress Wood\n\tb: Hazel Wood\n\n2: Phoenix Tail Feather Core Wands\n\ta: Laurel Wood\n\tb: Sycamore Wood\n\n3: Unicorn Hair Core Wands\n\ta: English Oak\n\tb: Hornbeam Wood");
        String wandChoice = Greenfoot.ask("Which wand would you like to duel with? Please enter your selection as a number followed by a letter, with no spaces in between." + prompt);
        
        switch(wandChoice) {
            case "1A":
            case "1a":
                currentWand = "Cypress";
                break;
            case "1B":
            case "1b":
                currentWand = "Hazel";
                break;
            case "2A":
            case "2a":
                currentWand = "Laurel";
                break;
            case "2B":
            case "2b":
                currentWand = "Sycamore";
                break;
            case "3A":
            case "3a":
                currentWand = "English Oak";
                break;
            case "3B":
            case "3b":
                currentWand = "Hornbeam";
                break;
            default:
                Greenfoot.ask("Not an option, please try again. Enter any key to continue.");
                chooseWand();
        }
    }
}
// omgggg
//hiiiiii
//this is my change 
