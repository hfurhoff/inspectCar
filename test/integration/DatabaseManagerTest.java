/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.VehicleDTO;
import dto.SpecifiedInspection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class DatabaseManager.
 * @author Coyote
 */
public class DatabaseManagerTest {
    
    public DatabaseManagerTest() {
    }
    
    VehicleDTO vehicle;
    DatabaseManager instance;
    
    @Before
    public void setUp() {
        vehicle = new VehicleDTO("123ABC");
        instance = new DatabaseManager();
    }
    
    @After
    public void tearDown() {
        vehicle = null;
        instance = null;
    }

    /**
     * Test of getInspectionsForVehicle method, of class DatabaseManager.
     */
    @Test
    public void testNumberOfInspections() {
        int expResult = 4;
        int result = instance.getInspectionsForVehicle(vehicle).length;
        assertEquals("The number of inspections were wrong", expResult, result);
    }
    
    /**
     * Test of getInspectionsForVehicle method, of class DatabaseManager.
     */
    @Test
    public void testForCorrectInspections(){
        boolean expResult = true;
        SpecifiedInspection[] inspectionChecklist = instance.getInspectionsForVehicle(vehicle);
        boolean result = true;
        result &= inspectionChecklist[0].toString().equalsIgnoreCase("Part to inspect and cost: Brakes, 250");
        result &= inspectionChecklist[1].toString().equalsIgnoreCase("Part to inspect and cost: Steering, 200");
        result &= inspectionChecklist[2].toString().equalsIgnoreCase("Part to inspect and cost: Exhaust levels, 300");
        result &= inspectionChecklist[3].toString().equalsIgnoreCase("Part to inspect and cost: Suspension, 150");
        assertEquals("It was not the correct inspections returned", expResult, result);
    }
}
