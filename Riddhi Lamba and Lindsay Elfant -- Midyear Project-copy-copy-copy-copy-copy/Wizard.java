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
        changeHealthBar(health);
        ((MyWorld) getWorld()).addObject(cast, wand.getImage().getWidth(), wand.getImage().getHeight()/2);
        cast.move(20);
        while (!isTouching(Wand.class)) {
            cast.move(1);
        }
        ((MyWorld) getWorld()).removeObject(cast);
        
        ((MyWorld) getWorld()).showText(cast.toString() + "" + index + " " + cast.damage, 150, 150);
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
    
    public abstract void changeHealthBar(int health);

    /**
     * Act - do whatever the Wizard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
