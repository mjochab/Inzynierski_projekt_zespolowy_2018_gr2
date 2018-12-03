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
public class ModelGradesTest {
    
    public ModelGradesTest() {
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
     * Test of getOcena method, of class ModelGrades.
     */
    @Test
    public void testGetOcena() {
        System.out.println("getOcena");
        ModelGrades instance = null;
        String expResult = "";
        String result = instance.getOcena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOcena method, of class ModelGrades.
     */
    @Test
    public void testSetOcena() {
        System.out.println("setOcena");
        String ocena = "";
        ModelGrades instance = null;
        instance.setOcena(ocena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrzedmiot method, of class ModelGrades.
     */
    @Test
    public void testGetPrzedmiot() {
        System.out.println("getPrzedmiot");
        ModelGrades instance = null;
        String expResult = "";
        String result = instance.getPrzedmiot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrzedmiot method, of class ModelGrades.
     */
    @Test
    public void testSetPrzedmiot() {
        System.out.println("setPrzedmiot");
        String id_przedmiotu = "";
        ModelGrades instance = null;
        instance.setPrzedmiot(id_przedmiotu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWykladowca method, of class ModelGrades.
     */
    @Test
    public void testGetWykladowca() {
        System.out.println("getWykladowca");
        ModelGrades instance = null;
        String expResult = "";
        String result = instance.getWykladowca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWykladowca method, of class ModelGrades.
     */
    @Test
    public void testSetWykladowca() {
        System.out.println("setWykladowca");
        String id_wykladowcy = "";
        ModelGrades instance = null;
        instance.setWykladowca(id_wykladowcy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
