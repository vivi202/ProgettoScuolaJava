/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaMedie;

import javax.swing.JTable;
import ArgoApi.*;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vincenzo
 */
public class PannelloTabellaMedie extends JPanel{
    private JTable tabella;
    private ModelloTabellaMedie modello;
    private ArgoApi api;

    public PannelloTabellaMedie(ArgoApi api) {
        this.setLayout(new BorderLayout());
        this.api=api;
        this.modello=new ModelloTabellaMedie(api);
        this.tabella=new JTable(modello);
        for(int i=0;i<tabella.getColumnCount();i++){
            tabella.setDefaultRenderer(tabella.getColumnClass(i), new TabellaMedieRender());
        }
        JScrollPane Js=new JScrollPane(tabella);
        JLabel titolo=new JLabel("Medie");
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titolo,BorderLayout.PAGE_START);
        this.add(Js,BorderLayout.CENTER);
    }
    public ModelloTabellaMedie getModello(){
        return this.modello;
    }
}
