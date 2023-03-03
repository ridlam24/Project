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
        changeHealth(cast.damage);
        getHealthBar().changeHealthBar(health);
        ((MyWorld) getWorld()).addObject(cast, wand.getX()+wand.getImage().getWidth(), wand.getY());
        for (int i = 0; i < 100; i ++) {
            cast.setLocation(cast.getX()+2, cast.getY()-1);
            Greenfoot.delay(1);
        }
        for (int i = 0; i < 100; i ++) {
            cast.setLocation(cast.getX()+2, cast.getY()+1);
            Greenfoot.delay(1);
        }
        ((MyWorld) getWorld()).removeObject(cast);
        GreenfootSound sound = new GreenfootSound("au.wav");
        sound.play();
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
