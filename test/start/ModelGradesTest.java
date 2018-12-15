package start;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

public class ModelGradesTest {

    /*
    * Objaśnienie Unit testu:
     - arrange - Tworzenie obiektów, inicjalizacja zmiennych itp. 
     - act - Wywołanie testowanej logiiki, metod itp. 
    - assert - Porównwanie otrzymanej wartosci z "act", z oczekiwanym/poprawnym rezultatem
    *
    * Oprocz JUnit dodana została biblioteka Mockito
    * */

    @Test
    public void getOcenaTest() {
        // tworzymy nowy ModelGrades, tylko dla tego testu
        // W tym tescie interesuje nas tylko pole ocena, dlatego dla pozostalych pol(idWykladowcy, idPrzedmiotu)
        // mozemy napisac anyString(), co "udaje" napis. Tworzy zaslepke dla tego pola i zwraca Stringa,
        // zeby kod sie kompilowal, a dla nas jest to bez znaczenia co tam jest, bo i tak tego nie testujemy w tym tescie
        ModelGrades modelGrades = new ModelGrades("5", anyString(), anyString());

        // act - wywolanie metody get() dla oceny
        String gradeFromModelGrades = modelGrades.getOcena();

        // assert - porownanie czy get() zwraca poprawnie ocene, ktora powinna byc 5
        assertEquals("5", gradeFromModelGrades);
    }

    @Test
    public void setOcenaTest() {
        // arrange analogicznie jak wyżej, tylko tutaj nie ustawiamy nawet oceny, bo chcemy ja ustawic poprzez set()
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), anyString());

        // act
        modelGrades.setOcena("5");

        // assert
        assertEquals("5", modelGrades.ocena);
    }

    @Test
    public void getPrzedmiotTest() {
        // arrange
        // jako pole klasy ModelGrades mozna wstawic cokolwiek, byle byla ta sama wartosc co pozniej w assercie
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), "Przedmiot");

        // act
        String courseFromModelGrades = modelGrades.getPrzedmiot();

        // assert
        assertEquals("Przedmiot", courseFromModelGrades);
    }

    @Test
    public void setPrzedmiotTest() {
        // arrange
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), anyString());

        // act
        modelGrades.setPrzedmiot("Matematyka");

        // assert
        assertEquals("Matematyka", modelGrades.id_przedmiotu);
    }

    @Test
    public void getWykladowcaTest() {
        // arrange
        ModelGrades modelGrades = new ModelGrades(anyString(), "123", anyString());

        // act
        String teacherFromModelGrades = modelGrades.getWykladowca();

        // assert
        assertEquals("123", teacherFromModelGrades);
    }

    @Test
    public void setWykladowcaTest() {
        // arrange
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), anyString());

        // act
        modelGrades.setWykladowca("123");

        // assert
        assertEquals("123", modelGrades.id_wykladowcy);
    }
}