/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dodz
 */
public class ModelEditStudentTest {
    
    public ModelEditStudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNr_indeksu method, of class ModelEditStudent.
     */
    @Test
    public void testGetNr_indeksu() {
        System.out.println("getNr_indeksu");
        ModelEditStudent instance = null;
        String expResult = "";
        String result = instance.getNr_indeksu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNr_indeksu method, of class ModelEditStudent.
     */
    @Test
    public void testSetNr_indeksu() {
        System.out.println("setNr_indeksu");
        String nr_indeksu = "";
        ModelEditStudent instance = null;
        instance.setNr_indeksu(nr_indeksu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImie method, of class ModelEditStudent.
     */
    @Test
    public void testGetImie() {
        System.out.println("getImie");
        ModelEditStudent instance = null;
        String expResult = "";
        String result = instance.getImie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImie method, of class ModelEditStudent.
     */
    @Test
    public void testSetImie() {
        System.out.println("setImie");
        String imie = "";
        ModelEditStudent instance = null;
        instance.setImie(imie);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNazwisko method, of class ModelEditStudent.
     */
    @Test
    public void testGetNazwisko() {
        System.out.println("getNazwisko");
        ModelEditStudent instance = null;
        String expResult = "";
        String result = instance.getNazwisko();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNazwisko method, of class ModelEditStudent.
     */
    @Test
    public void testSetNazwisko() {
        System.out.println("setNazwisko");
        String nazwisko = "";
        ModelEditStudent instance = null;
        instance.setNazwisko(nazwisko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
