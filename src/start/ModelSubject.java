
package start;


public class ModelSubject {
    
    String nazwa;
    
    public ModelSubject(String nazwa) {
       this.nazwa = nazwa;
    }

    public String getOcena() {
        return nazwa;
    }

    public final void setOcena(String ocena) {
        this.nazwa = ocena;
    }
    
}
