/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistica;

import TabellaMedie.ModelloTabellaMedie;
import TabellaMedie.TabellaMedieRender;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author marturanovin
 */
public class PannelloStatistica extends JPanel{
    private JTable tabellaMedie;
    private ModelloTabellaStatistica modello;
    private JTable tabella;
    public PannelloStatistica(JTable tabellaMedie) {
        this.tabellaMedie = tabellaMedie;
        this.setLayout(new BorderLayout());
        this.modello=new ModelloTabellaStatistica();
        this.tabella=new JTable(modello);
//        tabella.getTableHeader().setReorderingAllowed(false);
        JScrollPane Js=new JScrollPane(tabella);
        JLabel titolo=new JLabel("Statistica");
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titolo.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titolo,BorderLayout.PAGE_START);
        this.add(Js,BorderLayout.CENTER);
    }
    
}
