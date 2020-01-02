/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchermataPrincipale;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import ArgoApi.*;
import TabellaVoti.PannelloTabella;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 *
 * @author Vincenzo
 */
public class App extends JFrame{
    private ArgoApi api;

    public App(ArgoApi api) throws HeadlessException {
        this.api = api;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 500, 500);
        JPanel pannelloP=(JPanel)this.getContentPane();
        pannelloP.setLayout(new BoxLayout(pannelloP,BoxLayout.X_AXIS));
        JPanel sinistra=new JPanel();
        sinistra.setLayout(new BoxLayout(sinistra, BoxLayout.Y_AXIS));
        JPanel destra=new JPanel();
        destra.setLayout(new BoxLayout(destra, BoxLayout.Y_AXIS));
        pannelloP.add(sinistra);
        pannelloP.add(destra);
        sinistra.add(new PannelloTabella(api));
        destra.add(new PannelloTabella(api));
        this.setVisible(true);
    }
    
    
}
