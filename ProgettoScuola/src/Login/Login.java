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
import SchermataPrincipale.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vincenzo
 */
public class Login extends JFrame {
    private JLabel codice;
    private JLabel username;
    private JLabel password;
            
    private JTextField textFieldCodice;
    
    private JTextField textFieldUsername;
    
    private JPasswordField textFieldPassword;
    
    private JButton login;
    
    public Login() throws HeadlessException {
        this.setBounds(0,0, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        codice=new JLabel("Codice Scuola:");
        username=new JLabel("Username:");
        password=new JLabel("password: ");
        
        textFieldCodice=new JTextField();
        textFieldUsername=new JTextField();
        textFieldPassword=new JPasswordField();
        
        login=new JButton("login");
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               login();
            }
        });
        //imposto il layout manager
        JPanel pannelloPrincipale=(JPanel) this.getContentPane();
        pannelloPrincipale.setLayout(new BoxLayout(pannelloPrincipale, BoxLayout.Y_AXIS));
        pannelloPrincipale.setBorder(new EmptyBorder(10, 10, 10, 10));
        codice.setHorizontalAlignment(JLabel.CENTER);
        codice.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(codice);
        textFieldCodice.setMaximumSize(new Dimension(Short.MAX_VALUE,10));
        textFieldUsername.setMaximumSize(new Dimension(Short.MAX_VALUE,10));
        textFieldPassword.setMaximumSize(new Dimension(Short.MAX_VALUE, 10));
        this.add(textFieldCodice);
        this.add(Box.createVerticalGlue());
        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setHorizontalAlignment(JLabel.CENTER);
        this.add(username);
        this.add(textFieldUsername);
        this.add(Box.createVerticalGlue());
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        password.setHorizontalAlignment(JLabel.CENTER);
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(password);
        this.add(textFieldPassword);
        this.add(Box.createVerticalGlue());
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
