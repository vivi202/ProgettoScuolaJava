/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.finestreErrore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Vincenzo
 */
public class FinestraAccessoNonRiuscito extends JDialog{

    public FinestraAccessoNonRiuscito(Frame frame,String titolo) {
        super(frame, titolo,true);
        this.setMinimumSize(new Dimension(200, 200));
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        JLabel lab=new JLabel("accesso non riuscito!!");
        JButton bottone=new JButton("Ok");
        bottone.addActionListener((ActionEvent ae) -> {
           this.dispose();
        });
        lab.setAlignmentX(Component.CENTER_ALIGNMENT);
        lab.setHorizontalAlignment(JLabel.CENTER);
        this.add(lab,BorderLayout.CENTER);
        this.add(bottone,BorderLayout.PAGE_END);
        this.pack();
        this.setVisible(true);
    }
    
}
