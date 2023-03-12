import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

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
    public String castSpell = ""; 

    private int userTurn = 0;
    
    public User user = new User();
    public Opponent opponent = new Opponent();
    

    public boolean castDone = false;
    
    private ArrayList<String> wands = new ArrayList<String>(Arrays.asList("Cypress", "Hazel", "Laurel", "Sycamore", "English Oak", "Hornbeam"));
    private ArrayList<String> spells = new ArrayList<String>(Arrays.asList("Episkey", "Protego", "Salvio Hexia", "Expelliarmus", "Sectumsempra", "Stupefy"));
    
    private Logo logo = new Logo();
    private Screen open = new Screen();
    private int time = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        imageSetup();
        addObject(new HealthFrame(), 138, 70);
        addObject(new HealthFrame(), getWidth()-138, 70);
        addObject(user, 165, getHeight()/2+50); 
        addObject(opponent, getWidth()-165, getHeight()/2+50); 
        addObject(user.getHealthBar(), 138, 70);
        addObject(opponent.getHealthBar(), getWidth()-138, 70);
        addObject(open, getWidth()/2, getHeight()/2);
        addObject(logo, getWidth()/2, getHeight()/2);
    }
    
    public void act() {
        if (time == 0) {
            removeObject(logo);
            removeObject(open);
            showText("Your Health: ", 75, 30);
            showText("Opponent Health: ", 905, 30);
           GreenfootSound music = new GreenfootSound("duelmusic.mp3");
            music.playLoop(); 
            Greenfoot.delay(15);
        }
        if (currentWand.equals("")) {
            chooseWand(); 
            user.chooseWand(currentWand);
            user.addWand();
            opponent.chooseWand(wands.get(Greenfoot.getRandomNumber(6)));
            opponent.addWand();
        }

        if (userTurn == 0) {
            chooseSpell();
            user.castSpell(castSpell);
            userTurn = 1;
        }

        else {
            if (opponent.getHealth() < user.getHealth()) {
                int defenseChance = Greenfoot.getRandomNumber(5);
                int spell;
                if (defenseChance < 3) {
                    spell = Greenfoot.getRandomNumber(3);
                }
                
                else {
                    spell = Greenfoot.getRandomNumber(3)+3;
                }
                opponent.castSpell(spells.get(spell));
            }
            
            else {
                int offenseChance = Greenfoot.getRandomNumber(7);
                int oSpell;
                if (offenseChance < 5) {
                    oSpell = Greenfoot.getRandomNumber(3)+3;
                }
                else {
                    oSpell = Greenfoot.getRandomNumber(3);
                }
                opponent.castSpell(spells.get(oSpell));
            }
            userTurn = 0;
       }
       time++;
    }
    
    public void imageSetup() {
        image.scale(x, y);
        setBackground(image);
    }

    public void chooseSpell() {
        String prompt = String.format("\n\n1: Defensive spell\n\ta: Episkey\n\tb: Protego\n\tc: Salvio Hexia\n\n2: Offensive\n\ta: Expelliarmus\n\tb: Sectumsempra\n\tc: Stupefy"); 
        String spell = Greenfoot.ask("Which spell would you like to cast? Please enter your selection as a number followed by a letter, with no spaces in between." + prompt); 
        spell = spell.toLowerCase(); 
        switch(spell) {
            case"1a":
                castSpell = "Episkey"; 
                break; 
            case "1b": 
                castSpell = "Protego"; 
                break; 
            case "1c": 
                castSpell = "Salvio Hexia"; 
                break; 
            case "2a": 
                castSpell = "Expelliarmus"; 
                break; 
            case "2b": 
                castSpell = "Sectumsempra"; 
                break; 
            case "2c": 
                castSpell = "Stupefy";
                break; 
            default:
                Greenfoot.ask("Not an option, please try again. Enter any key to continue.");
                chooseSpell(); 
        }

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
    
    public Opponent getOpponent() {
        return opponent;
    }
    
    public User getUser() {
        return user;
    }
    
}
