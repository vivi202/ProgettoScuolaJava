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
public class Voto {
    private String materia;
    private double punteggio;
    private String data;
    
    public Voto(String materia, double punteggio,String data) {
        this.materia = new String(materia);
        this.punteggio = punteggio;
        this.data = new String(data);
    }

    public Voto(Voto x) {
        this(x.getMateria(),x.getPunteggio(),x.getData());
    }

    
    
    public String getMateria() {
        return materia;
    }

    private void setMateria(String materia) {
        this.materia = new String(materia);
    }

    public double getPunteggio() {
        return punteggio;
    }

    private void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }
    
    

    @Override
    public String toString() {
        return "Voto{" + "materia=" + materia + ", punteggio=" + punteggio + ", data=" + data + '}';
    }
    
    
    
}
