import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shooter extends SpaceActor
{
    private static final int STEP_SIZE = 1;
    private static final int BULLET_STEP_SIZE = -5;
    private static final int MAX_ACTS_BETWEEN_SHOTS = 30;
    private int actsBetweenShots = Integer.MAX_VALUE;

    public Shooter()
    {

    }   

    /**
     * Act - do whatever the Shooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left")) {
            moveHorizontally(-STEP_SIZE);
        }   

        if(Greenfoot.isKeyDown("right")) {
            moveHorizontally(STEP_SIZE);
        }    

        if(Greenfoot.isKeyDown("space")) {
            if (actsBetweenShots > MAX_ACTS_BETWEEN_SHOTS) {
                getWorld().addObject(new ShooterBullet(BULLET_STEP_SIZE), getX(), getY());
                actsBetweenShots = 0;
                Greenfoot.playSound("shoot.wav");
            }
            actsBetweenShots++;
        } else {
            actsBetweenShots = Integer.MAX_VALUE;
        }

        {
            Actor bullet = getOneIntersectingObject(AlienBullet.class);
            if (bullet != null) {
                getWorld().removeObject(this);
                Greenfoot.playSound("explosion.wav");
            }    
        }
    }
}
