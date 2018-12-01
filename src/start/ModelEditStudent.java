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
public class ModelEditStudent {
      String nr_indeksu,imie,nazwisko;

    public ModelEditStudent(String nr_indeksu,String imie, String nazwisko) {
        this.nr_indeksu=nr_indeksu;
        this.imie=imie;
        this.nazwisko=nazwisko;
        
    }

    public String getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
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
