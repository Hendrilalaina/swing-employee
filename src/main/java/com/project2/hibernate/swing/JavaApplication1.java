/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.project2.hibernate.swing;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Hendrilalaina
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        System.out.println(info.getName());
        if ("Windows".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}
        // TODO code application logic here
        MainFrame swing = new MainFrame();
        swing.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        swing.setLocationByPlatform(true);
        swing.pack();
        swing.setVisible(true);
    }
    
}
