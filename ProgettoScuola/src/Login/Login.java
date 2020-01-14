/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ArgoApi.*;
import ArgoApi.Eccezioni.AccessoNonRiuscito;
import Login.finestreErrore.FinestraAccessoNonRiuscito;
import SchermataPrincipale.App;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vincenzo
 */
public class Login extends JFrame implements KeyListener{
    private final JLabel codice;
    private final JLabel username;
    private final JLabel password;
            
    private final JTextField textFieldCodice;
    
    private final JTextField textFieldUsername;
    
    private final JPasswordField textFieldPassword;
    
    private final JButton login;
    
    public Login() throws HeadlessException {
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        codice=new JLabel("Codice Scuola:");
        codice.setAlignmentX(Component.CENTER_ALIGNMENT);//allinea la label al centro
        codice.setHorizontalAlignment(JLabel.CENTER);//allinea il testo al centro della label
        
        username=new JLabel("Username:");
        username.setAlignmentX(Component.CENTER_ALIGNMENT);//allinea la label al centro
        username.setHorizontalAlignment(JLabel.CENTER);//allinea il testo al centro della label
        
        password=new JLabel("password: ");
        password.setAlignmentX(Component.CENTER_ALIGNMENT);//allinea la label al centro
        password.setHorizontalAlignment(JLabel.CENTER);//allinea il testo al centro della label
        
        textFieldCodice=new JTextField();
        textFieldCodice.setMaximumSize(new Dimension(Short.MAX_VALUE,10));//imposta la dimensione massima
        textFieldCodice.setHorizontalAlignment(JTextField.CENTER);//allinea il testo del TextField al centro
        
        textFieldUsername=new JTextField();
        textFieldUsername.setMaximumSize(new Dimension(Short.MAX_VALUE,10));//imposta la dimensione massima
        textFieldUsername.setHorizontalAlignment(JTextField.CENTER);//allinea il testo del TextField al centro
        
        textFieldPassword=new JPasswordField();
        textFieldPassword.setMaximumSize(new Dimension(Short.MAX_VALUE, 10));//imposta la dimensione massima
        textFieldPassword.setHorizontalAlignment(JTextField.CENTER);//allinea il testo del TextField al centro
        textFieldPassword.addKeyListener(this);
        
        login=new JButton("login");
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener((ActionEvent ae) -> {
            login();
        });
        
        //imposto il layout manager
        JPanel pannelloPrincipale=(JPanel) this.getContentPane();
        pannelloPrincipale.setLayout(new BoxLayout(pannelloPrincipale, BoxLayout.Y_AXIS));//imposto il layout manager
        pannelloPrincipale.setBorder(new EmptyBorder(10, 10, 10, 10));//aggiungo un bordo vuoto
        

        
        this.add(codice);//aggiungo la JLabel codice all pannello 
        this.add(textFieldCodice);//aggiungo il JTextField codice all pannell 
        
        this.add(Box.createVerticalGlue());//spaziatore di componenti
        
        this.add(username);
        this.add(textFieldUsername);
        
        this.add(Box.createVerticalGlue());//spaziatore di componenti
        
        this.add(password);
        this.add(textFieldPassword);
        
        this.add(Box.createVerticalGlue());//spaziatore di componenti
        
        this.add(login);
        this.setVisible(true);
    }
    
    public void login(){
        String CodiceScuola=textFieldCodice.getText();
        String username=textFieldUsername.getText();
        String password= new String(textFieldPassword.getPassword());
        //System.out.println("codice scuola: "+CodiceScuola+" username: "+username+" Password: "+password);
        ArgoApi api= new ArgoApi(CodiceScuola, username, password);
        try {
            api.accedi();
            new App(api);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessoNonRiuscito ex) {
            //Da fare mettere popup
            login.setEnabled(true);
            new FinestraAccessoNonRiuscito(this,"errore");
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       if(ke.getKeyCode()==KeyEvent.VK_ENTER){
           login.setEnabled(false);
           this.login();
       }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
    
}
