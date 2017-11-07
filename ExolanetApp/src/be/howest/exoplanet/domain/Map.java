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
public class Map {
    
    //Fields
    private int[][] theMap; // onze bricks
    private int brickHeight,brickWidth;// berekent aan de hand van onze bricks
    
    public final int HOR_PAD=80, VERT_PAD=50;
    
    //Constructor
    public Map(int row, int col){
        
        initMap(row,col);
        
        brickWidth = (BOMain.WIDTH-2*HOR_PAD) / col;
        brickHeight = (BOMain.HEIGHT / 2 - VERT_PAD * 2) / row;
        
    }
    
    public void initMap(int row, int col){
        theMap = new int[row][col];
        
        for(int i = 0; i < theMap.length; i++){
            for(int j = 0; j < theMap[0].length;j++){
                // zorgt voor random bricks  ( de 4 + 1 is de range )
                int r = (int)(Math.random()* 4 + 1);
                theMap[i][j] = r;
            }
        }
    }
    public void draw(Graphics2D g){
        
        for(int row = 0; row < theMap.length; row++){
            for(int col = 0; col < theMap[0].length; col++){
                if(theMap[row][col] > 0){
                   
                    // 1 zjin de sterkste blokjes en 4 de zwakste
                    if(theMap[row][col] == 1){
                        g.setColor(new Color(200,200,200));
                    }
                    
                     if(theMap[row][col] == 2){
                        g.setColor(new Color(150,150,150));
                    }
                     
                      if(theMap[row][col] == 3){
                        g.setColor(new Color(100,100,100));
                    }
                      
                       if(theMap[row][col] == 4){
                        g.setColor(new Color(50,50,50));
                    }
                    
                   
                    g.fillRect(col* brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
                    g.setStroke(new BasicStroke(2));
                    g.setColor(Color.white);
                    g.drawRect(col* brickWidth + HOR_PAD, row * brickHeight + VERT_PAD, brickWidth, brickHeight);
                    
                }
            }
            
            
        }
        
        
    }
    
    public boolean isThereWin(){
        boolean thereIsWin = false;
        
        int bricksRemaining = 0;
        
        for(int row = 0; row < theMap.length; row ++){
            for( int col = 0; col < theMap[0].length; col++){
                bricksRemaining += theMap[row][col];
            }
        }
        
        if(bricksRemaining == 0){
            thereIsWin = true;
        }
        
        return thereIsWin;
    }
    
    public int[][] getMapArray(){
        return theMap;
    }
    
    public void setBrick(int row, int col, int value){
        theMap[row][col] = value;
    }
    
    public int getBrickWidth(){
        return brickWidth;
    }
    
    public int getBrickHeight(){
        return brickHeight;
    }
    
    // kijkt of de brick is gehit
    public void hitBrick(int row, int col){
       theMap[row][col] -= 1;
       if(theMap[row][col] < 0){
           theMap[row][col] = 0;
       }
    }
}
