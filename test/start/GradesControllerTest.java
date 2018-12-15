/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import javafx.collections.FXCollections;
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

public class GradesControllerTest {

    @Test
    public void sizeOfListShouldIncrease_when_addingNewItem()  {
        // Testujemy, czy element został prawidłowo dodany do listy

        // tworzymy obiekt ModelGrades, ktory dodamy do oblist
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), anyString());
        GradesController.oblist = FXCollections.observableArrayList();
        // pobieramy rozmiar listy przed dodaniem, w tym wypadku 0, aby porownac z rozmiarem po dodaniu
        int sizeOfListBefore = GradesController.oblist.size();

        // act
        // dodajemy dwa takie same elementy i przypisujemy rozmiar do zmiennej
        GradesController.oblist.add(modelGrades);
        GradesController.oblist.add(modelGrades);
        int sizeOfListAfter = GradesController.oblist.size();

        // assert
        // porownanie rozmiarów przed i po dodaniu
        // Przed i po, nie powinny być takie same
        assertNotEquals(sizeOfListAfter, sizeOfListBefore);
        // Po powinno byc o 2 większe niz przed
        assertEquals(sizeOfListAfter, sizeOfListBefore + 2);
    }

    @Test
    public void sizeOfListShouldDecrease_when_removingItem()  {
        // analogiczny test, ale z usuwaniem

        // arrange
        ModelGrades modelGrades = new ModelGrades(anyString(), anyString(), anyString());
        GradesController.oblist = FXCollections.observableArrayList(modelGrades);
        int sizeOfListBefore = GradesController.oblist.size();

        // act
        // jest tylko jeden element w liscie i usuwamy obiekt z pierwszej pozycji
        GradesController.oblist.remove(0);
        int sizeOfListAfter = GradesController.oblist.size();

        // assert
        // rozmiary przed i po nie moga byc ==
        assertNotEquals(sizeOfListAfter, sizeOfListBefore);
        // po powinien byc o 1 mniejszy niz przed
        assertEquals(sizeOfListAfter, sizeOfListBefore - 1);
    }
}