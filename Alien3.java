import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien3 extends Alien
{
   private int DEFAULT_POINTS = 10;
   private String IMG_1 = "enemy3.gif";
   private String IMG_2 = "enemy3-2.gif";
    /**
     * Act - do whatever the Alien3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public int getPointValue(){
        return DEFAULT_POINTS;
    }
           public String getImageUri(int nr){
            if(nr == 1) return IMG_1;
            else return IMG_2;
    }
    
}
