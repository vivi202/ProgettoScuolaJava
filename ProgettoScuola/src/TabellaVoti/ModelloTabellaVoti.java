/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaVoti;

import javax.swing.table.AbstractTableModel;
import ArgoApi.*;
import ArgoApi.Eccezioni.AccessoNonEffettuato;
import ArgoApi.Modelli.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Vincenzo
 */
public class ModelloTabellaVoti extends AbstractTableModel{

    private ArgoApi api;
    private ListaVoti voti;
    private final String[] nomi={"Materia","Data","Voto"};
    
    public ModelloTabellaVoti(ArgoApi api) {
        try {
            this.api = api;
            voti=api.getVoti();
        } catch (IOException ex) {
            Logger.getLogger(ModelloTabellaVoti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessoNonEffettuato ex) {
            Logger.getLogger(ModelloTabellaVoti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int getRowCount() {
        return voti.getLung();
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
    }

    @Override
    public String getColumnName(int i) {
        return nomi[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        Voto v=voti.getIndex(row);
        switch(col){
            case 0: return v.getMateria();
            case 1: return v.getData();
            case 2: return v.getPunteggio();
            default: return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return getValueAt(i, i).getClass(); //To change body of generated methods, choose Tools | Templates.
    }

}
