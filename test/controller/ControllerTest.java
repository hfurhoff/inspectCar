/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.CreditCardDTO;
import dto.Remark;
import externals.SpecifiedInspection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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

    /**
     * Test of pay method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterPay() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        CreditCardDTO creditCard = null;
        instance.pay(creditCard);
        State expectedRes = State.CUSTOMER_HAS_PAYED_WITH_AN_APPROVED_CREDITCARD;
        State result = instance.getCurrentState();
        assertEquals("Code has not been run.", result, expectedRes);
        
    }

    /**
     * Test of hasMoreInspections method, of class Controller.
     */
    @Test
    public void testHasMoreInspections() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        boolean expResult = true;
        boolean result = instance.hasMoreInspections();
        assertEquals("Method should have returned that there were more inspections to be made.", expResult, result);
    }

    /**
     * Test of hasMoreInspections method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterHasMoreInspections() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        instance.hasMoreInspections();
        State expResult = State.THERE_ARE_MORE_INSPECTIONS_TO_BE_MADE;
        State result = instance.getCurrentState();
        assertEquals("Code has not been run.", expResult, result);
    }    
    
    /**
     * Test of getNextSpecifiedInspection method, of class Controller.
     */
    @Test
    public void testGetNextSpecifiedInspection() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        boolean expResult = true;
        boolean result = instance.getNextSpecifiedInspection().equals(new SpecifiedInspection("Brakes", 250));
        assertEquals("The returned specified inspection was not what was expected.", expResult, result);
    }

    /**
     * Test of getNextSpecifiedInspection method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterGetNextSpecifiedInspection() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        instance.getNextSpecifiedInspection();
        State expResult = State.INSPECTOR_GOT_ANOTHER_INSPECTION;
        State result = instance.getCurrentState();
        assertEquals("Code has not been run.", expResult, result);
    }
    
    /**
     * Test of enterRemark method, of class Controller.
     */
    @Test
    public void testCorrectStateAfterEnterRemark() {
        instance.calculateCostForInspectionBasedOnVehicle("123ABC");
        Remark remark = null;
        instance.enterRemark(remark);
        State expResult = State.INSPECTOR_ENTERED_A_REMARK;
        State result = instance.getCurrentState();
        assertEquals("Code has not been run.", expResult, result);
    }
}
