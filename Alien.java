import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Iterator;
/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends SpaceActor
{
    private int DEFAULT_POINTS = 40;
    private int START_STEPS = 20;
    private int INTERVAL = 60;
    public int direction = 1;
    private int steps = START_STEPS;
    private int pulse_counter = 0;
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
        move();
        if (getWorld().getObjects(Alien.class).isEmpty())return ;
        System.out.println(getX()+" "+ getY());
    }
    
    public int getPointValue(){
        return DEFAULT_POINTS;
    }
    public void shoot()
    {    
        getWorld().addObject(new AlienBullet(), getX(), getY());
    }

    public void move() //move function, called in step
    {
        if(pulse_counter % INTERVAL != 0){
            pulse_counter++;
            return;
        }
            
        steps++;
        if(steps % (START_STEPS*2)==0){
            direction *=-1;
        }
        if(direction == 1) move_left();
        else move_right();
        pulse_counter++;
    }
    
    private void move_left(){
        moveHorizontally(-1);
    }
    private void move_right(){
        moveHorizontally(1);
    }
    private void come_closer(){
        
    }
}
    
