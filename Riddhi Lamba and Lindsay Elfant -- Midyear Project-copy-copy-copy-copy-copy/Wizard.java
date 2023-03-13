import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Wizard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Wizard extends Actor
{
    private int health; 
    
    public Wand wand;
    
    public ArrayList<String> spells = new ArrayList<String>(Arrays.asList("Episkey", "Protego", "Salvio Hexia", "Expelliarmus", "Sectumsempra", "Stupefy"));
    public ArrayList<Spell> spellClass = new ArrayList<Spell>(Arrays.asList(new Episkey(), new Protego(), new SalvioHexia(), new Expelliarmus(), new Sectumsempra(), new Stupefy()));

    public Wizard() {
        health = 100;
    }
    
    public void chooseWand(String choice) {
        switch (choice) {
            case "Cypress":
                wand = new Cypress();
                break;
            case "Hazel":
                wand = new Hazel();
                break;
            case "Laurel":
                wand = new Laurel();
                break;
            case "Sycamore":
                wand = new Sycamore();
                break;
            case "English Oak":
                wand = new EnglishOak();
                break;
            case "Hornbeam":
                wand = new Hornbeam();
                break;
        }
    }
    
    public abstract void addWand();
    
    public void castSpell(String spell) {
        int index = spells.indexOf(spell);
        Spell cast = spellClass.get(index);
        if (this instanceof Opponent) {
            ((MyWorld) getWorld()).addObject(cast, wand.getX()-wand.getImage().getWidth()/2, wand.getY());
        }
        else {
            ((MyWorld) getWorld()).addObject(cast, wand.getX()+wand.getImage().getWidth()/2, wand.getY());
        }
        if (cast instanceof Defensive) {
            for (int i = 0; i < 6; i ++) {
                GreenfootImage image = cast.getImage();
                image.scale(image.getWidth()+10, image.getHeight()+10);
                Greenfoot.delay(5);
            }
            for (int i = 0; i < 6; i ++) {
                GreenfootImage image = cast.getImage();
                image.scale(image.getWidth()-10, image.getHeight()-10);
                Greenfoot.delay(5);
            }
            GreenfootSound sound = new GreenfootSound("twinkle.mp3");
            sound.play();
            Greenfoot.delay(2);
        }
        else {
            for (int i = 0; i < 30; i ++) {
                if (this instanceof Opponent) {
                    cast.setLocation(cast.getX()-5, cast.getY()-4);
                    Greenfoot.delay(1);
                } 
                else {   
                    cast.setLocation(cast.getX()+5, cast.getY()-4);
                    Greenfoot.delay(1);
                }
            }
            for (int i = 0; i < 30; i ++) {
                if (this instanceof Opponent) {
                    cast.setLocation(cast.getX()-5, cast.getY()+4);
                    Greenfoot.delay(1);
                }
                else {   
                    cast.setLocation(cast.getX()+5, cast.getY()+4);
                    Greenfoot.delay(1);
                }
            }
            GreenfootSound sound = new GreenfootSound("au.wav");
            sound.play();
        }
        ((MyWorld) getWorld()).removeObject(cast);
    }
    
    public void setHealth(int health) {
        this.health = health; 
    }
    
    public void changeHealth(int health) {
        this.health += health;
    }

    public int getHealth() {
        return health; 
    }
    
    public abstract Health getHealthBar();  

    /**
     * Act - do whatever the Wizard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
