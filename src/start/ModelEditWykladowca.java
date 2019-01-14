/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;


public class ModelEditWykladowca {
      String id_wykladowcy,imie,nazwisko;

    public ModelEditWykladowca(String id_wykladowcy,String imie, String nazwisko) {
        this.id_wykladowcy=id_wykladowcy;
        this.imie=imie;
        this.nazwisko=nazwisko;
        
    }

    public String getId_Wykladowcy() {
        return id_wykladowcy;
    }

    public void setId_Wykladowcy(String id_wykladowcy) {
        this.id_wykladowcy = id_wykladowcy;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
}
