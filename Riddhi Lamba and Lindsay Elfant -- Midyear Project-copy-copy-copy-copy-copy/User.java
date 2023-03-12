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

        if (cast instanceof Defensive) {
            changeHealth(damage);
            if (getHealth() > 100) {
                setHealth(100);
            }
            getHealthBar().changeHealthBar(damage, this);
            if (damage > 0) {
                ((MyWorld)getWorld()).showText("+"+damage, 100, 125);
            }
            else {
                ((MyWorld)getWorld()).showText("Backfire!: "+damage, 100, 125);
            }
        }
        
        else {
            ((MyWorld) getWorld()).getOpponent().changeHealth(damage);
            int ret = ((MyWorld) getWorld()).getOpponent().getHealthBar().changeHealthBar(damage, ((MyWorld) getWorld()).getOpponent());
            ((MyWorld)getWorld()).showText(""+damage, ((MyWorld)getWorld()).getWidth()-100, 125);
            if (ret == 0) {
                ((MyWorld)getWorld()).showText("", 75, 30);
                ((MyWorld)getWorld()).showText("", 905, 30);
                ((MyWorld)getWorld()).addObject(new Screen(), ((MyWorld)getWorld()).getWidth()/2, ((MyWorld)getWorld()).getHeight()/2);
                ((MyWorld) getWorld()).showText("You Win! :)", ((MyWorld) getWorld()).getWidth()/2, ((MyWorld) getWorld()).getHeight()/2);
                GreenfootSound win = new GreenfootSound("win.mp3");
                win.play();
                Greenfoot.stop(); 
            }
        }
        Greenfoot.delay(20);
        ((MyWorld)getWorld()).showText("", 100, 125);
        ((MyWorld)getWorld()).showText("", ((MyWorld)getWorld()).getWidth()-100, 125);
    }
    
    public void addWand() {
        wand.turn(75);
        ((MyWorld) getWorld()).addObject(wand, getX()+33, getY()-getImage().getHeight()+203);
    }
    
    public Health getHealthBar() {
        return health;
    }
}
