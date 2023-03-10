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
        int damage = cast.randomDamage();

        if (damage > 0) {
            changeHealth(damage);
            getHealthBar().changeHealthBar(damage, this);
        }
        
        else {
            ((MyWorld) getWorld()).getOpponent().changeHealth(damage);
            int ret = ((MyWorld) getWorld()).getOpponent().getHealthBar().changeHealthBar(damage, ((MyWorld) getWorld()).getOpponent());
            if (ret == 0) {
                ((MyWorld) getWorld()).showText("You Win! :)", ((MyWorld) getWorld()).getWidth()/2, ((MyWorld) getWorld()).getHeight()/2);
                Greenfoot.stop(); 
            }
        }
        
    }
    
    public void addWand() {
        ((MyWorld) getWorld()).addObject(wand, getX()+getImage().getWidth(), getY()-getImage().getHeight()/2);
    }
    
    public Health getHealthBar() {
        return health;
    }
}
