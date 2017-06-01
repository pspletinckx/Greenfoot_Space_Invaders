import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends SpaceActor
{
    private int DEFAULT_POINTS = 40;
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor bullet = getOneIntersectingObject(ShooterBullet.class);
        if (bullet != null) {
            ((Space) getWorld()).addPoints(getPointValue());
            getWorld().removeObject(bullet);
            getWorld().removeObject(this);
            Greenfoot.playSound("invaderkilled.wav"); //sound
        }    
    }
    
    public int getPointValue(){
        return DEFAULT_POINTS;
    }
    public void shoot()
    {    
        getWorld().addObject(new AlienBullet(), getX(), getY());
    }

}
