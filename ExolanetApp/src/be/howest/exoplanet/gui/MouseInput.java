/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.gui;

import be.howest.exoplanet.gui.GamePanel.STATE;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author altia
 */
public class MouseInput implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        int nx = e.getX();
        int ny = e.getY();
        
//          public Rectangle SurvivalButton = new Rectangle(BOMain.WIDTH/6+50 , 150, 150,50);
//          public Rectangle StoryButton = new Rectangle(BOMain.WIDTH/2 +50, 150, 100,50);
//          public Rectangle OptionsButton = new Rectangle(BOMain.WIDTH/2+50 , 150, 100,50);
        // Survival button
        if (nx >= BOMain.WIDTH/6+50 && nx <= BOMain.WIDTH / 6 + 200 ){
            if(ny >= 150 && ny <= 200){
                // pressed Survival button
                GamePanel.state = STATE.GAME;
            }
        }
    
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
