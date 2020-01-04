/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchermataPrincipale;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import ArgoApi.*;
import GraficoBarre.ModelloGraficoABarre;
import GraficoBarre.PannelloGraficoABarre;
import TabellaVoti.PannelloTabella;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
        this.setBounds(0, 0, 1000, 500);
        this.setMinimumSize(new Dimension(900, 500));
        JPanel pannelloP=(JPanel)this.getContentPane();
        pannelloP.setLayout(new BoxLayout(pannelloP,BoxLayout.X_AXIS));
        JPanel sinistra=new JPanel();
        sinistra.setLayout(new BoxLayout(sinistra, BoxLayout.Y_AXIS));
        sinistra.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        JPanel destra=new JPanel();
        destra.setLayout(new BoxLayout(destra, BoxLayout.Y_AXIS));
        pannelloP.add(sinistra);
        pannelloP.add(destra);
        sinistra.add(new PannelloTabella(api));
        String[] label=new String[10];
        double[] valori= new double[10];
        
        for (int i = 0; i < 10; i++) {
            label[i]="materia"+(i+1);
            valori[i]=i+1-0.5;
        }
        
        ModelloGraficoABarre modello=new ModelloGraficoABarre(label, valori);//si passa un vettore di stringhe e i valori che vanno da 0 a 10
        destra.add(new PannelloGraficoABarre(30, modello));
        this.setVisible(true);
    }
    
    
}
