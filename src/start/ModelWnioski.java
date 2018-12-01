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
public class ModelWnioski {
    
     String id_wniosku, nr_indeksu;

    public ModelWnioski(String id_wniosku, String nr_indeksu) {
       this.id_wniosku=id_wniosku;
       this.nr_indeksu=nr_indeksu;
    }

    public String getId_wniosku() {
        return id_wniosku;
    }

    public void setId_wniosku(String id_wniosku) {
        this.id_wniosku = id_wniosku;
    }

    public String getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }
    
}
