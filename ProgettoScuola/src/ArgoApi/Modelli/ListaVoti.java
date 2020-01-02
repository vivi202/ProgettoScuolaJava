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
public class ListaVoti {
    private Nodo testa;

    public ListaVoti() {
        this.testa = null;
    }
    
    public void insTesta(Voto inf){
        Nodo p=new Nodo(inf);
        if(testa==null){
            this.testa=p;
        }else{
            p.setLink(testa);
            this.testa=p;
        }
    }
    public void insCoda(Voto inf){
        if(testa==null){
            this.insTesta(inf);
        }else{
            Nodo p=testa;
            while(p.getLink()!=null)p=p.getLink();
            p.setLink(new Nodo(inf));
        }
    }
    public void visitaLista(){
        Nodo p=testa;
        while(p!=null){
            System.out.println(p.toString());
            p=p.getLink();
        }
    }
    public int getLung(){
        Nodo p=testa;
        if(p==null){
            return 0;
        }
        else{
            int c=0;
            while(p!=null){
                c++;
                p=p.getLink();
            }
            return c;
        }
    }
    public Voto getIndex(int i){
        Nodo p=testa;
        int c=0;
        while(p!=null && c<i){
            c++;
            p=p.getLink();
        }
        if(p==null)return null;
        else
            return p.getInf();
    }
}
