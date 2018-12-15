package start;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.anyString;

 /*
    * Objaśnienie Unit testu:
     - arrange - Tworzenie obiektów, inicjalizacja zmiennych itp. 
     - act - Wywołanie testowanej logiiki, metod itp. 
    - assert - Porównwanie otrzymanej wartosci z "act" z oczekiwanym/poprawnym rezultatem
    *
    * Oprocz JUnit dodana została biblioteka Mockito
    * */

public class ModelEditStudentTest {

    @Test
    public void getNr_indeksuTest() {
        // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent("123", anyString(), anyString());

        // act
        String number = modelEditStudent.getNr_indeksu();

        // assert
        assertNotEquals("12", number);
        assertEquals("123", number);
    }

    @Test
    public void setNr_indeksuTest() {
        // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent(anyString(), anyString(), anyString());

        // act
        modelEditStudent.setNr_indeksu("1");

        // assert
        assertEquals("1", modelEditStudent.nr_indeksu);
    }

    @Test
    public void getImieTest() {
        // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent(anyString(), "imie", anyString());

        // act
        String name = modelEditStudent.getImie();

        // assert
        assertEquals("imie", name);
    }

    @Test
    public void setImieTest() {
        // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent(anyString(), anyString(), anyString());

        // act
        modelEditStudent.setImie("imie");

        // assert
        assertEquals("imie", modelEditStudent.imie);
    }

    @Test
    public void getNazwiskoTest() {
        // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent(anyString(), anyString(), "nazwisko");

        // act
        String surname = modelEditStudent.getNazwisko();

        // assert
        assertEquals("nazwisko", surname);
    }

    @Test
    public void setNazwiskoTest() {
                // arrange
        ModelEditStudent modelEditStudent = new ModelEditStudent(anyString(), anyString(), anyString());

        // act
        modelEditStudent.setNazwisko("nazwisko");

        // assert
        assertEquals("nazwisko", modelEditStudent.nazwisko);
    }
}