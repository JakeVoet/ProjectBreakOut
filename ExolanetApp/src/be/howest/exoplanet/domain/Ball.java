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
public class Ball {
    // dx en dy zijn de direction waar ze naartoe gaan.
    private int x,y,dx,dy;
    private int ballSize = 20;
    
    public Ball(){
        x=200;
        y=200;
        dx = 1;
        dy=3;
    }
    
    public void update(){
        setPosition();
    }

    public void setPosition() {
        x += dx;
        y+= dy;
        
        // kijkt of hij de rand raakt
        if(x < 0){
            dx = -dx;
        }
        if(y < 0){
            dy = - dy;
        }
        if(x > BOMain.WIDTH - ballSize){
            dx  = -dx;
        }
        if(y > BOMain.WIDTH - ballSize){
            dy  = -dy;
        }
    }
    
    public void draw(Graphics2D g){
        g.setColor(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(4));
        g.drawOval((int)x, (int)y, ballSize, ballSize);
    }
    
    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, ballSize, ballSize);
    }
    
    public int getDY(){
        return dy;
    }
    
    public void setDY(double theDY){
        dy = (int)theDY;
    }
    
    public void setDX(double theDX){
        dx =  (int)theDX;
    }
    
    public double getDX(){
        return dx;
    }
    
   public double getX(){
       return x;
   }
   
   public boolean youLose(){
       boolean loser = false;
       if(y > BOMain.HEIGHT - ballSize){
           loser = true;
       }
           
       return loser;
   }
    
    
}
