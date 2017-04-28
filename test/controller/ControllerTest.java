/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.VehicleDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of class Controller
 * @author Coyote
 */
public class ControllerTest {
    
    Controller instance;
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Controller();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of startNewInspection method, of class Controller.
     */
    @Test
    public void testStartNewInspection() {
        instance.startNewInspection();
        boolean result = instance.getCurrentState().equalsIgnoreCase("Inspection has started.");
        boolean expectedRes = true;
        assertEquals(("State should have been \"Inspection has started.\" but was: " + instance.getCurrentState()), expectedRes, result);
        
    }

    /**
     * Test of closeGarageDoor method, of class Controller.
     */
    @Test
    public void testCloseGarageDoor() {
        instance.closeGarageDoor();
        boolean result = instance.getCurrentState().equalsIgnoreCase("Door has closed.");
        boolean expectedRes = true;
        assertEquals(("State should have been \"Door has closed.\" but was: " + instance.getCurrentState()), expectedRes, result);
    }

    /**
     * Test of calculateCostForInspectionBasedOnVehicle method, of class Controller.
     */
    @Test
    public void testCorrectCostForInspectionBasedOnVehicle() {
        VehicleDTO vehicle = null;
        int expResult = 900;
        int result = instance.calculateCostForInspectionBasedOnVehicle(vehicle);
        assertEquals(("Cost should have been 900 but was " + instance.calculateCostForInspectionBasedOnVehicle(vehicle)),expResult, result);
    }
    
    /**
     * Test of calculateCostForInspectionBasedOnVehicle method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterHavingEnteredRegNumber(){
        VehicleDTO vehicle = null;
        boolean expectedRes = true;
        instance.calculateCostForInspectionBasedOnVehicle(vehicle);
        boolean result = instance.getCurrentState().equalsIgnoreCase("Registrationnumber has been entered and cost has been returned.");
        assertEquals(("State should have been \"Registrationnumber has been entered and cost has been returned.\" but was: " + instance.getCurrentState()),expectedRes, result);
    }
    
}
