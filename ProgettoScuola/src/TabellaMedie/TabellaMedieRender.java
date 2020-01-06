/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaMedie;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vincenzo
 */
public class TabellaMedieRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
        ModelloTabellaMedie modello=(ModelloTabellaMedie)jtable.getModel();
        if(col==2){
            setBackground(modello.getColore(row));
        }else{
            setBackground(Color.WHITE);
        }
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, row, col); //To change body of generated methods, choose Tools | Templates.7
    }
    
}
