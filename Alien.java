import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends SpaceActor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor bullet = getOneIntersectingObject(ShooterBullet.class);
        if (bullet != null) {
            getWorld().removeObject(bullet);
            getWorld().removeObject(this);
            Greenfoot.playSound("invaderkilled.wav"); //sound
        }    
    }

    public void shoot()
    {    
        getWorld().addObject(new AlienBullet(), getX(), getY());
    }

}
