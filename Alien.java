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
    private String IMG_1 = "enemy1.gif";
    private String IMG_2 = "enemy1-2.gif";
    
    private int interval = 60;
    public int direction = 1;
    private int steps = START_STEPS;
    private int pulse_counter = 0;
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getWorld() == null) return;
        move();
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

    public void move() //move function, called in step
    {
        if(pulse_counter % interval != 0){
            pulse_counter++;
            return;
        }
            
        steps++;
        if(steps % (START_STEPS*2)==0){
            direction *=-1;
            come_closer();
            interval -=4;
            if (interval <=12) ((Space)getWorld()).gameOver();
        }
        if(direction == 1) move_left();
        else move_right();
        pulse_counter++;
        animate();
    }
    
    private void move_left(){
        moveHorizontally(-1);
    }
    private void move_right(){
        moveHorizontally(1);
    }
    private void come_closer(){
        moveVertically(5);
    }
    public void animate(){
        if(pulse_counter/interval %2 ==0){
            setImage(getImageUri(1));
        }else{
            setImage(getImageUri(2));
        }
    }
        public String getImageUri(int nr){
            if(nr == 1) return IMG_1;
            else return IMG_2;
    }
}

    
