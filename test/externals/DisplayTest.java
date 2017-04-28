/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the external system display.
 * @author Coyote
 */
public class DisplayTest {
    
    public DisplayTest() {
    }
    
    /**
     * Test of showNextNumber method, of class Display.
     */
    @Test
    public void testThatNumberIsUpdated(){
        boolean expectedResult = false;
        Display instance = new Display();
        instance.showNextNumber();
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 0");
        assertEquals("Number was not updated", expectedResult, result);
    }
    
    @Test
    public void testThatNumberIsUpdatedCorrectly() {
        boolean expectedResult = true;
        Display instance = new Display();
        instance.showNextNumber();
        boolean result = instance.toString().equalsIgnoreCase("Display is showing number 1");
        assertEquals("Method showNextNumber updated the number to be displayed with wrong number", expectedResult, result);
    }    
    
    
}
