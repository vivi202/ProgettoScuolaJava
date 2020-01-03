/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficoBarre;

/**
 *
 * @author Vincenzo
 */
public class ModelloGraficoABarre {
    private String[] label;
    private double [] valori;

    public ModelloGraficoABarre(String[] label, double [] valori) {
        this.label = label;
        this.valori = valori;
    }
    
    public int getLenght(){
        return label.length;
    }
    
    public double getValore(int pos){
        return this.valori[pos];
    }
    
    public String getLabel(int pos){
        return this.label[pos];
    }
}
