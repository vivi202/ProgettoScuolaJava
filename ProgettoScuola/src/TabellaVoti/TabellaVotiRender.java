/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaVoti;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vincenzo
 */
public class TabellaVotiRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable tabella, Object o, boolean bln, boolean bln1, int row, int col) {
        if(col==2){
            if((double)tabella.getValueAt(row, col)<6)
                this.setForeground(Color.red);
            else
                this.setForeground(Color.BLACK);
        }
        return super.getTableCellRendererComponent(tabella, o, bln, bln1, row, col); //To change body of generated methods, choose Tools | Templates.
    }
    
}
