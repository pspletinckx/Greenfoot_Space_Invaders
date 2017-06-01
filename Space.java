import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;
    private static final int ROW_LENGHT = 500;
    private static final int FIRING_INTERVAL = 60;

    private int actCounter = 0;

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 

        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Shooter shooter = new Shooter();
        addObject(shooter,WIDTH/2, HEIGHT-100);

        for(int i=0; i<11; i++) {
            addObject(new Alien(), (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10, 20);
        }
    }

    public void act()
    {
        actCounter++;
        if (actCounter > FIRING_INTERVAL) {
            List aliens = getObjects(Alien.class);
            if (!aliens.isEmpty()) { 
            int number_of_aliens = aliens.size();
            int i = Greenfoot.getRandomNumber(number_of_aliens);
            Alien randomAlien = (Alien)aliens.get(i);
            randomAlien.shoot();
            }
            actCounter = 0;
        }
    }
}