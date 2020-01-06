/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoBarre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Vincenzo
 */
public class PannelloGraficoABarre extends JPanel{
    private int padding;
    private int labelPadding=60;
    private int d;
    private int larg;
    private ModelloGraficoABarre modello;
    public PannelloGraficoABarre(int padding,ModelloGraficoABarre modello) {
        this.padding=padding;
        this.modello=modello;
        this.setMinimumSize(new Dimension(200,100));
        this.setPreferredSize(new Dimension(500,300));
        this.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.white);
        g.fillRect(this.padding, this.padding, getWidth()-padding*2, this.getHeight()-this.padding*2);//area grafico
        g.setColor(Color.BLACK);
        g.drawLine(padding+labelPadding, padding, padding+labelPadding, getHeight()-padding-labelPadding);//asse y
        g.drawLine(padding+labelPadding, getHeight()-padding-labelPadding, getWidth()-padding-1, getHeight()-padding-labelPadding);//asse x
        d=(getHeight()-padding*2-labelPadding*2)/10;//unita di misura
        
        larg=(getWidth()-(padding*2+labelPadding*2))/modello.getLenght()-padding/2;//larghezza di una barra
        
        for(int i=0;i<10;i++){
            /*
             disegno le tacche e i numeri
            */
            g.drawString(Integer.toString(10-i), padding+labelPadding/2,labelPadding+padding+i*d);
            
            g.drawLine(padding+labelPadding-5,(labelPadding+padding)+i*d,padding+labelPadding,labelPadding+padding+i*d);
            
        }
        int x=padding*2+labelPadding;
        for(int i=0;i<modello.getLenght();i++){
            disegnaBarra(g,x,modello.getValore(i),modello.getLabel(i),modello.getColore(i));
            x+=(larg+padding/2);
        }
    }
    private void disegnaBarra(Graphics g,int x,double punteggio,String label,Color colore){        
        g.setColor(colore);
        g.fillRect(x,this.padding+labelPadding+(d*10)-((int)((d*10)*punteggio)/10),larg,getHeight()-labelPadding*2-padding*2-((d*10)-((int)((d*10)*punteggio)/10)));
        g.setColor(Color.BLACK);
        g.drawString(label, x,getHeight()-padding*2);
    }
    
}
