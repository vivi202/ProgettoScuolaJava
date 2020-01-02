/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabellaVoti;

import javax.swing.JPanel;
import javax.swing.JTable;
import ArgoApi.*;
import java.awt.FlowLayout;
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
        this.setLayout(new FlowLayout());
        this.api=api;
        modello=new ModelloTabellaVoti(this.api);
        tabella=new JTable(modello);
        JScrollPane Js=new JScrollPane(tabella);
        this.add(Js);
    }
    
}
