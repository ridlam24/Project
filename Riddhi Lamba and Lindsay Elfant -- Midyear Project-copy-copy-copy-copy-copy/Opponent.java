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
        if (cast instanceof Defensive) {
            changeHealth(damage);
            if (getHealth() > 100) {
                setHealth(100);
            }
            getHealthBar().changeHealthBar(damage, this);
            if (damage > 0) {
                ((MyWorld)getWorld()).showText("+"+damage, ((MyWorld)getWorld()).getWidth()-100, 125);
            }
            else {
                ((MyWorld)getWorld()).showText("Backfire!: "+damage, ((MyWorld)getWorld()).getWidth()-100, 125);
            }
        }
        
        else {
            ((MyWorld) getWorld()).getUser().changeHealth(damage);
            int ret = ((MyWorld) getWorld()).getUser().getHealthBar().changeHealthBar(damage, ((MyWorld) getWorld()).getUser());
            ((MyWorld)getWorld()).showText(""+damage, 100, 125);
            if (ret == 0) {
                ((MyWorld)getWorld()).showText("", 75, 30);
                ((MyWorld)getWorld()).showText("", 905, 30);
                ((MyWorld)getWorld()).addObject(new Screen(), ((MyWorld)getWorld()).getWidth()/2, ((MyWorld)getWorld()).getHeight()/2);
                ((MyWorld) getWorld()).showText("You Lose :(", ((MyWorld) getWorld()).getWidth()/2, ((MyWorld) getWorld()).getHeight()/2);
                GreenfootSound lost = new GreenfootSound("gameover.mp3");
                lost.play();
                Greenfoot.stop(); 
            }
        }
        Greenfoot.delay(20);
        ((MyWorld)getWorld()).showText("", 100, 125);
        ((MyWorld)getWorld()).showText("", ((MyWorld)getWorld()).getWidth()-100, 125);
    }
    
    public void addWand() {
        wand.turn(-115);
        ((MyWorld) getWorld()).addObject(wand, getX()-155, getY()-75);
    }

    public Health getHealthBar() {
        return health; 
    }
    
    
}
