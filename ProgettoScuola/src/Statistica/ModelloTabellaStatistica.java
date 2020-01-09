/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistica;

import ArgoApi.Modelli.ListaVoti;
import ArgoApi.Modelli.Voto;
import TabellaMedie.ModelloTabellaMedie;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marturanovin
 */
public class ModelloTabellaStatistica extends AbstractTableModel{
    private ModelloTabellaMedie modTabMedie;
    private String[] nomi={"Parametro","Valore"};
    private double deviazioneStandard;
    private double mediana;
    public ModelloTabellaStatistica(ModelloTabellaMedie modTabMedie) {
        this.modTabMedie = modTabMedie;
    }
    
    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0:{
                if(row==0)
                    return "Deviazione standard";
                else if(row==1)
                    return "mediana";
            }
            case 1:{
                if(row==0){
                    return String.format("%.3f",deviazioneStandard);
                }else if(row==1){
                    return mediana;
                }
            }
            default:return "";      
        }
    }

    @Override
    public String getColumnName(int i) {
        return nomi[i];
    }

    public double getDeviazioneStandard() {
        return deviazioneStandard;
    }

    public void setDeviazioneStandard(double deviazioneStandard) {
        this.deviazioneStandard = deviazioneStandard;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }
    
    public void calcolaDeviazioneStandard(String materia,double media){
        if(materia.compareTo("Totale")==0){
            ListaVoti voti=modTabMedie.getVoti();
            int cont=0;
            double varianza=0;
            for(int i=0;i<voti.getLung();i++){
                Voto v=voti.getIndex(i);
                if(v.getPunteggio()>1){
                    varianza+=Math.pow(v.getPunteggio()-media, 2);
                    cont++;
                }
                
            }
            this.setDeviazioneStandard(Math.sqrt(varianza/=cont));;
        }else{
            ListaVoti voti=modTabMedie.getVoti();
            int cont=0;
            double varianza=0; 
            for(int i=0;i<voti.getLung();i++){
                Voto v=voti.getIndex(i);
                if(v.getMateria().compareTo(materia)==0&&v.getPunteggio()>1){
                    varianza+=Math.pow(v.getPunteggio()-media, 2);
                    cont++;
                }
                
            }
            this.setDeviazioneStandard(Math.sqrt(varianza/=cont));;
        }
    }
    
    public void calcolaMediana(String materia){
        ListaVoti voti=modTabMedie.getVoti();
        double[] ordinato=new double[voti.getLung()];
        for(int i=0;i<ordinato.length;i++){
            ordinato[i]=voti.getIndex(i).getPunteggio();
        }
        bubbleSort(ordinato);
        for(int i=0;i<ordinato.length;i++){
            System.out.print(ordinato[i]+" ");
        }
        if(materia.compareTo("Totale")==0){
            
        }
    }
    
    public void bubbleSort(double[] vett){
        boolean scambio=false;
        do{
            scambio=false;
            for(int i=0;i<vett.length-1;i++){
                if(vett[i]>vett[i+1]){
                    double app=vett[i];
                    vett[i]=vett[i+1];
                    vett[i+1]=app;
                    scambio=true;
                }
            }
        }while(scambio);
    }
}
