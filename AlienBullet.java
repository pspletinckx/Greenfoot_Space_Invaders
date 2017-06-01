import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AlienBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienBullet extends Bullet
{

    public AlienBullet()
    {
    }
    
    public AlienBullet(int stepSize)
    {
        super(stepSize);
    }  
    
    public boolean isOutOfBounds()
    {
        return getY() > getWorld().getHeight()-getStepSize();
    }
}
