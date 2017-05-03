/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class vehicleDTO.
 * @author Coyote
 */
public class VehicleDTOTest {
    
    public VehicleDTOTest() {
    }
    
    VehicleDTO instance;
    
    @Before
    public void setUp() {
        instance = new VehicleDTO("123ABC");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of equals method, of class VehicleDTO.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNull() {
        VehicleDTO obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was null.", expResult, result);
    }
    
    /**
     * Test of equals method, of class VehicleDTO.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotInstanceOfVehicle() {
        String obj = "hejsvejs";
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was string.", expResult, result);
    }
    
    /**
     * Test of equals method, of class VehicleDTO.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotSameInstanceOfVehicle() {
        VehicleDTO obj = new VehicleDTO("CBA321");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal.", expResult, result);
    }
    
    /**
     * Test of equals method, of class VehicleDTO.
     */
    @Test
    public void testEqualsWhenOtherObjectIsSameInstanceOfVehicle() {
        VehicleDTO obj = new VehicleDTO("123ABC");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were not equal.", expResult, result);
    }
}
