import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Opponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Opponent extends Wizard {
    private Health health = new Health(); 
    
    public Opponent() {
    }
    
    /**
     * Act - do whatever the Opponent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        
    }
    
    public void castSpell(String spell) {
        super.castSpell(spell);
        int index = spells.indexOf(spell);
        Spell cast = spellClass.get(index);
        ((MyWorld) getWorld()).getUser().getHealthBar().changeHealthBar(cast.damage);
    }
    
    public void addWand() {
        wand.turn(-90);
        ((MyWorld) getWorld()).addObject(wand, getX()-getImage().getWidth(), getY()-getImage().getHeight()/2);
    }

    public Health getHealthBar() {
        return health; 
    }
    
    
}
