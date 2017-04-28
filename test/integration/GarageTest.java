/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the class Garage
 * @author Coyote
 */
public class GarageTest {

    /**
     * Test of nextCustomer method, of class Garage.
     */
    @Test
    public void testNextCustomer() {
        Garage instance = new Garage();
        boolean expResult = true;
        instance.nextCustomer();
        boolean result = instance.toString().equalsIgnoreCase("The garage has a door and a display. Garagedoor is open. Display is showing number 1.");
        assertEquals("", expResult, result);
    }

    /**
     * Test of closeDoor method, of class Garage.
     */
    @Test
    public void testCloseDoor() {
        Garage instance = new Garage();
        boolean expResult = true;
        instance.closeDoor();
        boolean result = instance.toString().equalsIgnoreCase("The garage has a door and a display. Garagedoor is closed. Display is showing number 0.");
        assertEquals("The door did not close", expResult, result);
    }
    
}
