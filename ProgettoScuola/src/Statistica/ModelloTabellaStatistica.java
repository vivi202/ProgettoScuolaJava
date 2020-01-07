/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistica;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marturanovin
 */
public class ModelloTabellaStatistica extends AbstractTableModel{
    private JTable tabellaMedie;
    private String[] nomi={"Parametro","Valore"};
    
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
            case 1:return 0;
            default:return "";      
        }
    }

    @Override
    public String getColumnName(int i) {
        return nomi[i];
    }
    
}
