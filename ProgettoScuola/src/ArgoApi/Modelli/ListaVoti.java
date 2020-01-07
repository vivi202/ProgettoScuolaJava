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
    
        public int getNumMaterie(){
        int pos=0;
        boolean app[]=new boolean[this.getLung()];
        
        for(int i=0;i<this.getLung();i++){
            app[i]=false;
        }
        
        for(int i=0;i<this.getLung();i++){
            if(app[i]==false){
                Voto v=this.getIndex(i);
                for(int j=i;j<this.getLung();j++){
                    if(app[j]==false){
                        Voto c=this.getIndex(j);
                        if(v.getMateria().compareTo(c.getMateria())==0){
                            app[j]=true;
                        }
                    }
                }
                pos++;
            }
            app[i]=true;
        }
        return pos;
    }
}
