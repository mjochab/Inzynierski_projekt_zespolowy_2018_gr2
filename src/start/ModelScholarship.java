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
public class ModelScholarship {
    
   public String nrindeksu, srednia;
    
        public ModelScholarship(String nr_indeksu, String srednia) {
        this.nrindeksu=nr_indeksu;
        this.srednia=srednia;
    }
        
            public String getNrIndeksu() {
        return nrindeksu;
    }

    public void setNrIndeksu(String nr_indeksu) {
        this.nrindeksu = nr_indeksu;
    }
    
    
            public String getSrednia() {
        return srednia;
    }
            
          public  void setSrednia(String srednia) {
        this.srednia = srednia;
    }

}
