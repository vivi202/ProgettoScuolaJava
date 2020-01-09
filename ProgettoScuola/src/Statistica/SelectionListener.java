/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistica;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vincenzo
 */
public class SelectionListener implements ListSelectionListener{

    private ModelloTabellaStatistica mod;
    private JTable tabellaMedie;

    public SelectionListener(ModelloTabellaStatistica mod, JTable tabellaMedie) {
        this.mod = mod;
        this.tabellaMedie = tabellaMedie;
    }
    
    
    
    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if(!lse.getValueIsAdjusting()){
            ListSelectionModel sel=tabellaMedie.getSelectionModel();
            int riga=sel.getLeadSelectionIndex();
            String materia=(String)tabellaMedie.getValueAt(riga, 0);
            mod.calcolaDeviazioneStandard(materia,Double.parseDouble((String)tabellaMedie.getValueAt(riga, 1)));
            mod.calcolaMediana(materia);
            mod.fireTableDataChanged();
        }
    }
    
}
