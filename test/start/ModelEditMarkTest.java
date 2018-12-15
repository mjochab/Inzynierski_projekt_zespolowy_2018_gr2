package start;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

 /*
    * Objaśnienie Unit testu:
     - arrange - Tworzenie obiektów, inicjalizacja zmiennych itp. 
     - act - Wywołanie testowanej logiiki, metod itp. 
    - assert - Porównwanie otrzymanej wartosci z "act" z oczekiwanym/poprawnym rezultatem
    *
    * */

public class ModelEditMarkTest {

    @Test
    public void getNr_indeksuTest() {
        // arrange
        // teoretycznie poprawne jest tez wpisanie jakiegos Stringa z palca, zamiast anyString()
        ModelEditMark modelEditMark = new ModelEditMark("3", "", "");

        // act
        String number = modelEditMark.getNr_indeksu();

        // assert
        assertEquals("3", number);
    }

    @Test
    public void setNr_indeksuTest() {
        // arrange
        ModelEditMark modelEditMark = new ModelEditMark("", "", "");

        // act
        modelEditMark.setNr_indeksu("123456");

        // assert
        assertEquals("123456", modelEditMark.nr_indeksu);
    }

    @Test
    public void getNazwaTest() {
        // arrange
        // poprawne jest tez wpisanie jakiegos Stringa z palca, zamiast anyString()
        ModelEditMark modelEditMark = new ModelEditMark("", "name", "");

        // act
        String name = modelEditMark.getNazwa();

        // assert
        assertEquals("name", name);
    }

    @Test
    public void setNazwaTest() {
                // arrange
        ModelEditMark modelEditMark = new ModelEditMark("", "", "");

        // act
        modelEditMark.setNazwa("newName");

        // assert
        assertEquals("newName", modelEditMark.nazwa);
    }

    @Test
    public void getOcenaTest() {
        // arrange
        //  poprawne jest tez wpisanie jakiegos Stringa z palca, zamiast anyString()
        ModelEditMark modelEditMark = new ModelEditMark("", "", "3");

        // act
        String grade = modelEditMark.getOcena();

        // assert
        assertEquals("3", grade);
    }

    @Test
    public void setOcenaTest() {
                // arrange
        ModelEditMark modelEditMark = new ModelEditMark("", "", "");

        // act
        modelEditMark.setOcena("2");

        // assert
        assertEquals("2", modelEditMark.ocena);
    }

}