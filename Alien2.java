import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien2 extends Alien
{
    private int DEFAULT_POINTS = 20;
    private String IMG_1 = "enemy2.gif";
    private String IMG_2 = "enemy2-2.gif";
    /**
     * Act - do whatever the Alien2 wants to do. This method is called whenever
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
