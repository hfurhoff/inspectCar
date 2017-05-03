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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the class Result
 * @author Coyote
 */
public class ResultTest {
    
    public ResultTest() {
    }

    SpecifiedInspection[] testArray;
    Result instance;
    
    @Before
    public void setUp() {
        SpecifiedInspection[] specInsp = { (new SpecifiedInspection("a", 1))};
        this.testArray = specInsp;
        instance = new Result(testArray);
    }
    
    @After
    public void tearDown() {
        testArray = null;
        instance = null;
    }

    @Test
    public void testThatResultIsInitializedCorrectly() {
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
        Result otherInstance = new Result(testArray);
        otherInstance.addRemark(remark);
        instance.addRemark(remark);
        
        boolean expectedRes = true;
        boolean result = instance.equals(otherInstance);
        assertEquals("Same remark was added.", expectedRes, result);
    }

    /**
     * Test of getTextToPrint method, of class Result.
     */
    @Test
    public void testGetTextToPrint() {
        SpecifiedInspection[] inspectionChecklist = {new SpecifiedInspection("a", 1)};
        VehicleDTO vehicle = new VehicleDTO("123ABC");
        Remark remark = new Remark("Passed", true);
        Result newInstance = new Result(inspectionChecklist);
        newInstance.addRemark(remark);
        String expResult = "The vehicle with registration number 123ABC was inspected. This is the result. \na was inspected. The vehicle passed. Passed\n";
        String result = newInstance.getTextToPrint(inspectionChecklist, vehicle);
        assertEquals("The text provided did not match the text expected.",expResult, result);
    }

    /**
     * Test of equals method, of class Result.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNull() {
        Result obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was null.", expResult, result);
    }
    
    /**
     * Test of equals method, of class Result.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotInstanceOfResult() {
        String obj = "hejsvejs";
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal when other object was string.", expResult, result);
    }
    
    /**
     * Test of equals method, of class Result.
     */
    @Test
    public void testEqualsWhenOtherObjectIsNotSameInstanceOfResult() {
        SpecifiedInspection[] otherTestArray = {(new SpecifiedInspection("a", 1)), (new SpecifiedInspection("b", 2))};
        Result obj = new Result(otherTestArray);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were equal.", expResult, result);
    }
    
    /**
     * Test of equals method, of class Result.
     */
    @Test
    public void testEqualsWhenOtherObjectIsSameInstanceOfResult() {
        Remark remark = new Remark("Passed.", true);
        SpecifiedInspection[] otherTestArray = {(new SpecifiedInspection("a", 1))};
        Result obj = new Result(otherTestArray);
        obj.addRemark(remark);
        instance.addRemark(remark);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals("Method returned that the objects were not equal.", expResult, result);
    }
    
}
