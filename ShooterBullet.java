import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShooterBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShooterBullet extends Bullet
{
    public ShooterBullet()
    {
    }
    
    public ShooterBullet(int stepSize)
    {
        super(stepSize);
    } 
    
    public boolean isOutOfBounds()
    {
        return getY() < Math.abs(getStepSize());
    }
}
