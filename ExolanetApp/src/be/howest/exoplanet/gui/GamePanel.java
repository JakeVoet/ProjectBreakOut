/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.gui;
import java.awt.*;
import java.awt.image.BufferedImage;


import be.howest.exoplanet.domain.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;


/**
 *
 * @author altia
 */
public class GamePanel extends JPanel {
    
    //Fields
    private boolean running;
    private BufferedImage image;
    private Graphics2D g; // main artist voor het gehele spel
    
    private MyMouseMotionListener theMouseListener;
    
    private int mouseX;
    
    // nog de public static te verwijderen met getters en setters
    public static enum STATE {
        MENU, GAME
    }
    
    // checkt de status van waar men zich bevind in de game
    public static STATE state  = STATE.MENU;
    
    // Entities
    
    Ball balletje;
    Paddle balk;
    Map theMap; // de enemy blokjes enzo die worden gespawned
    HUD theHud;
    Menu menu;
    
    // Constructor
    public GamePanel(){
            init();
        
    }
    
    public void init(){
        
        menu = new Menu();
        
        
        mouseX = 0;
        balletje = new Ball();
        balk = new Paddle();
        theMap = new Map(4,8);
        theHud = new HUD();
        
        
        this.addMouseListener(new MouseInput());
        theMouseListener = new MyMouseMotionListener();
        addMouseMotionListener(theMouseListener);
        
        running = true;
        
        image = new BufferedImage(BOMain.WIDTH, BOMain.HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        g = (Graphics2D) image.getGraphics(); //je canvas
        
        // het verwijderen van pixel isolation
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }
    
    // Game collision ( checkt of de bal de Paddle of de blokjes raakt )
    public void checkCollision(){
        Rectangle ballRect = balletje.getRect();
        Rectangle paddleRect = balk.getRect();
        
        // Collision dat de bal de paddle raakt
        if(ballRect.intersects(paddleRect)){
            balletje.setDY(-balletje.getDY());
            
            // zorgt ervoor dat het balletje juist verspringt naarmate waar het de paddle raakt
            if(balletje.getX() < mouseX + balk.getWidth() / 2){
                balletje.setDX(balletje.getDY() - .5 );
            }
            
            if(balletje.getX() < mouseX + balk.getWidth() && balletje.getX() > mouseX + balk.getWidth() / 2){
                balletje.setDX(balletje.getDY()+4);
            }
        }
        
        
        
        //Collision dat de ball de bricks raakt en ze verwijdert
        A: for(int row =0; row < theMap.getMapArray().length; row++ ){
            for(int col =0; col < theMap.getMapArray()[0].length; col++ ){
                if(theMap.getMapArray()[row][col] > 0){
                    int brickX = col * theMap.getBrickWidth() + theMap.HOR_PAD;
                    int brickY = row * theMap.getBrickHeight() + theMap.VERT_PAD;
                    int brickWidth = theMap.getBrickWidth();
                    int brickHeight = theMap.getBrickHeight();
                    
                    Rectangle brickRect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                    
                    // de brick verdwijnt bij aanraking
                    if(ballRect.intersects(brickRect)){
                        theMap.hitBrick(row, col);
                        
                        balletje.setDY(-balletje.getDY());
                        
                        theHud.addScore(50);
                        break A;
                    }
                }
            }
        }
    }
    
   public void PlayGame(){
       // Game loop
       
       while(running){
           
        if (state ==STATE.GAME){
           update();
           
           //render
           
           draw();
           
            //display image
           repaint();
        }else if ( state == STATE.MENU){
                 menu.render(g);
        }
           
          
           
           try{
               Thread.sleep(10);
           }catch(Exception e){
               e.printStackTrace();
           }
       }
   }
   
   public void update(){
       checkCollision();
       balletje.update();
   }
   
   public void draw(){
       g.setColor(Color.white);
       g.fillRect(0, 0, BOMain.WIDTH, BOMain.HEIGHT);
       
       
            theMap.draw(g);
            balletje.draw(g);
            balk.draw(g);
            theHud.draw(g);

            
            if(theMap.isThereWin() == true){
           drawWin();
           running = false;
            }

           if(balletje.youLose()){
                drawLoser();
                running = false;

            }
            
       
       
       
   }
   
   public void drawWin(){
       g.setColor(Color.red);
       g.setFont(new Font("Courier New", Font.BOLD, 50));
       g.drawString("WINNER!!!", 200,200);
   }
   
   public void drawLoser(){
       g.setColor(Color.red);
       g.setFont(new Font("Courier New", Font.BOLD, 50));
       g.drawString("You Lose.", 200,200);
   }
   
   public void paintComponent(Graphics g){
       Graphics2D g2 = (Graphics2D) g;
       
       g2.drawImage(image, 0, 0,BOMain.WIDTH,BOMain.HEIGHT,null);
       
       g2.dispose();
   }
   
   private class MyMouseMotionListener implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent me) {
            // wordt niet gebruikt
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            mouseX= me.getX();
            balk.mouseMoved(me.getX());
        }
       
   }
    
}
