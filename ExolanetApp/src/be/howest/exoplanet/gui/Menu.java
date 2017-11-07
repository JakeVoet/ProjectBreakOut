/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.gui;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author altia
 */
public class Menu extends JPanel {
    
    public Rectangle SurvivalButton = new Rectangle(BOMain.WIDTH/6+50 , 150, 150,50);
     public Rectangle StoryButton = new Rectangle(BOMain.WIDTH/2 +50, 150, 100,50);
      public Rectangle OptionsButton = new Rectangle(BOMain.WIDTH/2+50 , 150, 100,50);
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("Exoplanet", BOMain.WIDTH / 3, 100);
        
        Font titel = new Font("arial", Font.BOLD,30);
        
        g.setFont(titel);
        g.drawString("Survival", SurvivalButton.x+ 19, SurvivalButton.y+ 30);
        g2d.draw(SurvivalButton);
        g2d.draw(StoryButton);
        g2d.draw(OptionsButton);
        
        
    }
}
