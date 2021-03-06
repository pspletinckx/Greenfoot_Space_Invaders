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
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final int ROW_LENGHT = (int)250/5;
    private static final int FIRING_INTERVAL = 120;

    private int actCounter = 0;
    Counter score = new Counter("Score: ");
    Counter lives = new Counter("Lives: ");
    
    GifImage gifImage = new GifImage("MPbLYRdJzLKa4.gif");

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 5); 

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
       createPlayer();
       createBarrier();
       createAliens();
       lives.add(3);
       addObject(score, 15, 90);
       addObject(lives, 95, 90);
    }
    
    private void createPlayer(){
        Shooter shooter = new Shooter();
        addObject(shooter,WIDTH/2, HEIGHT-15);}
        private void createBarrier(){
        
        for(int i=0; i<4; i++){
            Barrier barrier1 = new Barrier();
            addObject(barrier1, 20 + i*20, 75);
        }
        
    }
    private void createAliens(){
            int offset = 5;
        //eerste rij
        Alien[] alien1 = new Alien[10];
        for(int i=0; i<10; i++) {
            alien1[i] = new Alien();
            addObject(alien1[i], (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10, 5+offset);
        }
        
        //tweede rij
        Alien[] alien2 = new Alien[10];
        for(int i=0; i<10; i++) {
            alien1[i] = new Alien2();
            addObject(alien1[i], (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10 , 10+offset);
        }
        
        //derde rij
        Alien[] alien3 = new Alien[10];
        
        for(int i=0; i<10; i++) {
            alien1[i] = new Alien2();
            addObject(alien1[i], (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10, 15+offset);
        }
        
        //vierde rij
        Alien[] alien4 = new Alien[10];
        
        for(int i=0; i<10; i++) {
            alien1[i] = new Alien3();
            addObject(alien1[i], (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10, 20+offset);
        }
        //vijfde rij
         Alien[] alien5 = new Alien[10];
        
        for(int i=0; i<10; i++) {
            alien1[i] = new Alien3();
            addObject(alien1[i], (WIDTH-ROW_LENGHT)/2+i*ROW_LENGHT/10, 25+offset);
        }
    }
    //the game!!!!

        public void addPoints(int pts)
    {
        score.add(pts);
    }
    
    public void die()
    {
        lives.subtract(1);
        System.out.println("Lives is now "+ lives.getValue());
        if (lives.getValue() == 0) { 
            gameOver();
        }
       
        
         System.out.println("Died");
        addObject(new Shooter(),WIDTH/2, HEIGHT-15);
        //shot = 1;
    }
    
    public void gameOver() 
    {
        addObject(new ScoreBoard(score.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.playSound("game-over.wav");
        Greenfoot.stop();
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
        setBackground(gifImage.getCurrentImage());
        
    }
}