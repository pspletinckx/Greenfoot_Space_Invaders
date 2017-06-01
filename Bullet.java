import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Bullet extends SpaceActor
{
    private static final int DEFAULT_STEP_SIZE = 5;
    private int stepSize;

    public Bullet()
    {
        this(DEFAULT_STEP_SIZE);
    }
    
    public Bullet(int stepSize)
    {
        this.stepSize = stepSize;
    }     

    /**
     * Act - do whatever the ShooterBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveVertically(stepSize);
        if (isOutOfBounds()) {
            getWorld().removeObject(this);
        }    
    }
    
    public int getStepSize()
    {
        return stepSize;
    }
    
    public void setStepSize(int stepSize)
    {
        this.stepSize = stepSize;
    }
    
    public abstract boolean isOutOfBounds();
}
