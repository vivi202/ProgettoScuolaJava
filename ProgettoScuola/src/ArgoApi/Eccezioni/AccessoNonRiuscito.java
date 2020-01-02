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
public class AccessoNonRiuscito extends Exception {

    public AccessoNonRiuscito() {
        System.err.println("accesso non riuscito");
    }
    
}
