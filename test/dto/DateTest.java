/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Coyote
 */
public class DateTest {
    
    public DateTest() {
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
     * Test of toString method, of class Date.
     */
    @Test
    public void testToStringWhitExpiryDate() {
        int expiryMonth = 1;
        int expiryYear = 2;
        Date instance = new Date(expiryMonth, expiryYear);
        String expResult = "1/2";
        String result = instance.toString();
        assertEquals("Wrong stringrepresentation was returned.", expResult, result);
    }
    
    /**
     * Test of toString method, of class Date.
     */
    @Test
    public void testToStringWhitPaymentDate() {
        Date instance = new Date();
        String expResult = "4/5/2017";
        String result = instance.toString();
        assertEquals("Wrong stringrepresentation was returned.", expResult, result);
    }
}
