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
public class ModelWnioskiTest {
    
    public ModelWnioskiTest() {
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
     * Test of getId_wniosku method, of class ModelWnioski.
     */
    @Test
    public void testGetId_wniosku() {
        System.out.println("getId_wniosku");
        ModelWnioski instance = null;
        String expResult = "";
        String result = instance.getId_wniosku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_wniosku method, of class ModelWnioski.
     */
    @Test
    public void testSetId_wniosku() {
        System.out.println("setId_wniosku");
        String id_wniosku = "";
        ModelWnioski instance = null;
        instance.setId_wniosku(id_wniosku);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNr_indeksu method, of class ModelWnioski.
     */
    @Test
    public void testGetNr_indeksu() {
        System.out.println("getNr_indeksu");
        ModelWnioski instance = null;
        String expResult = "";
        String result = instance.getNr_indeksu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNr_indeksu method, of class ModelWnioski.
     */
    @Test
    public void testSetNr_indeksu() {
        System.out.println("setNr_indeksu");
        String nr_indeksu = "";
        ModelWnioski instance = null;
        instance.setNr_indeksu(nr_indeksu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
