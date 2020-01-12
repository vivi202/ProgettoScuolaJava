/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaMedie;
import ArgoApi.*;
import ArgoApi.Eccezioni.AccessoNonEffettuato;
import ArgoApi.Modelli.*;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vincenzo
 */
public class ModelloTabellaMedie extends AbstractTableModel{
    private ArgoApi api;
    private ListaVoti voti;
    private Voto[] medie;
    private final String[] nomi={"Materia","Voto","Colore"};
    private Color[] colori;//in prova
    public ModelloTabellaMedie(ArgoApi api) {
        try {
            this.api=api;
            this.voti=this.api.getVoti();
            medie=new Voto[voti.getNumMaterie()+1];
            colori=new Color[voti.getNumMaterie()+1];
            for(int i=0;i<colori.length;i++){
                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();
                colori[i]=new Color(r,g,b);
            }
            MediaPerMaterie();
            MediaTotale();
        } catch (IOException ex) {
            Logger.getLogger(ModelloTabellaMedie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessoNonEffettuato ex) {
            Logger.getLogger(ModelloTabellaMedie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void MediaPerMaterie(){
        double med;
        int cont;
        int pos=0;
        boolean app[]=new boolean[voti.getLung()];
        for(int i=0;i<voti.getLung();i++){
            app[i]=false;
        }
        for(int i=0;i<voti.getLung();i++){
            med=0;
            cont=0;
            if(app[i]==false){
                Voto v=voti.getIndex(i);
                if(v.getPunteggio()>1){
                med+=v.getPunteggio();
                cont++;
                }
                for(int j=i;j<voti.getLung();j++){
                    if(app[j]==false){
                        Voto c=voti.getIndex(j);
                        if(v.getMateria().compareTo(c.getMateria())==0){
                            if(c.getPunteggio()>1){
                            med+=c.getPunteggio();
                            cont++;
                            }
                            app[j]=true;
                        }
                    }
                }
                med=med/cont;
                medie[pos++]=new Voto(v.getMateria(), med, "");
            }
            app[i]=true;
        }
    }
    public void MediaTotale(){
        int cont=0;
        double media=0;
        for(int i=0;i<medie.length;i++){
            if(medie[i]==null){
                medie[i]=new Voto("Totale", media/cont, "");
            }else{
                Voto v=medie[i];
                media+=v.getPunteggio();
                cont++;
            }
        }
    }

    @Override
    public int getRowCount() {
        return medie.length;
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Voto v=medie[row];
        switch(col){
            case 0: return v.getMateria();
            case 1: return arrotondato(v.getPunteggio());
            default: return "";
        }
    }

    @Override
    public String getColumnName(int col) {
        return nomi[col];
    }
    
    public String arrotondato(double voto){
        if(voto<10){
            return Double.toString(voto).substring(0, 3);
        }else{
            return Double.toString(voto).substring(0,2);
        }
    }
    
    
    public Voto getMedia(int i){
        return medie[i];
    }
    
    public Color getColore(int i){
        return colori[i];
    }

    public ListaVoti getVoti() {
        return voti;
    }
    
}
