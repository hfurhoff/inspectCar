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
 * Tests the external system garagedoor.
 * @author Coyote
 */
public class GarageDoorTest {
    
    GarageDoor instance;
    
    public GarageDoorTest() {
    }
    
    @Before
    public void setUp() {
        instance = new GarageDoor();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of openDoor method, of class GarageDoor.
     */
    @Test
    public void testOpenDoor() {
        boolean expectedResult = true;
        instance.openDoor();
        boolean result = instance.toString().equalsIgnoreCase("Garagedoor is open");
        assertEquals("Door did not open", expectedResult, result);
    }

    /**
     * Test of closeDoor method, of class GarageDoor.
     */
    @Test
    public void testCloseDoor() {
        boolean expectedResult = true;
        instance.closeDoor();
        boolean result = instance.toString().equalsIgnoreCase("Garagedoor is closed");
        assertEquals("Door did not close", expectedResult, result);
    }
    
}