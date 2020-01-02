/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArgoApi.Eccezioni;

/**
 *
 * @author Vincenzo
 */
public class AccessoNonEffettuato extends Exception{

    public AccessoNonEffettuato() {
        System.err.println("Accesso non effettuato");
    }
    
}
