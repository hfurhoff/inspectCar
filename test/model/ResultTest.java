/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.Remark;
import dto.VehicleDTO;
import externals.SpecifiedInspection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the class Result
 * @author Coyote
 */
public class ResultTest {
    
    public ResultTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testThatResultIsInitializedCorrectly() {
        SpecifiedInspection[] testArray = { new SpecifiedInspection("a", 1), 
                                            new SpecifiedInspection("b", 2), 
                                            new SpecifiedInspection("c", 3), 
                                            new SpecifiedInspection("d", 4)};
        Result instance = new Result(testArray);
        int expectedRes = testArray.length;
        int result = instance.getNumberOfRemarks();
        assertEquals("Result was not initialized correctly", expectedRes, result);
    }

    /**
     * Test of addRemark method, of class Result.
     */
    @Test
    public void testAddRemark() {
        Remark remark = new Remark("Passed", true);
        SpecifiedInspection[] testArray = { new SpecifiedInspection("a", 1), 
                                            new SpecifiedInspection("b", 2), 
                                            new SpecifiedInspection("c", 3), 
                                            new SpecifiedInspection("d", 4)};
        Result instance = new Result(testArray);
        instance.addRemark(remark);
        
        SpecifiedInspection[] otherTestArray = { new SpecifiedInspection("a", 1), 
                                            new SpecifiedInspection("b", 2), 
                                            new SpecifiedInspection("c", 3), 
                                            new SpecifiedInspection("d", 4)};
        Result otherInstance = new Result(testArray);
        boolean expectedRes = false;
        boolean result = instance.equals(otherInstance);
        assertEquals("No remark was added.", expectedRes, result);
    }

    /**
     * Test of getTextToPrint method, of class Result.
     */
    @Test
    public void testGetTextToPrint() {
        SpecifiedInspection[] inspectionChecklist = {new SpecifiedInspection("a", 1)};
        VehicleDTO vehicle = new VehicleDTO("123ABC");
        Remark remark = new Remark("Passed", true);
        Result instance = new Result(inspectionChecklist);
        instance.addRemark(remark);
        String expResult = "The vehicle with registration number 123ABC was inspected. This is the result. \n";
        String result = instance.getTextToPrint(inspectionChecklist, vehicle);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Result.
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Result instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
