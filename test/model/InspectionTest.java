/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.VehicleDTO;
import externals.SpecifiedInspection;
import integration.DatabaseManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for class Inspection
 * @author Coyote
 */
public class InspectionTest {
    
    public InspectionTest() {
    }

    /**
     * Test of getCost method, of class Inspection.
     */
    @Test
    public void testGetCostAndIndirectlyCalculateCost() {
        VehicleDTO vehicle = new VehicleDTO("");
        DatabaseManager dbm = new DatabaseManager();
        SpecifiedInspection[] specInsp = dbm.getInspectionsForVehicle(vehicle);
        Inspection instance = new Inspection(vehicle, specInsp);
        int expResult = 900;
        int result = instance.getCost();
        assertEquals("Cost was not correct", expResult, result);
    }
    
}
