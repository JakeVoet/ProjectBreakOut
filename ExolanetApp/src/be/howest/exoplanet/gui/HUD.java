/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.gui;

import java.awt.*;

/**
 *
 * @author altia
 */
public class HUD {
    
    //Field
    private int score;
    
    // Constructor
    public HUD(){
        init();
        
    }
    
    public void init(){
        score = 0;
    }
    
    public void draw(Graphics2D g){
        g.setFont(new Font("Courier New", Font.PLAIN, 14));
        g.setColor(Color.red);
        g.drawString("Score: "+ score , 20, 20);
    
    }
    
    public int getScore() { 
        return score;
    }
    
    public void addScore(int scoreToAdd){
        score += scoreToAdd;
    }

    
}
