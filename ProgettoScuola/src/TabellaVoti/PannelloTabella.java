/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaVoti;

import javax.swing.JPanel;
import javax.swing.JTable;
import ArgoApi.*;
import TabellaMedie.TabellaMedieRender;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
/**
 *
 * @author Vincenzo
 */
public class PannelloTabella extends JPanel{
    private JTable tabella;
    private ModelloTabellaVoti modello;
    private ArgoApi api;
    
    public PannelloTabella(ArgoApi api){
        this.setLayout(new BorderLayout());
        this.api=api;
        modello=new ModelloTabellaVoti(this.api);
        tabella=new JTable(modello);
        tabella.getTableHeader().setReorderingAllowed(false);
          for(int i=0;i<tabella.getColumnCount();i++){
            tabella.setDefaultRenderer(tabella.getColumnClass(i), new TabellaVotiRender());
        }
        JScrollPane Js=new JScrollPane(tabella);
        JLabel titolo=new JLabel("Voti");
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titolo,BorderLayout.PAGE_START);
        this.add(Js);
    }
    
}
