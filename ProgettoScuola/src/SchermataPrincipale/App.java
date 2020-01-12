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
import Statistica.PannelloStatistica;
import TabellaMedie.ModelloTabellaMedie;
import TabellaMedie.PannelloTabellaMedie;
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
        this.setMinimumSize(new Dimension(900, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        PannelloTabellaMedie PannelloMedie=new PannelloTabellaMedie(api);
        ModelloGraficoABarre modello=new ModelloGraficoABarre(PannelloMedie.getModello());//si passa il modello del pannelloMedie
        destra.add(new PannelloGraficoABarre(30, modello));
        sinistra.add(PannelloMedie);
        sinistra.add(new PannelloStatistica(PannelloMedie.getTabella()));
        this.setVisible(true);
    }
    
    
}
