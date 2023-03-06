import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User extends Wizard {
    private Health health = new Health(); 
        
    public User() {
        
    }
    
    /**
     * Act - do whatever the User wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
    }
    
    public void castSpell(String spell) {
        super.castSpell(spell);
        int index = spells.indexOf(spell);
        Spell cast = spellClass.get(index);
        if (cast.damage > 0) {
            changeHealth(cast.damage);
            getHealthBar().changeHealthBar(cast.damage);
        }
        
        else {
            ((MyWorld) getWorld()).getOpponent().changeHealth(cast.damage);
            ((MyWorld) getWorld()).getOpponent().getHealthBar().changeHealthBar(cast.damage);
        }
    }
    
    public void addWand() {
        ((MyWorld) getWorld()).addObject(wand, getX()+getImage().getWidth(), getY()-getImage().getHeight()/2);
    }
    
    public Health getHealthBar() {
        return health;
    }
}
