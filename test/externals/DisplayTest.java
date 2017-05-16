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
        instance = Display.getDisplay();
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
    
    /**
     * Test of showNextNumber method, of class Display.
     */
    @Test
    public void testThatNumberIsUpdatedCorrectly() {
        boolean expectedResult = true;
        instance.showNextNumber();
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 1");
        assertEquals("Method showNextNumber updated the number to be displayed with wrong number", expectedResult, result);
    }    
    
    /**
     * Test of toString method, of class Display.
     */
    @Test
    public void testThatValueIsReset() {
        boolean expectedResult = true;
        final int maximumDisplayNumber = 1000;
        for(int i = 0; i < maximumDisplayNumber; i++){
            instance.showNextNumber();
        }
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 1");
        assertEquals("The string returned was: " + instance.toString(), expectedResult, result);
    }
}
