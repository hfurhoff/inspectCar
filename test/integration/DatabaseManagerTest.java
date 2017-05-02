/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import dto.VehicleDTO;
import externals.SpecifiedInspection;
import externals.StoredResult;
import model.Result;
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
public class DatabaseManagerTest {
    
    public DatabaseManagerTest() {
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
     * Test of getInspectionsForVehicle method, of class DatabaseManager.
     */
    @Test
    public void testNumberOfInspections() {
        VehicleDTO vehicle = null;
        DatabaseManager instance = new DatabaseManager();
        int expResult = 4;
        int result = instance.getInspectionsForVehicle(vehicle).length;
        assertEquals("The number of inspections were wrong", expResult, result);
    }
    
    @Test
    public void testForCorrectInspections(){
        VehicleDTO vehicle = null;
        DatabaseManager instance = new DatabaseManager();
        boolean expResult = true;
        SpecifiedInspection[] inspectionChecklist = instance.getInspectionsForVehicle(vehicle);
        boolean result = true;
        result &= inspectionChecklist[0].toString().equalsIgnoreCase("Part to inspect and cost: Brakes, 250");
        result &= inspectionChecklist[1].toString().equalsIgnoreCase("Part to inspect and cost: Steering, 200");
        result &= inspectionChecklist[2].toString().equalsIgnoreCase("Part to inspect and cost: Exhaust levels, 300");
        result &= inspectionChecklist[3].toString().equalsIgnoreCase("Part to inspect and cost: Suspension, 150");
        assertEquals("It was not the correct inspections returned", expResult, result);
    }

    /**
     * Test of storeResult method, of class DatabaseManager.
     */
    @Test
    public void testStoreResult() {
        VehicleDTO vehicle = null;
        StoredResult expectedRes = null;
        SpecifiedInspection[] doneInspections = null;
        DatabaseManager instance = new DatabaseManager();
        Result testResult = null;
        instance.storeResult(vehicle, testResult, doneInspections);
        StoredResult storedResultForAVehicle = instance.getStoredResult();
        boolean result = storedResultForAVehicle.equals(testResult);
        
    }
    
}
