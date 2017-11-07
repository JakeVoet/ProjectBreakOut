/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.exoplanet.gui;

import javax.swing.JFrame;

/**
 *
 * @author altia
 */
public class BOMain {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    
    public static void main(String[] args){
        JFrame MainFrame = new JFrame("Exoplanet");
        
        GamePanel MainPanel = new GamePanel();
        
        Menu Menu = new Menu();
        
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setResizable(false);
        MainFrame.setSize(WIDTH, HEIGHT);
        
        MainFrame.add(MainPanel);
        
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setVisible(true);
        
        MainPanel.PlayGame();
        
    }
}
