/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.domain;
import java.awt.*;
import be.howest.exoplanet.gui.*;
/**
 *
 * @author altia
 */
public class Paddle {
    //Fields
    private double x;
    private int width, height;
    
    public final int YPOS = BOMain.HEIGHT - 100;
    
    //Constructor
    public Paddle(){
        width = 100;
        height = 10;
        
        x = BOMain.WIDTH / 2 - width / 2; // --> voor de padle in het midden te plaatsen
    }
    
    public void update(){
        
    }
    
    //draw the paddle
    public void draw(Graphics2D g){
        g.setColor(Color.blue);
        g.fillRect((int)x , YPOS, width, width);
    }
    
    public void mouseMoved(int XPos){
        x = XPos;
        
        if(x > BOMain.WIDTH - width){
            x = BOMain.WIDTH-width;
        }

        
    }
    
    public Rectangle getRect(){
        return new Rectangle ((int)x,YPOS, width, height);
    }

    public int getWidth() {
        return width;
    }
}
