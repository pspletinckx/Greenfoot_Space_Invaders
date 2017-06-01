import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int hp = 4;
    
    private GreenfootImage img1;
    private GreenfootImage img2;
    private GreenfootImage img3;
    private GreenfootImage img4;
    
    public Barrier(){
        img1 = getImage();
        img2 = new GreenfootImage("barrier-2.gif");
        img3 = new GreenfootImage("barrier-3.gif");
        img4 = new GreenfootImage("barrier-4.gif");
    }
 
    public void act() 
    {
       List bullets = getNeighbours(10, false, AlienBullet.class); //new list with all Pbullets within 2 uinits adjacent to the enemy
       if(bullets.size()>0){
       System.out.println("Alien bullets nearby "+ bullets.size());
    }
       if (!bullets.isEmpty()) { //is there is one (there will only be one, since only one bullet on screen at a time)
       Actor b = (Actor) bullets.get(0); //gets the first object in the list
       if (b instanceof AlienBullet) { //just an extra check to make sure its a player bullet
           getWorld().removeObject(b); //remobe the bullet
       hp--;
           if (hp <= 0) {
               getWorld().removeObject(this);
           } else {
               switch (hp) {
                   case 3: setImage(img2); break;
                   case 2: setImage(img3); break;
                   case 1: setImage(img4); break;
                }
            }
       }
       } else {
       List bullets2 = getNeighbours(3, false, ShooterBullet.class); //new list with all Pbullets within 2 uinits adjacent to the enemy
       if (!bullets2.isEmpty()) { //is there is one (there will only be one, since only one bullet on screen at a time)
       Actor b = (Actor) bullets2.get(0); //gets the first object in the list
       if (b instanceof ShooterBullet) { //just an extra check to make sure its a player bullet
           getWorld().removeObject(b); //remobe the bullet
           //((Space) getWorld()).ShootSet(1);
           hp--;
           if (hp <= 0) {
               getWorld().removeObject(this);
           } else {
               switch (hp) {
                   case 3: setImage(img2); break;
                   case 2: setImage(img3); break;
                   case 1: setImage(img4); break;
                }
            }
       }
    }
    }
       
    }  
}
