/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoBarre;

import TabellaMedie.ModelloTabellaMedie;
import java.awt.Color;

/**
 *
 * @author Vincenzo
 */
public class ModelloGraficoABarre {
    private ModelloTabellaMedie modello;
    public ModelloGraficoABarre(ModelloTabellaMedie modello) {
        this.modello=modello;
    }
    
    public int getLenght(){
        return modello.getRowCount();
    }
    
    public double getValore(int pos){
        return modello.getMedia(pos).getPunteggio();
    }
    
    public String getLabel(int pos){
        return "";
    }
    public Color getColore(int i){
        return modello.getColore(i);
    }
}
