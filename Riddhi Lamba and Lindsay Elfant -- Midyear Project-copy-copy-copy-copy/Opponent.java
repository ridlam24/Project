import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opponent extends Wizard
{
    private Health health = new Health();
    public Wand wand;
    
<<<<<<< HEAD:Riddhi Lamba and Lindsay Elfant -- Midyear Project-copy-copy-copy-copy/Opponent.java
    public Opponent() {
=======
    public User() {
        switch (((MyWorld) getWorld()).currentWand) {
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
        
>>>>>>> dd9349b7f5162abbfe920dcafbe61e08647cb3f1:Riddhi Lamba and Lindsay Elfant -- Midyear Project-copy/User.java
        ((MyWorld) getWorld()).addObject(health, 50, 50);
        ((MyWorld) getWorld()).addObject(wand, getImage().getWidth(), getImage().getHeight()/2);
    }
    
    /**
     * Act - do whatever the Opponent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
