import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceActor extends Actor
{
    
    /**
     * moveVertically - Move vertically according to stepSize. If StepSize is postive,
     * move down StepSize steps. If stepSize is negative, move up StepSize steps.
     */
    public void moveVertically(int stepSize) 
    {
        setLocation(getX(), getY()+stepSize);
    }
    
    /**
     * moveHorizontally - Move Horizontally according to stepSize. If StepSize is postive,
     * move right StepSize steps. If stepSize is negative, move left StepSize steps.
     */
    public void moveHorizontally(int stepSize) 
    {
        setLocation(getX()+stepSize, getY());
    } 
}
