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
        int damage = cast.randomDamage();
        if (damage > 0) {
            changeHealth(damage);
            getHealthBar().changeHealthBar(damage, this);
            ((MyWorld)getWorld()).showText("+"+damage, ((MyWorld)getWorld()).getWidth()-100, 125);
        }
        
        else {
            ((MyWorld) getWorld()).getUser().changeHealth(damage);
            int ret = ((MyWorld) getWorld()).getUser().getHealthBar().changeHealthBar(damage, ((MyWorld) getWorld()).getUser());
            ((MyWorld)getWorld()).showText(""+damage, 100, 125);
            if (ret == 0) {
                ((MyWorld) getWorld()).showText("You Lose :(", ((MyWorld) getWorld()).getWidth()/2, ((MyWorld) getWorld()).getHeight()/2);
                Greenfoot.stop(); 
            }
        }
        Greenfoot.delay(20);
        ((MyWorld)getWorld()).showText("", 100, 125);
        ((MyWorld)getWorld()).showText("", ((MyWorld)getWorld()).getWidth()-100, 125);
    }
    
    public void addWand() {
        wand.turn(-120);
        ((MyWorld) getWorld()).addObject(wand, getX()-155, getY()-75);
    }

    public Health getHealthBar() {
        return health; 
    }
    
    
}
