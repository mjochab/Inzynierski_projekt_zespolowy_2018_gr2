package start;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

 /*
    * Objaśnienie Unit testu:
     - arrange - Tworzenie obiektów, inicjalizacja zmiennych itp. 
     - act - Wywołanie testowanej logiiki, metod itp. 
    - assert - Porównwanie otrzymanej wartosci z "act" z oczekiwanym/poprawnym rezultatem
    *
    * */

public class ModelWnioskiTest {

    private ModelWnioski modelWnioski;

    // Inny sposob inicjowania zmiennych do testu
    @Before
    public void setUp() {
        modelWnioski = new ModelWnioski("id", "indeks");
    }

    @Test
    public void getId_wnioskuTest() {
        // arrange
        // inicjacja jest w setUpie

        // act
        String documentId = modelWnioski.getId_wniosku();

        // assert
        assertEquals("id", documentId);
    }

    @Test
    public void setId_wnioskuTest() {

        // act
        modelWnioski.setId_wniosku("noweId");

        // assert
        assertEquals("noweId", modelWnioski.id_wniosku);
    }

    @Test
    public void getNr_indeksuTest() {
        // arrange
        // inicjacja jest w setUpie

        // act
        String number = modelWnioski.getNr_indeksu();

        // assert
        assertEquals("indeks", number);
    }

    @Test
    public void setNr_indeksuTest() {

         // act
        modelWnioski.setNr_indeksu("nowyNr");

        // assert
        assertEquals("nowyNr", modelWnioski.nr_indeksu);
    }
}