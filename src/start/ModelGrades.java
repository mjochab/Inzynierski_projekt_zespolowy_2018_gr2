/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

/**
 *
 * @author Przemek
 */
public class ModelGrades  {
    
    String ocena,id_przedmiotu,id_wykladowcy;

    public ModelGrades(String ocena,String id_wykladowcy, String id_przedmiotu) {
        this.ocena = ocena;
        this.id_przedmiotu = id_przedmiotu;
        this.id_wykladowcy = id_wykladowcy;
    }

    public String getOcena() {
        return ocena;
    }

    public final void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public String getPrzedmiot() {
        return id_przedmiotu;
    }

    public final void setPrzedmiot(String id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public String getWykladowca() {
        return id_wykladowcy;
    }

    public final void setWykladowca(String id_wykladowcy) {
        this.id_wykladowcy = id_wykladowcy;
    }
    
    
    
}
