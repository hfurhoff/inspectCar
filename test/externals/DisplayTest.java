/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externals;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Tests the external system display.
 * @author Coyote
 */
public class DisplayTest {
    
    Display instance;
    
    public DisplayTest() {
    }
    
    @Before
    public void setUp(){
        instance = new Display();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }
    
    /**
     * Test of showNextNumber method, of class Display.
     */
    @Test
    public void testThatNumberIsUpdated(){
        boolean expectedResult = false;
        instance.showNextNumber();
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 0");
        assertEquals("Number was not updated", expectedResult, result);
    }
    
    @Test
    public void testThatNumberIsUpdatedCorrectly() {
        boolean expectedResult = true;
        instance.showNextNumber();
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 1");
        assertEquals("Method showNextNumber updated the number to be displayed with wrong number", expectedResult, result);
    }    
    
    
}
