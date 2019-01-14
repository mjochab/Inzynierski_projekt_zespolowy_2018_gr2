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
public class ModelModifyStudent {
      String nr_indeksu,imie,nazwisko,haslo,kierunek_s,nr_domu,ulica,miejscowosc,kod_p;
      int pesel,nr_tel;

    public ModelModifyStudent(String nr_indeksu,String imie, String nazwisko, String haslo, String kierunek_s, 
            String nr_domu, String ulica, String miejscowosc, String kod_p, int pesel, int nr_tel) {
        this.nr_indeksu=nr_indeksu;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.haslo=haslo;
        this.kierunek_s=kierunek_s;
        this.nr_domu=nr_domu;
        this.ulica=ulica;
        this.miejscowosc=miejscowosc;
        this.kod_p=kod_p;
        this.pesel=pesel;
        this.nr_tel=nr_tel;
        
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
    
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getKierunek_s() {
        return kierunek_s;
    }

    public void setKierunek_s(String kierunek_s) {
        this.kierunek_s = kierunek_s;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }
    
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKod_p() {
        return kod_p;
    }

    public void setKod_p(String kod_p) {
        this.kod_p = kod_p;
    }
    
    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(int nr_tel) {
        this.nr_tel = nr_tel;
    }
    
    
}

