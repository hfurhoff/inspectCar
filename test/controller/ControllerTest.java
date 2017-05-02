/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import state.State;
import static state.StateHandler.stateToString;

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
        State result = instance.getCurrentState();
        State expectedRes = State.AN_INSPECTION_HAS_STARTED;
        assertEquals(("State should have been AN_INSPECTION_HAS_STARTED but was: " + stateToString(instance.getCurrentState())), expectedRes, result);
        
    }

    /**
     * Test of closeGarageDoor method, of class Controller.
     */
    @Test
    public void testCloseGarageDoor() {
        instance.closeGarageDoor();
        State result = instance.getCurrentState();
        State expectedRes = State.DOOR_HAS_CLOSED;
        assertEquals(("State should have been DOOR_HAS_CLOSED but was: " + stateToString(instance.getCurrentState())), expectedRes, result);
    }

    /**
     * Test of calculateCostForInspectionBasedOnVehicle method, of class Controller.
     */
    @Test
    public void testCorrectCostForInspectionBasedOnVehicle() {
        String regNo = null;
        int expResult = 900;
        int result = instance.calculateCostForInspectionBasedOnVehicle(regNo);
        assertEquals(("Cost should have been 900 but was " + 
                instance.calculateCostForInspectionBasedOnVehicle(regNo)),expResult, result);
    }
    
    /**
     * Test of calculateCostForInspectionBasedOnVehicle method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterHavingEnteredRegNumber(){
        String regNo = null;
        State expectedRes = State.REGISTRATION_NUMBER_HAS_BEEN_ENTERED_AND_COST_HAS_BEEN_RETURNED;
        instance.calculateCostForInspectionBasedOnVehicle(regNo);
        State result = instance.getCurrentState();
        assertEquals(("State should have been "
                + "REGISTRATION_NUMBER_HAS_BEEN_ENTERED_AND_COST_HAS_BEEN_RETURNED"
                + " but was: " + stateToString(instance.getCurrentState())), expectedRes, result);
    }
    
}
