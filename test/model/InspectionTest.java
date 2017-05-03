/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.VehicleDTO;
import dto.SpecifiedInspection;
import integration.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Inspection
 * @author Coyote
 */
public class InspectionTest {
    
    public InspectionTest() {
    }
    
    VehicleDTO vehicle;
    DatabaseManager dbm;
    SpecifiedInspection[] specInsp;
    Inspection instance;
    
    @Before
    public void setUp() throws Exception {
        vehicle = new VehicleDTO("");
        dbm = new DatabaseManager();
        specInsp = dbm.getInspectionsForVehicle(vehicle);
        instance = new Inspection(vehicle, specInsp);
    }

    @After
    public void tearDown() throws Exception {
        vehicle = null;
        dbm = null;
        specInsp = null;
        instance = null;
    }

    /**
     * Test of getCost method, of class Inspection.
     */
    @Test
    public void testGetCostAndIndirectlyCalculateCost() {
        int expResult = 900;
        int result = instance.getCost();
        assertEquals("Cost was not correct", expResult, result);
    }

    /**
     * Test of hasMoreInspections method, of class Inspection.
     */
    @Test
    public void testHasMoreInspectionsWhenThereShouldBeMore() {
        boolean expResult = true;
        boolean result = instance.hasMoreInspections();
        assertEquals("Returned that there were no more inspection when there is.", expResult, result);
    }
    
    /**
     * Test of hasMoreInspections method, of class Inspection.
     */
    @Test
    public void testHasMoreInspectionsWhenThereShouldntBeMore() {
        final int numberOfSpecifiedInspectionsInTheDatabase = 4;
    for(int i = 0; i < numberOfSpecifiedInspectionsInTheDatabase; i++){
            instance.getNextSpecifiedInspection();
        }
        boolean expResult = false;
        boolean result = instance.hasMoreInspections();
        assertEquals("Returned that there were more inspection when there is not.", expResult, result);
    }

    /**
     * Test of getNextSpecifiedInspection method, of class Inspection.
     */
    @Test
    public void testGetNextSpecifiedInspectionWhenThereAreMoreInspectionsToCome() {
        boolean expResult = true;
        boolean result = instance.getNextSpecifiedInspection().equals(specInsp[0]);
        assertEquals("Did not return correct specified inspection.", expResult, result);
    }
    
    /**
     * Test of getNextSpecifiedInspection method, of class Inspection.
     */
    @Test
    public void testGetNextSpecifiedInspectionWhenThereAreNotMoreInspectionsToCome() {
        final int numberOfSpecifiedInspectionsInTheDatabase = 4;
        for(int i = 0; i < numberOfSpecifiedInspectionsInTheDatabase; i++){
            instance.getNextSpecifiedInspection();
        }
        
        boolean expResult = true;
        boolean result = instance.getNextSpecifiedInspection() == null;
        assertEquals("Did not return null when there no more specified inspections.", expResult, result);
    }
}
