/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArgoApi.Modelli;

/**
 *
 * @author Vincenzo
 */
public class Nodo {
    private Voto Inf;
    private Nodo link;

    public Nodo() {
        this.Inf=null;
        this.link=null;
    }

    public Nodo(Voto Inf) {
        this.Inf = Inf;
        this.link=null;
    }

    public Voto getInf() {
        return Inf;
    }

    public void setInf(Voto Inf) {
        this.Inf = Inf;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Nodo{" + "Inf=" + Inf + '}';
    }
    
    
    
}
